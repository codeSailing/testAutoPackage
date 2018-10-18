package com.zhum.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhum.demo.entity.User;
import com.zhum.demo.mapper.UserMapper;
import com.zhum.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhum
 * @description:
 * @create: 2018-10-11 14:55
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    public void add(User user) {
        userMapper.insertSelective(user);
    }
}
