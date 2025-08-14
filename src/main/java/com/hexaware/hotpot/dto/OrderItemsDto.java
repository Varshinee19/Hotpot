/*
 * 
 * auth: Varshinee
 * DTO class for validation.
 */
package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderItemsDto {
	private int orderItemId;
	@NotNull
	@Min(value=1)
	private int quantity;
	@NotNull(message="Price cannot be null")
	@Min(value=1)
	private double price;
	@NotBlank
	private String itemName;
	@NotNull
	private int orderId;
	@NotNull
	private int menuId;

}
