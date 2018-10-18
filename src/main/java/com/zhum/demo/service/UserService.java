package com.zhum.demo.service;

import com.zhum.demo.entity.User;

import java.util.List;

/**
 * @author: zhum
 * @description:
 * @create: 2018-10-11 14:43
 **/
public interface UserService {
    /**
     * @author: zhum
     * @description: 新增
     * @date: 2018/10/11 14:54
     */
    void addUser(User user);

    /**
     * @author: zhum
     * @description: 查询所有
     * @date: 2018/10/11 14:55
     */
    List<User> findAllUser(int pageNum, int pageSize);

    void add(User user);
}
