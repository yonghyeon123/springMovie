package com.aia.springMovie.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieService {
    @Autowired
    private SqlSession session;
    private final String NAMESPACE = "springMovie.MovieMapper";


}
