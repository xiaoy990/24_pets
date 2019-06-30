package com.nenu.ossas.service.billService.impl;

import com.nenu.ossas.entity.bill.Bill;
import com.nenu.ossas.mapper.billMapper.BillMapper;
import com.nenu.ossas.service.billService.BillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("billService")
public class BillServiceImpl implements BillService {

    @Resource
    BillMapper billMapper;

    @Override
    public void addBill(Bill bill) {
        billMapper.addBill(bill);
    }

    @Override
    public List<Bill> queryBill(Bill bill) {

        List<Bill> list = billMapper.queryBill(bill);

        int total = 0;
        for (Bill b : list
             ) {
            total += b.getAmount();
        }
        for (Bill b : list
        ) {
            b.setTotal(total);
        }

        return list;
    }

    @Override
    public void delBill(Bill bill) {
        billMapper.delBill(bill);
    }

    @Override
    public void updateBill(Bill bill) {
        billMapper.updateBill(bill);
    }
}
