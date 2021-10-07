package com.westonsublett.tutormebackend.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Instruction {

    private final ArrayList<String> instructions = new ArrayList<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public void addInstructions(String instruction) {
        instructions.add(instruction + "<br>");
    }

    public String getGson() {
        return gson.toJson(instructions);
    }
}
