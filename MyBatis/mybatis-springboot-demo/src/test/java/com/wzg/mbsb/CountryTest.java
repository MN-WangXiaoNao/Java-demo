package com.wzg.mbsb;

import com.wzg.mbsb.entity.Country;
import com.wzg.mbsb.mapper.CountryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class CountryTest {

    @Autowired
    private CountryMapper countryMapper;


    @Test
    void testSelectIf(){
        Country country = new Country();
        country.setCountryName("中国");
        country.setCountryCode("CN");
        List<Country> countries = countryMapper.selectCountryByNameOrCode(country);
        System.out.println(countries.size());
    }

}
