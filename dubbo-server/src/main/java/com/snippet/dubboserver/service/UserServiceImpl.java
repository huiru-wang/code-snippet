package com.snippet.dubboserver.service;

import com.snippet.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * create by whr on 2023-07-16
 */
@Slf4j
@DubboService(version = "0.0.1", protocol = {"dubbo"}, cluster = ClusterRules.FAIL_FAST)
public class UserServiceImpl implements UserService {
    @Override
    public String userInfo(Long userId) {
        String userName = "";
        if (null == userId) {
            userName = "FAILED:0.0.1";
        } else {
            userName = "SUCCESS:0.0.1";
        }
        log.info("Dubbo RPC Request: {}:{}", userId, userName);
        return userName;
    }
}
