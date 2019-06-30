package com.nenu.ossas.service.animalShelterService;

import com.nenu.ossas.entity.animalShelterEntity.AnimalShelter;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnimalShelterService {
    /**
     * 通过编号查找救助站
     * */
    AnimalShelter queryShelterByCode(int shelterCode);
    /**
     * 通过任意属性模糊查找救助站
     * */
    List<AnimalShelter> queryAnimalShelter(@Param("animalShelter") AnimalShelter animalShelter);
    /**
     * 新增救助站信息
     * */
    void addAnimalShelter(@Param("animalShelter") AnimalShelter animalShelter);
    /**
     * 删除救助站信息
     * */
    void delAnimalShelter(@Param("animalShelter") AnimalShelter animalShelter);
    /**
     * 更新救助站信息
     * */
    void updateAnimalShelter(@Param("animalShelter") AnimalShelter animalShelter);

    void uploadIcon(MultipartFile file, AnimalShelter animalShelter);


    void pass(AnimalShelter animalShelter);

    List<AnimalShelter> queryAnimalShelterApply(@Param("animalShelter") AnimalShelter animalShelter);
}
