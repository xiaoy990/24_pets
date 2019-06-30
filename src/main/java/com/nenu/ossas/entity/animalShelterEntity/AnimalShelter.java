package com.nenu.ossas.entity.animalShelterEntity;

import javax.persistence.*;

/**
 * 救助站Entity
 * jpa自动建表
 * */
@Entity
@Table(name = "t_animalshelter")
public class AnimalShelter {
    /**
     * 主键
     * 自动递增
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * 救助站编号
     * */
    @Column(name = "shelterCode",length = 10)
    private int shelterCode;

    /**
     * 救助站名称
     * */
    @Column(name = "name",length = 50)
    private String name;

    /**
     * 救助站地址
     * */
    @Column(name = "shelterAddress",length = 60)
    private String shelterAddress;

    /**
     * 救助站电话
     * */
    @Column(name = "telephone",length = 30)
    private String telephone;

    /**
     * 救助站介绍
     * 存储方式：路径
     * 实际文件：
     * */
    @Column(name = "introduction",length = 50)
    private String introduction;

    /**
     * 救助站相关图片
     * 存储方式：路径
     * 实际文件：
     * */
    @Column(name = "img",length = 50)
    private String img;

    /**
     * 救助站状态
     * */
    @Column(length = 30)
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShelterCode() {
        return shelterCode;
    }

    public void setShelterCode(int shelterCode) {
        this.shelterCode = shelterCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShelterAddress() {
        return shelterAddress;
    }

    public void setShelterAddress(String shelterAddress) {
        this.shelterAddress = shelterAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AnimalShelter{" +
                "id=" + id +
                ", shelterCode=" + shelterCode +
                ", name='" + name + '\'' +
                ", shelterAddress='" + shelterAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", introduction='" + introduction + '\'' +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
