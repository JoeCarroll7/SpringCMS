package com.cms.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
public class Customers implements UserDetails {
		
	@Id @GeneratedValue
	Integer id;
	String name;
	String address;
	String phoneNumber;
	String email;
	String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	String orders = "";
	Integer openOrder = 0;
	boolean isAccountNonExpired = false;
	boolean isAccountNonLocked = false;
	boolean isCredentialsNonExpired = false;
	boolean isEnabled = false;
	
	public Customers(String name, String address, String phoneNumber, String email, String password,
			UserRole userRole) {			
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	
	public Customers(String name, String address, String phoneNumber, String email, String password, UserRole userRole,
			String orders, Integer openOrder, boolean isAccountNonExpired, boolean isAccountNonLocked,
			boolean isCredentialsNonExpired, boolean isEnabled) {		
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.orders = orders;
		this.openOrder = openOrder;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@Override
	public boolean isEnabled() {
		return false;
	}
}
