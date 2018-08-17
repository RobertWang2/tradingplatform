package com.xyz.biz;

import com.xyz.dao.User;

/**
 * @program: tradingplatform
 * @description: 用户业务的接口
 * @author: Robert_Wang
 * @create: 2018-08-17 09:11
 **/
public interface UserService {

    public void addUser(User user);

    public  void deleteUserById(Integer id);
    public  void deleteUserByUsername(Integer id, String username);

    public User queryById(Integer id);
    public User queryByUsername(String username);

    public void updatePasswordById(Integer id, String password);
    public void updatePasswordByUsername(String username, String password);

    public void updateRemarkById(Integer id, String remark);
    public void updateRemarkByUsername(String remark, String username);

    public void transfer(String org, String des, Double money);
}
