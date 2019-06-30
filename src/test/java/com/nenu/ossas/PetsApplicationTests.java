package com.nenu.ossas;

import com.nenu.ossas.entity.animalShelterEntity.AnimalShelter;
import com.nenu.ossas.entity.bill.Bill;
import com.nenu.ossas.entity.user.User;
import com.nenu.ossas.service.billService.BillService;
import com.nenu.ossas.entity.petClinicEntity.PetClinic;
import com.nenu.ossas.service.animalShelterService.AnimalShelterService;
import com.nenu.ossas.service.petClinicService.PetClinicService;
import com.nenu.ossas.service.userservice.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetsApplicationTests {

    @Resource
    AnimalShelterService animalShelterService;
    @Resource
    PetClinicService petClinicService;
    @Resource
    BillService billService;
    @Resource
    UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPetClinic(){
        PetClinic petClinic = new PetClinic();
        petClinic.setId(1);
        petClinic.setPetClinicAddress("test");
        petClinic.setPetClinicCode("test");
        petClinic.setIntroduction("test");
        petClinic.setName("test");
        petClinic.setTelephone("test");
        petClinic.setImg("test");

        petClinicService.addPetClinic(petClinic);
        System.out.println(petClinicService.queryPetClinicByCode("test"));

        PetClinic petClinic1 = new PetClinic();
        petClinic1.setName("update test");
        petClinic1.setId(1);
        petClinicService.updatePetClinic(petClinic1);
        System.out.println(petClinicService.queryPetClinicByCode("test"));

    }

    @Test
    public void testAnimalShelterTest(){

        System.out.println(animalShelterService.queryShelterByCode(0001));

        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.setShelterCode(2);
        animalShelter.setShelterAddress("addressTest");
        animalShelter.setIntroduction("我是intro");
        animalShelter.setName("shelter02");
        animalShelter.setTelephone("1111-11111");
        animalShelter.setImg("/upload/test/xxxxxxxx.png");
        animalShelterService.addAnimalShelter(animalShelter);
        System.out.println(animalShelterService.queryShelterByCode(2));

        animalShelter.setName("updateTest");
        animalShelter.setId(2);
        animalShelterService.updateAnimalShelter(animalShelter);
        System.out.println(animalShelterService.queryShelterByCode(2));

        AnimalShelter animalShelter1 = new AnimalShelter();
        animalShelter1.setShelterAddress("a");
        animalShelter1.setName("nmsl");
        animalShelter1.setTelephone("nmsl");
        System.out.println("模糊查询测试："+animalShelterService.queryAnimalShelter(animalShelter1));

        animalShelterService.delAnimalShelter(animalShelter);
        System.out.println(animalShelterService.queryShelterByCode(2));
    }

    @Test
    public void uploadTest(){
        System.out.println(this.getClass().getClassLoader().getResource(""));
    }

    @Test
    public void billTest(){
        Bill bill = new Bill();
        bill.setAmount(10);
        bill.setDonorEmail("xiaoy990@nenu.edu.cn");
        bill.setDonorName("xiaoy");
        bill.setDonorTel("6666666");
        billService.addBill(bill);
        bill.setId(1);
        bill.setMessage("updateMsg");
        billService.updateBill(bill);
        System.out.println(billService.queryBill(new Bill()));
    }

    @Test
    public void test(){
        User user = new User();
        user.setId(1);
        user.setUsername("1");
        user.setPassword("1");
        user.setPerms("perm:add");
        userService.addUser(user);
    }
}
