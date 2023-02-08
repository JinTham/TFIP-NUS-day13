package tfip.ssf.day13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import tfip.ssf.day13.model.Employee;
import tfip.ssf.day13.repository.EmployeeRepo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    
    @GetMapping("/home")
    public String employeeListPage(Model model){
        List<Employee> employeeList = employeeRepo.findAll();
        model.addAttribute("employeeList", employeeList);
        return "employeeList";
    }

    @GetMapping("/addNew")
    public String addNew(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }

    @PostMapping("/addNew")
    //Model model must be the last argument else wont work
    public String addEmployee(@Valid @ModelAttribute("employee") Employee newEmployee, BindingResult result, Model model){
        if (result.hasErrors()){
            return "employeeAdd";
        }
        Boolean addResult = employeeRepo.save(newEmployee);
        return "redirect:/employee/home";
    }

}
