package cn.lger.dao;

import cn.lger.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
@Repository
public interface CommodityDao extends JpaRepository<Commodity, String>{

    Commodity findCommodityById(String id);

}
