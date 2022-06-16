package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository repository;

    @Test
    public void getCategories(){
        List<Category> list = repository.findAll(Sort.by("id").descending());
        System.out.println(list);
    }
}
