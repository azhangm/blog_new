package com.nuc.zmblog.resp;

import com.nuc.zmblog.pojo.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeResp {

    private Long id;

    private String name;

    private Long blogSize;
}
