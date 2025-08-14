/*
 * 
 * auth: Varshinee
 * DTO class for validation.
 */
package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrdersDto {
	private int orderId;
	@NotNull
	private double totalPrice;
	@NotEmpty(message="Delivery Address cannot be empty")
	private String deliveryAddress;
	@NotBlank
	private String status;

}
