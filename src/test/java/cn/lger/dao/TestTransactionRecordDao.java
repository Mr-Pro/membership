package cn.lger.dao;

import cn.lger.domain.Commodity;
import cn.lger.domain.TransactionRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-13.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTransactionRecordDao {

    @Resource
    private TransactionRecordDao transactionRecordDao;
    @Resource
    private MemberDao memberDao;
    @Resource
    private CommodityDao commodityDao;

    /**
     * 测试保存
     */
    @Test
    public void test01(){
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setCommodity(commodityDao.findCommodityById("2c9ba08b60634aab016063caa6650000"));
        transactionRecord.setMember(memberDao.findMemberById("20171215143945448"));
        transactionRecordDao.save(transactionRecord);
    }

    /**
     * 测试保存
     */
    @Test
    public void test02(){
        TransactionRecord transactionRecord =
                transactionRecordDao.findById("2c9ba08b6064ba9d016064bab7110000").get();
        System.out.println(transactionRecord);
    }

    @Test
    public void test03(){
        Pageable pageable = new PageRequest(0, 3);
        Page<TransactionRecord> page = transactionRecordDao.findAll(pageable);
        System.out.println(page);
    }

    @Test
    public void test04(){
        Pageable pageable = new PageRequest(0, 3);
        Page<TransactionRecord> page = transactionRecordDao.findAllByMemberId(pageable, "20171215143945448");
        System.out.println(page);
    }

    @Test
    @Transactional
//    @Rollback(false)
    public void test05(){
        Commodity commodity = new Commodity();
        commodity.setId("2c9bweew6dsb7110000");
//        commodity.setCommodityName("132ffdsadf东风公司东风公司第三方公司的 上的");
        commodity.setCommodityPrice(123F);
        commodity.setCommodityIntegral(111L);

//        commodityDao.save(commodity);
        commodity.setCommodityName("safd");
//        commodityDao.flush();
        commodityDao.save(commodity);

//        commodityDao.flush();
//        int a = 1 / 0;
    }

}
