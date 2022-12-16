package com.fullcycle.admincatalog.application;

import com.fullcycle.admincatalog.domain.category.Category;

public class UseCase {

    public Category execute() {
        return new Category();
    }
}