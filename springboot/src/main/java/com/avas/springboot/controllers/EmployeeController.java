package com.avas.springboot.controllers;

import com.avas.springboot.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    HashMap<Integer, Employee> empHm = new HashMap<>();
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee e) throws Exception {
        int id = e.getId();
        if(id == 0){
            throw new Exception("Id not present");
        }
        if(empHm.containsKey(id)){
            throw new Exception("Employee present");
        } else {
            empHm.put(id, e);
        }
        return  "Employee Created";
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployees(){
        return new ArrayList<>(empHm.values());
    }


    @GetMapping(value = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployees(@RequestParam("id") int id) throws Exception {
        if(empHm.containsKey(id))
            return empHm.get(id);
        else
            throw new Exception("employee not found");
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public String deleteEmployee(@RequestParam("id") int id) throws Exception {
        if(empHm.containsKey(id)){
            empHm.remove(id);
            return "Employee deleted";
        } else {
            return "Employee doesnt exist";
        }
    }

    @PatchMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee) throws Exception {
        int id = employee.getId();
        if(empHm.containsKey(id)){
            empHm.remove(id);
            return "Employee deleted";
        } else {
            return "Employee doesnt exist";
        }
    }


}
