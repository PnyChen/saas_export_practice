package com.itheima.test;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.company.Company;
import com.itheima.service.company.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/applicationContext-tx.xml")
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class CompanyServiceTest {

    @Autowired
    CompanyService companyService;

    @Test
    public void findAllTest(){
        List<Company> companyList = companyService.findAll();
        System.out.println(companyList);
    }

    @Test
    public void findByPage(){
        int pageNum=1;
        int pageSize=5;
        PageInfo<Company> pageInfo = companyService.findByPage(pageNum,pageSize);
        System.out.println(pageInfo);
    }

}
