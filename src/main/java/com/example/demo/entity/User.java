package com.example.demo.entity;


import java.io.Serializable;

/**
 * 用户的实体类,实现了序列化接口
 */

public class User implements Serializable {
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private Long tel;
    //邮箱
    private String email;
    //公司名称
    private String company;
    //所在部门
    private String department;
    //主营方向
    private String  mainBusiness;
    //用户身份
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", mainBusiness='" + mainBusiness + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
