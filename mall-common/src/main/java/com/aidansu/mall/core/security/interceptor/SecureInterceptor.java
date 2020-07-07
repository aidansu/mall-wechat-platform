package com.aidansu.mall.core.security.interceptor;

import com.aidansu.mall.core.api.R;
import com.aidansu.mall.core.api.ResultCode;
import com.aidansu.mall.core.constant.CommonConstant;
import com.aidansu.mall.core.security.utils.JwtTokenUtil;
import com.aidansu.mall.core.utils.WebUtil;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * JWT 拦截器校验
 *
 * @author aidan
 */
@Slf4j
@AllArgsConstructor
public class SecureInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (JwtTokenUtil.checkToken()) {
            return true;
        } else {
            log.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}", request.getRequestURI(), WebUtil.getIP(request), JSON.toJSONString(request.getParameterMap()));
            R<String> result = R.fail(ResultCode.UN_AUTHORIZED);
            response.setCharacterEncoding(CommonConstant.UTF_8);
            response.setHeader(CommonConstant.CONTENT_TYPE_NAME, MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_OK);
            try {
                response.getWriter().write(Objects.requireNonNull(JSON.toJSONString(result)));
            } catch (IOException ex) {
                log.error(ex.getMessage());
            }
            return false;
        }
    }

}
