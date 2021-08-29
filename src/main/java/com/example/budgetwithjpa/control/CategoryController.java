package com.example.budgetwithjpa.control;

import com.example.budgetwithjpa.data.CategoryRepository;
import com.example.budgetwithjpa.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/cat")
@Transactional
public class CategoryController {
    CategoryRepository catRepo;

    @Autowired
    public CategoryController(CategoryRepository catRepo) {
        this.catRepo = catRepo;
    }

    @GetMapping("/view")
    public Iterable<Category> viewAll() {
        return catRepo.findAll();
    }

    @PostMapping("/add/{type}")
    public String addCategory(@PathVariable String type) {
        catRepo.save(new Category(type));
        return "ok ";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        catRepo.deleteById(id);
    }

    @PutMapping("/update")
    public int updateCategory(@Param("original") String original, @Param("newName") String newName) {
        return catRepo.update(original, newName);
    }
}
