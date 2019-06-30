package com.nenu.ossas.service.animal;

import com.nenu.ossas.entity.animal.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {

    /**
     * 遍历寻主动物信息
     * @return
     */
    public List<Animal> listAll();


    /**
     * 增加动物信息
     * @param animal
     * @return
     */
    public Animal addAnimal(Animal animal);


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
    public Animal updateAnimal(Animal animal);


    /**
     * 根据关键字查询动物信息
     * @param keyword
     * @return
     */
    public List<Animal> selectByKeyword(String keyword);
}
