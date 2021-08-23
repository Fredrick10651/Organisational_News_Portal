package dao;
import models.*;
import java.util.List;

public interface DepartmentDao {

    //create
    static void add(Department department);

    abstract List<Department> getAll();

    void addDepartmentToUser(Department department, User user);

    void add(Department department);

    //read
    static List<Department> getAll();
    static Department findById(int id);

    Department findById(int id);

    List<User> getAllUsersByDepartment(int departmentId);

    //update
    void update(int id, String departmentName, String departmentDescription, int departmentEmployeesNumber);

    //delete
    void deleteById(int id);
    void clearAll();

}