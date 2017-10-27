package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
