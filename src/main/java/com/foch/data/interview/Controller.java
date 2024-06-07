package com.foch.data.interview;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@RestController

@RequestMapping

public class Controller {

    public final DecessService decessService;

    public Controller(DecessService decessService) {
        this.decessService = decessService;
    }

    @PostMapping
    public void saveData() throws SQLException, FileNotFoundException, ClassNotFoundException {
        decessService.saveData();
    }

    @GetMapping
    public void getSomeData() {
        decessService.getSomeData();
    }


}
