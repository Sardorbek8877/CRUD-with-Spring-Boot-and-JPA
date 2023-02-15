package uz.bek.springboottask_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bek.springboottask_6.model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer> {

}
