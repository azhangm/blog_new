package com.nuc.zmblog.service.impl.admin;

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
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogAddReq,blog);
        blog.setId(l);

        System.out.println("==========================");
        System.out.println(blog.getId());
        System.out.println("==========================");
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
        BlogExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(blogReq.getTitile())) criteria.andTitileLike(blogReq.getTitile());
        if (blogReq.isRecommend()) criteria.andRecommendEqualTo(1);
        if (!StringUtils.isEmptyOrWhitespace(blogReq.getType())) {
            List<Type> types = typeMapper.selectByName(blogReq.getType());
            Long id = types.get(0).getId();
        }
        return null;
    }
}
