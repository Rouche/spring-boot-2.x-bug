package com.test.bootstrap.oracle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.test.jpa.repositories.oracle.TestMDLRepository;
import com.test.jpa.repositories.oracle.mock.MockTestMDLRepository;


/**
 * @author syduch
 */
@Slf4j
@Component
@AllArgsConstructor
@Profile("testh2")
public class TestMDLBootstrap implements CommandLineRunner {

    private final TestMDLRepository testMDLRepository;

    @Override
    public void run(String... args) {

        testMDLRepository.saveAll(MockTestMDLRepository.getMock("JOB1").findAll());

        log.debug("testMDLRepository loaded: " + testMDLRepository.count());
    }
}
