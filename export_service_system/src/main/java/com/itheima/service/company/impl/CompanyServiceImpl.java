package com.itheima.service.company.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.company.CompanyDao;
import com.itheima.domain.company.Company;
import com.itheima.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> findAll() {
        List<Company> companyList = companyDao.findAll();
        return companyList;
    }

    @Override
    public void save(Company company) {
        company.setId(UUID.randomUUID().toString());
        companyDao.save(company);
    }

    @Override
    public void update(Company company) {
        companyDao.update(company);
    }

    @Override
    public Company findById(String id) {
        Company company = companyDao.findById(id);
        return company;
    }

    @Override
    public void delete(String id) {
        companyDao.delete(id);
    }

    @Override
    public PageInfo<Company> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Company> companyList = companyDao.findAll();
        return new PageInfo<>(companyList);
    }
}
