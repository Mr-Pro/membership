package cn.lger.web;

import cn.lger.dao.AdminDao;
import cn.lger.domain.Admin;
import cn.lger.domain.AdminRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
@Controller
public class AdminController {

    @Resource
    private AdminDao adminDao;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/modifyAdmin")
    @ResponseBody
    public String modifyAdmin(Admin admin, HttpSession session){
        Admin adminSession = (Admin) session.getAttribute("admin");
        Optional<Admin> optional = adminDao.findById(adminSession.getId());
        if (optional.isPresent()) {
            Admin adminFromDB = optional.get();
            if (StringUtils.hasText(admin.getPassword())) {
                adminFromDB.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
            }
            adminFromDB.setUsername(admin.getUsername());
            adminFromDB.setEmail(admin.getEmail());
            adminFromDB.setPhone(admin.getPhone());
            adminDao.save(adminFromDB);
            session.removeAttribute("admin");
            session.setAttribute("admin", adminFromDB);
            return "修改成功";
        }
        return "修改失败";
    }

    @GetMapping("/addAdmin")
    public String getAddAdminView(){
        return "addAdmin";
    }

    @GetMapping("/deleteAdmin")
    public String getDeleteView(){
        return "deleteAdmin";
    }

    @GetMapping("/myAccount")
    public String getAccountView(){
        return "modifyAdmin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        return "login";
    }

    @PreAuthorize("hasAnyAuthority('S_ADMIN')")
    @PostMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(Admin admin, HttpSession session){
        Admin admin1 = (Admin) session.getAttribute("admin");
        if (!admin1.getRole().equals(AdminRole.S_ADMIN.toString())){
            return "你不是超级管理员";
        }
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        admin.setRole(AdminRole.G_ADMIN);
        adminDao.save(admin);
        return "添加成功";
    }

    @PostMapping("/queryAllAdmin")
    @ResponseBody
    public Page<Admin> queryAllAdmin(Integer currentPage){
        if (currentPage == null || currentPage < 0){
            currentPage = 0;
        }
        Pageable pageable = PageRequest.of(currentPage, 3);
        return adminDao.findAll(pageable);
    }

    @PreAuthorize("hasAnyAuthority('S_ADMIN')")
    @PostMapping("/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(Integer id, HttpSession session){
        Admin admin1 = (Admin) session.getAttribute("admin");
        if (!admin1.getRole().equals(AdminRole.S_ADMIN.toString())){
            return "你不是超级管理员";
        }
        try{
            if (id != null){
                Admin admin = (Admin) session.getAttribute("admin");
                if (admin.getId().equals(id))
                    return "你不能删除自己";
                adminDao.deleteById(id);
                return "success";
            }
            return "id不能为空";
        }catch (Exception e){
            e.printStackTrace();
            return "删除失败";
        }
    }

}
