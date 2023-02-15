package uz.bek.springboottask_6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bek.springboottask_6.model.Laptop;
import uz.bek.springboottask_6.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;

    // GET LAPTOP LIST
    @RequestMapping(value = "/laptop", method = RequestMethod.GET)
    public List<Laptop> getLaptop(){
        List<Laptop> laptopList = laptopRepository.findAll();
        return laptopList;
    }

    //GET LAPTOP BY ID
    @RequestMapping(value = "laptop/{id}", method = RequestMethod.GET)
    public Laptop getLaptopById(@PathVariable Integer id){
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()){
            Laptop laptop = optionalLaptop.get();
            return laptop;
        }
        else {
            return new Laptop();
        }
    }

    //ADD LAPTOP
    @RequestMapping(value = "/laptop", method = RequestMethod.POST)
    public String addLaptop(@RequestBody Laptop laptop){
        List<Laptop> laptopList = laptopRepository.findAll();
        for (Laptop currentLaptop : laptopList) {
            if (currentLaptop.getMacAddress().equals(laptop.getMacAddress())){
                return "Laptop already exist";
            }
        }
        laptopRepository.save(laptop);
        return "Laptop added";
    }

    //DELETE LAPTOP BY ID
    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.DELETE)
    public String deleteLaptop(@PathVariable Integer id){
        laptopRepository.deleteById(id);
        return "Laptop deleted";
    }

    //UPDATE LAPTOP BY ID
    @RequestMapping(value ="/laptop/{id}", method = RequestMethod.PUT)
    public String editLaptop(@PathVariable Integer id, @RequestBody Laptop laptop){
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()){
            Laptop editingLaptop = optionalLaptop.get();
            editingLaptop.setName(laptop.getName());
            editingLaptop.setModel(laptop.getModel());
            editingLaptop.setBrandName(laptop.getBrandName());
            editingLaptop.setRam(laptop.getRam());
            editingLaptop.setStorage(laptop.getStorage());
            editingLaptop.setMacAddress(laptop.getMacAddress());
            laptopRepository.save(editingLaptop);
            return "Laptop edited";
        }
        return "Laptop not found";
    }
}








