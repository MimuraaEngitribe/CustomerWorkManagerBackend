package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerWorkerManagerController {

    @RequestMapping("/getEmploee")  // ルートへこのメソッドをマップする
    public String getEmploee() {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("src/main/resources/employees.json")), StandardCharsets.UTF_8);
            return jsonData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}


