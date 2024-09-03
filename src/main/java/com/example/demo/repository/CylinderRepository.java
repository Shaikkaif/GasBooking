package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cylinder;

@Repository
public interface CylinderRepository extends JpaRepository<Cylinder, Long>{

}

