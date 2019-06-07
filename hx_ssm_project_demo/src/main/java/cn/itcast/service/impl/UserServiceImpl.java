package cn.itcast.service.impl;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User u = userMapper.findUser(user);
        return u;
    }
}
