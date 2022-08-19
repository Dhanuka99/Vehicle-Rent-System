package lk.dmax.spring.repo;


import lk.dmax.spring.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking, Integer> {


    @Query(value = "select b.bookingId from Booking b order by b.bookingId desc limit 1",nativeQuery = true)
    int getLastId();

}
