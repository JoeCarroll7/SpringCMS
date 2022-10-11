package com.cms.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cms.model.ConfirmationToken;
import com.cms.model.Customers;
import com.cms.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService implements UserDetailsService {
	
	private final CustomerRepository customerRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return customerRepository.findByEmail(email).orElseThrow(()
				-> new UsernameNotFoundException("User doesn't exist"));
	}
	
	public String registerCustomer(Customers customer) {
		boolean userExists = customerRepository
				.findByEmail(customer.getEmail())
				.isPresent();
		
		ConfirmationToken confirmationTester = new ConfirmationToken();
		
		if (userExists) {
			if(confirmationTester.getConfirmedAt() != null) {
				throw new IllegalStateException("Email already exists");
			}						
		}else{
			String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
			
			customer.setPassword(encodedPassword);
			
			customerRepository.save(customer);
		}
		
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				customer
		);
		
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		
		return token;
	}
	
	public int enableCustomer(String email) {
    	return customerRepository.enableCustomer(email);
	}

}
