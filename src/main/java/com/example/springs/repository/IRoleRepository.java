package com.example.springs.repository;

import com.example.springs.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where  r.name =:name")
    public Role findByName(String name);


}
