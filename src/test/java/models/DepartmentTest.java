package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDepartmentNameReturnCorrectDepartmentName() throws Exception{
        Department testDepartment = setDepartment();
        assertEquals("Badgers", testDepartment.getDepartmentName());
    }

    @Test
    public  void getDepartmentDescriptionReturnDepartmentDescription() throws Exception{
        Department testDepartment = setDepartment();
        assertEquals("Make hay while the sun shines", testDepartment.getDepartmentDescription());
    }


    @Test
    public void  getDepartmentIEmployeesNumberReturnDepartmentEmployeesNumber() throws Exception{
        Department testDepartment = setDepartment();
        assertEquals(10, testDepartment.getDepartmentEmployeesNumber());
    }

    @Test
    public void setDepartmentNameSetsCorrectDepartmentName() throws Exception {
        Department testDepartment = setDepartment();
        testDepartment.setDepartmentName("Clevers");
        assertNotEquals("Badgers",testDepartment.getDepartmentName());
    }

    @Test
    public void setDepartmentDescriptionCorrectDepartmentDescription() throws Exception {
        Department testDepartment = setDepartment();
        testDepartment.setDepartmentDescription("Early bird");
        assertEquals("Make hay while the sun shines", testDepartment.getDepartmentDescription());
    }


    @Test
    public void setDepartmentIEmployeesNumberCorrectDepartmentIEmployeesNumber()throws Exception{
        Department testDepartment = setDepartment();
        testDepartment.setDepartmentEmployeesNumber(15);
        assertEquals(10, testDepartment.getDepartmentEmployeesNumber());
    }




    public Department setDepartment (){
        return new Department("Badgers", "Make hay while the sun shines",  10);
    }

    public Department setAltDepartment (){
        return new Department("Badgers", "Make hay while the sun shines", 10);
    }
}
