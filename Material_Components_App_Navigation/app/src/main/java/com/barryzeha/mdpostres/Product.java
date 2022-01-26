package com.barryzeha.mdpostres;

import java.util.Objects;

public class Product {
    private String name;
    private String url;
    private boolean selected;

    public Product(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return selected == product.selected && Objects.equals(name, product.name) && Objects.equals(url, product.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, selected);
    }
}
