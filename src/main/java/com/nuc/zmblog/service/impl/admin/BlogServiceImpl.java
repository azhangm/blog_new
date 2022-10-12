package com.nuc.zmblog.service.impl.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuc.zmblog.exception.NotFoundException;
import com.nuc.zmblog.mapper.BlogMapper;
import com.nuc.zmblog.mapper.TagsBlogMapper;
import com.nuc.zmblog.mapper.TypeMapper;
import com.nuc.zmblog.pojo.*;
import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.resp.BlogResp;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.resp.TagsResp;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.service.admin.TagsService;
import com.nuc.zmblog.utils.CopyUtils;
import com.nuc.zmblog.utils.MarkdownUtils;
import com.nuc.zmblog.utils.SnowFlake;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;


    @Resource
    private TagsService tagsService;

    @Resource
    private TagsBlogMapper tagsBlogMapper;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private SnowFlake snowFlake;

    @Override
    public Integer saveBlog(BlogReq blogAddReq) {
        Long l = blogAddReq.getId();
        Blog blog = new Blog();
        boolean flag = false;
        if (l == null) {
            l = snowFlake.nextId();
            blogAddReq.setId(l);
            blog.setCreate_time(LocalDateTime.now());
            blog.setUpdate_time(LocalDateTime.now());
            flag = true;
        }else {
            blog.setUpdate_time(LocalDateTime.now());
        }
        blog.setType_id(Long.valueOf(blogAddReq.getType()));
        BeanUtils.copyProperties(blogAddReq,blog);
        if (blogAddReq.isCommentated()) blog.setCommentated(1);
        if (blogAddReq.isAppreciation()) blog.setAppreciation(1);
        if (blogAddReq.isPublished()) blog.setPublished(1);
        if (blogAddReq.isRecommend()) blog.setRecommend(1);
        if (blogAddReq.getFlag().equals("")) blog.setFlag("原创");
        blog.setViews(0L);
        blog.setCreate_time(LocalDateTime.now());
        blog.setUpdate_time(LocalDateTime.now());
        blog.setId(l);
//        处理 中间表
        String tag = blogAddReq.getTag();
        List<TagsResp> tagsResps = tagsService.listTags(tag);
        List<Long> list = tagsBlogMapper.selectByBlogId(l);
        List<Long> tagsId = new ArrayList<>();

        for (TagsResp tagsResp : tagsResps) {
            tagsId.add(tagsResp.getId());
        }
        for (Long aLong : list) {
            tagsId.remove(aLong);
        }

        for (Long aLong : tagsId) {
             TagsBlog tagsBlog = new TagsBlog(l,aLong);
               tagsBlogMapper.insert(tagsBlog);

        }

        if (flag)
        return blogMapper.insert(blog);
        else  return blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public BlogResp getBlogById(Long id) {
        BlogResp copy ;
        if (id == null) return  null;
        else {
            Blog blog = blogMapper.selectByPrimaryKey(id);
            if (blog == null) return null;
            copy = CopyUtils.copy(blog, BlogResp.class);
            if (blog.getRecommend() == 1) copy.setRecommend(true);

            if (blog.getPublished() == 1) copy.setPublished(true);
            if (blog.getAppreciation() == 1) copy.setAppreciation(true);
            if (blog.getCommentated() == 1) copy.setCommentated(true);
            Type type = typeMapper.selectByPrimaryKey(blog.getType_id());
            copy.setType(type.getName());
            List<TagsResp> list = tagsService.listTagsByBlogId(blog.getId());
            copy.setTags(list);
        }
        return copy;
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
        System.out.println("blogs" + "   " + blogs );
        for (Blog blog : blogs) {
            Long type_id = blog.getType_id();
            Type type = typeMapper.selectByPrimaryKey(type_id);
            blog.setType(type.getName());
            List<TagsResp> list = tagsService.listTagsByBlogId(blog.getId());
            blog.setList(list);
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


            StringBuffer ids = new StringBuffer();
            for (TagsResp tags: blog.getList()) {
                ids.append(tags.getId());
                if (blog.getList().indexOf(tags) < blog.getList().size() - 1)
                    ids.append(",");
            }
            blogResp.setTagIds(ids.toString());

        }

        PageInfo<BlogResp> pageInfo = new PageInfo<>(blogResps);
        long total = pageInfo.getTotal();
        boolean isFirst = page == 1;
        boolean isLast = total < size ;
        return new PageResp<>(pageInfo.getTotal(), pageInfo.getList(),page,isFirst,isLast);
    }

    /**
     * 推荐列表创建时间
     *
     * @return {@link List}<{@link BlogResp}>
     */
    @Override
    public List<BlogResp> listRecommendByCreateTime(Integer size) {
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andRecommendEqualTo(1);
        blogExample.setLimit(size);
        blogExample.setOrderByClause("create_time desc");
        List<Blog> blogs = blogMapper.selectByExample(blogExample);

        for (Blog blog : blogs) {
            Long type_id = blog.getType_id();
            Type type = typeMapper.selectByPrimaryKey(type_id);
            blog.setType(type.getName());
            List<TagsResp> list = tagsService.listTagsByBlogId(blog.getId());
            blog.setList(list);
        }
        List<BlogResp> blogResps = CopyUtils.copyList(blogs, BlogResp.class);
        CopyUtils.copyList(blogs, BlogResp.class);
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

//            System.out.println("appreciation : " + blogResp.isAppreciation());
//            System.out.println("commentated : " + blogResp.isCommentated());
//            System.out.println("published : " + blogResp.isPublished());
//            System.out.println("recommend : " + blogResp.isRecommend());

            StringBuffer ids = new StringBuffer();
            for (TagsResp tags: blog.getList()) {
                ids.append(tags.getId());
                if (blog.getList().indexOf(tags) < blog.getList().size() - 1)
                    ids.append(",");
            }
            blogResp.setTagIds(ids.toString());
        }
        return blogResps;
    }
        @Override
        public Long countBlog() {
        return blogMapper.countByExample(null);
        }

    @Override
    public BlogResp getAndConvert(Long id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        if (blog == null) throw new NotFoundException("博客不存在~");
        boolean appreciation = blog.getAppreciation() == 1;
        boolean commentated = blog.getCommentated() == 1;
        boolean published = blog.getPublished() == 1;
        boolean recommend = blog.getRecommend() == 1;
        String content = blog.getContent();
        String s = MarkdownUtils.markdownToHtmlExtensions(content);
        BlogResp copy = CopyUtils.copy(blog, BlogResp.class);
        copy.setAppreciation(appreciation);
        copy.setCommentated(commentated);
        copy.setPublished(published);
        copy.setRecommend(recommend);
        copy.setContent(s);
        Type type = typeMapper.selectByPrimaryKey(blog.getType_id());
        copy.setType(type.getName());
        List<TagsResp> list = tagsService.listTagsByBlogId(blog.getId());
        copy.setTags(list);
        return copy;
    }
}
