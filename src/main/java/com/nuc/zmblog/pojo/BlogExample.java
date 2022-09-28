package com.nuc.zmblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public BlogExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("blog.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("blog.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("blog.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("blog.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("blog.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("blog.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("blog.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("blog.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("blog.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("blog.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("blog.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("blog.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitileIsNull() {
            addCriterion("blog.titile is null");
            return (Criteria) this;
        }

        public Criteria andTitileIsNotNull() {
            addCriterion("blog.titile is not null");
            return (Criteria) this;
        }

        public Criteria andTitileEqualTo(String value) {
            addCriterion("blog.titile =", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotEqualTo(String value) {
            addCriterion("blog.titile <>", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileGreaterThan(String value) {
            addCriterion("blog.titile >", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileGreaterThanOrEqualTo(String value) {
            addCriterion("blog.titile >=", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileLessThan(String value) {
            addCriterion("blog.titile <", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileLessThanOrEqualTo(String value) {
            addCriterion("blog.titile <=", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileLike(String value) {
            addCriterion("blog.titile like", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotLike(String value) {
            addCriterion("blog.titile not like", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileIn(List<String> values) {
            addCriterion("blog.titile in", values, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotIn(List<String> values) {
            addCriterion("blog.titile not in", values, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileBetween(String value1, String value2) {
            addCriterion("blog.titile between", value1, value2, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotBetween(String value1, String value2) {
            addCriterion("blog.titile not between", value1, value2, "titile");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("blog.content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("blog.content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("blog.content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("blog.content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("blog.content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("blog.content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("blog.content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("blog.content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("blog.content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("blog.content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("blog.content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("blog.content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("blog.content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("blog.content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureIsNull() {
            addCriterion("blog.first_picture is null");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureIsNotNull() {
            addCriterion("blog.first_picture is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureEqualTo(String value) {
            addCriterion("blog.first_picture =", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureNotEqualTo(String value) {
            addCriterion("blog.first_picture <>", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureGreaterThan(String value) {
            addCriterion("blog.first_picture >", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureGreaterThanOrEqualTo(String value) {
            addCriterion("blog.first_picture >=", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureLessThan(String value) {
            addCriterion("blog.first_picture <", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureLessThanOrEqualTo(String value) {
            addCriterion("blog.first_picture <=", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureLike(String value) {
            addCriterion("blog.first_picture like", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureNotLike(String value) {
            addCriterion("blog.first_picture not like", value, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureIn(List<String> values) {
            addCriterion("blog.first_picture in", values, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureNotIn(List<String> values) {
            addCriterion("blog.first_picture not in", values, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureBetween(String value1, String value2) {
            addCriterion("blog.first_picture between", value1, value2, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFirst_pictureNotBetween(String value1, String value2) {
            addCriterion("blog.first_picture not between", value1, value2, "first_picture");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("blog.flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("blog.flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("blog.flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("blog.flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("blog.flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("blog.flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("blog.flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("blog.flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("blog.flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("blog.flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("blog.flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("blog.flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("blog.flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("blog.flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andViewsIsNull() {
            addCriterion("blog.views is null");
            return (Criteria) this;
        }

        public Criteria andViewsIsNotNull() {
            addCriterion("blog.views is not null");
            return (Criteria) this;
        }

        public Criteria andViewsEqualTo(Long value) {
            addCriterion("blog.views =", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotEqualTo(Long value) {
            addCriterion("blog.views <>", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThan(Long value) {
            addCriterion("blog.views >", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThanOrEqualTo(Long value) {
            addCriterion("blog.views >=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThan(Long value) {
            addCriterion("blog.views <", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThanOrEqualTo(Long value) {
            addCriterion("blog.views <=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsIn(List<Long> values) {
            addCriterion("blog.views in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotIn(List<Long> values) {
            addCriterion("blog.views not in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsBetween(Long value1, Long value2) {
            addCriterion("blog.views between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotBetween(Long value1, Long value2) {
            addCriterion("blog.views not between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andAppreciationIsNull() {
            addCriterion("blog.appreciation is null");
            return (Criteria) this;
        }

        public Criteria andAppreciationIsNotNull() {
            addCriterion("blog.appreciation is not null");
            return (Criteria) this;
        }

        public Criteria andAppreciationEqualTo(Integer value) {
            addCriterion("blog.appreciation =", value, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationNotEqualTo(Integer value) {
            addCriterion("blog.appreciation <>", value, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationGreaterThan(Integer value) {
            addCriterion("blog.appreciation >", value, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog.appreciation >=", value, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationLessThan(Integer value) {
            addCriterion("blog.appreciation <", value, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationLessThanOrEqualTo(Integer value) {
            addCriterion("blog.appreciation <=", value, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationIn(List<Integer> values) {
            addCriterion("blog.appreciation in", values, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationNotIn(List<Integer> values) {
            addCriterion("blog.appreciation not in", values, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationBetween(Integer value1, Integer value2) {
            addCriterion("blog.appreciation between", value1, value2, "appreciation");
            return (Criteria) this;
        }

        public Criteria andAppreciationNotBetween(Integer value1, Integer value2) {
            addCriterion("blog.appreciation not between", value1, value2, "appreciation");
            return (Criteria) this;
        }

        public Criteria andCommentatedIsNull() {
            addCriterion("blog.Commentated is null");
            return (Criteria) this;
        }

        public Criteria andCommentatedIsNotNull() {
            addCriterion("blog.Commentated is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatedEqualTo(Integer value) {
            addCriterion("blog.Commentated =", value, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedNotEqualTo(Integer value) {
            addCriterion("blog.Commentated <>", value, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedGreaterThan(Integer value) {
            addCriterion("blog.Commentated >", value, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog.Commentated >=", value, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedLessThan(Integer value) {
            addCriterion("blog.Commentated <", value, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedLessThanOrEqualTo(Integer value) {
            addCriterion("blog.Commentated <=", value, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedIn(List<Integer> values) {
            addCriterion("blog.Commentated in", values, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedNotIn(List<Integer> values) {
            addCriterion("blog.Commentated not in", values, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedBetween(Integer value1, Integer value2) {
            addCriterion("blog.Commentated between", value1, value2, "commentated");
            return (Criteria) this;
        }

        public Criteria andCommentatedNotBetween(Integer value1, Integer value2) {
            addCriterion("blog.Commentated not between", value1, value2, "commentated");
            return (Criteria) this;
        }

        public Criteria andPublishedIsNull() {
            addCriterion("blog.published is null");
            return (Criteria) this;
        }

        public Criteria andPublishedIsNotNull() {
            addCriterion("blog.published is not null");
            return (Criteria) this;
        }

        public Criteria andPublishedEqualTo(Integer value) {
            addCriterion("blog.published =", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedNotEqualTo(Integer value) {
            addCriterion("blog.published <>", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedGreaterThan(Integer value) {
            addCriterion("blog.published >", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog.published >=", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedLessThan(Integer value) {
            addCriterion("blog.published <", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedLessThanOrEqualTo(Integer value) {
            addCriterion("blog.published <=", value, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedIn(List<Integer> values) {
            addCriterion("blog.published in", values, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedNotIn(List<Integer> values) {
            addCriterion("blog.published not in", values, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedBetween(Integer value1, Integer value2) {
            addCriterion("blog.published between", value1, value2, "published");
            return (Criteria) this;
        }

        public Criteria andPublishedNotBetween(Integer value1, Integer value2) {
            addCriterion("blog.published not between", value1, value2, "published");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("blog.recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("blog.recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Integer value) {
            addCriterion("blog.recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Integer value) {
            addCriterion("blog.recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Integer value) {
            addCriterion("blog.recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog.recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Integer value) {
            addCriterion("blog.recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("blog.recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Integer> values) {
            addCriterion("blog.recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Integer> values) {
            addCriterion("blog.recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Integer value1, Integer value2) {
            addCriterion("blog.recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("blog.recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("blog.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("blog.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("blog.create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("blog.create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("blog.create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog.create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("blog.create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("blog.create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("blog.create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("blog.create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("blog.create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("blog.create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("blog.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("blog.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("blog.update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("blog.update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("blog.update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog.update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("blog.update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("blog.update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("blog.update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("blog.update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("blog.update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("blog.update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andType_idIsNull() {
            addCriterion("blog.type_id is null");
            return (Criteria) this;
        }

        public Criteria andType_idIsNotNull() {
            addCriterion("blog.type_id is not null");
            return (Criteria) this;
        }

        public Criteria andType_idEqualTo(Long value) {
            addCriterion("blog.type_id =", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotEqualTo(Long value) {
            addCriterion("blog.type_id <>", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idGreaterThan(Long value) {
            addCriterion("blog.type_id >", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idGreaterThanOrEqualTo(Long value) {
            addCriterion("blog.type_id >=", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idLessThan(Long value) {
            addCriterion("blog.type_id <", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idLessThanOrEqualTo(Long value) {
            addCriterion("blog.type_id <=", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idIn(List<Long> values) {
            addCriterion("blog.type_id in", values, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotIn(List<Long> values) {
            addCriterion("blog.type_id not in", values, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idBetween(Long value1, Long value2) {
            addCriterion("blog.type_id between", value1, value2, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotBetween(Long value1, Long value2) {
            addCriterion("blog.type_id not between", value1, value2, "type_id");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}