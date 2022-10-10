package com.nuc.zmblog.service.admin;

import com.nuc.zmblog.pojo.Type;
import com.nuc.zmblog.request.TypeReq;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.resp.TypeResp;

import java.util.List;

public interface TypeService {
    Integer saveType(TypeReq typeAddReq);

    Type getTypeById(Long id);

    int removeById(Long id);

    int updateType(TypeReq typeReq);

    PageResp<TypeResp> listType(Integer page, Integer size);

    List<TypeResp> listType();

    List<TypeResp> listType(Integer size);

}
