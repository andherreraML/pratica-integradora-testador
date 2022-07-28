package com.testador.testador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean tested;

    @Column(nullable = false)
    private boolean passed;

    @Column(nullable = false)
    private int numberOfTries;

    private LocalDate lastUpdate;
}
