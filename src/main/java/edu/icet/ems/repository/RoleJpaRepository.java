package edu.icet.ems.repository;

import edu.icet.ems.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRepository extends CrudRepository<RoleEntity, Long> {
}
