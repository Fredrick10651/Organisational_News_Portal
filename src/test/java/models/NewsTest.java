package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNewsTitleReturnCorrectNewsTitle() throws Exception{
        News testNews = setNews();
        assertEquals("Daily Nation", testNews.getNewsTitle());
    }


    @Test
    public void  getNewsContentReturnNewsContent() throws Exception{
        News testNews = setNews();
        assertEquals("BBI Agenda", testNews.getNewsContent());
    }

    @Test
    public void  getDepartmentIdReturnDepartmentId() throws Exception{
        News testNews = setNews();
        assertEquals(1, testNews.getDepartmentId());
    }

    @Test
    public void setNewsTitLeSetsCorrectNewsTitle() throws Exception {
        News testNews = setNews();
        testNews.setNewsTitle("Taifa Leo");
        assertNotEquals("Daily Nation",testNews.getNewsTitle());
    }

    @Test
    public void setNewsContentCorrectNewsContent() throws Exception {
        News testNews = setNews();
        testNews.setNewsContent("Elections");
        assertEquals("BBI Agenda", testNews.getNewsContent());
    }


    @Test
    public void setDepartmentIdCorrectDepartmentId()throws Exception{
        News testNews = setNews();
        testNews.setDepartmentId(2);
        assertEquals(1, testNews.getDepartmentId());
    }




    public News setNews (){
        return new News("Daily Nation", "BBI Agenda",  1);
    }

    public News setAltNews (){
        return new News("Daily Nation", "BBI Agenda",  1);
    }
}
