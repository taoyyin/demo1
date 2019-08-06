package com.example1.demo1.controller;

import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class UnityController {
    private UnityRespository unityRespository;
    @RequestMapping("/add")
    public void add(){
        UnityModel unityModel = new UnityModel();
        unityModel.setId(1);
        unityModel.setTitle("问候");
        unityModel.setContent("hello");
        unityRespository.save(unityModel);

    }

    @RequestMapping("/update")
    public void  update(){
        UnityModel unityModel = new UnityModel();
        unityModel.setTitle("问候");
        unityModel.setContent("你好");
        unityRespository.save(unityModel);
    }

    @RequestMapping("/list")
    public Iterable<UnityModel> list(){
        return  unityRespository.findAll();

    }


}
