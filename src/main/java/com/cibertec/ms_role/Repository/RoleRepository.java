package com.cibertec.ms_role.Repository;

import com.cibertec.ms_role.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
