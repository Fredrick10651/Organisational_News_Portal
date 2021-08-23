package dao;

import models.User;

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

    static void add() {
        add();

    }

    void add(User user);

    List<User> getAllUsers();

    User findUserById(int id);

    List<User> getAllUsersByDepartment(int departmentId);

    //update
    void update(int id, String userName,  String userCompanyPosition, String useCompanyRole, int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();

}
