package cn.lger.service;

import cn.lger.dao.AdminDao;
import cn.lger.domain.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public Admin findAdminByUsernameAndPassword(String username, String password){
        return adminDao.findByUsernameAndPassword(username, password);
    }

}
