package uz.bek.springboottask_6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.bek.springboottask_6.repository.PassportRepository;

@RestController
public class PassportController {
    @Autowired
    PassportRepository passportRepository;
}
