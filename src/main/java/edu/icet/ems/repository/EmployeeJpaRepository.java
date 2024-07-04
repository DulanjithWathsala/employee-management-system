package edu.icet.ems.repository;

import edu.icet.ems.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeJpaRepository extends CrudRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByEmail(String email);
}
