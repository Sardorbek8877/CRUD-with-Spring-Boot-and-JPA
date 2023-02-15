package uz.bek.springboottask_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.springboottask_6.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
