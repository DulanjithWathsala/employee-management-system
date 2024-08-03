package edu.icet.ems.service;

import edu.icet.ems.model.Role;

import java.util.List;

public interface RoleService {

    List<String> retrieveRoleNames();

    List<Role> retrieveAll();
}
