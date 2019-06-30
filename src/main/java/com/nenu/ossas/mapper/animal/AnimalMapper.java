package com.nenu.ossas.mapper.animal;

import com.nenu.ossas.entity.animal.Animal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnimalMapper {

    /**
     * 遍历寻宠动物信息
     * @return
     */
    public List<Animal> listAll();


    /**
     * 增加动物信息
     * @Param animal
     * @return
     */
    public void addAnimal(@Param("animal") Animal animal);

    /**
     * 删除动物信息
     * @param id
     * @return
     */
    public boolean delAnimal(int id);


    /**
     * 更新动物信息
     * @param animal
     * @return
     */
    public void updateAnimal(@Param("animal")Animal animal);

    /**
     * 根据关键字查询动物信息
     * @return
     */
    public List<Animal> selectByKeyword(String keyword);
    Animal selectById(@Param("id")int id);
}
