package services;

import dao.CategoryDao;
import entity.Category;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryService {

        private final CategoryDao categoryDao;

        public List<Category> getAllCategories() {
            return categoryDao.findAll();
        }

}
