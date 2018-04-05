package cn.lger.dao;

import cn.lger.domain.ExchangeRecord;
import cn.lger.domain.TransactionRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
@Repository
public interface ExchangeRecordDao extends JpaRepository<ExchangeRecord, String>{

    Page<ExchangeRecord> findAll(Pageable pageable);

    Page<ExchangeRecord> findAllByMemberId(Pageable pageable, String memberId);

}
