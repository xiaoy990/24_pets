package com.nenu.ossas.service.volunteer;

import com.nenu.ossas.entity.volunteer.Volunteer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VolunteerService {
    /**
     * 遍历所有志愿活动
     * @return
     */
    public List<Volunteer> listAllVolunteer();

    /**
     * 增加志愿活动（后台管理）
     * @param volunteer
     * @return
     */
    public Volunteer addVolunteer(Volunteer volunteer);

    /**
     * 删除志愿活动（后台管理）
     * @param volunteering
     * @return
     */
    public boolean delVolunteer(String volunteering);

    /**
     * 编辑志愿活动（后台管理）
     * @param volunteer
     * @return
     */
    public Volunteer updateVolunteer(Volunteer volunteer);

    /**
     * 根据关键字查询
     * @param keyword
     * @return
     */
    public List<Volunteer> selectVolunteerByKeyword(String keyword);
}
