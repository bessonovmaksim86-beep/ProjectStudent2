package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final String url;
    private final String user;
    private final String password;

    public StudentDaoImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private Student mapRow(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("id"),
                rs.getString("gender"),
                rs.getString("race_ethnicity"),
                rs.getString("parental_education"),
                rs.getString("lunch"),
                rs.getString("test_preparation_course"),
                rs.getInt("math_score"),
                rs.getInt("reading_score"),
                rs.getInt("writing_score")
        );
    }

    private List<Student> executeQuery(String sql, Object... params) {
        List<Student> students = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при выполнении запроса: " + sql, e);
        }

        return students;
    }

    @Override
    public List<Student> getAllStudents() {
        return executeQuery("SELECT * FROM students");
    }

    @Override
    public List<Student> getStudentsWithPreparationCourse() {
        return executeQuery("SELECT * FROM students WHERE test_preparation_course = ?", "completed");
    }

    @Override
    public List<Student> getStudentsWithMathScoreGreaterThan(int score) {
        return executeQuery("SELECT * FROM students WHERE math_score > ?", score);
    }

    @Override
    public List<Student> getStudentsByGender(String gender) {
        return executeQuery("SELECT * FROM students WHERE gender = ?", gender);
    }

    @Override
    public List<Student> getStudentsByRaceEthnicity(String raceEthnicity) {
        return executeQuery("SELECT * FROM students WHERE race_ethnicity = ?", raceEthnicity);
    }

    @Override
    public List<Student> getStudentsByGenderAndRaceEthnicity(String gender, String raceEthnicity) {
        return executeQuery("SELECT * FROM students WHERE gender = ? AND race_ethnicity = ?", gender, raceEthnicity);
    }
}