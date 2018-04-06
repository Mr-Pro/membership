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
@Component //注册为Spring组件
public class CustomerUserDetailsService implements UserDetailsService{

    @Resource
    private AdminDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过dao查找当前用户名对应的用户
        Admin admin = adminDao.findAdminByUsername(username);
        if (admin == null){
            throw new UsernameNotFoundException("This username: "+username+"is not exist");
        }
        //返回一个定制的UserDetails
        //AuthorityUtils.createAuthorityList(admin.getRole())就是将我们该用户所有的权限（角色）生成一个集合
        return new CustomerUserDetails(admin, AuthorityUtils.createAuthorityList(admin.getRole()));
    }
}
