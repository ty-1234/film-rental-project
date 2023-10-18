package com.films4you.req4;
public class FilmCategory {
    private int filmId;
    private int categoryId;
    
    public FilmCategory(int filmId, int categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }
    
    // Getters and setters
    public int getFilmId() {
        return filmId;
    }
    
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
    
    public int getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}