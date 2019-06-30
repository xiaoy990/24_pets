package com.nenu.ossas.entity.volunteer;

import javax.persistence.*;

@Entity
@Table(name = "t_volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //key_value
    private int id;

    //
    @Column(length = 10)
    private String volunteering;

    //标题
    @Column(length = 10)
    private String name;

    //日期
    @Column(length = 10)
    private String date;

    //地点
    @Column(length = 10)
    private String place;

    //详情
    @Column(length = 10)
    private String introduction;

    //图片
    @Column(length = 10)
    private String img;

    //联系方式  因前端bug 所以必须添加一个这个属性
    @Column(length = 10)
    private String telephone;

    public String getVolunteering() {
        return volunteering;
    }

    public void setVolunteering(String volunteering) {
        this.volunteering = volunteering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", volunteering='" + volunteering + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", place='" + place + '\'' +
                ", introduction='" + introduction + '\'' +
                ", img='" + img + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
