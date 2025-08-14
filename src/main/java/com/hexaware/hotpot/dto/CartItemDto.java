/*
 * 
 * auth: Varshinee
 * DTO class for validation.
 */
package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CartItemDto {
	@NotNull
	private int CartItemId;
	@NotNull
	private int cartId;
	@NotNull
	private int menuId;
	@NotNull
	@Min(value=1)
	private int quantity;
	private int orderItemId;

}
