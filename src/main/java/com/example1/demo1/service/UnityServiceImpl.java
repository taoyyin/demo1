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
    @Transactional
    public void delete(int id) {
        unityRespository.deleteById(id);
    }



    @Override
    @Transactional
    public void save(UnityModel u) {
           unityRespository.save(u);

    }

    @Override
    @Transactional
    public void update(UnityModel u) {
           UnityModel unityModel  = unityRespository.findById(u.getId()).get();
           unityModel.setTitle(u.getTitle());
           unityModel.setContent(u.getContent());



    }

    @Override
    @Transactional
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

