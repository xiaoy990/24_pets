package com.nenu.ossas.service.volunteer.impl;

import com.nenu.ossas.entity.volunteer.Volunteer;
import com.nenu.ossas.mapper.volunteer.VolunteerMapper;
import com.nenu.ossas.service.volunteer.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service("VolunteerService")
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    VolunteerMapper volunteerMapper;

    /**
     * 遍历所有志愿活动
     * @return
     */
    @Override
    @Transactional
    public List<Volunteer> listAllVolunteer(){
        List<Volunteer> list = Collections.emptyList();
        try {
            list = volunteerMapper.listAllVolunteer();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 增加志愿活动信息
     * @param volunteer
     * @return
     */
    @Override
    @Transactional
    public Volunteer addVolunteer(Volunteer volunteer){
        try {
            volunteer = volunteerMapper.addVolunteer(volunteer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return volunteer;
    }

    /**
     * 删除志愿活动信息
     * @param volunteering
     * @return
     */
    @Override
    @Transactional
    public boolean delVolunteer(String volunteering){
        boolean flag = false;
        try{
            flag = volunteerMapper.delVolunteer(volunteering);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 编辑志愿活动信息
     * @param volunteer
     * @return
     */
    @Override
    @Transactional
    public Volunteer updateVolunteer(Volunteer volunteer){
        try {
            volunteer = volunteerMapper.updateVolunteer(volunteer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return volunteer;
    }

    /**
     * 根据关键字查询志愿活动信息
     * @param keyword
     * @return
     */
    @Override
    @Transactional
    public List<Volunteer> selectVolunteerByKeyword(String keyword){
        List<Volunteer> resultList = Collections.emptyList();
        try {
            resultList = volunteerMapper.selectVolunteerByKeyword(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }
}
