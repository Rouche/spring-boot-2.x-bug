package com.test.jpa.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

import lombok.*;

/**
 * @author syduch
 *
 */

@Data
@Builder
@EqualsAndHashCode(of = {"number"})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "TBL_TEST")
public class TestMinimalMDL {

    @Id
    @Column(name = "NUM")
    private long number;

    @Column(name = "JOBCODE")
    private String jobCode;

    // BUG_2.1.4: Case sensitive bug with Spring boot 2.1.4
    // TestMDL is mapped on same table with name= "STATUS" in uppercase, this is minimal version of the mapping.
    // Use 2.1.4 lowercase -> Column STATUS not found.
    // Use 2.1.4 uppercase -> ok
    // Use 2.1.3 everything ok.
    @Column(name = "status")
    private String status;
}
