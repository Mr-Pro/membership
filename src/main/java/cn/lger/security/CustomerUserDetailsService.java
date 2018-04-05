package cn.lger.security;

import cn.lger.dao.AdminDao;
import cn.lger.domain.Admin;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2018-04-05.
 */
@Component
public class CustomerUserDetailsService implements UserDetailsService{

    @Resource
    private AdminDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminDao.findAdminByUsername(username);
        if (admin == null){
            throw new UsernameNotFoundException("This username: "+username+"is not exist");
        }
        return new CustomerUserDetails(admin, AuthorityUtils.createAuthorityList(admin.getRole()));
    }

}
