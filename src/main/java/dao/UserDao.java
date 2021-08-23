package dao;
import models.*;
import java.util.List;

public interface UserDao {

    //create
    static void add(User user);

    //read
    static List<User> getAllUsers();
    static User findUserById(int id);
    static List<User> getAllUsersByDepartment(int departmentId);

    //update
    void update(int id, String userName,  String userCompanyPosition, String useCompanyRole, int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();

}
