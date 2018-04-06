package cn.lger.security;

import cn.lger.domain.AdminRole;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2018-04-05.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法上的认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomerUserDetailsService userDetailsService;
    @Resource
    private CustomerLoginSuccessHandler successHandler;
    @Resource
    private BCryptPasswordEncoder encoder;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**"); //不过滤静态资源
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService) //注册自己定制的UserDetailsService
                .passwordEncoder(encoder); // 配置密码加密器
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests() //获取请求方面的验证器
                    .antMatchers("/", "/error").permitAll()// 访问当前配置的路径可通过认证
                    //访问其他路径需要认证和角色权限
                    .anyRequest().hasAnyAuthority(AdminRole.G_ADMIN.toString(), AdminRole.S_ADMIN.toString())
//                    .anyRequest().authenticated()
                    .and()
                .formLogin() //获取登录认证验证器
                    .loginPage("/login") //注册自定义的登录页面URL
                    .failureForwardUrl("/login") //登录失败后以登录时的请求转发到该链接
                    .successHandler(successHandler) //登录成功后调用该处理器
                    .permitAll() //登录请求给予通过认证
                    .and()
                .logout() //推出登录
                    .logoutSuccessUrl("/login") //退出后访问URL
                    .and()
                .csrf().disable(); //关闭csrf，默认开启

    }
}
