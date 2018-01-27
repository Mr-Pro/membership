package cn.lger.web;

import cn.lger.domain.Admin;
import cn.lger.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginView(HttpServletRequest request){
        if (null != request.getSession().getAttribute("admin")){
            return "index";
        }
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request){

        if (null != request.getSession().getAttribute("admin"))
            return "index";
        else {
            Admin admin = adminService.findAdminByUsernameAndPassword(username, password);
            if (admin != null)
                request.getSession().setAttribute("admin", admin);
            else {
                request.setAttribute("msg", "用户不存在或者密码错误！");
                return "login";
            }
        }
        return "index";
    }
}
