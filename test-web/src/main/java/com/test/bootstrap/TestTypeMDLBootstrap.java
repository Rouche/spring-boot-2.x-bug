package com.test.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.test.jpa.model.h2mysql.TestTypeMDL;
import com.test.jpa.repositories.h2mysql.TestTypeMDLRepository;



/**
 * @author syduch
 *
 */
@Slf4j
@Component
@AllArgsConstructor
@Profile("testh2")
public class TestTypeMDLBootstrap implements CommandLineRunner {

    private final TestTypeMDLRepository testTypeMDLRepository;

    @Override
    public void run(String... args) throws Exception {

        testTypeMDLRepository.save(TestTypeMDL.builder().testTypeCode("U").description("unique").build());

        testTypeMDLRepository.save(TestTypeMDL.builder().testTypeCode("M").description("master").build());

        testTypeMDLRepository.save(TestTypeMDL.builder().testTypeCode("D").description("detail").build());

        log.debug("TestTypeMDLRepository loaded: " + testTypeMDLRepository.count());
    }
}
