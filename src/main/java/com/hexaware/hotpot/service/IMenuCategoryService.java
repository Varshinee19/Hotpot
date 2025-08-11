package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.MenuCategoriesDto;
import com.hexaware.hotpot.entities.MenuCategories;

public interface IMenuCategoryService {
	public MenuCategories addCategory(MenuCategoriesDto category);
	public MenuCategories updateCategory(Integer CategoryId,MenuCategoriesDto category);
    public List<MenuCategories> getAllCategories();
    public String deleteCategory(int categoryId);
    public MenuCategories getById(int categoryId);
}
