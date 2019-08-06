/*package com.example1.demo1.controller;

import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        mockMvc.perform(get("/list")).andExpect(status().isOk());

    }

    @Test
    public void UnityCurd() throws Exception{
        unityRespository.deleteAll();
        UnityModel unityModel = new UnityModel();
        unityModel.setTitle("问候");
        unityModel.setContent("你好");
        JSONObject object = new JSONObject();
        object.put("id","1");
        object.put("title",unityModel.getTitle());
        object.put("content",unityModel.getContent());
        MvcResult mvcResult =  mockMvc.perform(post("/list")).
                content (object.toJSONString()).
                contentType(MediaType.APPLICATION_JSON)).
                 andExpect(status().isOk())
                .andReturn();
        String test = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(test);
        assertThat(jsonArray.size()).isEqualTo(1);
        assertThat(((JSONObject)jsonArray.get(0)).getString("title")).isEqualTo("joketitle");
        logger.info(test);



    }





}*/
