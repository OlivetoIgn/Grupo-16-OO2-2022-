package com.unla.aulas.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "subject_code")
    private int subjectCode;
    @Column(name = "subject")
    private String subject;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "carrer_id")
    private CarrerEntity carrer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return subjectCode == that.subjectCode && Objects.equals(subject, that.subject) && Objects.equals(carrer, that.carrer);
    }
}
