package com.test.controllers.rest.v1;

import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import com.test.jpa.model.oracle.TestMDL;
import com.test.services.test.TestInternalService;

/**
 * @author syduch
 */
@RestController
@AllArgsConstructor
public class DeliveryRestController {

    private final TestInternalService testInternalService;

    public TestMDL searchDeliveries() {
        return testInternalService.searchTest();
    }
}
