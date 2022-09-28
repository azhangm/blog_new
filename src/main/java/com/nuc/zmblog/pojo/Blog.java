package com.nuc.zmblog.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * blog
 * @author 
 */
@Data

public class Blog implements Serializable {
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
    private Integer appreciation;

    /**
     * 是否开启评论  0 否 1 是
     */
    private Integer commentated;

    /**
     * 是否发布该博客~
     */
    private Integer published;

    /**
     * 是否推荐该博客~
     */
    private Integer recommend;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    private Long type_id;

    private String type;


    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Blog other = (Blog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitile() == null ? other.getTitile() == null : this.getTitile().equals(other.getTitile()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getFirst_picture() == null ? other.getFirst_picture() == null : this.getFirst_picture().equals(other.getFirst_picture()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getViews() == null ? other.getViews() == null : this.getViews().equals(other.getViews()))
            && (this.getAppreciation() == null ? other.getAppreciation() == null : this.getAppreciation().equals(other.getAppreciation()))
            && (this.getCommentated() == null ? other.getCommentated() == null : this.getCommentated().equals(other.getCommentated()))
            && (this.getPublished() == null ? other.getPublished() == null : this.getPublished().equals(other.getPublished()))
            && (this.getRecommend() == null ? other.getRecommend() == null : this.getRecommend().equals(other.getRecommend()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getType_id() == null ? other.getType_id() == null : this.getType_id().equals(other.getType_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitile() == null) ? 0 : getTitile().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getFirst_picture() == null) ? 0 : getFirst_picture().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getViews() == null) ? 0 : getViews().hashCode());
        result = prime * result + ((getAppreciation() == null) ? 0 : getAppreciation().hashCode());
        result = prime * result + ((getCommentated() == null) ? 0 : getCommentated().hashCode());
        result = prime * result + ((getPublished() == null) ? 0 : getPublished().hashCode());
        result = prime * result + ((getRecommend() == null) ? 0 : getRecommend().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getType_id() == null) ? 0 : getType_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", titile=").append(titile);
        sb.append(", content=").append(content);
        sb.append(", first_picture=").append(first_picture);
        sb.append(", flag=").append(flag);
        sb.append(", views=").append(views);
        sb.append(", appreciation=").append(appreciation);
        sb.append(", commentated=").append(commentated);
        sb.append(", published=").append(published);
        sb.append(", recommend=").append(recommend);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", type_id=").append(type_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}