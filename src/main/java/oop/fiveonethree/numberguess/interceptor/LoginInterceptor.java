package oop.fiveonethree.numberguess.interceptor;

import lombok.extern.log4j.Log4j2;
import oop.fiveonethree.numberguess.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@Log4j2
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        User loginUser = (User) session.getAttribute("user");

        if (loginUser == null) {
            log.debug("用户未登录，正在跳转到登陆界面。");
            response.sendRedirect("/user/login");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }
}
