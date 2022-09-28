package com.nuc.zmblog.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tags_blog
 * @author zm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagsBlog implements Serializable {
    /**
     * 多对多表的关系主键
     */
    private Long id;

    /**
     * 博客表主键
     */
    private Long blogId;

    /**
     * 标签表主键
     */
    private Long tagsId;

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
        TagsBlog other = (TagsBlog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBlogId() == null ? other.getBlogId() == null : this.getBlogId().equals(other.getBlogId()))
            && (this.getTagsId() == null ? other.getTagsId() == null : this.getTagsId().equals(other.getTagsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBlogId() == null) ? 0 : getBlogId().hashCode());
        result = prime * result + ((getTagsId() == null) ? 0 : getTagsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogId=").append(blogId);
        sb.append(", tagsId=").append(tagsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}