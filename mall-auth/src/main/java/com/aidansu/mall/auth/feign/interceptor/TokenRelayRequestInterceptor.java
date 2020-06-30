package com.aidansu.mall.auth.feign.interceptor;

import com.aidansu.mall.core.constant.TokenConstant;
import com.aidansu.mall.core.utils.WebUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 传递token拦截器
 *
 * @author aidan
 */
public class TokenRelayRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        // 1. 获取到token
        HttpServletRequest request = WebUtil.getRequest();
        if(request != null){
            String token = request.getHeader(TokenConstant.HEADER);

            // 2. 将token传递
            if (StringUtils.isNotBlank(token)) {
                template.header(TokenConstant.HEADER, token);
            }
        }
    }
}
