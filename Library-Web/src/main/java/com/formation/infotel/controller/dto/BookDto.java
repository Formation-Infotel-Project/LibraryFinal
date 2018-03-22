package com.formation.infotel.controller.dto;

import java.sql.Date;
import java.util.List;

public class BookDto {

    private String title;
    private String description;
    private float price;
    private List<Integer> authorsId;
    private int categoryId;
    private int editorId;
    private Date pubDate;
    private boolean popular;
    private String imagePath;

    public BookDto() {
    }

    public BookDto(String title, String description, float price, List<Integer> authorsId, int categoryId, int editorId, Date pubDate, boolean popular, String imagePath) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.authorsId = authorsId;
        this.categoryId = categoryId;
        this.editorId = editorId;
        this.pubDate = pubDate;
        this.popular = popular;
        this.imagePath = imagePath;
    }
    public BookDto(String title, String description, float price, Date pubDate) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.pubDate = pubDate;
        }
    
     



    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Integer> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(List<Integer> authorsId) {
        this.authorsId = authorsId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

   

    public boolean getPopular() {
		return popular;
	}

	public void setPopular(boolean popular) {
		this.popular = popular;
	}

	public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
