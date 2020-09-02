package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
public interface UserService extends IService<User> {
    public User getUserByUsername(String username);
    public boolean checkExists(String username);
}
