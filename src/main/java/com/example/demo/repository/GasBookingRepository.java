package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GasBooking;

@Repository
public interface GasBookingRepository extends JpaRepository<GasBooking, Long>{


	@Query("SELECT g FROM GasBooking g WHERE g.bookingDate BETWEEN :date1 AND :date2")
	List<GasBooking> findByBookingBetweenDates(@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);

	@Query("SELECT g FROM GasBooking g WHERE g.bookingDate BETWEEN :d1 AND :d2")
	List<GasBooking> findByBookingDate(@Param("d1") LocalDate d1,@Param("d2") LocalDate d2);

	GasBooking findByUserUserId(long userId);

}
