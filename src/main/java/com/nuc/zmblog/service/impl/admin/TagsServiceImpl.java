package com.nuc.zmblog.service.impl.admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuc.zmblog.mapper.TagsBlogMapper;
import com.nuc.zmblog.mapper.TagsMapper;
import com.nuc.zmblog.pojo.Tags;
import com.nuc.zmblog.pojo.TagsBlog;
import com.nuc.zmblog.pojo.TagsBlogExample;
import com.nuc.zmblog.pojo.TagsExample;
import com.nuc.zmblog.request.TagsReq;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.resp.TagsResp;
import com.nuc.zmblog.service.admin.TagsService;
import com.nuc.zmblog.utils.CopyUtils;
import com.nuc.zmblog.utils.SnowFlake;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    @Resource
    private TagsMapper tagsMapper;

    @Resource SnowFlake snowFlake;


    @Resource
    private TagsBlogMapper tagsBlogMapper;

//    这里可以返回一个 tags resp 指定错误信息 我的想法 之后在修改
    @Override
    public Integer saveTags(TagsReq tagsAddReq) {
        Tags tags = new Tags();
        System.out.println(tagsAddReq.getId());
        if (tagsAddReq.getId() != null) return updateTags(tagsAddReq);
        long l = snowFlake.nextId();
        tags.setId(l);
//        属性名字必须一样
//        BeanUtils.copyProperties(tagsAddReq,tags);
        return tagsMapper.insert(tags);
    }

    @Override
    public Tags getTagsById(Long id) {
        return tagsMapper.selectByPrimaryKey(id);
    }


    @Override
    public int removeById(Long id) {
        return tagsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateTags(TagsReq tagsReq) {
        Long id = tagsReq.getId();
        Tags tags = tagsMapper.selectByPrimaryKey(id);
        if (tags == null) { return 0; }
        return tagsMapper.updateByPrimaryKey(tags);
    }

    @Override
    public PageResp<TagsResp> listTags(Integer page , Integer size) {
        PageHelper.startPage(page,size);
        TagsExample example = new TagsExample();
        example.setOrderByClause("update_time desc");
        List<Tags> tagss = tagsMapper.selectByExample(null);
        List<TagsResp> tagsResps = CopyUtils.copyList(tagss, TagsResp.class);
        PageInfo<TagsResp> pageInfo = new PageInfo<>(tagsResps);
        long total = pageInfo.getTotal();
        boolean isFirst = page == 1;
        boolean isLast = total < size ;
        return new PageResp<>(pageInfo.getTotal(), pageInfo.getList(),page,isFirst,isLast);
    }

    /**
     * 列表类型
     *
     * @return {@link List}<{@link TagsResp}>
     */
    @Override
    public List<TagsResp> listTags() {
        List<Tags> tagss = tagsMapper.selectByExample(null);
        return CopyUtils.copyList(tagss, TagsResp.class);
    }

    @Override
    public List<TagsResp> listTags(String ids) {
        List<Long> list = convertToList(ids);
        TagsExample example = new TagsExample();
        TagsExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        List<Tags> tags = tagsMapper.selectByExample(example);
        return CopyUtils.copyList(tags, TagsResp.class);
    }
    @Override
    public List<TagsResp> listTagsByBlogId(Long id) {
        TagsBlogExample example = new TagsBlogExample();
        TagsBlogExample.Criteria criteria = example.createCriteria();
        criteria.andBlogIdEqualTo(id);
        List<TagsBlog> tagsBlogs = tagsBlogMapper.selectByExample(example);
        StringBuilder ids = new StringBuilder();
        for (TagsBlog tagsBlog : tagsBlogs) {
                ids.append(tagsBlog.getTagsId());
        }
        return listTags(ids.toString());
    }
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (StringUtils.isEmptyOrWhitespace(ids)) return list;
        String[] split = ids.split(",");
        for (String s : split) {
            list.add(Long.valueOf(s));
        }
        return list;
    }
}
