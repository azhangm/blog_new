package com.nuc.zmblog.service.impl.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuc.zmblog.exception.NotFoundException;
import com.nuc.zmblog.mapper.BlogMapper;
import com.nuc.zmblog.mapper.TypeMapper;
import com.nuc.zmblog.pojo.Blog;
import com.nuc.zmblog.pojo.BlogExample;
import com.nuc.zmblog.pojo.Type;
import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.resp.BlogResp;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.utils.CopyUtils;
import com.nuc.zmblog.utils.SnowFlake;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;


    @Resource
    private TypeMapper typeMapper;

    @Resource
    private SnowFlake snowFlake;

    @Override
    public Integer saveBlog(BlogReq blogAddReq) {
        long l = snowFlake.nextId();
        blogAddReq.setId(l);
        Blog blog = new Blog();
        blog.setType_id(Long.valueOf(blogAddReq.getType()));
        BeanUtils.copyProperties(blogAddReq,blog);
        if (blogAddReq.isCommentated()) blog.setCommentated(1);
        if (blogAddReq.isAppreciation()) blog.setAppreciation(1);
        if (blogAddReq.isPublished()) blog.setPublished(1);
        if (blogAddReq.isRecommend()) blog.setRecommend(1);
        blog.setViews(0L);
        blog.setCreate_time(LocalDateTime.now());
        blog.setUpdate_time(LocalDateTime.now());
        blog.setId(l);

        return blogMapper.insert(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        if (id == null) return  null;
        else return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int removeById(Long id) {
        if (id == null) return 0;
        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBlog(Blog blogReq) {
        Long id = blogReq.getId();
        blogReq.setUpdate_time(LocalDateTime.now());
        Blog blog = blogMapper.selectByPrimaryKey(id);
        if (blog == null) throw new NotFoundException("该博客消失了~");
        BeanUtils.copyProperties(blogReq,blog);
        return blogMapper.updateByPrimaryKey(blog);
    }

    @Override
    public PageResp<BlogResp> listBlog(Integer page, Integer size, BlogReq blogReq) {
        BlogExample example = new BlogExample();
        if (blogReq == null) {
//            PageHelper.startPage(page,size);
//            List<Blog> blogs = blogMapper.selectByExample(null);
//            List<BlogResp> blogResps = CopyUtils.copyList(blogs, BlogResp.class);
//            PageInfo<BlogResp> pageInfo = new PageInfo<>(blogResps);
//            long total = pageInfo.getTotal();
//            boolean isFirst = page == 1;
//            boolean isLast = total < size;
//            return new PageResp<>(pageInfo.getTotal(), pageInfo.getList(),page,isFirst,isLast);

        }
        else {
            BlogExample.Criteria criteria = example.createCriteria();
            BlogExample.Criteria criteria1 = example.createCriteria();
            if (!StringUtils.isEmptyOrWhitespace(blogReq.getTitile())) criteria.andTitileLike(blogReq.getTitile());
            if (blogReq.isRecommend()) criteria.andRecommendEqualTo(1);
            else criteria.andRecommendEqualTo(0);
            if (!StringUtils.isEmptyOrWhitespace(blogReq.getType())) {
                // 根据分类查询博客
                Long id = Long.valueOf(blogReq.getType());
                criteria.andType_idEqualTo(id);
            }
            example.or(criteria1);
        }
        PageHelper.startPage(page,size);
        example.setOrderByClause("update_time desc");
        List<Blog> blogs = blogMapper.selectByExample(example);
        System.out.println("blogs" + "        [========]    " + blogs );
        for (Blog blog : blogs) {
            Long type_id = blog.getType_id();
            System.out.println(type_id);
            Type type = typeMapper.selectByPrimaryKey(type_id);
            blog.setType(type.getName());
        }
        List<BlogResp> blogResps = CopyUtils.copyList(blogs, BlogResp.class);

        for (int i = 0; i < blogs.size(); i++) {
            Blog blog = blogs.get(i);
            boolean appreciation = blog.getAppreciation() == 1;
            boolean commentated = blog.getCommentated() == 1;
            boolean published = blog.getPublished() == 1;
            boolean recommend = blog.getRecommend() == 1;

            BlogResp blogResp = blogResps.get(i);
            blogResp.setAppreciation(appreciation);
            blogResp.setCommentated(commentated);
            blogResp.setPublished(published);
            blogResp.setRecommend(recommend);

        }

        PageInfo<BlogResp> pageInfo = new PageInfo<>(blogResps);
        long total = pageInfo.getTotal();
        boolean isFirst = page == 1;
        boolean isLast = total < size ;
        return new PageResp<>(pageInfo.getTotal(), pageInfo.getList(),page,isFirst,isLast);
    }
}
