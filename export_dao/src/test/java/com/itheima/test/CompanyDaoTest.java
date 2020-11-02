package com.itheima.test;

import com.itheima.dao.company.CompanyDao;
import com.itheima.dao.system.DeptDao;
import com.itheima.domain.company.Company;
import com.itheima.domain.system.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class CompanyDaoTest {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private DeptDao deptDao;

    @Test
    public void findAllTest(){
        List<Company> companyList = companyDao.findAll();
        System.out.println(companyList);
    }

    @Test
    public void findAll(){
        List<Dept> deptList = deptDao.findAll("1");
        System.out.println(deptList);
    }

}
