package ua.gov.uz.pldpv.repositories;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.gov.uz.pldpv.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>{
}