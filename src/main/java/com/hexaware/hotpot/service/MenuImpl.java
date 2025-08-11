package com.hexaware.hotpot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.MenuDto;
import com.hexaware.hotpot.entities.Menu;
import com.hexaware.hotpot.repository.MenuRepository;
@Service
public class MenuImpl implements IMenuService {
	
	@Autowired
	MenuRepository repo;

	@Override
	public Menu addMenuItem(MenuDto menu) {
		Menu menus=repo.findById(menu.getMenuId()).orElse(null);
		menus.setItemName(menu.getItemName());
		menus.setType(menu.getType());
		menus.setDescription(menu.getDescription());
		menus.setInfo(menu.getInfo());
		menus.setImage(menu.getImage());
		menus.setPrice(menu.getPrice());
		
		return repo.save(menus);
	}

	@Override
	public Menu updateMenu(Integer menuId,MenuDto menu) {
		Menu menus=repo.findById(menuId).orElse(null);
		menus.setItemName(menu.getItemName());
		menus.setType(menu.getType());
		menus.setDescription(menu.getDescription());
		menus.setInfo(menu.getInfo());
		menus.setImage(menu.getImage());
		menus.setPrice(menu.getPrice());
		
		return repo.save(menus);
		
	}

	@Override
	public List<Menu> getMenuByRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		return repo.findByRestaurant(restaurantId);
	}

	@Override
	public List<Menu> getMenuByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return repo.findByCategory(categoryId);
	}

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String deleteMenuItem(int menuId) {
		// TODO Auto-generated method stub
		repo.deleteById(menuId);
		return "Menu deleted";
	}

	@Override
	public Menu getById(int menuId) {
		// TODO Auto-generated method stub
		return repo.findById(menuId).orElse(null);
	}

}
