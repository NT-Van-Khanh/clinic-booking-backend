package com.ptithcm.clinic_booking.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ptithcm.clinic_booking.model.Clinic;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, String> {
    List<Clinic> findByStatus(String status);
    Page<Clinic> findByStatus(String status, Pageable pageable);

    @Query("""
        SELECT a FROM Clinic a 
        WHERE LOWER(a.id) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.address) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.phone) LIKE LOWER(CONCAT('%', :keyword, '%')) 
           OR LOWER(a.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    Page<Clinic> searchByKeyword(@Param("keyword")  String keyword, Pageable pageable);
}
