package com.aidansu.mall.auth.feign.fallbackfactory;

import com.aidansu.mall.auth.dto.UserLoginDTO;
import com.aidansu.mall.auth.entity.UserInfo;
import com.aidansu.mall.auth.feign.IUserClient;
import com.aidansu.mall.core.api.R;
import com.aidansu.mall.core.constant.ApisConstant;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 限流/降级处理
 *
 * @author aidan
 */
@Component
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<IUserClient> {
    @Override
    public IUserClient create(Throwable cause) {
        return new IUserClient() {
            @Override
            public R<UserInfo> loginByMini(UserLoginDTO dto) {
                log.warn("远程调用被限流/降级了", cause);
                return R.fail(ApisConstant.FLOW_CONTROL_DOWNGRADE);
            }

            @Override
            public R<UserInfo> loginByUsername(UserLoginDTO dto) {
                log.warn("远程调用被限流/降级了", cause);
                return R.fail(ApisConstant.FLOW_CONTROL_DOWNGRADE);
            }
        };
    }
}
