package com.billow.system.config.jpa;

import com.billow.common.business.UserTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * 给Bean中的 @CreatedBy  @LastModifiedBy 注入操作人
 *
 * @author LiuYongTao
 * @date 2019/7/16 14:29
 */
@Configuration
public class InjectOpreator implements AuditorAware<String> {

    @Autowired
    private UserTools userTools;


    @Override
    public String getCurrentAuditor() {
        return userTools.getCurrentUserCode();
    }
}