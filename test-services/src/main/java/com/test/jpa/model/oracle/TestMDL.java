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
public class TestMDL {

    @Id
    @Column(name = "NUM")
    private long number;

    @Column(name = "JOBCODE")
    private String jobCode;

    @Column(name = "TYP")
    private String testTypeCode;

    @Column(name = "DESC")
    private String description;

    @Column(name = "ORIGIN")
    private String origin;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DEST")
    private String recipient;

    @Column(name = "QTE")
    private long quantity;

    @Column(name = "DT_TIME")
    private ZonedDateTime sentDateTime;

    @Column(name = "USER")
    private String user;
}
