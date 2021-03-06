package models.dao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;


public class Sql2oDepartmentDaoTest {

    private static Connection conn;
    private static Sql2oDepartmentDao departmentsDao;
    private static Sql2oNewsDao newsDao;
    private static Sql2oUserDao userDao;

    @BeforeClass
    public static void setUp() throws Exception {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
        String connectionString = "jdbc:postgresql://localhost:5432/myorg_test";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "moringa");
        departmentsDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentsDao.clearAll();
        newsDao.clearAll();
        userDao.clearAll();
//        conn.close();
    }

    @AfterClass     //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }

    //helper
    public Department setUpDepartment (){
        Department department =  new Department("Developer", "Programming", 205);
        departmentsDao.add(department);
        return department;
    }
    //helper
    public Department setUpAltDepartment(){
        Department altDepartment = new Department("Finance", "Transportation", 329);
        departmentsDao.add(altDepartment);
        return altDepartment;
    }
    //helper
    public User setUpUser(){
        User user = new User("Michelle", "Secretary", "Writing", 2);
        userDao.add(user);
        return user;
    }
    //helper
    public User setUpAltUser(){
        User altUser = new User("Gideon","Manager", "Oversight", 2);
        userDao.add(altUser);
        return altUser;
    }

    @Test
    public void savesOneInstanceCorrectlyAndGetsRightId_true(){
        Department testDepartment = new Department("Servicing", "Repairs", 210);
        assertEquals(0, testDepartment.getId());
    }

    @Test
    public void getsTotalSizeCorrectly_true(){
        Department testDepartment = new Department("Servicing", "Repairs", 210);
        departmentsDao.add(testDepartment);
        assertEquals(1, departmentsDao.getAll().size());
    }

    @Test
    public void returnsZeroIfNoInstanceOfDepartmentExists_0(){
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectDepartment(){
        Department testDepartment = setUpDepartment();
        Department testSecondDepartment = new Department("visits", "ushering", 123);
        assertEquals(testDepartment, departmentsDao.findById(testDepartment.getId()));
    }

    @Test
    public void update_UpdatesCorrectlyUpdatesAllFieldsCorrectly_true(){
        Department testDepartment = setUpDepartment();
        departmentsDao.update(testDepartment.getId(), "People", "Crowd", 125);
        Department foundDepartment = departmentsDao.findById(testDepartment.getId());
        assertEquals("People", foundDepartment.getDepartmentName());
        assertEquals("Crowd", foundDepartment.getDepartmentDescription());
        assertEquals(125, foundDepartment.getDepartmentEmployeesNumber());
    }

    @Test
    public void deleteDepartmentByIdDeletesCorrectDepartment(){
        Department testDepartment = setUpDepartment();
        departmentsDao.deleteById(testDepartment.getId());
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void clearAll_deletesAllTheDataPresentInTheDepartmentsTable_true(){
        Department firstDepartment = setUpDepartment();
        Department secondDepartment = setUpAltDepartment();
        departmentsDao.clearAll();
        assertEquals(0, departmentsDao.getAll().size());

    }


    @Test
    public void deletingADepartmentAlsoUpdatesTheJointTable(){
        Department testDepartment = setUpDepartment();
        departmentsDao.add(testDepartment);
        Department altTestDepartment = setUpAltDepartment();
        departmentsDao.add(altTestDepartment);

        User testUser = setUpUser();
        userDao.add(testUser);

        departmentsDao.addDepartmentToUser(testDepartment, testUser);
        departmentsDao.addDepartmentToUser(altTestDepartment, testUser);

        departmentsDao.deleteById(testDepartment.getId());

        assertEquals(0, departmentsDao.getAllUsersByDepartment(testDepartment.getId()).size());
    }

}