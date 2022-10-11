package com.nuc.zmblog.service.impl.admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuc.zmblog.mapper.BlogMapper;
import com.nuc.zmblog.mapper.TagsBlogMapper;
import com.nuc.zmblog.mapper.TagsMapper;
import com.nuc.zmblog.pojo.*;
import com.nuc.zmblog.request.TagsReq;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.resp.TagsResp;
import com.nuc.zmblog.resp.TypeResp;
import com.nuc.zmblog.service.admin.TagsService;
import com.nuc.zmblog.utils.CopyUtils;
import com.nuc.zmblog.utils.SnowFlake;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class TagsServiceImpl implements TagsService {

    @Resource
    private TagsMapper tagsMapper;

    @Resource
    SnowFlake snowFlake;

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
        return getTagsRespPageResp(page, size);
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
    public PageResp<TagsResp> listTag(Integer page, Integer size) {
        return getTagsRespPageResp(page, size);
    }

    private PageResp<TagsResp> getTagsRespPageResp(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        TagsExample example = new TagsExample();
        example.setOrderByClause("update_time desc");
        List<Tags> types = tagsMapper.selectByExample(null);
        List<TagsResp> typeResps = CopyUtils.copyList(types, TagsResp.class);
        PageInfo<TagsResp> pageInfo = new PageInfo<>(typeResps);
        long total = pageInfo.getTotal();
        boolean isFirst = page == 1;
        boolean isLast = total < size ;
        return new PageResp<>(pageInfo.getTotal(), pageInfo.getList(),page,isFirst,isLast);
    }

    @Override
    public List<TagsResp> listTags(String ids) {
        if (StringUtils.isEmptyOrWhitespace(ids)) return null;
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
                if (tagsBlogs.indexOf(tagsBlog) < tagsBlogs.size())
                ids.append(",");
        }
        return listTags(ids.toString());
    }

    @Override
    public Integer saveTag(TagsReq req) {
        Tags tags = new Tags();
        if (req.getId() != null) return updateTags(req);
        long l = snowFlake.nextId();
        List<Tags> tagsList = tagsMapper.selectByName(req.getName());
        if (tagsList.size() > 0) return 0;
        tags.setId(l);
        tags.setName(req.getName());
//        属性名字必须一样
//        BeanUtils.copyProperties(typeAddReq,type);
        return tagsMapper.insert(tags);
    }

    @Override
    public List<TagsResp> listTags(Integer size) {
        List<TagInfo> list = topN(size);
        return CopyUtils.copyList(list, TagsResp.class);
    }

    private List<TagInfo> topN(Integer size) {
        long l = tagsMapper.countByExample(null);
        if (l <= size) {
            ArrayList<TagInfo> ans = new ArrayList<>();
            Queue<TagInfo> queue = new PriorityQueue<>(new TagInfo());
            List<TagsResp> tagResps = listTags();
            for (TagsResp tagResp : tagResps) {
                long l1 = tagsBlogMapper.countByExample(null);
                TagInfo tagInfo = new TagInfo(tagResp.getId(), l1,tagResp.getName());
                queue.add(tagInfo);
            }
            while (!queue.isEmpty()) {
                ans.add(queue.poll());
            }
            return ans;
        }
        TagsBlogExample example = new TagsBlogExample();
        TagsBlogExample.Criteria criteria = example.createCriteria();
        List<TagsResp> tagResps = listTags();
        Queue<TagInfo> queue = new PriorityQueue<>(new TagInfo());
        for (TagsResp tagResp : tagResps) {
            criteria.andTagsIdEqualTo(tagResp.getId());
            long l1 = tagsBlogMapper.countByExample(example);
            TagInfo tagInfo = new TagInfo(tagResp.getId(), l1,tagResp.getName());
            queue.add(tagInfo);
        }
        ArrayList<TagInfo> ans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            assert queue.peek() != null;
            System.out.println(queue.peek().blogSize);
            ans.add(queue.poll());
        }
        return ans;
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
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TagInfo implements Comparator<TagsServiceImpl.TagInfo> {
        Long id;
        Long blogSize;
        String name;


        @Override
        public int compare(TagInfo o1, TagInfo o2) {
            return (int) (o2.blogSize - o1.blogSize);
        }
    }

}
