package com.nuc.zmblog.mapper;

import com.nuc.zmblog.pojo.TagsBlog;
import com.nuc.zmblog.pojo.TagsBlogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagsBlogMapper {
    long countByExample(TagsBlogExample example);

    int deleteByExample(TagsBlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TagsBlog record);

    int insertSelective(TagsBlog record);

    List<TagsBlog> selectByExample(TagsBlogExample example);

    TagsBlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TagsBlog record, @Param("example") TagsBlogExample example);

    int updateByExample(@Param("record") TagsBlog record, @Param("example") TagsBlogExample example);

    int updateByPrimaryKeySelective(TagsBlog record);

    int updateByPrimaryKey(TagsBlog record);

    List<Long> selectByBlogId(Long blogId);

    Long countByTagId(Long id);
}