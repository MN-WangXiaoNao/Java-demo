package com.wzg.mbsb;

import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wzg.mbsb.dto.SysUserDTO;
import com.wzg.mbsb.entity.SysUserEntity;
import com.wzg.mbsb.mapper.SysUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SysUserTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void testUpdateByIdSelective() {
        SysUserEntity entity = new SysUserEntity();
        entity.setId(1L);
        entity.setUserEmail("admin@mybatis123456.tk");
        // int count = sysUserMapper.updateByIdSelective(entity);
        int count = sysUserMapper.updateByIdSelective2(entity);
        log.info("更新了{}条记录", count);
    }

    @Test
    void testInsertBySelective() {
        SysUserEntity entity = new SysUserEntity();
        entity.setUserName("abc");
        entity.setUserPassword("123456");
        entity.setUserEmail("xiaonao@163.com");
        entity.setCreateTime(new Date());
        entity.setUserInfo("test info");
        entity.setHeadImg(null);
        int count = sysUserMapper.insertBySelective(entity);
        log.info("添加了{}条记录", count);
    }

    @Test
    void testSelectByIdOrUserName() {
        SysUserEntity entity = new SysUserEntity();
        // entity.setId(1L);
        entity.setUserName("test");
        // SysUserEntity sysUserEntity = sysUserMapper.selectByIdOrUserName(entity);
        List<SysUserEntity> entities = sysUserMapper.selectByIdOrUserName2(entity);
        entities.forEach(System.out::println);
    }

    @Test
    void testSelectByUser() {
        SysUserEntity entity = new SysUserEntity();
        entity.setId(1L);
        List<SysUserEntity> entities = sysUserMapper.selectByUser(entity);
        entities.forEach(System.out::println);
    }

    @Test
    void testSelectByIdList() {
        List<Long> ids = Lists.newArrayList();
        ids.add(1L);
        ids.add(1001L);
        List<SysUserEntity> entities = sysUserMapper.selectByIdList(ids);
        entities.forEach(System.out::println);

    }

    // --- 批量插入 ---
    @Test
    void batchInsert1() {
        List<SysUserEntity> entities = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            SysUserEntity sysUserEntity = new SysUserEntity();
            sysUserEntity.setUserName("路人" + i);
            sysUserEntity.setUserPassword(String.valueOf(i * i * 13));
            sysUserEntity.setUserEmail(String.valueOf(i * i * 13) + "@163.com");
            sysUserEntity.setCreateTime(new Date());
            sysUserEntity.setUserInfo("description : " + i);
            entities.add(sysUserEntity);
        }

        int count = sysUserMapper.batchInsert1(entities);
        System.out.println("添加了 " + count + " 条数据");
    }


//    -- 高级查询
    @Test
    void testSelectUserAndRoleById(){
        List<SysUserDTO> sysUserDTOS = sysUserMapper.selectUserAndRoleById(1L);
        sysUserDTOS.forEach(System.out::println);
    }
}
