package com.cms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Orders {
	@Id @GeneratedValue
	Integer id;
	String description;
	String deliveryAddress;
	boolean orderCompleted;
	String orderedBy;
}
