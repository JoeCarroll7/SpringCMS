package com.cms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
	Optional<Customers> findByEmail(String email);

	@Transactional
    @Modifying
    @Query("UPDATE Customers a " +
            "SET a.isEnabled = TRUE WHERE a.email = ?1")
    int enableCustomer(String email);
}
