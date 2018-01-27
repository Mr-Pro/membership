package cn.lger.dao;

import cn.lger.domain.MemberGrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-06.
 */
public interface MemberGradeDao extends JpaRepository<MemberGrade, String> {

    MemberGrade findMemberGradeById(Integer id);

    List<MemberGrade> findMemberGradeByGradeName(String gradeName);

    Page<MemberGrade> findAll(Pageable pageable);

}
