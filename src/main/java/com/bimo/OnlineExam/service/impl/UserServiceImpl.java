package com.bimo.OnlineExam.service.impl;

import com.bimo.OnlineExam.pojo.User;
import com.bimo.OnlineExam.mapper.UserMapper;
import com.bimo.OnlineExam.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
