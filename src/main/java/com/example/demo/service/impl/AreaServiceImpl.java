package com.example.demo.service.impl;

import com.example.demo.dao.AreaDAO;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDAO areaDAO;

    @Override
    public List<Area> getAreaList() {
        return areaDAO.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDAO.queryAreaById(areaId);
    }

    @Override
    @Transactional
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDAO.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    @Transactional
    public boolean modifyArea(Area area) {
        //空值判断，主要是areaId不为空
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            //设置默认值
            area.setLastEditTime(new Date());
            try {
                //更新区域信息
                int effectedNum = areaDAO.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    @Transactional
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                //删除区域信息
                int effectedNum = areaDAO.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域Id不能为空!");
        }
    }
}
