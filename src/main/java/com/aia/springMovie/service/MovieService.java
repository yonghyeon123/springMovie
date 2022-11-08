package com.aia.springMovie.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieService {
    @Autowired
    private SqlSession session;
    private final String NAMESPACE = "springMovie.MovieMapper";

    public List<Map<Object, Object>> selectAll(int pageNo, int size){
        HashMap<String, Integer> limits = new HashMap<>();
        limits.put("start", (pageNo - 1) * size);
        limits.put("size", size);
        return session.selectList(NAMESPACE + ".selectAll", limits);
    }
}
