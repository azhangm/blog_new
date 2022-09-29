package com.nuc.zmblog.service.impl.admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuc.zmblog.mapper.TypeMapper;
import com.nuc.zmblog.pojo.Type;
import com.nuc.zmblog.pojo.TypeExample;
import com.nuc.zmblog.request.TypeReq;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.resp.TypeResp;
import com.nuc.zmblog.service.admin.TypeService;
import com.nuc.zmblog.utils.CopyUtils;
import com.nuc.zmblog.utils.SnowFlake;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Resource SnowFlake snowFlake;


//    这里可以返回一个 type resp 指定错误信息 我的想法 之后在修改
    @Override
    public Integer saveType(TypeReq typeAddReq) {
        Type type = new Type();
        System.out.println(typeAddReq.getId());
        if (typeAddReq.getId() != null) return updateType(typeAddReq);
        long l = snowFlake.nextId();
        List<Type> types = typeMapper.selectByName(typeAddReq.getTypeName());
        if (types.size() > 0) return 0;
        type.setId(l);
        type.setName(typeAddReq.getTypeName());
//        属性名字必须一样
//        BeanUtils.copyProperties(typeAddReq,type);
        return typeMapper.insert(type);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }


    @Override
    public int removeById(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateType(TypeReq typeReq) {
        Long id = typeReq.getId();
        Type type = typeMapper.selectByPrimaryKey(id);
        if (type == null) { return 0; }
        type.setName(typeReq.getTypeName());
        return typeMapper.updateByPrimaryKey(type);
    }

    @Override
    public PageResp<TypeResp> listType(Integer page , Integer size) {
        PageHelper.startPage(page,size);
        TypeExample example = new TypeExample();
        example.setOrderByClause("update_time desc");
        List<Type> types = typeMapper.selectByExample(null);
        List<TypeResp> typeResps = CopyUtils.copyList(types, TypeResp.class);
        PageInfo<TypeResp> pageInfo = new PageInfo<>(typeResps);
        long total = pageInfo.getTotal();
        boolean isFirst = page == 1;
        boolean isLast = total < size ;
        return new PageResp<>(pageInfo.getTotal(), pageInfo.getList(),page,isFirst,isLast);
    }

    /**
     * 列表类型
     *
     * @return {@link List}<{@link TypeResp}>
     */
    @Override
    public List<TypeResp> listType() {
        List<Type> types = typeMapper.selectByExample(null);
        return CopyUtils.copyList(types, TypeResp.class);
    }


}
