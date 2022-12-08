package com.nest.studentapp_backend.controller;

import com.nest.studentapp_backend.dao.StudentDao;
import com.nest.studentapp_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentDao dao;
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public  String Homepage(){

        return "Welcome to my website";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Map<String,String> AddStudent(@RequestBody Students s){

        dao.save(s);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Students> ViewStudent(){
        return (List<Students>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Students> SearchStudent(@RequestBody Students s){
        return (List<Students>) dao.searchStudent(s.getAdmno());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public Map<String,String> DeletePatient(@RequestBody Students s){
        String pid=String.valueOf(s.getId());
        System.out.println(pid);
        dao.deleteStudent(s.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }



}
