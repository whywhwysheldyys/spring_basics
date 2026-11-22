package com.example.demo.l12_Library;

public class LibraryDTO {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private boolean status;
    private int pages;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
}