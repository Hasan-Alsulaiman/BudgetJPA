package com.example.budgetwithjpa.data;

import com.example.budgetwithjpa.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    public Category findCategoryByName(String name);

    @Modifying
    @Query(value = "update Category c set c.name = :newName where c.name = :original")
    public int update(String original, String newName);
}
