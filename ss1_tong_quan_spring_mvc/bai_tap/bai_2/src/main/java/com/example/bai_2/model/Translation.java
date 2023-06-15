package com.example.bai_2.model;

public class Translation {
    private String en;
    private String vi;

    public Translation() {
    }

    public Translation(String en, String vi) {
        this.en = en;
        this.vi = vi;
    }


    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }
}
