package com.nenu.ossas.mapper.petClinicMapper;

import com.nenu.ossas.entity.animalShelterEntity.AnimalShelter;
import com.nenu.ossas.entity.petClinicEntity.PetClinic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PetClinicMapper {

    /**
     * 通过编号查找救助站
     * */
    PetClinic queryPetClinicByCode(@Param("petClinicCode") String petClinicCode);
    /**
     * 通过任意属性模糊查找救助站
     * */
    List<PetClinic> queryPetClinic(@Param("petClinic") PetClinic petClinic);
    /**
     * 新增救助站信息
     * */
    void addPetClinic(@Param("petClinic") PetClinic petClinic);
    /**
     * 删除救助站信息
     * */
    void delPetClinic(@Param("petClinic") PetClinic petClinic);
    /**
     * 更新救助站信息
     * */
    void updatePetClinic(@Param("petClinic") PetClinic petClinic);

    void pass(@Param("petClinic") PetClinic petClinic);

}
