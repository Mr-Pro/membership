package cn.lger.service;

import cn.lger.dao.ExchangeRecordDao;
import cn.lger.dao.TransactionRecordDao;
import cn.lger.domain.ExchangeRecord;
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
public class ExchangeRecordService {

    @Resource
    private ExchangeRecordDao exchangeRecordDao;

    public Page<ExchangeRecord> findTransactionRecord(Integer currentPage){
        Pageable pageable = PageRequest.of(currentPage, 3);
        return exchangeRecordDao.findAll(pageable);
    }

    public Page<ExchangeRecord> findTransactionRecordByMemberId(Integer currentPage, String memberId) {
        Pageable pageable = PageRequest.of(currentPage, 3);
        return exchangeRecordDao.findAllByMemberId(pageable, memberId);
    }
}
