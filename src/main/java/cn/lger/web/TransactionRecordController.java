package cn.lger.web;

import cn.lger.domain.TransactionRecord;
import cn.lger.service.TransactionRecordService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
@Controller
public class TransactionRecordController {

    @Resource
    private TransactionRecordService transactionRecordService;

    @GetMapping("/transactionRecord")
    public String getTransactionRecord(){
        return "transactionRecord";
    }

    @PostMapping("/transactionRecord")
    @ResponseBody
    public Page<TransactionRecord> transactionRecord(Integer currentPage, String memberId){
        if (currentPage == null || currentPage <0)
            currentPage = 0;
        if (memberId == null || "".equals(memberId)){
            return transactionRecordService.findTransactionRecord(currentPage);
        }
        return transactionRecordService.findTransactionRecordByMemberId(currentPage, memberId);
    }
}
