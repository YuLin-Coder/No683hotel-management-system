package cn.edu.glut.jiudian.service.impl;

import cn.edu.glut.jiudian.dao.AdminMapper;
import cn.edu.glut.jiudian.dao.UserMapper;
import cn.edu.glut.jiudian.entity.Admin;
import cn.edu.glut.jiudian.entity.User;
import cn.edu.glut.jiudian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author stone(huangshizhang) at 2019-06-11 10:26
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean deleteUser(String userName) {
        return userMapper.deleteByName(userName);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public boolean updateAdminPassword(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }
}
