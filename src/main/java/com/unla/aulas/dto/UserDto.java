package com.unla.aulas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
    private String userName;
    private String password;
	public CharSequence getPassword() {
		return password;
	}
	public Object getUserName() {
		return userName;
	}
}
