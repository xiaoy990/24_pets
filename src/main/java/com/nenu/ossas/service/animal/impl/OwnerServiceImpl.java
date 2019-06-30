package com.nenu.ossas.service.animal.impl;

import com.nenu.ossas.entity.animal.Animal;
import com.nenu.ossas.mapper.animal.OwnerMapper;
import com.nenu.ossas.service.animal.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service("OwnerService")
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerMapper ownerMapper;

    /**
     * 遍历寻主动物信息
     * @return
     */
    @Override
    @Transactional
    public List<Animal> listAll(){
        List<Animal> list = Collections.emptyList();
        try {
            list = ownerMapper.listAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 增加动物信息
     * @param animal
     * @return
     */
    @Override
    @Transactional
    public Animal addAnimal(Animal animal) {
        try{
            animal = ownerMapper.addAnimal(animal);
        }catch (Exception e){
            e.printStackTrace();
        }
        return animal;
    }

    /**
     * 删除动物信息
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean delAnimal(int id){
        try {
            return ownerMapper.delAnimal(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 更新动物信息
     * @param animal
     * @return
     */
    @Override
    @Transactional
    public Animal updateAnimal(Animal animal){
        try {
            animal = ownerMapper.updateAnimal(animal);
        }catch (Exception e){
            e.printStackTrace();
        }
        return animal;
    }

    /**
     * 根据关键字查询动物信息
     * @param keyword
     * @return
     */
    @Override
    @Transactional
    public List<Animal> selectByKeyword(String keyword){
        List<Animal> resultList = Collections.emptyList();
        try{
            ownerMapper.selectByKeyword(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }
}
