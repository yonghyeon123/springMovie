package com.aia.springMovie.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RateService {
    @Autowired
    private SqlSession session;
    private final String NAMESPACE = "springMovie.RateMapper";

    public Map AvgByMovieId(){
        return session.selectMap(NAMESPACE + ".avgByMovieId", "movieId");
    }
}
