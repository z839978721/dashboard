package com.cloud.model.user;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 会员编号
     */
    private String id;

    /**
     * 会员名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 会员身份
     */
    private String membership;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 国家
     */
    private String nationality;

    /**
     * 省份
     */
    private String province;

    /**
     * 地区
     */
    private String city;

    /**
     * 地址
     */
    private String address;

    /**
     * 传真
     */
    private String fax;

    /**
     * 状态
     */
    private String status;

    /**
     * 最后登陆时间
     */
    private Date lastLoginAt;

    /**
     * 最后修改密码时间
     */
    private Date lastPasswordAt;

    /**
     * 最后选择租户
     */
    private String lastTenant;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改者
     */
    private String updator;

    /**
     * 删除状态
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 删除时间
     */
    private Date deletedAt;

    private static final long serialVersionUID = 1L;
}