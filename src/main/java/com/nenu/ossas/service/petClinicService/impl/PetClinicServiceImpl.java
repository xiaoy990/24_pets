package com.nenu.ossas.service.petClinicService.impl;

import com.nenu.ossas.entity.petClinicEntity.PetClinic;
import com.nenu.ossas.mapper.petClinicMapper.PetClinicMapper;
import com.nenu.ossas.service.petClinicService.PetClinicService;
import com.nenu.ossas.util.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service("petClinicService")
public class PetClinicServiceImpl implements PetClinicService {

    @Resource
    private PetClinicMapper petClinicMapper;

    @Resource
    FileUpload fileUpload;

    @Override
    public PetClinic queryPetClinicByCode(String petClinicCode) {
        return petClinicMapper.queryPetClinicByCode(petClinicCode);
    }

    @Override
    public List<PetClinic> queryPetClinic(PetClinic petClinic) {
        return petClinicMapper.queryPetClinic(petClinic);
    }

    @Override
    public void addPetClinic(PetClinic petClinic) {
        petClinicMapper.addPetClinic(petClinic);
    }

    @Override
    public void delPetClinic(PetClinic petClinic) {
        petClinicMapper.delPetClinic(petClinic);
    }

    @Override
    public void updatePetClinic(PetClinic petClinic) {
        petClinicMapper.updatePetClinic(petClinic);
    }

    @Override
    public void uploadIcon(MultipartFile file,PetClinic petClinic) {
        File file1 = fileUpload.updateFile(file,"D:\\appData\\IdeaProjects\\pets\\target\\classes\\upload\\icon", UUID.randomUUID().toString());
        petClinic = queryPetClinicByCode(petClinic.getPetClinicCode());
        petClinic.setImg(file1.getPath());
        updatePetClinic(petClinic);
    }

    @Override
    public List<PetClinic> queryPetClinicApply(PetClinic petClinic) {
        List<PetClinic> list = petClinicMapper.queryPetClinic(petClinic);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getStatus().equals("0")){
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    @Override
    public void pass(PetClinic petClinic) {
        petClinicMapper.pass(petClinic);
    }

}
