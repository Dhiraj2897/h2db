package com.TechDhiraj.DemoH2DB.repository;

import com.TechDhiraj.DemoH2DB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
