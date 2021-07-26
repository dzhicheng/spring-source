package com.dongzhic.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 前置过滤器：权限校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("======UserInterceptor用户权限校验=========");
        return true;
    }

    /**
     * 中置过滤器：倒叙调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========UserInterceptor修改modelAndView======");
        HttpSession session = request.getSession();
        if(modelAndView != null) {
            String modifyViewName = modelAndView.getViewName() + "_" + session.getAttribute("language");
            modelAndView.setViewName(modifyViewName);
        }
    }

    /**
     * 后置过滤器：倒叙调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========UserInterceptor资源释放======");
    }
}
