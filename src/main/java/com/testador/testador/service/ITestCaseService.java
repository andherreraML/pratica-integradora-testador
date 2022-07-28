package com.testador.testador.service;

import com.testador.testador.model.TestCase;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITestCaseService{

    TestCase create(TestCase testCase);
    List<TestCase> readAll();
    List<TestCase> readByUpdateDate(LocalDate date);
    TestCase readById(long id);
    TestCase updatePartial(TestCase testCase);
    void delete(long id);
}
