package com.example1.demo1.respository;

import com.example1.demo1.model.UnityModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface UnityRespository extends CrudRepository<UnityModel,Integer> {
  /*  @Override
    Optional<UnityModel> findById(Integer integer);

    @Override
    void delete(UnityModel unityModel);

    @Override
    Iterable<UnityModel> findAll();*/

}
