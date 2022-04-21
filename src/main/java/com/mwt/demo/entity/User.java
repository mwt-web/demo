package com.mwt.demo.entity;


import com.mwt.demo.config.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户的实体类,实现了序列化接口
 */
@Data
public class User extends BaseEntity {
    /**
     * id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private Long tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 公司
     */
    private String company;
    /**
     * 所在部门
     */
    private String department;
    /**
     * 主营方向
     */
    private String  mainBusiness;
    /**
     * 用户身份
     */
    private String role;
}
