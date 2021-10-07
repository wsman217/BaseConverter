package com.westonsublett.tutormebackend.controller;

import com.westonsublett.tutormebackend.logic.BaseConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/base")
public class BaseConversionController {

    @GetMapping("/{value}/{originalBase}/{toBase}")
    public String convertBase(@PathVariable("value") String value, @PathVariable("originalBase") int originalBase, @PathVariable("toBase") int toBase) {
        BaseConverter converter = new BaseConverter();
        converter.convert(value, originalBase, toBase);
        return converter.getJson();
    }
}
