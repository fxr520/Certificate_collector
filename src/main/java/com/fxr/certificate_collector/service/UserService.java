package com.fxr.certificate_collector.service;


import com.fxr.certificate_collector.entity.User;

/**
 * @author fanXiaoRui
 * @date 2020/10/6 10:57
 */
public interface UserService {

    User checkUser(String userName, String passWord);
}
