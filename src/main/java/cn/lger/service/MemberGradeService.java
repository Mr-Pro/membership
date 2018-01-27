package cn.lger.service;

import cn.lger.dao.MemberGradeDao;
import cn.lger.domain.MemberGrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-14.
 */
@Service
public class MemberGradeService {

    @Resource
    private MemberGradeDao memberGradeDao;

    public List<MemberGrade> findAll(){
        return memberGradeDao.findAll();
    }

    public List<MemberGrade> findMemberGradeByGradeName(String name){
        return memberGradeDao.findMemberGradeByGradeName(name);
    }

    public Page<MemberGrade> findAll(Integer currentPage){
        Pageable pageable = new PageRequest(currentPage, 5);
        return memberGradeDao.findAll(pageable);
    }

    @Transactional
    public void updateMemberGrade(MemberGrade memberGrade){
        if (memberGradeDao.findMemberGradeById(memberGrade.getId())!=null){
            memberGradeDao.save(memberGrade);
            return;
        }
        throw new RuntimeException("MemberGrade中不存在当前的id:"+memberGrade.getId());
    }

    public MemberGrade add(MemberGrade memberGrade){
        return memberGradeDao.save(memberGrade);
    }
}
