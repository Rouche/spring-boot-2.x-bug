package com.test.jpa.repositories.oracle.mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.test.jpa.model.oracle.TestMDL;
import com.test.jpa.repositories.oracle.TestMDLRepository;


public class MockTestMDLRepository {

    public static TestMDLRepository getMock(String jobCode) {

        TestMDLRepository deliveryMDLRepository = mock(TestMDLRepository.class);

        when(deliveryMDLRepository.findAll()).thenReturn(getResults(jobCode));

        return deliveryMDLRepository;
    }

    private static List<TestMDL> getResults(String jobCode) {

        List<TestMDL> results = new ArrayList<>();

        results.add(TestMDL.builder()
                .number(1L)
                .jobCode(jobCode)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Anticosti gagnant. Français.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(2L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Cerf de virginie gagnant. Français.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(3L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Anticosti attente. Anglais.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(4L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Cerf de virginie attente. Anglais.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(5L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Anticosti gagnant. Anglais.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(6L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Orignal attente. Anglais.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(7L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Cerf de virginie gagnant. Anglais.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(8L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Orignal gagnant. Anglais.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());
        results.add(TestMDL.builder()
                .number(9L)
                .testTypeCode("AAA")
                .description("Résultat postal Sépaq. Non gagnants, erreurs. Anglais.")
                .origin("P")
                .status(null)
                .quantity(1000L)
                .build());

        return results;
    }
}
