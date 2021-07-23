package com.dongzhic.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author dongzhic
 * @Date 7/10/21 12:15 AM
 */
@Component
@Scope("jackScope")
public class CustomScopeBean {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
