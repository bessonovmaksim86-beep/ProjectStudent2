package org.example;

public class Student {
    private final int id;
    private final String gender;
    private final String raceEthnicity;
    private final String parentalEducation;
    private final String lunch;
    private final String testPreparationCourse;
    private final int mathScore;
    private final int readingScore;
    private final int writingScore;

    public Student(int id, String gender, String raceEthnicity, String parentalEducation,
                   String lunch, String testPreparationCourse,
                   int mathScore, int readingScore, int writingScore) {
        this.id = id;
        this.gender = gender;
        this.raceEthnicity = raceEthnicity;
        this.parentalEducation = parentalEducation;
        this.lunch = lunch;
        this.testPreparationCourse = testPreparationCourse;
        this.mathScore = mathScore;
        this.readingScore = readingScore;
        this.writingScore = writingScore;
    }

    public int getId() { return id; }
    public String getGender() { return gender; }
    public String getRaceEthnicity() { return raceEthnicity; }
    public String getParentalEducation() { return parentalEducation; }
    public String getLunch() { return lunch; }
    public String getTestPreparationCourse() { return testPreparationCourse; }
    public int getMathScore() { return mathScore; }
    public int getReadingScore() { return readingScore; }
    public int getWritingScore() { return writingScore; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", raceEthnicity='" + raceEthnicity + '\'' +
                ", parentalEducation='" + parentalEducation + '\'' +
                ", lunch='" + lunch + '\'' +
                ", testPreparationCourse='" + testPreparationCourse + '\'' +
                ", mathScore=" + mathScore +
                ", readingScore=" + readingScore +
                ", writingScore=" + writingScore +
                '}';
    }
}