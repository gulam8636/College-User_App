package com.example.myapp20.Ebook;

public class EbookData {
    private String name,url;

    public EbookData() {
    }

    public EbookData(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }
}
