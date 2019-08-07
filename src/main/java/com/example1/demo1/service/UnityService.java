package com.example1.demo1.service;

import com.example1.demo1.model.UnityModel;

import java.util.List;
import java.util.Optional;

public interface UnityService {
    void  delete(int id);
    UnityModel save(UnityModel u);
    UnityModel update(UnityModel u,int id);
    Optional<UnityModel> find(int id);
    Iterable<UnityModel> getAll();

}
