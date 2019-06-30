package com.nenu.ossas.controller.petClinicController;

import com.nenu.ossas.entity.petClinicEntity.PetClinic;
import com.nenu.ossas.service.petClinicService.PetClinicService;
import com.nenu.ossas.util.ui.Button;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class PetClinicController {

    @Resource
    PetClinicService petClinicService;

    @RequestMapping("petClinic")
    public String goToShelter(Model model){
        model.addAttribute("type","宠物诊所");
        List list = petClinicService.queryPetClinic(new PetClinic());
        model.addAttribute("list",list);
        return "PAGES/jzxiangqing";
    }

    @ResponseBody
    @RequestMapping("/queryPetClinicByCode")
    public PetClinic queryAnimalShelterByCode(String shelterCode){
        return petClinicService.queryPetClinicByCode(shelterCode);
    }

    @ResponseBody
    @RequestMapping("/queryPetClinic")
    public List<PetClinic> queryAnimalShelter(PetClinic petClinic){
        return petClinicService.queryPetClinic(petClinic);
    }

    @RequestMapping("managePC")
    public String managePC(Model model){
        List<Button> list = new ArrayList<>();
        Button button = new Button();
        button.setHref("/delPetClinic?id=");
        button.setValue("删除");
        list.add(button);

        List<PetClinic> list1 = petClinicService.queryPetClinic(new PetClinic());
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i).getStatus().equals("1")){
                list1.remove(i);
                i--;
            }
        }

        model.addAttribute("buttons",list);
        model.addAttribute("list",list1);
        return "PAGES/manage";
    }

    @RequestMapping("petClinicApply")
    public String petClinicApply(Model model){
        List<Button> list = new ArrayList<>();
        Button button = new Button();
        button.setHref("/passPT?status=0&id=");
        button.setValue("通过");

        Button button1 = new Button();
        button1.setHref("/passPT?status=1&id=");
        button1.setValue("不通过");

        list.add(button);
        list.add(button1);

        model.addAttribute("buttons",list);
        model.addAttribute("list",petClinicService.queryPetClinicApply(new PetClinic()));
        return "PAGES/manage";
    }

    @ResponseBody
    @RequestMapping("/addPetClinic")
    public String addAnimalShelter(PetClinic petClinic){
        petClinicService.addPetClinic(petClinic);
        return null;
    }

    @ResponseBody
    @RequestMapping("/updatePetClinic")
    public String updateAnimalShelter(PetClinic petClinic){
        petClinicService.updatePetClinic(petClinic);
        return null;
    }

    @RequestMapping("/delPetClinic")
    public String delAnimalShelter(PetClinic petClinic){
        petClinicService.delPetClinic(petClinic);
        return null;
    }

    @RequestMapping("passPT")
    public String pass(PetClinic petClinic){
        petClinicService.pass(petClinic);
        return "redirect:petClinicApply";
    }
}
