package uz.bek.springboottask_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bek.springboottask_6.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
