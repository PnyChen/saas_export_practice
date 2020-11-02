package com.itheima.web.controller.system;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.system.Dept;
import com.itheima.service.system.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/list")
    public ModelAndView list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize
    ){
        String companyId = "1";
        PageInfo<Dept> pageInfo = deptService.findByPage(companyId,pageNum,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("system/dept/dept-list");
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        String companyId = "1";
        List<Dept> deptList = deptService.findAll(companyId);
        model.addAttribute("deptList",deptList);
        return "system/dept/dept-add(1)";
    }

    @RequestMapping("/edit")
    public String edit(Dept dept){
        dept.setCompanyId("1");
        dept.setCompanyName("传智播客教育股份有限公司");

        if (StringUtils.isEmpty(dept.getId())){
            deptService.save(dept);
        }else{
            deptService.update(dept);
        }
        return "redirect:/system/dept/list.do";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id,Model model){
        String companyId = "1";
        Dept dept = deptService.findById(id);
        List<Dept> deptList = deptService.findAll(companyId);
        model.addAttribute("dept",dept);
        model.addAttribute("deptList",deptList);
        return "system/dept/dept-update";
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String,String> delete(String id){
        Map<String,String> result = new HashMap<>();
        boolean flag = deptService.delete(id);
        if (flag){
            result.put("message","删除成功!");
        }else {
            result.put("message","删除失败：删除的部门有子部门，不能删除！");
        }
        return result;
    }


}
