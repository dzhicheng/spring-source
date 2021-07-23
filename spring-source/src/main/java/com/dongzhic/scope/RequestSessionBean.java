package com.dongzhic.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @Author dongzhic
 * @Date 7/9/21 11:12 PM
 */
@Component
@Scope(value = RequestAttributes.REFERENCE_REQUEST)
public class RequestSessionBean {
}
