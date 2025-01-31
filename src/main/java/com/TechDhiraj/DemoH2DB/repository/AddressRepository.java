package com.TechDhiraj.DemoH2DB.repository;

import com.TechDhiraj.DemoH2DB.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
