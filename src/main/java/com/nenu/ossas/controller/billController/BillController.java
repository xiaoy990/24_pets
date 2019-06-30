package com.nenu.ossas.controller.billController;

import com.nenu.ossas.entity.bill.Bill;
import com.nenu.ossas.service.billService.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class BillController {

    @Resource
    BillService billService;

    @RequestMapping("toDonation")
    public String toDonation(Model model){
        model.addAttribute("donation",billService.queryBill(new Bill()));
        return "PAGES/donation";
    }

    @RequestMapping("/queryBill")
    @ResponseBody
    public List<Bill> queryBill(Bill bill){
        return billService.queryBill(bill);
    }

    @RequestMapping("/updateBill")
    @ResponseBody
    public String updateBill(Bill bill){
        billService.updateBill(bill);
        return null;
    }

    @RequestMapping("/delBill")
    @ResponseBody
    public String delBill(Bill bill){
        billService.delBill(bill);
        return null;
    }

    @RequestMapping("/addBill")
    @ResponseBody
    public String addBill(Bill bill){
        billService.addBill(bill);
        return null;
    }
}
