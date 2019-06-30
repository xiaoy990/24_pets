package com.nenu.ossas.service.petClinicService;

import com.nenu.ossas.entity.animalShelterEntity.AnimalShelter;
import com.nenu.ossas.entity.petClinicEntity.PetClinic;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PetClinicService {
    /**
     * 通过编号查找救助站
     * */
    PetClinic queryPetClinicByCode(String petClinicCode);
    /**
     * 通过任意属性模糊查找救助站
     * */
    List<PetClinic> queryPetClinic(PetClinic petClinic);
    /**
     * 新增救助站信息
     * */
    void addPetClinic(PetClinic petClinic);
    /**
     * 删除救助站信息
     * */
    void delPetClinic(PetClinic petClinic);
    /**
     * 更新救助站信息
     * */
    void updatePetClinic(PetClinic petClinic);

    void uploadIcon(MultipartFile file,PetClinic petClinic);

    public List<PetClinic> queryPetClinicApply(PetClinic animalShelter);

    void pass(PetClinic petClinic);
}
