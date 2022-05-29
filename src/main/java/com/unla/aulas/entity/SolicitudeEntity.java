package com.unla.aulas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitude")
public class SolicitudeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "solicitude_date")
    private LocalDate solicitudeDate;

    @Column(name = "shift")
    private String shift; //turno

    @Column(name = "students_quantity")
    private int studentsQuantity;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subjectEntity;

    @Column(name = "observations")
    private String observations;

    @Column(name = "solicitude_type")
    @Enumerated(value = EnumType.STRING)
    private SolicitudeTypeEntity typeSolicitude;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudeEntity that = (SolicitudeEntity) o;
        return studentsQuantity == that.studentsQuantity && Objects.equals(solicitudeDate, that.solicitudeDate)
                && Objects.equals(shift, that.shift) && Objects.equals(subjectEntity, that.subjectEntity)
                && Objects.equals(observations, that.observations) && typeSolicitude == that.typeSolicitude
                && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }
}
