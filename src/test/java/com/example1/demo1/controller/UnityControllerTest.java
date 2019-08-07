package com.example1.demo1.controller;

import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
;


import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWebMvc

public class UnityControllerTest {
    private Logger logger = LoggerFactory.getLogger(UnityControllerTest.class);
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UnityRespository unityRespository;

    @Test
    public void  getAllUnityTest() throws Exception{
        mockMvc.perform(get("/api/unity")).andExpect(status().isOk());

    }

    @Test
    public void saveTest() throws Exception{
        unityRespository.deleteAll();
        UnityModel unityModel = new UnityModel();
        unityModel.setTitle("say");
        unityModel.setContent("hello");
        JSONObject object = new JSONObject();
        object.put("id","");
        object.put("title",unityModel.getTitle());
        object.put("content",unityModel.getContent());

        //System.out.println(object.toJSONString());

        MvcResult mvcResult =  mockMvc.perform(post("/api/unity").
                content(object.toJSONString()).

                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        String test = mvcResult.getResponse().getContentAsString();
        //System.out.println("_____________-------------------------------"+test);
       JSONObject jsonObject = JSONObject.parseObject(test);

        assertThat(jsonObject.getString("title")).isEqualTo("say");
        logger.info(test);
//
//
//        int id = ((JSONObject) jsonArray.get(0)).getInteger("id");
//        unityModel.setId(id);
//        unityModel.setTitle("看书");
//        mvcResult = mockMvc.perform(put("/api/unity"+id).
//                content(JSONObject.toJSONString(unityModel)).
//                contentType(MediaType.APPLICATION_JSON)).
//                andExpect(status().isOk())
//                .andReturn();
//        object = JSONObject.parseObject(mvcResult.getResponse().getContentAsString());
//        assertThat(object.getString("title")).isEqualTo("看书");
//
//
//
//        mockMvc.perform(delete("/api/unity/"+id)).andExpect(status().isOk());
//        mvcResult = mockMvc.perform(get("/api/unity")).andExpect(status().isOk())
//                .andReturn();
//        jsonArray = JSONArray.parseArray(mvcResult.getResponse().getContentAsString());
//        assertThat(jsonArray.size()).isEqualTo(0);
//
//
//
//
    }
    @Test
    public void updateTest() throws Exception{

        UnityModel unityModel = new UnityModel();
        unityModel.setTitle("say");
        unityModel.setContent("hi");
       UnityModel u = unityRespository.save(unityModel);
       int id = u.getId();
       unityModel.setContent("hello");
       MvcResult mvcResult = mockMvc.perform(put("/api/unity/"+id).
                content(JSONObject.toJSONString(unityModel)).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        JSONObject object =JSONObject.parseObject( mvcResult.getResponse().getContentAsString());
        assertThat(object.getString("content")).isEqualTo("hello");

    }

    @Test
    public void findByIdTest() throws Exception{
        UnityModel unityModel =new UnityModel();
        unityModel.setContent("ok");
        unityModel.setTitle("say");
       UnityModel u = unityRespository.save(unityModel);
       int id = u.getId();
        MvcResult mvcResult = mockMvc.perform(get("/api/unity/"+id).
                content(JSONObject.toJSONString(unityModel)).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        JSONObject object =JSONObject.parseObject( mvcResult.getResponse().getContentAsString());
        assertThat(object.getString("content")).isEqualTo("ok");


    }

    @Test
    public void deleteByIdTest() throws Exception{
        unityRespository.deleteAll();
        UnityModel unityModel =new UnityModel();
        unityModel.setContent("ok");
        unityModel.setTitle("say");
        UnityModel u = unityRespository.save(unityModel);
        int id = u.getId();
        mockMvc.perform(delete("/api/unity/"+id)).andExpect(status().isOk());
       Iterable i = unityRespository.findAll();
        Iterator iterator = i.iterator();
       if(iterator.hasNext()){
           System.out.println("测试失败");
       }else{
           System.out.println("测试成功");
       }


    }







}
