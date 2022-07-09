package com.wzg.mbsb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wzg.mbsb.entity.Country;

/**
 * @author wangzhigang
 */
@Mapper
public interface CountryMapper {


    List<Country> selectAll();

    List<Country> selectCountryByNameOrCode(Country country);


}
