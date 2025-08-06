package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrdersDto {
	@NotNull
	private double totalprice;
	@NotEmpty(message="Delivery Address cannot be empty")
	private String deladdress;
	@NotBlank
	private String status;

}
