/*
 * 
 * auth: Varshinee
 * DTO class for validation.
 */
package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class RestaurantDto {
	private int restaurantId;
	@NotBlank(message="Restaurant name cannot be left blank")
	private String restaurantName;
	@NotNull(message="Restaurant address is mandatory")
	private String restaurantAddress;
	@NotNull
	private String phoneNo;

}
