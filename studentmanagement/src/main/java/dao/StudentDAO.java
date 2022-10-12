package dao;

import connection.ConnectionSC;
import model.Class;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private static final String INSERT_STUDENTS_SQL = "insert into student(studentname,dateofbirth,address,phonenumber,email,classroom_id) values (?,?,?,?,?,?)";
    private static final String SELECT_STUDENT_BY_ID = "select * from studentclass where id = ?";
    private static final String SELECT_ALL_STUDENTS = "select * from studentclass";
    private static final String DELETE_STUDENT_SQL ="delete from student where id = ?";
    private static final String UPDATE_STUDENT_SQL = "update users set studentname = ?,  dateofbirth = ?, address =? ,phonenumber =? ,email=? ,classroom_id =? where id = ?";
    private static final String SELECT_BY_NAME = "select * from studentclass where studentname like ?;";

    private static final String SELECT_ALL_CLASS = "select * from class";
    public StudentDAO() {}

    @Override
    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENTS_SQL);
        try(Connection connection = ConnectionSC.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
            //public void setString(int paramIndex, String value)
            //đặt giá trị String cho chỉ số tham số đã cho
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setDate(2, student.getDateOfBirth());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassRoomID());
            System.out.println(preparedStatement);
            //thực hiện truy vấn. Nó được sử dụng để create, drop, insert, update, delete, vv.
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try(Connection connection = ConnectionSC.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("studentname");
                Date dateOfBirth = rs.getDate("dateofbirth");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String classRoom = rs.getString("classname");
                student = new Student(id,name,dateOfBirth,address,phoneNumber,email,classRoom);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = ConnectionSC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("studentname");
                Date dateOfBirth = rs.getDate("dateofbirth");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String classRoomId = rs.getString("classname");
                students.add(new Student(id,name,dateOfBirth,address,phoneNumber,email,classRoomId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = ConnectionSC.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)){
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setDate(2, student.getDateOfBirth());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassRoomID());
            preparedStatement.setInt(7, student.getId());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = ConnectionSC.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public  List<Class> selectAllClass() {
        List<Class> classes = new ArrayList<>();
        try (Connection connection = ConnectionSC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("classname");

                classes.add(new Class(id,name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return classes;
    }
    public List<Student> searchByName(String inputName) {
        List<Student> students = new ArrayList<>();
        Connection conn = ConnectionSC.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_NAME);
            ps.setString(1, "%"+ inputName + "%");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("studentname");
                Date dateOfBirth = rs.getDate("dateofbirth");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String classRoomId = rs.getString("classname");
                students.add(new Student(id,name,dateOfBirth,address,phoneNumber,email,classRoomId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
