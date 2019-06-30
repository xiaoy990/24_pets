package com.nenu.ossas.controller.animalShelterController;

import com.nenu.ossas.entity.animal.Animal;
import com.nenu.ossas.entity.animalShelterEntity.AnimalShelter;
import com.nenu.ossas.service.animalShelterService.AnimalShelterService;
import com.nenu.ossas.util.ui.Button;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AnimalShelterController {

    @Resource
    AnimalShelterService animalShelterService;

    @RequestMapping("shelterCommon")
    public String goToCommon(){
        return "PAGES/res_station";
    }

    @RequestMapping("shelter")
    public String goToShelterClinic(Model model){
        model.addAttribute("type","救助站");
        model.addAttribute("list",animalShelterService.queryAnimalShelter(new AnimalShelter()));
        return "PAGES/jzxiangqing";
    }

    @RequestMapping("shelterApply")
    public String shelterApply(Model model){
        List<Button> list = new ArrayList<>();
        Button button = new Button();
        button.setHref("/passAS?status=0&id=");
        button.setValue("通过");

        Button button1 = new Button();
        button1.setHref("/passAS?status=1&id=");
        button1.setValue("不通过");

        list.add(button);
        list.add(button1);

        model.addAttribute("buttons",list);
        model.addAttribute("list",animalShelterService.queryAnimalShelterApply(new AnimalShelter()));
        return "PAGES/manage";
    }

    @RequestMapping("/queryAnimalShelterByCode")
    @ResponseBody
    public AnimalShelter queryAnimalShelterByCode(Integer shelterCode){
        return animalShelterService.queryShelterByCode(shelterCode);
    }

    @RequestMapping("/queryAnimalShelter")
    @ResponseBody
    public List<AnimalShelter> queryAnimalShelter(AnimalShelter animalShelter){
        return animalShelterService.queryAnimalShelter(animalShelter);
    }

    @RequestMapping("manageAS")
    public String queryMAS(Model model){

        List<Button> list = new ArrayList<>();
        Button button = new Button();
        button.setHref("/delAnimalShelter?id=");
        button.setValue("删除");
        list.add(button);
        List<AnimalShelter> list1 = animalShelterService.queryAnimalShelter(new AnimalShelter());
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

    @RequestMapping("/addAnimalShelter")
    @ResponseBody
    public String addAnimalShelter(AnimalShelter animalShelter){
        animalShelterService.addAnimalShelter(animalShelter);
        return null;
    }

    @RequestMapping("/updateAnimalShelter")
    @ResponseBody
    public String updateAnimalShelter(AnimalShelter animalShelter){
        animalShelterService.updateAnimalShelter(animalShelter);
        return null;
    }

    @RequestMapping("/delAnimalShelter")
    public String delAnimalShelter(AnimalShelter animalShelter){
        animalShelterService.delAnimalShelter(animalShelter);
        return "redirect:/manageAS";
    }

    @RequestMapping("/tofile")
    public String toFile(){
        return "filetest";
    }

    @RequestMapping("/updateIcon")
    @ResponseBody
    public String updateIcon(MultipartFile file,AnimalShelter animalShelter){

        if (file.isEmpty()){
            return "error";
        }
        System.out.println(animalShelter);
        animalShelterService.uploadIcon(file,animalShelter);
        return "success";
    }

    @RequestMapping("passAS")
    public String pass(AnimalShelter animalShelter){
        animalShelterService.pass(animalShelter);
        return "redirect:shelterApply";
    }
}