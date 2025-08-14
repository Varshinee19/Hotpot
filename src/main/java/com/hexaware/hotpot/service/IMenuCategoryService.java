package com.hexaware.hotpot.service;
/*
 * 
 * auth: Varshinee
 * Service Interface Class.
 */
import java.util.List;

import com.hexaware.hotpot.dto.MenuCategoriesDto;
import com.hexaware.hotpot.entities.MenuCategories;
import com.hexaware.hotpot.exception.CategoryDoesNotExistException;

public interface IMenuCategoryService {
	public MenuCategories addCategory(MenuCategoriesDto category);
	public MenuCategories updateCategory(Integer CategoryId,MenuCategoriesDto category) throws CategoryDoesNotExistException;
    public List<MenuCategories> getAllCategories();
    public String deleteCategory(int categoryId)throws CategoryDoesNotExistException;
    public MenuCategories getById(int categoryId)throws CategoryDoesNotExistException;
    
}
