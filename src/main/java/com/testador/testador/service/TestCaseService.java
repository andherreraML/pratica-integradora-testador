package com.testador.testador.service;

import com.testador.testador.model.TestCase;
import com.testador.testador.repository.TestCaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    private TestCaseRepo repository;

    @Override
    public TestCase create(TestCase testCase) {
        return repository.save(testCase);
    }

    @Override
    public List<TestCase> readAll() {
        return (List<TestCase>) repository.findAll();
    }

    @Override
    public List<TestCase> readByUpdateDate(LocalDate date) {
        return repository.findByLastUpdateAfter(date);
    }

    @Override
    public TestCase readById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public TestCase updatePartial(TestCase testCase) {
        TestCase foundTest = readById(testCase.getId());
        if(foundTest != null) {
            foundTest.setDescription(testCase.getDescription());
            foundTest.setTested(testCase.isTested());
            foundTest.setPassed(testCase.isPassed());
            foundTest.setNumberOfTries(testCase.getNumberOfTries());
            foundTest.setLastUpdate(testCase.getLastUpdate());
        }
        return repository.save(foundTest);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}

