package cn.lger.web;

import cn.lger.domain.MemberGrade;
import cn.lger.service.MemberGradeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-16.
 */
@Controller
public class MemberGradeController {

    @Resource
    private MemberGradeService memberGradeService;

    @GetMapping("/memberGrade")
    public String getMemberGradeView(){
        return "memberGrade";
    }

    @PostMapping("/memberGrade")
    @ResponseBody
    public Page<MemberGrade> memberGrade(Integer currentPage){
        return memberGradeService.findAll(currentPage);
    }

    @PostMapping("/updateMemberGrade")
    @ResponseBody
    public String updateMemberGrade(MemberGrade memberGrade){
        try{
            memberGradeService.updateMemberGrade(memberGrade);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @PostMapping("/addMemberGrade")
    @ResponseBody
    public MemberGrade addMemberGrade(MemberGrade memberGrade){
        return memberGradeService.add(memberGrade);
    }

}
