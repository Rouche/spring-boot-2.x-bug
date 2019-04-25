
package com.test.jpa.repositories.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.jpa.model.oracle.TestMDL;

/**
 * @author syduch
 */
@Repository
public interface TestMDLRepository extends JpaRepository<TestMDL, Long> {

    @Query("FROM TestMDL d where d.number = :number")
    TestMDL findTestByNumber(@Param("number") Long number);
}


