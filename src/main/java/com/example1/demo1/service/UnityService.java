package com.example1.demo1.service;

import com.example1.demo1.model.UnityModel;

import java.util.List;

public interface UnityService {
    void delete(int id);
    void save(UnityModel u);
    void update(UnityModel u);
    void find(int id);
    Iterable<UnityModel> getAll();
}
