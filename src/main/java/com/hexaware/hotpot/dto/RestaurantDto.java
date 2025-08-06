package com.hexaware.hotpot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class RestaurantDto {
	@NotBlank(message="Restaurant name cannot be left blank")
	private String rname;
	@NotNull(message="Restaurant address is mandatory")
	private String raddress;
	@NotNull
	private String phoneno;

}
