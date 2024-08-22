package com.example.demo.repositories;

import com.example.demo.domain.patient;
import org.springframework.data.repository.CrudRepository;

public interface patientRepo extends CrudRepository <patient,Long> {
}
