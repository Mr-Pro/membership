package cn.lger.security;

import cn.lger.domain.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2018-04-05.
 */
public class CustomerUserDetails implements UserDetails {

    private Admin admin = null;
    //存放权限的集合
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

    public CustomerUserDetails(Admin admin, Collection<? extends GrantedAuthority> authorities) {
        this(admin, true, true, true,true,authorities);
    }

    public CustomerUserDetails(Admin admin, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        if(admin.getUsername() != null && !"".equals(admin.getUsername()) && admin.getPassword() != null) {
            this.admin = admin;
            this.enabled = enabled;
            this.accountNonExpired = accountNonExpired;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = authorities;
        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(@NotNull Admin admin) {
        this.admin = admin;
    }

    public boolean equals(Object rhs) {
        return rhs instanceof CustomerUserDetails && this.getUsername().equals(((CustomerUserDetails) rhs).getUsername());
    }

    public int hashCode() {
        return this.getUsername().hashCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.admin.getPassword();
    }

    @Override
    public String getUsername() {
        return this.admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
