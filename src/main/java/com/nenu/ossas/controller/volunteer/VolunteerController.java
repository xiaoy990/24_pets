package com.nenu.ossas.controller.volunteer;

import com.nenu.ossas.entity.volunteer.Volunteer;
import com.nenu.ossas.service.volunteer.VolunteerService;
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
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    /**
     * 志愿活动页面
     * @return
     */
    @RequestMapping(value = "/listAllVolunteer",method = RequestMethod.GET)
    public List<Volunteer> listAllVolunteer(){
        List<Volunteer> list = null;
        try {
            list = volunteerService.listAllVolunteer();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("manageVt")
    public String manageVt(Model model){
        List<Button> list = new ArrayList<>();
        Button button = new Button();
        button.setHref("/delPetClinic?id=");
        button.setValue("删除");
        list.add(button);

        model.addAttribute("buttons",list);
        model.addAttribute("list",volunteerService.listAllVolunteer());
        return "PAGES/manage";
    }

    /**
     * 跳转增加页面
     * @return
     */
    @RequestMapping(value = "/toAdd_vt",method = RequestMethod.GET)
    public String toAdd(){
        return "/addVolunteer";
    }

    /**
     * 增加志愿活动页面
     * @param volunteer
     * @return
     */
    @RequestMapping(value = "/addVolunteer",method = RequestMethod.POST)
    public Volunteer addVolunteer(Volunteer volunteer){
        try {
            volunteer = volunteerService.addVolunteer(volunteer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return volunteer;
    }

    /**
     * 删除志愿活动
     * @param volunteering
     * @return
     */
    @RequestMapping(value = "/delVolunteer",method = RequestMethod.GET)
    public boolean delVolunteer(String volunteering){
        boolean flag = false;
        try {
            flag = volunteerService.delVolunteer(volunteering);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 跳转编辑志愿活动
     * @return
     */
    @RequestMapping(value = "/toUpdate_vt",method = RequestMethod.GET)
    public String toUpdate(){
        return "/updateVolunteer";
    }

    /**
     * 编辑志愿活动页面
     * @param volunteer
     * @return
     */
    @RequestMapping(value = "/updateVolunteer",method = RequestMethod.POST)
    public Volunteer updateVolunteer(Volunteer volunteer){
        try {
            volunteer = volunteerService.updateVolunteer(volunteer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return volunteer;
    }

    /**
     * 根据关键字查找志愿活动
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/selectVolunteerByKeyword",method = RequestMethod.POST)
    public List<Volunteer> selectVolunteerByKeyword(String keyword){
        List<Volunteer> resultList = null;
        try {
            resultList = volunteerService.selectVolunteerByKeyword(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }
}
