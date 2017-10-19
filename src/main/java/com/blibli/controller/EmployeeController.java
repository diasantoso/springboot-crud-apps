package com.blibli.controller;

import com.blibli.model.Employee;
import com.blibli.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dias on 1/30/2017.
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @RequestMapping("/tampilemp")
    public String MahasiswaList(Model model){
        model.addAttribute("employee", employeeServices.showEmp());
        return "tampilemp";
    }

    @RequestMapping(value = "/tampilemp/create", method = RequestMethod.GET)
    public String tampilFormCreate(Model model){
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @RequestMapping(value = "/tampilemp/create", method = RequestMethod.POST)
    public String simpanDataMhs(Model model, Employee emp){
        model.addAttribute("employee", employeeServices.saveOrUpdate(emp));
        return "redirect:/tampilemp";
    }

    @RequestMapping(value = "/tampilemp/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("employee", employeeServices.getIdEmp(id));
        return "create";
    }

    @RequestMapping(value = "tampilemp/hapus/{id}", method = RequestMethod.GET)
    public String hapus(@PathVariable Integer id, Model model){
        employeeServices.hapus(id);
        return "redirect:/tampilemp";
    }
}
