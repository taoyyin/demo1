package com.example1.demo1.controller;

import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import com.example1.demo1.service.UnityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UnityController {
    @Autowired
    private UnityServiceImpl unityServiceImpl;

    @PostMapping("/add")
    public void add(UnityModel unityModel){
       //unityModel.setId(1);
        //unityModel.setTitle("问候");
        //unityModel.setContent("hello");
        unityServiceImpl.save(unityModel);

    }

    @PutMapping ("/update")
    public void  update(UnityModel unityModel){
        unityServiceImpl.update(unityModel);
        //unityModel.setTitle("问候");
        //unityModel.setContent("你好");
        //unityRespository.save(unityModel);
    }

    @GetMapping("/list")
    public Iterable<UnityModel> list(){
        return  unityServiceImpl.getAll();

    }

    @DeleteMapping("/delete")
    public void  delete(int id){
        unityServiceImpl.delete(id);
    }

    @GetMapping("/findbyid")
    public Optional<UnityModel>  findById(int id){
      Optional<UnityModel> unities = unityServiceImpl.find(id);
      return unities;
    }



}
