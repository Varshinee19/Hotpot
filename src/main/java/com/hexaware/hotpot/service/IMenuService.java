package com.hexaware.hotpot.service;
import java.util.List;

import com.hexaware.hotpot.dto.MenuDto;
import com.hexaware.hotpot.entities.Menu;

public interface IMenuService {
	
	public Menu addMenuItem(MenuDto menu);
	public Menu updateMenu(Integer menuId,MenuDto menu);
	public List<Menu> getMenuByRestaurant(int restaurantId);
	public List<Menu> getMenuByCategory(int categoryId);
	public List<Menu> getAllMenu();
	public Menu getById(int menuId);
	public String deleteMenuItem(int menuId);
	

	

}
