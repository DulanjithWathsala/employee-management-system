package edu.icet.ems.repository;

import edu.icet.ems.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentJpaRepository extends CrudRepository<DepartmentEntity, Long> {
}
