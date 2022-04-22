package com.mwt.demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.mwt.demo.config.BaseEntity;
import lombok.Data;

/**
 * 用户的实体类,实现了序列化接口
 * @author muwentao
 */
@Data
public class SysUser extends BaseEntity {
    /**
     * id
     */
    @TableId
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
