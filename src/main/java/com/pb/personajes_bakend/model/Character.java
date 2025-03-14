package com.pb.personajes_bakend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    private String imageUrl;

    @NotBlank(message = "El rol es obligatorio")
    private String role;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }

    public Character() {
    }

    public Character(Long id, String name, String imageUrl, String role, String description, LocalDateTime createdDate) {
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

    public @NotBlank(message = "El nombre es obligatorio") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "El nombre es obligatorio") String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public @NotBlank(message = "El rol es obligatorio") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "El rol es obligatorio") String role) {
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
