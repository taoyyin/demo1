package com.example1.demo1.service;

import com.example1.demo1.model.UnityModel;

import java.util.List;
import java.util.Optional;

public interface UnityService {
    void delete(int id);
    void  save(UnityModel u);
    void update(UnityModel u);
    Optional<UnityModel> find(int id);
    Iterable<UnityModel> getAll();

}
