package com.hexaware.hotpot.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class AuthRequest {
	
	private String email;
	private String password;

}
