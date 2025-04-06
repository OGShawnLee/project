package org.project.db;

import org.project.business.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DBConnector implements DAO<StudentDTO> {
  private static final String CREATE_QUERY =
    "INSERT INTO Student (id_student, email, name, paternal_last_name, maternal_last_name) VALUES (?, ?, ?, ?, ?)";
  private static final String GET_ALL_QUERY = "SELECT * FROM Student";
  private static final String GET_QUERY = "SELECT * FROM Student WHERE id_student = ?";
  private static final String UPDATE_QUERY =
    "UPDATE Student SET name = ?, paternal_last_name = ?, maternal_last_name = ? WHERE student_id = ?";
  private static final String DELETE_QUERY = "DELETE FROM Student WHERE id_student = ?";

  @Override
  public void create(StudentDTO element) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);

    try (statement) {
      statement.setString(1, element.getID());
      statement.setString(2, element.getEmail());
      statement.setString(3, element.getName());
      statement.setString(4, element.getPaternalLastName());
      statement.setString(5, element.getMaternalLastName());
      statement.executeUpdate();
    }

    close();
  }

  @Override
  public List<StudentDTO> getAll() throws SQLException {
    Connection conn = getConnection();
    PreparedStatement statement = conn.prepareStatement(GET_ALL_QUERY);

    try (ResultSet resultSet = statement.executeQuery()) {
      List<StudentDTO> list = new ArrayList<>();

      while (resultSet.next()) {
        list.add(new StudentDTO(resultSet));
      }

      close();

      return list;
    }
  }

  @Override
  public StudentDTO get(int id) throws SQLException {
    return null;
  }

  @Override
  public StudentDTO get(String id) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement statement = conn.prepareStatement(GET_QUERY);
    StudentDTO element = null;

    try (statement) {
      statement.setString(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        element = new StudentDTO(resultSet);
      }
    }

    close();

    return element;
  }

  @Override
  public void update(StudentDTO element) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);

    try (statement) {
      statement.setString(1, element.getName());
      statement.setString(2, element.getPaternalLastName());
      statement.setString(3, element.getMaternalLastName());
      statement.setString(4, element.getID());
    }

    close();
  }

  @Override
  public void delete(int id) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);

    try (statement) {
      statement.setInt(1, id);
      statement.executeUpdate();
    }

    close();
  }
}