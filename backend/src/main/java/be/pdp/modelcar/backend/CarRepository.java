package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllBy(Pageable pageable);

    Car findByItemRef(String itemRef);

}
