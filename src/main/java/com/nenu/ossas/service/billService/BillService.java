package com.nenu.ossas.service.billService;

import com.nenu.ossas.entity.bill.Bill;

import java.util.List;

public interface BillService {

        void addBill(Bill bill);

        List<Bill> queryBill(Bill bill);

        void delBill(Bill bill);

        void updateBill(Bill bill);

    }