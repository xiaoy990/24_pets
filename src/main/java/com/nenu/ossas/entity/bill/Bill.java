package com.nenu.ossas.entity.bill;

import javax.persistence.*;

@Entity
@Table(name = "t_bill")
public class Bill {

    //账单id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //账单金额
    @Column(length = 16)
    private int amount;

    //捐助者姓名
    @Column(length = 50)
    private String donorName;

    //捐助者联系方式（tel）
    @Column(length = 30)
    private String donorTel;

    //捐助者联系方式（email)
    @Column(length = 30)
    private String donorEmail;

    //捐助者留言
    @Column(length = 255)
    private String message;

    //总数
    private int total = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorTel() {
        return donorTel;
    }

    public void setDonorTel(String donorTel) {
        this.donorTel = donorTel;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", donorName='" + donorName + '\'' +
                ", donorTel='" + donorTel + '\'' +
                ", donorEmail='" + donorEmail + '\'' +
                ", message='" + message + '\'' +
                ", total=" + total +
                '}';
    }
}
