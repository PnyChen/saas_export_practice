package com.itheima.service.system;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.system.Dept;

import java.util.List;

public interface DeptService {

    //分页查询
    PageInfo<Dept> findByPage(String companyId,int pageNum,int pageSize);

    List<Dept> findAll(String companyId);

    void save(Dept dept);

    void update(Dept dept);

    Dept findById(String id);

    boolean delete(String id);
}
