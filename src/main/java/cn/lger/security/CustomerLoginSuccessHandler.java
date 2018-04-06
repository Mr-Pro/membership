package cn.lger.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2018-04-05.
 */
@Component
public class CustomerLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //SecurityContextHolder是Spring Security的核心组件，可获取框架爱内的一些信息
        //这里我得到登录成功后的UserDetails
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            request.getSession().setAttribute("admin", ((CustomerUserDetails) principal).getAdmin());
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
