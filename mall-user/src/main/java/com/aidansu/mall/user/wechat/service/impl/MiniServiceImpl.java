package com.aidansu.mall.user.wechat.service.impl;

import com.aidansu.mall.core.error.ApisException;
import com.aidansu.mall.user.config.WechatAccountConfig;
import com.aidansu.mall.user.wechat.entity.UserSession;
import com.aidansu.mall.user.wechat.service.MiniService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author aidansu
 */
@Service
public class MiniServiceImpl implements MiniService {


    @Resource
    private WechatAccountConfig wechatAccountConfig;

    @Override
    public UserSession code2Session(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+wechatAccountConfig.getMiniAppId()+"&secret="+wechatAccountConfig.getMiniAppSecret()+"&js_code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String userInfo = restTemplate.getForObject(url, String.class);

        if(StringUtils.isEmpty(userInfo)){
            throw new ApisException("获取不到用户信息");
        }
        UserSession userSession = JSON.parseObject(userInfo,UserSession.class);
        if(userSession.getErrcode() != null){
            if(userSession.getErrcode() == 40029){
                throw new ApisException("code 无效");
            }else if(userSession.getErrcode() == 45011){
                throw new ApisException("频率限制，每个用户每分钟100次");
            }else if(userSession.getErrcode() == -1){
                throw new ApisException("系统繁忙，此时请开发者稍候再试");
            }
        }

        return userSession;

    }
}
