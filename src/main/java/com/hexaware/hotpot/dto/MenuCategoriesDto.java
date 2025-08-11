package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class MenuCategoriesDto {
	private int categoryId;
	@NotEmpty(message="category name must not be empty")
	private String categoryName;

}
