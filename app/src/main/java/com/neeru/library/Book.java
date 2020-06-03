package com.neeru.library;

public class Book {
    private int id;
    private String name;
    private String author;
    private int pages;
    private String imageurl;
    private String shortDesc;
    private String LongDesc;

    public Book(int id, String name, String author, int pages, String imageurl, String shortDesc, String longDesc) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imageurl = imageurl;
        this.shortDesc = shortDesc;
        LongDesc = longDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imageurl='" + imageurl + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", LongDesc='" + LongDesc + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return LongDesc;
    }

    public void setLongDesc(String longDesc) {
        LongDesc = longDesc;
    }
}
