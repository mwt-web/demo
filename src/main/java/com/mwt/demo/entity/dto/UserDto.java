package com.mwt.demo.entity.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * 用户的实体类,实现了序列化接口
 */
@Data
public class UserDto implements Serializable {
    /**
     * id
     */
    private String id;
    /**
     * 所在部门
     */
    private String username;
    /**
     * 所在部门
     */
    private String password;
    /**
     * 所在部门
     */
    private Long tel;
    /**
     * 所在部门
     */
    private String email;
    /**
     * 所在部门
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
