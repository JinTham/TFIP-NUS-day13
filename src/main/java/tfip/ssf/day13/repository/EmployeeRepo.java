package tfip.ssf.day13.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import tfip.ssf.day13.model.Employee;

@Repository
public class EmployeeRepo {
    private List<Employee> employees;
    //Constructor
    public EmployeeRepo() throws ParseException{
        if (employees == null){
            employees = new ArrayList<>();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Create employee1
        Date dt = df.parse("1994-10-10");
        Employee employee = new Employee("John", "Doe", "johndoe@gmail.com", "98416213", 5500, dt, "Taman Johor Jaya", 888888);
        employees.add(employee);
        //Create employee2
        dt = df.parse("1992-11-11");
        employee = new Employee("Johnny", "Dowy", "johnnydowy@gmail.com", "98432243", 6500, dt, "Taman Sentosa", 888555);
        employees.add(employee);
    }

    //Methods
    public List<Employee> findAll(){
        return employees;
    }
    public Boolean save(Employee employee){
        Boolean result = employees.add(employee);
        return result;
    }
    public Boolean delete(Employee employee){
        int employeeIndex = employees.indexOf(employee);
        if (employeeIndex >=0){
            employees.remove(employeeIndex);
            return true;
        }
        return false;
    }
}
