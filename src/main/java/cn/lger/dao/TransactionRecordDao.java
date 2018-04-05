package cn.lger.dao;

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
public interface TransactionRecordDao extends JpaRepository<TransactionRecord, String>{

    Page<TransactionRecord> findAll(Pageable pageable);

    Page<TransactionRecord> findAllByMemberId(Pageable pageable, String memberId);

}
