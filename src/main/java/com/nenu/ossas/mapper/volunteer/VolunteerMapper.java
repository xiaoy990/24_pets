package com.nenu.ossas.mapper.volunteer;

import com.nenu.ossas.entity.volunteer.Volunteer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VolunteerMapper {

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
