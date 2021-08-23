package dao;
import models.*;
import java.util.List;

public interface NewsDao {

    //create
    static void add(News news) {

    }

//    void add(News news);

    void addNewsToDepartment(News news, Department department);

    //read
    default List<News> getAll() {
        return null;
    }

//    List<News> getAll();

    static News findById(int id) {
        return null;
    }

//    News findById(int id);

    static List<News> getAllNewsByDepartment(int departmentId) {
        return null;
    }

//    List<News> getAllNewsByDepartment(int departmentId);

    //
    List<News> getNewsByDepartment(int departmentId);
    //

    //update
    void update(int id, String newsTitle, String newsContent,int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();

}

