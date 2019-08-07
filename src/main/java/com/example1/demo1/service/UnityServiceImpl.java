package com.example1.demo1.service;

import com.example1.demo1.model.UnityModel;
import com.example1.demo1.respository.UnityRespository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class UnityServiceImpl implements UnityService{
    @Resource
    private UnityRespository unityRespository;
   ;

    @Override

    public void delete(int id) {
        unityRespository.deleteById(id);


    }



    @Override

    public UnityModel save(UnityModel u) {
          return  unityRespository.save(u);

    }

    @Override

    public UnityModel update(UnityModel u,int id) {
           UnityModel unityModel  = unityRespository.findById(u.getId()).get();
           unityModel.setTitle(u.getTitle());
           unityModel.setContent(u.getContent());
           return unityRespository.save(unityModel);



    }

    @Override

    public Optional<UnityModel> find(int id) {
      Optional<UnityModel>  unities = unityRespository.findById(id);
      return unities;

    }



    @Override
    @Transactional
    public Iterable<UnityModel> getAll() {
        return unityRespository.findAll();
}
}

