package com.ptithcm.clinic_booking.repository;

import com.ptithcm.clinic_booking.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    List<Doctor> findByStatus(String status);
    Page<Doctor> findByStatus(String status, Pageable pageable);

    Optional<Doctor> findByAccountUsername(String username);
    Optional<Doctor> findByEmail(String email);
//    List<Doctor> findByService_Id(String serviceId);

    // Lấy bác sĩ theo chuyên khoa (chuyên khoa của bác sĩ)
    List<Doctor> findByMedicalSpecialty_Id(String medicalSpecialtyId);

    @Query("""
    SELECT d FROM Doctor d 
    WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :keyword, '%')) 
       OR LOWER(d.email) LIKE LOWER(CONCAT('%', :keyword, '%')) 
       OR LOWER(d.phone) LIKE LOWER(CONCAT('%', :keyword, '%')) 
       OR LOWER(d.qualification) LIKE LOWER(CONCAT('%', :keyword, '%')) 
       OR LOWER(d.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    Page<Doctor> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
