/*
 * 
 * auth: Varshinee
 * DTO class for validation.
 */
package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CartDto {
	@NotNull
	private int cartId;
	private int customerId;
	

}
