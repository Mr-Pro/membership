package cn.lger.dao;

import cn.lger.domain.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
@Repository
public interface GiftDao extends JpaRepository<Gift, Integer>{

    @Modifying
    @Transactional
    @Query("update Gift gift set gift.giftNumber = ?2 where gift.id = ?1")
    void updateGiftNumberById(Integer giftId, Integer giftNumber);
}
