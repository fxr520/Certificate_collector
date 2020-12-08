package com.fxr.certificate_collector.dao;


import com.fxr.certificate_collector.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanXiaoRui
 * @date 2020/10/6 11:58
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findByUserNameAndPassWord(String username, String password);
}
