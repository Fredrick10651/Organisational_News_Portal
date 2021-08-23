package dao;
import models.*;
import java.util.List;

public interface UserDao {

//    //create
//    static void add(User user) {
//
//    }
//
////    void add(User user);
//
//    void add(User user);
//
//    //read
//    static List<User> getAllUsers() {
//        return null;
//    }
//
////    List<User> getAllUsers();
//
//    List<User> getAllUsers();

    static void add(User user);

    static List<User> getAllUsers();

    static User findUserById(int id) {
        return null;
    }

//    User findUserById(int id);

    User findUserById(int id);

    static List<User> getAllUsersByDepartment(int departmentId) {
        return null;
    }

//    List<User> getAllUsersByDepartment(int departmentId);

    List<User> getAllUsersByDepartment(int departmentId);

    //update
    void update(int id, String userName,  String userCompanyPosition, String useCompanyRole, int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();

}
