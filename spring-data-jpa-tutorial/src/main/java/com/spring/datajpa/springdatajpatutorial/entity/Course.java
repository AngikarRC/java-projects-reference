package com.spring.datajpa.springdatajpatutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    @NonNull
    private String title;
    private int credit;

    @OneToOne(
            mappedBy = "course"
    )
    private Coursematerial coursematerial;
}
