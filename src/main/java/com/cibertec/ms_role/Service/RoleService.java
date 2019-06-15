package com.cibertec.ms_role.Service;

import com.cibertec.ms_role.Model.Role;
import org.springframework.http.ResponseEntity;

public interface RoleService {

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> getOne(Integer id);

    ResponseEntity<Object> insert(Role role);

    ResponseEntity<Object> update(Integer id, Role role);

    ResponseEntity<Object> delete(Integer id);

}
