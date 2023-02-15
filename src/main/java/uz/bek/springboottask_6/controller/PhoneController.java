package uz.bek.springboottask_6.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bek.springboottask_6.model.Phone;
import uz.bek.springboottask_6.repository.PhoneRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    //GET PHONE LIST
    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public List<Phone> getPhone(){
        List<Phone> phoneList = phoneRepository.findAll();
        return phoneList;
    }

    //GET PHONE BY ID
    @RequestMapping(value = "/phone/{id}", method = RequestMethod.GET)
    public Phone getPhoneById(@PathVariable Integer id){
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()){
            Phone phone = optionalPhone.get();
            return phone;
        }
        else {
            return new Phone();
        }
    }

    //ADD PHONE
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String addPhone(@RequestBody Phone phone){
        phoneRepository.save(phone);
        return "Phone added";
    }

    //DELETE PHONE BY ID
    @RequestMapping(value = "/phone/{id}", method = RequestMethod.DELETE)
    public String deletePhone(@PathVariable Integer id){
        phoneRepository.deleteById(id);
        return "Phone deleted";
    }

    //UPDATE PHONE
    @RequestMapping(value = "/phone/{id}", method = RequestMethod.PUT)
    public String updatePhone(@PathVariable Integer id, @RequestBody Phone phone){
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()){
            Phone editingPhone = optionalPhone.get();
            editingPhone.setName(phone.getName());
            editingPhone.setModel(phone.getModel());
            editingPhone.setInfo(phone.getInfo());
            editingPhone.setMacAddress(phone.getMacAddress());
            phoneRepository.save(editingPhone);
            return "Phone edited";
        }
        return "Phone not found";
    }
}













