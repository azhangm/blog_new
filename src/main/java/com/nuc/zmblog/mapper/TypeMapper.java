package com.nuc.zmblog.mapper;

import com.nuc.zmblog.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<Type> selectByName(String typeName);

    Integer insert(Type type);

    Type selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    List<Type> selectByExample(Type type);

    int deleteByExample(Type type);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int insertSelective(Type record);

    int updateByPrimaryKey(Type record);

    long countByExample(TypeExample example);

}