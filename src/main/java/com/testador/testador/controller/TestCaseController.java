package com.testador.testador.controller;

import com.testador.testador.model.TestCase;
import com.testador.testador.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<TestCase> create(@RequestBody TestCase testCase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(testCase));
    }

    @GetMapping()
    public ResponseEntity<List<TestCase>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> readById(@PathVariable long id) {
        return ResponseEntity.ok(service.readById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCase>> readByUpdateDate(@RequestParam String lastUpdate) {
        return ResponseEntity.ok(service.readByUpdateDate(LocalDate.parse(lastUpdate)));
    }

    @PutMapping("/update")
    public ResponseEntity<TestCase> updatePartial(@PathVariable TestCase testCase) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePartial(testCase));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
