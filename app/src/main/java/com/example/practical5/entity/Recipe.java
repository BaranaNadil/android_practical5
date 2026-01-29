package com.example.practical5.entity;

import android.net.Uri;

public class Recipe {

    private String menuName;
    private String menuPrice;

    private Uri productImage;

    public Recipe(String menuName, String menuPrice, Uri productImage) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.productImage = productImage;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Uri getProductImage() {
        return productImage;
    }

    public void setProductImage(Uri productImage) {
        this.productImage = productImage;
    }
}
