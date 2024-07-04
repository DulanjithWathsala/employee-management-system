package edu.icet.ems.repository;

import edu.icet.ems.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends CrudRepository<EmployeeEntity, Integer> {
}
