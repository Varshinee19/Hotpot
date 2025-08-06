package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.MenuCategories;

public interface IMenuCategoryService {
	public MenuCategories addCategory(MenuCategories category);
	public MenuCategories updateCategory(MenuCategories category);
    public List<MenuCategories> getAllCategories();
    public String deleteCategory(int catid);
}
