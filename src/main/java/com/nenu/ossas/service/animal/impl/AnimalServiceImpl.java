package com.nenu.ossas.service.animal.impl;

import com.nenu.ossas.entity.animal.Animal;
import com.nenu.ossas.mapper.animal.AnimalMapper;
import com.nenu.ossas.service.animal.AnimalService;
import com.nenu.ossas.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service("AnimalService")
public class AnimalServiceImpl implements AnimalService {
    @Resource
    AnimalMapper animalMapper;

    @Resource
    FileUpload fileUpload;

    /**
     * 遍历寻宠动物信息
     * @return
     */
    @Override
    @Transactional
    public List<Animal> listAll(){
        List<Animal> list = Collections.emptyList();
        try {
            list = animalMapper.listAll();
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
    public void addAnimal(MultipartFile multipartFile,Animal animal) {
        try{
            String str = this.getClass().getClassLoader().getResource("static/IMG/icon").toString();
            //部署配置
//        str = str.replace("/pets-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/","/upload/icon/");
//        str = str.replace("jar:file:","");
            str = str.replace("file:","");
            File file = fileUpload.updateFile(multipartFile,str, UUID.randomUUID().toString());


            str = str.replace("/D:/appData/IdeaProjects/pets/target/classes/static/","");
            animal.setImg(str+"/"+file.getName());
            System.out.println(str+file.getName());
            animalMapper.addAnimal(animal);
        }catch (Exception e){
            e.printStackTrace();
        }
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
            return animalMapper.delAnimal(id);
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
    public void updateAnimal(Animal animal){
        try {
            animalMapper.updateAnimal(animal);
        }catch (Exception e){
            e.printStackTrace();
        }
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
            animalMapper.selectByKeyword(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    public Animal selectById(int id){
        return animalMapper.selectById(id);
    }
}
