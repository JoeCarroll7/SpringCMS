package com.cms.model;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Configuration
@Setter
public class RegistrationRequest {
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private String password;
	
	public RegistrationRequest parameters(String name, String address, String phoneNumber, String email, String password) {
		return new RegistrationRequest(name, address, phoneNumber, email, password);
	}
}
