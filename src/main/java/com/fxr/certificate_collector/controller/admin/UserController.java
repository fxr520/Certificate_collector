package com.fxr.certificate_collector.controller.admin;

import com.fxr.certificate_collector.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fanXiaoRui
 * @date 2020/11/23 15:13
 */
@RestController
@Api(tags = "登录API")
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "验证登录", notes = "通过校验用户名与密码判断登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",defaultValue = "admin"),
            @ApiImplicitParam(name = "passWord",value = "密码",defaultValue = "wamsb")
    })
    @GetMapping("/login")
    public Boolean login(@RequestParam String userName,
                         @RequestParam String passWord) {
        userService.checkUser(userName,passWord);
        return true;

    }

}
