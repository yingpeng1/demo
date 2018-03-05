package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDAOTest {

    @Autowired
    private AreaDAO areaDAO;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDAO.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDAO.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectedNum = areaDAO.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setAreaId(3);
        int effectedNum = areaDAO.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteArea() {
        int effectedNum = areaDAO.deleteArea(3);
        assertEquals(1,effectedNum);
    }
}