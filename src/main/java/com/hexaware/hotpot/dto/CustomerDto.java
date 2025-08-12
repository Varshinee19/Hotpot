package com.hexaware.hotpot.dto;

import com.hexaware.hotpot.entitiesenum.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class CustomerDto {
	
    private int customerId;
	@NotNull
	@NotBlank(message="name is mandatory")
	private String name;
	@NotNull
	@Pattern(regexp="^(Male|Female|Other)$")
	private String gender;
	@Email
	private String email;
	@Pattern(regexp="[0-9]{10}")
	private String phone;
	@NotEmpty(message="address cannot be left empty")
	private String address;
	@NotNull(message="Must mention role")
	private Role role;

}
