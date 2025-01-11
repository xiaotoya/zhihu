package com.xiaotoya.zhihu.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "zh_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    // ID
    @Id
    @GeneratedValue(generator = "JDBC")
    @JsonProperty
    private Integer id;

    // 组别ID
    private Integer groupId;

    // 用户名
    @JsonProperty
    private String username;

    // 昵称
    private String nickname;

    // 真名
    private String realname;

    // 密码
    @JsonProperty
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
}
