package com.example.demo.repositories;

import com.example.demo.domain.doctor;
import org.springframework.data.repository.CrudRepository;

public interface doctorRepo extends CrudRepository<doctor, Long> {
}
