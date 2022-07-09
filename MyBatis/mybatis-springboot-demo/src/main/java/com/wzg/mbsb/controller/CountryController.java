package com.wzg.mbsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzg.mbsb.mapper.CountryMapper;
import com.wzg.mbsb.entity.Country;

/**
 * @author wangzhigang
 */
@RequestMapping("/country")
@RestController
public class CountryController {

    @Autowired
    private CountryMapper countryMapper;

    @GetMapping("all")
    List<Country> selectAll(){
        return countryMapper.selectAll();
    }
}
