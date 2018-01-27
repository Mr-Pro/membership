package cn.lger.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
@Order(1)
@WebFilter(filterName = "loginFilter", urlPatterns = {"/*"} ,initParams={@WebInitParam(name ="EXCLUDED_URL" , value = "/assets/")})
public class LoginFilter implements Filter{

    private String excludedURL;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedURL = filterConfig.getInitParameter("EXCLUDED_URL");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getServletPath().contains(excludedURL) || request.getServletPath().contains("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        Object object = request.getSession().getAttribute("admin");
        if (null != object){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(request.getServletContext().getContextPath()+"/login");
        }
    }

    @Override
    public void destroy() {
        this.excludedURL = null;
    }
}
