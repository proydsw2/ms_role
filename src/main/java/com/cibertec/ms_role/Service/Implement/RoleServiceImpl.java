package com.cibertec.ms_role.Service.Implement;

import com.cibertec.ms_role.Model.Role;
import com.cibertec.ms_role.Repository.RoleRepository;
import com.cibertec.ms_role.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    RoleRepository roleRepository;

    public ResponseEntity<Object> getAll() {
        try {
            List<Role> roles = roleRepository.findAll();

            if (roles == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(roles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        try {
            Optional<Role> role = roleRepository.findById(id);

            if (!role.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(role);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> insert(Role role) {
        try {
            Role entity = roleRepository.save(role);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getNum_role_id()).toUri();

            return ResponseEntity.ok().body(entity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> update(Integer id, Role role) {
        try {
            Optional<Role> entity = roleRepository.findById(id);

            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            role.setNum_role_id(id);
            Role cust = roleRepository.save(role);
            return ResponseEntity.ok().body(cust);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> delete(Integer id) {

        try {
            Optional<Role> entity = roleRepository.findById(id);
            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            roleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
