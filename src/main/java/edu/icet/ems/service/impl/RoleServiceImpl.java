package edu.icet.ems.service.impl;

import edu.icet.ems.entity.RoleEntity;
import edu.icet.ems.repository.RoleJpaRepository;
import edu.icet.ems.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleJpaRepository roleJpaRepository;

    @Override
    public List<String> retrieveRoleNames() {
        Iterable<RoleEntity> roleEntities = roleJpaRepository.findAll();
        List<String> roleNames = new ArrayList<>();

        roleEntities.forEach(roleEntity -> roleNames.add(roleEntity.getName()));

        return roleNames;
    }
}
