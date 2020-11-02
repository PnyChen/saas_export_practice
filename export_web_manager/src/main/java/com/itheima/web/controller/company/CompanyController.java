package com.itheima.web.controller.company;

import com.itheima.domain.company.Company;
import com.itheima.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public String findAll(Model model){
        List<Company> list = companyService.findAll();
        model.addAttribute("list",list);
        return "company/company-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "company/company-add";
    }

    @RequestMapping("/edit")
    public String edit(Company company){
        if (StringUtils.isEmpty(company.getId())){
            companyService.save(company);
        }else{
            companyService.update(company);
        }
        return "redirect:/company/list.do";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(String id){
        Company company = companyService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("company/company-update");
        modelAndView.addObject("company",company);
        return modelAndView;
    }

    @RequestMapping("/date")
    public String date(Date date){
        //int a = 1/0;
        System.out.println("birth = " + date);
        return "success";
    }

    @RequestMapping("delete")
    public String deleteById(String id){
        companyService.delete(id);
        return "redirect:/company/list.do";
    }

}
