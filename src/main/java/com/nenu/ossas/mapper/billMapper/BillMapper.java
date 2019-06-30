package com.nenu.ossas.mapper.billMapper;

import com.nenu.ossas.entity.bill.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillMapper {

    void addBill(@Param("bill") Bill bill);

    List<Bill> queryBill(@Param("bill") Bill bill);

    void delBill(@Param("bill") Bill bill);

    void updateBill(@Param("bill") Bill bill);

}
