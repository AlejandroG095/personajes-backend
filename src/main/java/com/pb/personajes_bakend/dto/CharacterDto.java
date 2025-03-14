package com.pb.personajes_bakend.dto;

import java.time.LocalDateTime;

public class CharacterDto {

    private Long id;

    private String name;

    private String imageUrl;

    private String role;

    private String description;

    private LocalDateTime createdDate;

    public CharacterDto() {
    }

    public CharacterDto(Long id, String name, String imageUrl, String role, String description, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.role = role;
        this.description = description;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
