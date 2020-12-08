package com.fxr.certificate_collector.service.impl;

import com.fxr.certificate_collector.dao.UserDao;
import com.fxr.certificate_collector.entity.User;
import com.fxr.certificate_collector.exception.DomainException;
import com.fxr.certificate_collector.service.UserService;
import com.fxr.certificate_collector.utils.MD5Util;

import com.fxr.certificate_collector.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanXiaoRui
 * @date 2020/10/6 11:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 登录校验
     * @author fanXiaoRui
     * @date 2020/11/30 11:56
     * @param userName
    	* @param passWord
     * @return com.fxr.certificate_collector.entity.User
     */
    @Override
    public User checkUser(String userName, String passWord) {
        User user = userDao.findByUserNameAndPassWord(userName, MD5Util.code(passWord));
        if (user == null){
            throw new DomainException(ResultCode.USERNAME_PASSWORD_EXCEPTION);
        }else {
            return user;
        }

    }

}
