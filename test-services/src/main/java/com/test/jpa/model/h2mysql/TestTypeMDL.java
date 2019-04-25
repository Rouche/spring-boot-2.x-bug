package com.test.jpa.model.h2mysql;

import javax.persistence.*;

import lombok.*;

/**
 * @author syduch
 *
 */
@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "testtype")
public class TestTypeMDL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String testTypeCode;

    @Column(nullable = false)
    private String description;
}
