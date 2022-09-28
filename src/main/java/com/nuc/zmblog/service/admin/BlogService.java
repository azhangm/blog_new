package com.nuc.zmblog.service.admin;

import com.nuc.zmblog.pojo.Blog;
import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.resp.BlogResp;

/**
 * 博客服务
 *
 * @author zm
 * @date 2022/09/27
 */
public interface BlogService {

    /**
     * 保存博客
     *
     * @param blogAddReq 博客添加请求
     * @return {@link Integer}
     */
    Integer saveBlog(BlogReq blogAddReq);

    /**
     * 通过id获取博客
     *
     * @param id id
     * @return {@link Blog}
     */
    Blog getBlogById(Long id);

    /**
     * 删除通过id
     *
     * @param id id
     * @return int
     */
    int removeById(Long id);

    /**
     * 更新博客
     *
     * @param blogReq 博客申请
     * @return int
     */
    int updateBlog(Blog blogReq);


    /**
     * 博客列表
     *
     * @param page    页面
     * @param size    大小
     * @param blogReq 博客申请
     * @return {@link PageResp}<{@link BlogResp}>
     */
    PageResp<BlogResp> listBlog(Integer page, Integer size , BlogReq blogReq);
    
}
