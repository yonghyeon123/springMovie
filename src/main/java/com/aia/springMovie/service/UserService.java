package com.aia.springMovie.service;

import com.aia.springMovie.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    private SqlSession session;
    private final String NAMESPACE = "springMovie.Mapper";

    public UserDTO auth(UserDTO userDTO){
        return session.selectOne(NAMESPACE + ".auth", userDTO);
    }
}
