package com.example1.demo1.servicetest;

import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import com.example1.demo1.service.UnityServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UnityServiceTest {
    @Autowired
    private UnityServiceImpl unityService;
    @MockBean
    UnityRespository unityRespository;
    @Before
    public void setUp(){
        UnityModel u = new UnityModel();
        u.setId(1);
        u.setTitle("运动");
        u.setContent("打篮球");
        unityService.save(u);

        UnityModel u2 = new UnityModel();
        u2.setId(2);
        u2.setTitle("娱乐");
        u2.setContent("打游戏");


        List<UnityModel> unityModelList = Arrays.asList(u,u2);
        Mockito.when(unityRespository.findById(u.getId())).thenReturn(Optional.of(u));
        Mockito.when(unityRespository.findById(u2.getId())).thenReturn(Optional.of(u2));
        Mockito.when(unityRespository.findById(0)).thenReturn(null);
        Mockito.when(unityRespository.save(new UnityModel())).thenReturn(u2);
        Mockito.when(unityRespository.findAll()).thenReturn(unityModelList);

    }
    @Test
    public void  saveTest(){
        UnityModel u = new UnityModel();
        u.setId(1);
        u.setTitle("运动");
        u.setContent("打篮球");
        unityService.save(u);
        System.out.println(u);

        UnityModel u2 = new UnityModel();
        u2.setId(2);
        u2.setTitle("娱乐");
        u2.setContent("打游戏");
        unityService.save(u2);
        System.out.println(u2);

        Iterable<UnityModel> allUnity = unityService.getAll();
        assertThat(allUnity).hasSize(2).extracting(UnityModel::getContent).
                contains(u.getContent(),u2.getContent());





    }

    @Test
    public void deleteTest(){
        UnityModel u = new UnityModel();
        u.setId(1);
        u.setTitle("运动");
        u.setContent("打篮球");
        unityService.save(u);
        System.out.println(u);

        UnityModel u2 = new UnityModel();
        u2.setId(2);
        u2.setTitle("娱乐");
        u2.setContent("打游戏");
        unityService.save(u2);


        //unityService.delete(1);
        Iterable<UnityModel> i = unityService.getAll();
        System.out.println(i);

    }






}
