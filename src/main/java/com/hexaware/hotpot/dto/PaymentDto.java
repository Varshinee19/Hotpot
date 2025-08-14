package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class PaymentDto {
	@NotNull
	private int paymentId;
	@NotNull(message="Amount can't be null")
	@Min(1)
	private double amount;
	@NotEmpty(message="Payment mode must be specified")
	@Pattern(regexp="^(UPI|NetBanking|COD|Card)$")
	private String mode;
	@NotBlank(message="Payment status cannot be blank")
	@Pattern(regexp="^(pending|success|failed)$")
	private String status;
	private int orderId;

}
