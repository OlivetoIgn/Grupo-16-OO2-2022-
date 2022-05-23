package com.unla.aulas.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="course")
public class Course extends Order{

    @Column(name = "course_code")
    private int courseCode;

    public Course(LocalDate date, String shift, int studentsQuantity, Subject subject, String observations, int courseCode) {
        super(date, shift, studentsQuantity, subject, observations);
        this.courseCode = courseCode;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode=" + courseCode +
                "} " + super.toString();
    }
}
