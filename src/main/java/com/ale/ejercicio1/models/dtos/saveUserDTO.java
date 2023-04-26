package com.ale.ejercicio1.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class saveUserDTO {
	@NotEmpty(message = "Username cannot be empty")
	@Size(min = 5, max = 15, message = "Between 5 and 15 characteres")
	private String username;
	
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 8, max = 15, message = "Between 8 and 15 characteres")
	private String password;
	
	private String confirmPassword;
}
