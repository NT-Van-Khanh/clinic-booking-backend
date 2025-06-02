package com.ptithcm.clinic_booking.repository;

import com.ptithcm.clinic_booking.model.Schedule;
import com.ptithcm.clinic_booking.model.ScheduleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByStatus(ScheduleStatus status);

    List<Schedule> findByDoctorId(String doctorId);
    @Query("""
        SELECT s FROM Schedule s
        JOIN s.doctor d
        JOIN s.clinic c
        WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR CAST(s.date AS string) LIKE CONCAT('%', :keyword, '%')
           OR CAST(s.timeStart AS string) LIKE CONCAT('%', :keyword, '%')
    """)
    Page<Schedule> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

//    List<Schedule> findByServiceId(String serviceId);

    @Query("SELECT COUNT(s) FROM Schedule s WHERE s.doctor.id = :doctorId AND s.date = :date")
    long countByDoctorAndDate( @Param("doctorId") String doctorId, @Param("date") LocalDate date);
}
