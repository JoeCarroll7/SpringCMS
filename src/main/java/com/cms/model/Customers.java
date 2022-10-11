package com.cms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Customers {
	@Id @GeneratedValue
	Integer id;
	String name;
	String address;
	String phoneNumber;
	String email;
	String orders;
	Integer openOrder;
}
