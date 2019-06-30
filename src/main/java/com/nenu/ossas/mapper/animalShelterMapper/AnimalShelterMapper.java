package com.nenu.ossas.mapper.animalShelterMapper;

import com.nenu.ossas.entity.animal.Animal;
import com.nenu.ossas.entity.animalShelterEntity.AnimalShelter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnimalShelterMapper {

    /**
     * 通过编号查找救助站
     * */
    AnimalShelter queryAnimalShelterByCode(@Param("shelterCode") int shelterCode);
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

    void pass(@Param("animalShelter") AnimalShelter animalShelter);

}
