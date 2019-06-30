package com.nenu.ossas.controller.animal;

import com.nenu.ossas.entity.animal.Animal;
import com.nenu.ossas.service.animal.OwnerService;
import com.nenu.ossas.util.ui.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    /**
     * 寻主页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/listAll_own",method = RequestMethod.GET)
    public List<Animal> listAll(Model model){
        List<Animal> list = null;
        try {
            list = ownerService.listAll();
            model.addAttribute("animalList",list);
            //return "xunchong";
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("manageOn")
    public String manageOn(Model model){
        List<Button> list = new ArrayList<>();
        Button button = new Button();
        button.setHref("/delPetClinic?id=");
        button.setValue("删除");
        list.add(button);

        model.addAttribute("buttons",list);
        model.addAttribute("list",ownerService.listAll());
        return "PAGES/manage";
    }


    /**
     * 跳转增加页面
     * @return
     */
    @RequestMapping(value = "/toAdd_own",method = RequestMethod.GET)
    public String toAdd(){
        return "addAnimal";
    }


    /**
     * 增加动物信息页面
     * @param animal
     * @return
     */
    @RequestMapping(value = "/addAnimal_own",method = RequestMethod.POST)
    public String addAnimal(Animal animal){
        try {
            ownerService.addAnimal(animal);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fail";
    }

    /**
     * 删除动物信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delAnimal_own",method = RequestMethod.POST)
    public String delAnimal(int id){
        try {
            ownerService.delAnimal(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fail";
    }


    /**
     * 跳转更新页面
     * @return
     */
    @RequestMapping(value = "/toUpdate_own",method =RequestMethod.GET)
    public String toUpdate(){
        return "updateAnimal";
    }


    /**
     * 更新动物信息
     * @param animal
     * @return
     */
    @RequestMapping(value = "/updateAnimal_own",method = RequestMethod.POST)
    public String updateAnimal(Animal animal){
        try {
            ownerService.updateAnimal(animal);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fail";
    }

    /**
     * 根据关键字查询动物信息
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectByKeyword_own",method = RequestMethod.GET)
    public List<Animal> selectByKeyword(String keyword, Model model){
        List<Animal> resultList = null;
        try {
            resultList = ownerService.selectByKeyword(keyword);
            model.addAttribute("resultList",resultList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }
}
