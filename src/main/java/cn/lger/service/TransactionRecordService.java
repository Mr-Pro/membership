package cn.lger.service;

import cn.lger.dao.TransactionRecordDao;
import cn.lger.domain.TransactionRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
@Service
public class TransactionRecordService {

    @Resource
    private TransactionRecordDao transactionRecordDao;

    public Page<TransactionRecord> findTransactionRecord(Integer currentPage){
        Pageable pageable = PageRequest.of(currentPage, 3);
        return transactionRecordDao.findAll(pageable);
    }

    public Page<TransactionRecord> findTransactionRecordByMemberId(Integer currentPage, String memberId) {
        Pageable pageable = PageRequest.of(currentPage, 3);
        return transactionRecordDao.findAllByMemberId(pageable, memberId);
    }
}
