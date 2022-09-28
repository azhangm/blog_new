package com.nuc.zmblog.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResp<T> {
    private Long total;
    private List<T> list;
    private Integer nowPage;
    private boolean isFirst;
    private boolean isLast;
}
