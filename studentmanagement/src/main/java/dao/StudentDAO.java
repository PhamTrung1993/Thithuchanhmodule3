package dao;

public class StudentDAO {
    private static final String INSERT_STUDENTS_SQL = "insert into student(studentname,dateofbirth,address,phonenumber,email,classroom_id) values (?,?,?,?,?,?)";
    private static final String SELECT_STUDENT_BY_ID = "select * from studentclass where id = ?";
    private static final String SELECT_ALL_STUDENTS = "select * from studentclass";
    private static final String DELETE_STUDENT_SQL ="delete from student where id = ?";
    private static final String UPDATE_STUDENT_SQL = "update users set studentname = ?,  dateofbirth = ?, address =? ,phonenumber =? ,email=? ,classroom_id =? where id = ?";
    private static final String SELECT_BY_NAME = "select * from student where studentname like ?;";

    private static final String SELECT_ALL_CLASS = "select * from class";

}
