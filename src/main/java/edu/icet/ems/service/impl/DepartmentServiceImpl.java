package edu.icet.ems.service.impl;

import edu.icet.ems.entity.DepartmentEntity;
import edu.icet.ems.entity.RoleEntity;
import edu.icet.ems.repository.DepartmentJpaRepository;
import edu.icet.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentJpaRepository departmentJpaRepository;

    @Override
    public List<String> retrieveDepartmentNames() {
        Iterable<DepartmentEntity> departmentEntities = departmentJpaRepository.findAll();
        List<String> departmentNames = new ArrayList<>();

        departmentEntities.forEach(departmentEntity ->
                departmentNames.add(departmentEntity.getName()));

        return departmentNames;
    }
}
