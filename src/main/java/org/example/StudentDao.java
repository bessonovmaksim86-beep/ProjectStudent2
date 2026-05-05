package org.example;

import java.util.List;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    List<Student> getStudentsWithPreparationCourse();
    List<Student> getStudentsWithMathScoreGreaterThan(int score);
    List<Student> getStudentsByGender(String gender);
    List<Student> getStudentsByRaceEthnicity(String raceEthnicity);
    List<Student> getStudentsByGenderAndRaceEthnicity(String gender, String raceEthnicity);
}