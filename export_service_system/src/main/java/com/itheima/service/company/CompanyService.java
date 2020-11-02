package com.itheima.service.company;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.company.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    void save(Company company);

    void update(Company company);

    Company findById(String id);

    void delete(String id);

    //分页查询
    PageInfo<Company> findByPage(int pageNum,int pageSize);
}
