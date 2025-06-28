package com.example.portfolio.model;

public class Project {
    private String title;
    private String description;
    private String technologies;
    private String category;

    public Project(String title, String description, String technologies, String category) {
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.category = category;
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getTechnologies() { return technologies; }
    public String getCategory() { return category; }
}
