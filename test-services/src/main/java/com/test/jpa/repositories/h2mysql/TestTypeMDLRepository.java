package com.test.jpa.repositories.h2mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.jpa.model.h2mysql.TestTypeMDL;

/**
 * Created by jt on 9/24/17.
 */
public interface TestTypeMDLRepository extends JpaRepository<TestTypeMDL, Long> {

}
