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

    @NotBlank(message = "La imagen es obligatoria")
    private String imageUrl;

    @NotBlank(message = "El rol es obligatorio")
    private String role;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "La descripción es obligatoria")
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

    public @NotBlank(message = "El nombre es obligatorio") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "El nombre es obligatorio") String name) {
        this.name = name;
    }

    public @NotBlank(message = "La imagen es obligatoria") String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotBlank(message = "La imagen es obligatoria") String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public @NotBlank(message = "El rol es obligatorio") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "El rol es obligatorio") String role) {
        this.role = role;
    }

    public @NotBlank(message = "La descripción es obligatoria") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "La descripción es obligatoria") String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
