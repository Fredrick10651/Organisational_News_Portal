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
        User testUser = setUser();
        assertEquals("Fredrick Angose", testUser.getUserName());
    }

    @Test
    public  void getUserCompanyPositionReturnUserCompanyPosition() throws Exception{
        User testUser = setUser();
        assertEquals("Manager", testUser.getUserCompanyPosition());
    }

    @Test
    public void  getUserCompanyRoleReturnUserCompanyRole() throws Exception{
        User testUser = setUser();
        assertEquals("Developer", testUser.getUserCompanyRole());
    }

    @Test
    public void  getDepartmentIdReturnDepartmentId() throws Exception{
        User testUser = setUser();
        assertEquals(1, testUser.getDepartmentId());
    }

    @Test
    public void setUserNameSetsCorrectUserName() throws Exception {
        User testUser = setUser();
        testUser.setUserName("Daniel Owino");
        assertNotEquals("Fredrick Angose",testUser.getUserName());
    }

    @Test
    public void setUserCompanyPositionCorrectUserCompanyPosition() throws Exception {
       User testUser = setUser();
       testUser.setUserCompanyPosition("Secretary");
       assertEquals("Manager", testUser.getUserCompanyPosition());
    }

    @Test
    public void setUserCompanyRoleCorrectUserCompanyRole() throws Exception{
        User testUser = setUser();
        testUser.setUserCompanyPosition("Programmer");
        assertEquals("Developer", testUser.getUserCompanyRole());
    }

    @Test
    public void setDepartmentIdCorrectDepartmentId()throws Exception{
        User testUser = setUser();
        testUser.setDepartmentId(2);
        assertEquals(1, testUser.getDepartmentId());
    }




    public User setUser (){
        return new User("Fredrick Angose", "Manager", "Developer", 1);
    }

    public User setAltUser (){
        return new User("Fredrick Angose", "Manager", "Developer", 1);
    }
}
