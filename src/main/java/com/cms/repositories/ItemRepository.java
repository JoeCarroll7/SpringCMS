package com.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {
}
