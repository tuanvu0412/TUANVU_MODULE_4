package com.example.bai_1.model;

public class BoxEmail {
    private String languages;
    private int size;
    private boolean filter;
    private String signature;
    public BoxEmail(String languages, int size, boolean filter, String signature) {
        this.languages = languages;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public BoxEmail() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
