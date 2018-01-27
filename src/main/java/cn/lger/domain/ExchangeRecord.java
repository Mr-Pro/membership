package cn.lger.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
@Entity
public class ExchangeRecord {

    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id",strategy="uuid")
    private String id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Gift gift;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "ExchangeRecord{" +
                "id='" + id + '\'' +
                ", member=" + member +
                ", gift=" + gift +
                '}';
    }
}
