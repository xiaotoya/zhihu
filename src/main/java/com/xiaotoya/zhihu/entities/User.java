package com.xiaotoya.zhihu.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "zh_user")
public class User implements Serializable {
    // ID
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    // 组别ID
    private Integer groupId;

    // 用户名
    private String username;

    // 昵称
    private String nickname;

    // 真名
    private String realname;

    // 密码
    private String password;

    // 密码盐
    private String salt;

    // 电子邮箱
    private String email;

    // 手机号
    private String mobile;

    // 头像
    private String avatar;

    // 等级
    private Integer level;

    // 性别, 0 => man, 1 => woman
    private Integer gender;

    // 生日
    private Date birthday;

    // 余额
    private BigDecimal money;

    // 积分
    private Integer score;

    // 连续登录天数
    private Integer successions;

    // 最大连续登录天数
    private Integer maxsuccessions;

    // 上次登录时间
    private Long prevtime;

    // 登录IP
    private String loginip;

    // 创建时间
    private Long createtime;

    // 更新时间
    private Long updatetime;

    // 状态
    private String status;

    // 消费累计
    private BigDecimal totalConsume;

    // unionid
    private String unionid;

    // mobile_openid
    private String mobileOpenid;

    // openid
    private String openid;

    // 地址
    private String address;

    // 年龄
    private Integer age;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSuccessions() {
        return successions;
    }

    public void setSuccessions(Integer successions) {
        this.successions = successions;
    }

    public Integer getMaxsuccessions() {
        return maxsuccessions;
    }

    public void setMaxsuccessions(Integer maxsuccessions) {
        this.maxsuccessions = maxsuccessions;
    }

    public Long getPrevtime() {
        return prevtime;
    }

    public void setPrevtime(Long prevtime) {
        this.prevtime = prevtime;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(BigDecimal totalConsume) {
        this.totalConsume = totalConsume;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getMobileOpenid() {
        return mobileOpenid;
    }

    public void setMobileOpenid(String mobileOpenid) {
        this.mobileOpenid = mobileOpenid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
