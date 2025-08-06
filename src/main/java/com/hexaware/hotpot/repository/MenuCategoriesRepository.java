package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.entities.MenuCategories;
@Repository
public interface MenuCategoriesRepository extends JpaRepository<MenuCategories,Integer> {

}
