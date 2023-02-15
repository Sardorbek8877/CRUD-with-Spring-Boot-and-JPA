package uz.bek.springboottask_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bek.springboottask_6.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
