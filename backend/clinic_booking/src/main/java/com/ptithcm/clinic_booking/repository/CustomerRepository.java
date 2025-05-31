package com.ptithcm.clinic_booking.repository;

import com.ptithcm.clinic_booking.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAllCustomerByStatus(String status);
    @Query("""
    SELECT c FROM Customer c 
    WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(c.phone) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    Page<Customer> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
    List<Customer> findByNameContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String name, String phone, String email);
}
