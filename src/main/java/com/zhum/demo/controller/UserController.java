package com.zhum.demo.controller;

import com.zhum.demo.entity.User;
import com.zhum.demo.pojo.ResponseData;
import com.zhum.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhum
 * @description:
 * @create: 2018-10-11 15:09
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController{

    @Resource
    private UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public void add(User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData findAll(int pageNum, int pageSize){
        ResponseData responseData = new ResponseData();
        List<User> userList = userService.findAllUser(pageNum,pageSize);
        responseData.setData(userList);
        return responseData;
    }

}
