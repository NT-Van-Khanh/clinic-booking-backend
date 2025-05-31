package com.ptithcm.clinic_booking.repository;

import com.ptithcm.clinic_booking.dto.PaginationRequest;
import com.ptithcm.clinic_booking.model.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    Optional<Manager> findByAccountUsername(String username);

    Optional<Manager> findByEmail(String email);

    @Query("""
        SELECT a FROM Manager a 
        WHERE LOWER(a.id) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.address) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.phone) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    Page<Manager> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
