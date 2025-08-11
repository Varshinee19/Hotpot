package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PaymentDto {
	@NotNull
	@Min(1)
	private int paymentId;
	@NotNull(message="Amount can't be null")
	private double amount;
	@NotEmpty(message="Payment mode must be specified")
	private String mode;
	@NotBlank(message="Payment status cannot be blank")
	private String status;

}
