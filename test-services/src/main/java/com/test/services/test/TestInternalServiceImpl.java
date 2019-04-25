package com.test.services.test;

import org.springframework.stereotype.Service;

import com.test.jpa.model.oracle.TestMDL;
import com.test.jpa.repositories.oracle.TestMDLRepository;

/**
 * @author syduch
 */
@Service
public class TestInternalServiceImpl implements TestInternalService {

    private final TestMDLRepository testMDLRepository;

    public TestInternalServiceImpl(TestMDLRepository testMDLRepository) {
        this.testMDLRepository = testMDLRepository;
    }

    @Override
    public TestMDL searchTest() {
        TestMDL test = testMDLRepository.findTestByNumber(10L);

        return test;
    }
}
