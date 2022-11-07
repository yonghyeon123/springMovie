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

    /**
     * 로그인 메소드
     * @param userDTO 로그인할 회원정보
     * @return 로그인된 회원정보
     */
    public UserDTO auth(UserDTO userDTO){
        return session.selectOne(NAMESPACE + ".auth", userDTO);
    }

    /**
     * 아이디 중복 체크
     * @param userDTO 중복 체크를 할 회원정보
     * @return 중복이 없다면 true, 있다면 false
     */
    public boolean validateUsername(UserDTO userDTO){
        return session.selectOne(NAMESPACE + ".validateUsername", userDTO) == null;
    }

    /**
     * 회원가입 메소드
     * @param userDTO 회원가입할 회원정보
     */
    public void register(UserDTO userDTO){
        session.insert(NAMESPACE + ".register", userDTO);
    }

    /**
     * 회원정보 업데이트
     * @param userDTO 수정할 회원정보
     */
    public void update(UserDTO userDTO){
        session.update(NAMESPACE + ".update", userDTO);
    }

    /**
     * 회원정보 삭제
     * @param id 삭제할 회원정보의 번호
     */
    public void delete(int id){
        session.delete(NAMESPACE + ".delete", id);
    }
}
