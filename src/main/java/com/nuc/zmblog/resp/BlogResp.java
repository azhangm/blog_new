package com.nuc.zmblog.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 博客职责
 *
 * @author zm
 * @date 2022/09/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogResp  {
    /**
     * 博客id
     */
    private Long id;

    /**
     * 博客标题
     */
    private String titile;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 博客图片
     */
    private String first_picture;

    /**
     * 博客原创 转载 翻译
     */
    private String flag;

    /**
     * 博客被阅读次数
     */
    private Long views;

    /**
     * 是否开启赞赏功能
     */
    private boolean appreciation;

    /**
     * 是否开启评论  0 否 1 是
     */
    private boolean commentated;

    /**
     * 是否发布该博客~
     */
    private boolean published;

    /**
     * 是否推荐该博客~
     */
    private boolean recommend;

    private String type;
    /**
     * 创建时间
     */

    private String description;

    private List<String > tags;
    private LocalDateTime create_time;


    private String tagIds;
    /**
     * 更新时间
     */
    private LocalDateTime update_time;
}
