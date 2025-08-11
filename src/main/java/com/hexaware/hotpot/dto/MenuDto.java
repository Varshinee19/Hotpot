package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class MenuDto {
	private int menuId;
	@NotEmpty(message="ItemName cannot be empty")
	private String itemName;
	@NotBlank
	private String description;
	@NotNull(message="Price cannot be null")
	@Min(value=1)
	private double price;
	@NotNull(message="Specify type(Veg/Non-Veg)")
	private String type;
	private String image;
	@NotBlank
	private String info;

}
