package com.example1.demo1.controller;

import com.example1.demo1.exception.UntityNotFoundException;
import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import com.example1.demo1.service.UnityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class UnityController {
    @Autowired
    private UnityServiceImpl unityServiceImpl;

    @PostMapping("/api/unity")
    public UnityModel add(@RequestBody UnityModel unityModel){
       //unityModel.setId(1);
        //unityModel.setTitle("问候");
        //unityModel.setContent("hello");
       return unityServiceImpl.save(unityModel);

    }

    @PutMapping ("/api/unity/{id}")
    public UnityModel  update(@RequestBody UnityModel unityModel,@PathVariable("id") int id){
        unityServiceImpl.update(unityModel,id);
        //unityModel.setTitle("问候");
        //unityModel.setContent("你好");
        //unityRespository.save(unityModel);
        return unityServiceImpl.save(unityModel);
    }

    @GetMapping("/api/unity")
    public Iterable<UnityModel> list(){
        return  unityServiceImpl.getAll();

    }

    @DeleteMapping("/api/unity/{id}")
    public void  delete(@PathVariable("id") int id){
        unityServiceImpl.delete(id);

    }

    @GetMapping("/api/unity/{id}")
    public Optional<UnityModel>  findById(@PathVariable("id") int id){
        try {
            Optional<UnityModel> unities = unityServiceImpl.find(id);
            return unities;
        }catch (UntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found",e);
        }
    }

    @GetMapping("/api/notfund")
    public String notException(){
        throw  new EntityNotFoundException();
    }
    @GetMapping("/api/runexception")
    public String runException(){
        throw  new RuntimeException();
    }



}
