package com.nenu.ossas.service.animalShelterService.impl;

import com.nenu.ossas.entity.animalShelterEntity.AnimalShelter;
import com.nenu.ossas.mapper.animalShelterMapper.AnimalShelterMapper;
import com.nenu.ossas.service.animalShelterService.AnimalShelterService;
import com.nenu.ossas.util.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service("animalShelterService")
public class AnimalShelterServiceImpl implements AnimalShelterService {

    @Resource
    private AnimalShelterMapper animalShelterMapper;

    @Resource
    FileUpload fileUpload;

    @Override
    public AnimalShelter queryShelterByCode(int shelterCode) {
        return animalShelterMapper.queryAnimalShelterByCode(shelterCode);
    }

    @Override
    public List<AnimalShelter> queryAnimalShelter(AnimalShelter animalShelter) {
        return animalShelterMapper.queryAnimalShelter(animalShelter);
    }

    @Override
    public void addAnimalShelter(AnimalShelter animalShelter) {
        animalShelterMapper.addAnimalShelter(animalShelter);
    }

    @Override
    public void delAnimalShelter(AnimalShelter animalShelter) {
        animalShelterMapper.delAnimalShelter(animalShelter);
    }

    @Override
    public void updateAnimalShelter(AnimalShelter animalShelter) {
        animalShelterMapper.updateAnimalShelter(animalShelter);
    }

    @Override
    public void uploadIcon(MultipartFile multipartFile, AnimalShelter animalShelter){
        String str = this.getClass().getClassLoader().getResource("static/IMG/icon").toString();
        //部署配置
//        str = str.replace("/pets-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/","/upload/icon/");
//        str = str.replace("jar:file:","");
        str = str.replace("file:","");
        File file = fileUpload.updateFile(multipartFile,str, UUID.randomUUID().toString());
        animalShelter = queryShelterByCode(animalShelter.getShelterCode());
        str = str.replace("/D:/appData/IdeaProjects/pets/target/classes/static/","");
        animalShelter.setImg(str+"/"+file.getName());
        System.out.println(str+file.getName());
        updateAnimalShelter(animalShelter);
    }

    @Override
    public void pass(AnimalShelter animalShelter) {
        animalShelterMapper.pass(animalShelter);
    }

    @Override
    public List<AnimalShelter> queryAnimalShelterApply(AnimalShelter animalShelter) {
        List<AnimalShelter> list = animalShelterMapper.queryAnimalShelter(animalShelter);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("0")) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }
}
