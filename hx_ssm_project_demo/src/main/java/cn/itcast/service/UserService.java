package cn.itcast.service;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    public User login(User user);

}
