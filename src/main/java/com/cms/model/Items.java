package com.cms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Items {
	@Id @GeneratedValue
	Integer id;
	String name;
	String description;
	Integer quantity;
	
}
