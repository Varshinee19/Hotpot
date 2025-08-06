package com.hexaware.hotpot.service;
import java.util.*;
import com.hexaware.hotpot.entities.Menu;

public interface IMenuService {
	
	public Menu addMenuItem(Menu menu);
	public Menu updateMenu(Menu menu);
	public List<Menu> getMenuByRestaurant(int resid);
	public List<Menu> getMenuByCategory(int catid);
	public List<Menu> getAllMenu();
	public String deleteMenuItem(int menuid);
	

	

}
