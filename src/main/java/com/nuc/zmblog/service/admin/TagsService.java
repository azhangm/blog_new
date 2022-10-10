package com.nuc.zmblog.service.admin;

import com.nuc.zmblog.pojo.Tags;
import com.nuc.zmblog.request.TagsReq;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.resp.TagsResp;

import java.util.List;

public interface TagsService {
    Integer saveTags(TagsReq tagsAddReq);

    Tags getTagsById(Long id);

    int removeById(Long id);

    int updateTags(TagsReq tagsReq);

    PageResp<TagsResp> listTags(Integer page, Integer size);

    List<TagsResp> listTags();

    PageResp<TagsResp> listTag(Integer page, Integer size);

    List<TagsResp> listTags(String ids);


    List<TagsResp> listTagsByBlogId(Long id);

    Integer saveTag(TagsReq req);
}
