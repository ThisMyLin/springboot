package com.xiaozhai.Pojo;

import lombok.ToString;

@ToString
public class Category {
    private Integer categoryId;

    private String appImage;

    private String categoryName;

    private Integer categorySort;

    private Integer deep;

    private Integer parentId;

    private String categoryNameMian;

    private String categoryNameEnglish;

    private Boolean isPush;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage == null ? null : appImage.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getCategorySort() {
        return categorySort;
    }

    public void setCategorySort(Integer categorySort) {
        this.categorySort = categorySort;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCategoryNameMian() {
        return categoryNameMian;
    }

    public void setCategoryNameMian(String categoryNameMian) {
        this.categoryNameMian = categoryNameMian == null ? null : categoryNameMian.trim();
    }

    public String getCategoryNameEnglish() {
        return categoryNameEnglish;
    }

    public void setCategoryNameEnglish(String categoryNameEnglish) {
        this.categoryNameEnglish = categoryNameEnglish == null ? null : categoryNameEnglish.trim();
    }

    public Boolean getIsPush() {
        return isPush;
    }

    public void setIsPush(Boolean isPush) {
        this.isPush = isPush;
    }
}