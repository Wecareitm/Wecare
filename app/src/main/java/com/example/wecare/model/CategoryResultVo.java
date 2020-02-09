package com.example.wecare.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryResultVo {

    @SerializedName("Category_id")
    @Expose
    private String categoryId;
    @SerializedName("Category_name")
    @Expose
    private String categoryName;
    @SerializedName("Category_icon")
    @Expose
    private String categoryIcon;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }
}
