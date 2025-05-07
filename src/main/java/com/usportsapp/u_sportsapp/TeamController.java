package com.basketballapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
public class TeamController {

    @GetMapping("/api/teams")
    public String getTeams() {
        try {
            String command = "C:\\Users\\juliu\\OneDrive\\Desktop\\Coding\\python\\fetch_teams.py";


            Process process = Runtime.getRuntime().exec(command);


            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            return output.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching data from Python script.";
        }
    }
}
