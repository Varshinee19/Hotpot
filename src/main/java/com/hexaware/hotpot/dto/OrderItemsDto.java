package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderItemsDto {
	@NotNull
	@Min(value=1)
	private int quantity;
	@NotNull(message="Price cannot be null")
	private double price;

}
