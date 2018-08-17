package com.xyz.daoImpl;

import com.xyz.dao.User;
import com.xyz.dao.UserDAO;
import com.xyz.dao.UserMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @program: tradingplatform
 * @description: 用户DAO的实现
 * @author: Robert_Wang
 * @create: 2018-08-17 08:45
 **/
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

    @Override
    public void addUser(User user) {
            String sql = "insert into user (username, password, email, balance, credit, remark, birthday, age) values(?,?,?,?,?,?,?,?)";
            this.getJdbcTemplate().update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getBalance(),user.getCredit(), user.getRemark(),user.getBirthday(),user.getAge());
            System.out.println("Add user successfully!");
    }

    @Override
    public void deleteUserById(Integer id) {
        String sql = "delete from user where id = ?";
        this.getJdbcTemplate().update(sql,id);
        System.out.println("A user was deleted successfully! id:" + id);
    }

    @Override
    public void deleteUserByUsername(Integer id, String username) {
        String sql = "delete from user where username = ?";
        this.getJdbcTemplate().update(sql,username);
        System.out.println("A user was deleted successfully! username: "  + username);
    }

    @Override
    public User queryById(Integer id) {
        String sql = "select * from user where id = ?";
        User user = this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    @Override
    public User queryByUsername(String username) {
        String sql = "select * from user where username = ?";
        User user = this.getJdbcTemplate().queryForObject(sql, new Object[]{username}, new UserMapper());
        return user;
    }

    @Override
    public void updatePasswordById(Integer id, String password) {
        String sql = "update user set password = ? where id = ?";
        this.getJdbcTemplate().update(sql,password,id);
        System.out.println("Password update successfully!");
    }

    @Override
    public void updatePasswordByUsername(String username, String password) {
        String sql = "update user set password = ? where usernmae = ?";
        this.getJdbcTemplate().update(sql,password,username);
        System.out.println("Password update successfully!");
    }

    @Override
    public void updateRemarkById(Integer id, String remark) {
        String sql = "update user set remark = ? where id = ?";
        this.getJdbcTemplate().update(sql,remark,id);
        System.out.println("Password update successfully!");
    }

    @Override
    public void updateRemarkByUsername(String remark, String username) {
        String sql = "update user set remark = ? where username = ?";
        this.getJdbcTemplate().update(sql,remark,username);
        System.out.println("Password update successfully!");
    }

    @Override
    public void outmoney(String username, Double money) {
        String sql = "update user set balance = balance - ? where username = ?";
        this.getJdbcTemplate().update(sql,money,username);
    }

    @Override
    public void inmoney(String username, Double money) {
        String sql = "update user set balance = balance + ? where username = ?";
        this.getJdbcTemplate().update(sql,money,username);
    }
}
