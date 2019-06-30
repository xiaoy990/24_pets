package com.nenu.ossas.entity.animal;

import javax.persistence.*;

@Entity
@Table(name = "t_animal")
public class Animal {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //动物名字
    @Column(length = 100)
    private String name;

    //动物性别
    @Column(length = 100)
    private String sex;

    //动物年龄
    @Column
    private int age;

    //动物品种
    @Column(length = 100)
    private String breed;

    //动物毛色
    @Column(length = 100)
    private String color;

    //动物照片
    @Column(length = 100)
    private String img;

    //动物是否接种疫苗
    @Column
    private int vaccine_yon;

    //动物是否绝育
    @Column
    private int sterilization_yon;

    //动物性格
    @Column(length = 100)
    private String animal_character;

    //动物现居地
    @Column(length = 100)
    private String location;

    //动物爱好
    @Column(length = 100)
    private String hobby;

    //动物体重
    @Column
    private double weight;

    //丢失动物详情
    @Column(length = 100)
    private String details;

    //动物丢失地点
    @Column(length = 100)
    private String lostPlace;

    //联系人电话
    @Column
    private long telephone;

    @Column(length = 30)
    private String owner;

    @Column
    private String introduction;

    @Column
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getVaccine_yon() {
        return vaccine_yon;
    }

    public void setVaccine_yon(int vaccine_yon) {
        this.vaccine_yon = vaccine_yon;
    }

    public int getSterilization_yon() {
        return sterilization_yon;
    }

    public void setSterilization_yon(int sterilization_yon) {
        this.sterilization_yon = sterilization_yon;
    }

    public String getAnimal_character() {
        return animal_character;
    }

    public void setAnimal_character(String animal_character) {
        this.animal_character = animal_character;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", img='" + img + '\'' +
                ", vaccine_yon=" + vaccine_yon +
                ", sterilization_yon=" + sterilization_yon +
                ", animal_character='" + animal_character + '\'' +
                ", location='" + location + '\'' +
                ", hobby='" + hobby + '\'' +
                ", weight=" + weight +
                ", details='" + details + '\'' +
                ", lostPlace='" + lostPlace + '\'' +
                ", telephone=" + telephone +
                ", owner='" + owner + '\'' +
                ", introduction='" + introduction + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
