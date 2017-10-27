package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Model;
import be.pdp.modelcar.dto.ModelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    @Query("SELECT m FROM Model m WHERE m.brand.id = ?1")
    List<Model> findByBrandId(Long brandId);

}
