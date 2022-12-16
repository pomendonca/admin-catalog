package com.fullcycle.admincatalog.domain.category;

import com.fullcycle.admincatalog.AggregateRoot;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {

    private String name;

    private String description;

    private boolean active;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

    private Category(CategoryID id, String name, String description, boolean active, Instant createdAt, Instant updatedAt, Instant deletedAt) {
        super(id);
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Category newCategory(final String name, final String description, final boolean active) {
        final CategoryID id = CategoryID.unique();
        final Instant now = Instant.now();

        return new Category(id, name, description, active, now, now, now);
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}