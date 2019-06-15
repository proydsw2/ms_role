package com.cibertec.ms_role.Controller;

import com.cibertec.ms_role.Model.Role;
import com.cibertec.ms_role.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(path = "/role")
    public ResponseEntity<Object> retriveAll() {
        return roleService.getAll();
    }

    @GetMapping(path = "/role/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return roleService.getOne(id);
    }

    @PostMapping(path = "/role")
    public ResponseEntity<Object> create(@RequestBody Role role) {
        return roleService.insert(role);
    }

    @PutMapping(path = "/role/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Role role) {
        return roleService.update(id, role);
    }

    @DeleteMapping(path = "/role/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return roleService.delete(id);
    }
}
