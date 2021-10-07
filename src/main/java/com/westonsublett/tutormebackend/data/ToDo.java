package com.westonsublett.tutormebackend.data;

import lombok.Getter;
import org.springframework.data.annotation.Id;

public class ToDo {

    @Id
    @Getter
    private String id;

    @Getter
    private String title;

    @Getter
    private boolean complete;

    public ToDo(String title, boolean complete) {
        this.title = title;
        this.complete = complete;
    }
}
