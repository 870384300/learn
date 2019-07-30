package com.billow.user.api;

import com.billow.common.base.BaseApi;
import com.billow.user.pojo.vo.UserVo;
import com.billow.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息操作
 *
 * @author liuyongtao
 * @create 2018-11-05 15:11
 */
@Api(value = "用户信息操作")
@RestController
@RequestMapping("/userApi")
public class UserApi extends BaseApi {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名查询出用户信息
     *
     * @param userCode 用户名
     * @return UserVo
     * @author LiuYongTao
     * @date 2018/11/5 15:18
     */
    @GetMapping("/findUserInfoByUsercode/{userCode}")
    public UserVo findUserInfoByUsercode(@PathVariable("userCode") String userCode) {
        UserVo userVo = userService.findUserInfoByUsercode(userCode);
        return userVo;
    }

    /**
     * 根据用户code 查询用户信息，用于spring security 认证使用
     *
     * @param userCode 用户code
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author LiuYongTao
     * @date 2019/4/28 9:27
     */
    @GetMapping("/loadUserByUsername/{userCode}")
    public UserDetails loadUserByUsername(@PathVariable("userCode") String userCode) {
        UserDetails userDetails = userService.loadUserByUsername(userCode);
        return userDetails;
    }
}
