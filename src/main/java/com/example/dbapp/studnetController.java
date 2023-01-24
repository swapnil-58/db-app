package com.example.dbapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class studnetController {
    @Autowired
    dbManager dbManager;

    @PostMapping("/insert_info")
    public void insertinfo(@RequestBody Student s)throws SQLException {
        dbManager.student_inf(s);
    }

}
