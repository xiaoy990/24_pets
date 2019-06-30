package com.nenu.ossas.entity.petClinicEntity;

import javax.persistence.*;

@Entity
@Table(name = "t_petclinic")
public class PetClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 10)
    private String petClinicCode;

    @Column(length = 50)
    private String name;

    @Column(length = 60)
    private String petClinicAddress;

    @Column(length = 30)
    private String telephone;

    @Column(length = 50)
    private String introduction;

    @Column(length = 50)
    private String img;

    //状态
    @Column(length = 30)
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetClinicCode() {
        return petClinicCode;
    }

    public void setPetClinicCode(String petClinicCode) {
        this.petClinicCode = petClinicCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetClinicAddress() {
        return petClinicAddress;
    }

    public void setPetClinicAddress(String petClinicAddress) {
        this.petClinicAddress = petClinicAddress;
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
        return "PetClinic{" +
                "id=" + id +
                ", petClinicCode='" + petClinicCode + '\'' +
                ", name='" + name + '\'' +
                ", petClinicAddress='" + petClinicAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", introduction='" + introduction + '\'' +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
