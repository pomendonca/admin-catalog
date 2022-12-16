package com.fullcycle.admincatalog.domain.category;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void givenAValidParam_whenCallNewCategory_thenInstantiateACategory() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida.";
        final var expectedIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);


        assertNotNull(actualCategory);
        assertNotNull(actualCategory.getId());
        assertEquals(expectedName, actualCategory.getName());
        assertEquals(expectedDescription, actualCategory.getDescription());
        assertEquals(expectedIsActive, actualCategory.isActive());
        assertNotNull(actualCategory.getCreatedAt());
        assertNotNull(actualCategory.getUpdatedAt());
        assertNotNull(actualCategory.getDeletedAt());
    }

    @Test
    public void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReturnError() {
        final String expectedName = null;
        final var expectErrorCount = 1;
        final var expectErrorMessage = "'name' should not be null";
        final var expectedDescription = "A categoria mais assistida.";
        final var expectedIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException = assertThrows(DomainException.class, () -> actualCategory.validate());

        assertEquals(expectErrorCount, actualException.getErrors);
        assertEquals(expectErrorMessage, actualException.getErrors().get(0));
    }

}
