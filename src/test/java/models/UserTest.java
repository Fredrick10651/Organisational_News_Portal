package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUsernameReturnCorrectUserName() throws Exception{
        User testUser = setupAltUser();
        assertEquals("Fredrick Angose", testUser.getUserName());
    }

    @Test
    public  void getUserCompanyPositionReturnUserCompanyPosition() throws Exception{
        User testUser = setUpUser();
        assertEquals("Manager", testUser.getUserCompanyPosition());
    }

    @Test
    public void  getUserCompanyRoleReturnUserCompanyRole() throws Exception{
        User testUser = setUpUser();
        assertEquals("Developer", testUser.getUserCompanyRole());
    }

    @Test
    public void  getDepartmentIdReturnDepartmentId() throws Exception{
        User testUser = setUpUser();
        assertEquals(1, testUser.getDepartmentId());
    }

    @Test
    public void setUserNameSetsCorrectUserName() throws Exception {
        User testUser = setupUser();
        testUser.setUserName("Daniel Owino");
        assertNotEquals("Fredrick Angose",testUser.getUserName());
    }

    @Test
    public void setUserCompanyPositionCorrectUserCompanyPosition() throws Exception {
       User testUser = setUpUser();
       testUser.setUserCompanyPosition("Secretary");
       assertEquals("Manager", testUser.getUserCompanyPosition());
    }

    @Test
    public void setUserCompanyRoleCorrectUserCompanyRole() throws Exception{
        User testUser = setupUser();
        testUser.setUserCompanyPosition("Programmer");
        assertEquals("Developer", testUser.getUserCompanyRole());
    }

    @Test
    public void setDepartmentIdCorrectDepartmentId()throws Exception{
        User testUser = setUpUser();
        testUser.setDepartmentId(2);
        assertEquals(1, testUser.getDepartmentId());
    }




    public User setupUser (){
        return new User("Fredrick Angose", "Manager", "Developer", 1);
    }

    public User setupAltUser (){
        return new User("Fredrick Angose", "Manager", "Developer", 1);
    }
}
