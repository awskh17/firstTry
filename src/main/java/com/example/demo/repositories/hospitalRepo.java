package com.example.demo.repositories;

import com.example.demo.domain.hospital;
import org.springframework.data.repository.CrudRepository;

public interface hospitalRepo extends CrudRepository<hospital, Long> {
}
