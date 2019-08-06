package com.example1.demo1.respositorytest;

import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnityRespositoryTest {
    @Autowired
    private UnityRespository unityRespository;

    @Test
    public void add(){
    UnityModel unityModel = new UnityModel();
    unityModel.setId(1);
    unityModel.setTitle("问候");
    unityModel.setContent("hello");
    UnityModel u=unityRespository.save(unityModel);
    System.out.println(u);

    UnityModel unityModel1 = new UnityModel();
    unityModel1.setId((2));
    unityModel1.setTitle("看书");
    unityModel1.setContent("看故事书");
    UnityModel u1 = unityRespository.save(unityModel1);
    System.out.println(u1);
    //System.out.println(unityRespository.findById(1));

    }
    @Test
    public void update(){
        UnityModel unityModel = new UnityModel();

        unityModel.setTitle("问候");
        unityModel.setContent("你好——修改后");
        UnityModel u = unityRespository.save(unityModel);
        System.out.println(u);
    }


    @Test
    public void  find(){
        UnityModel u = new UnityModel();
        u.setId(1);
        u.setTitle("问候");
        u.setContent("hello");
        unityRespository.save(u);
        System.out.println(unityRespository.findById(1));
    }

    @Test
    public void delete(){
        UnityModel unityModel = new UnityModel();
        unityModel.setId(1);
        unityModel.setTitle("问候");
        unityModel.setContent("hello");
        UnityModel u=unityRespository.save(unityModel);


        UnityModel unityModel1 = new UnityModel();
        unityModel1.setId((2));
        unityModel1.setTitle("看书");
        unityModel1.setContent("看故事书");
        UnityModel u1 = unityRespository.save(unityModel1);

        unityRespository.deleteById(6);
        Iterable i =unityRespository.findAll();
        System.out .println(i);
    }

    @Test
    public void findById(){
        UnityModel unityModel = new UnityModel();
        unityModel.setId(1);
        unityModel.setTitle("问候");
        unityModel.setContent("hello");
        UnityModel u=unityRespository.save(unityModel);


        UnityModel unityModel1 = new UnityModel();
        unityModel1.setId((2));
        unityModel1.setTitle("看书");
        unityModel1.setContent("看故事书");
        UnityModel u1 = unityRespository.save(unityModel1);

        System.out.println(unityRespository.findById(1));

    }






}



