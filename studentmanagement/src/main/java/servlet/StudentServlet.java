package servlet;

import dao.StudentDAO;
import model.Class;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;
    public void init(){
        studentDAO = new StudentDAO();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "view":
                    viewStudent(request, response);

                default:
                    listStudents(request, response);
                    break;
            }
        }catch(SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException {
        List<Student> listStudents = studentDAO.selectAllStudents();
        request.setAttribute("listStudents",listStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        List<Student> listStudents = studentDAO.selectAllStudents();
        request.setAttribute("listStudents", listStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.selectStudent(id);
        RequestDispatcher dispatcher;
        if (student == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student",student);
            dispatcher = request.getRequestDispatcher("view.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.selectStudent(id);
        RequestDispatcher dispatcher;
        if (existingStudent == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student", existingStudent);
            dispatcher = request.getRequestDispatcher("edit.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,SQLException {
        List<Class> listClass = studentDAO.selectAllClass();
        request.setAttribute("listStudents",listClass);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertBook(request, response);
                    break;
                case "edit":
                    updateBook(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "searchByName" :
                    searchByName(request, response);
                    break;
                default:
                    listStudents(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException {
        String name = request.getParameter("searchName");
        List<Student> students = studentDAO.searchByName(name);
        request.setAttribute("listStudents", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String classRoomID = request.getParameter("classRoomID");

        Student student = new Student(id, name,dateOfBirth,address,phoneNumber,email,classRoomID);
        studentDAO.updateStudent(student);
        request.setAttribute("student",student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("message","Product information was updated");
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws  SQLException,IOException,ServletException {
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String classRoomID = request.getParameter("classRoomID");


        Student  newStudent = new Student(name,dateOfBirth,address,phoneNumber,email,classRoomID);
        studentDAO.insertStudent(newStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        request.setAttribute("message","New product was created");
        dispatcher.forward(request, response);
    }
}
