package com.example.demo.dao;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaDAO {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
