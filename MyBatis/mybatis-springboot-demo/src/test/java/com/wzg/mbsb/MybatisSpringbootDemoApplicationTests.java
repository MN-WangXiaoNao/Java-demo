package com.wzg.mbsb;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wzg.mbsb.entity.Country;
import com.wzg.mbsb.mapper.CountryMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MybatisSpringbootDemoApplicationTests {

    @Autowired
    private CountryMapper countryMapper;

    @Test
    void contextLoads() {
        List<Country> countries = countryMapper.selectAll();
        countries.forEach(System.out::println);
    }
}
