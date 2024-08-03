package edu.icet.ems.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.ems.entity.RoleEntity;
import edu.icet.ems.model.Role;
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
    private final ObjectMapper mapper;

    @Override
    public List<String> retrieveRoleNames() {
        Iterable<RoleEntity> roleEntities = roleJpaRepository.findAll();
        List<String> roleNames = new ArrayList<>();

        roleEntities.forEach(roleEntity -> roleNames.add(roleEntity.getName()));

        return roleNames;
    }

    @Override
    public List<Role> retrieveAll() {
        Iterable<RoleEntity> roleEntities = roleJpaRepository.findAll();
        List<Role> roleList = new ArrayList<>();

       roleEntities.forEach(roleEntity -> roleList.add(
               mapper.convertValue(roleEntity, Role.class)
       ));

       return roleList;
    }
}
