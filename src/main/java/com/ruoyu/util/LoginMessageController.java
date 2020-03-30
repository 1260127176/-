package com.ruoyu.util;

import com.ruoyu.bean.XbloUserBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

public class LoginMessageController implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginName = request.getSession().getAttribute("loginName");
        XbloUserBean userBean1 = (XbloUserBean) request.getSession().getAttribute("userBean");
        if (userBean1.equals("") || userBean1==null){
            int option = JOptionPane.showConfirmDialog(null,"身份信息失效，是否重新登录？", "系统消息", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);

            switch (option) {
                case JOptionPane.YES_NO_OPTION: {
                    request.getRequestDispatcher("page/admin/login/login.jsp").forward(request,response);
                }
                case JOptionPane.NO_OPTION:
                    System.exit(0);

            }
        }
        System.out.println("preHandle");
        System.out.println("===loginName:"+loginName);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
