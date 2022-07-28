package com.testador.testador.repository;

import com.testador.testador.model.TestCase;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TestCaseRepo extends CrudRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate date);
}
