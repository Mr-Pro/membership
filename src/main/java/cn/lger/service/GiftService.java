package cn.lger.service;

import cn.lger.dao.ExchangeRecordDao;
import cn.lger.dao.GiftDao;
import cn.lger.dao.MemberDao;
import cn.lger.domain.ExchangeRecord;
import cn.lger.domain.Gift;
import cn.lger.domain.Member;
import cn.lger.exception.GiftNumberNotEnoughException;
import cn.lger.exception.IdNotFoundException;
import cn.lger.exception.IntegralNotEnoughException;
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
 * Created by Pro on 2017-12-18.
 */

@Service
public class GiftService {

    @Resource
    private GiftDao giftDao;
    @Resource
    private MemberDao memberDao;
    @Resource
    private ExchangeRecordDao exchangeRecordDao;

    public Gift add(Gift gift) {
        return giftDao.save(gift);
    }

    public Page<Gift> findGifts(Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        Pageable pageable = new PageRequest(currentPage, 3);
        return giftDao.findAll(pageable);
    }

    public void modifyGiftNumber(Integer giftNumber, Integer giftId) {
        giftDao.updateGiftNumberById(giftId, giftNumber);
    }

    public void deleteGift(Integer giftId) {
        giftDao.deleteById(giftId);
    }

    @Transactional
    public void integralExchange(String memberId, Integer giftId) {
        Member member = memberDao.findMemberById(memberId);
        Gift gift = giftDao.findById(giftId).isPresent()?giftDao.findById(giftId).get():null;

        //确保存在两个id的实体
        if (member != null && gift != null) {
            Long resultIntegral = member.getMemberIntegral() - gift.getGiftIntegral();
            if (resultIntegral < 0) {
                throw new IntegralNotEnoughException();
            }
            int giftNum = gift.getGiftNumber() - 1;
            if (giftNum < 0) {
                throw new GiftNumberNotEnoughException();
            } else {
                gift.setGiftNumber(giftNum);
                member.setMemberIntegral(resultIntegral);
                memberDao.save(member);
                giftDao.save(gift);
                ExchangeRecord exchangeRecord = new ExchangeRecord();
                exchangeRecord.setGift(gift);
                exchangeRecord.setMember(member);
                exchangeRecordDao.save(exchangeRecord);
                return;
            }
        }
        throw new IdNotFoundException();
    }

    public List<Gift> findAll() {
        return giftDao.findAll();
    }
}
