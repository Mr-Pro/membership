package cn.lger.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-06.
 */
@Entity
public class Member {

    @Id
    private String id;
    private String iconPath;
    private String memberName;
    private String password;
    private String phone;
    private LocalDate birthday;
    private String sex;
    //会员等级
    @ManyToOne
    private MemberGrade memberGrade;
    //会员积分
    private Long memberIntegral;
    //会员余额
    private Float balance;
    //会员状态 挂失、停用、正常
    private String state;
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday.toString();
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }

    public Long getMemberIntegral() {
        return memberIntegral;
    }

    public void setMemberIntegral(Long memberIntegral) {
        this.memberIntegral = memberIntegral;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getLocalDate(){
        return this.birthday;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", memberName='" + memberName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", memberGrade=" + memberGrade +
                ", memberIntegral=" + memberIntegral +
                ", balance=" + balance +
                ", state='" + state + '\'' +
                '}';
    }
}
