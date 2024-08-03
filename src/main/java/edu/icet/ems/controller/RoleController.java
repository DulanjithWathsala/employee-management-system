package edu.icet.ems.controller;

import edu.icet.ems.model.Role;
import edu.icet.ems.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all-names")
    public List<String> retrieveAllNames() {
        return roleService.retrieveRoleNames();
    }

    @GetMapping("/all")
    public List<Role> retrieveAll() {
        return roleService.retrieveAll();
    }
}
