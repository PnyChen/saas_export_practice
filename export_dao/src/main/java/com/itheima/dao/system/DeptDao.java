package com.itheima.dao.system;

import com.itheima.domain.system.Dept;

import java.util.List;

public interface DeptDao {

    //查询全部部门
    List<Dept> findAll(String companyId);

    //根据id查询部门
    Dept findById(String id);

    void save(Dept dept);

    void update(Dept dept);

    Integer delete(String id);

    List<Dept> findByParentId(String id);
}

