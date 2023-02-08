package tfip.ssf.day13.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
    final String dirPath = "C:/Users/user/My File/TFIP/Code/day13";
    final String filename = "employee.txt";
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
    public Employee findByEmail(String email){
        Employee employee = employees.stream().filter(e->e.getEmail().equalsIgnoreCase(email)).findFirst().get();
        return employee;
    }
    public Boolean save(Employee employee) throws IOException{
        Boolean result = employees.add(employee);
        File file = new File(dirPath+"/"+filename);
        OutputStream os = new FileOutputStream(file, true);
        PrintWriter pw = new PrintWriter(os);
        pw.println(employee.toString());
        pw.flush();
        pw.close();
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
    public Boolean update(Employee employee){
        Employee updatingEmployee = findByEmail(employee.getEmail());
        int updatingEmployeeIndex = employees.indexOf(updatingEmployee);
        if (updatingEmployeeIndex >=0){
            employees.remove(updatingEmployeeIndex);
        }
        employees.add(employee);
        return true;
    }
}
