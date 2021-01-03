package com.shiaopin.horizontalgridviewpager;

public class ProductModel {
    private int item_img;
    private String item_title;

    public ProductModel(int item_img, String item_title) {
        this.item_img = item_img;
        this.item_title = item_title;
    }

    public int getItem_img() {
        return item_img;
    }

    public void setItem_img(int item_img) {
        this.item_img = item_img;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }
}
