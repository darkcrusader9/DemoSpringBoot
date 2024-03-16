package com.avas.springboot.controllers;

import com.avas.springboot.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeDBController {
    private static final Connection employeeConnection;

    static {
        try {
            employeeConnection = DBConnection.getDBConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) throws Exception {
        String query = "INSERT INTO employee_data VALUES" +
                "("+employee.getId()+",\""+employee.getName()+"\",\""
                +employee.getEmail()+"\",\""+employee.getDesignation()+"\");";

        Statement statement = employeeConnection.createStatement();
        statement.execute(query);
        return "Employee Added";
    }

//    @GetMapping("/getAllEmployee")
//    public List<Employee> getAllEmployees(){
//        String sqlQuery = "SELECT * FROM employee_data";
//    }
//
//
//    @GetMapping(value = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Employee getEmployees(@RequestParam("id") int id) throws Exception {
//
//    }
//
//    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
//    public String deleteEmployee(@RequestParam("id") int id) throws Exception {
//
//    }
//
//    @PatchMapping("/updateEmployee")
//    public String updateEmployee(@RequestBody Employee employee) throws Exception {
//
//    }


}
