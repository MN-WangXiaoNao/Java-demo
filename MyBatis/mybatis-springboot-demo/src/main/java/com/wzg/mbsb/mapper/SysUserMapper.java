package com.wzg.mbsb.mapper;

import java.util.List;

import com.wzg.mbsb.dto.SysUserDTO;
import com.wzg.mbsb.entity.SysUserEntity;

public interface SysUserMapper {

    int updateByIdSelective(SysUserEntity sysUser);

    int updateByIdSelective2(SysUserEntity sysUser);

    int insertBySelective(SysUserEntity sysUser);

    /**
     * 当 参数 id 有值 的时候优 先使 用 id 查询，当 id 没有值时就去判断用户名是否有值，如果有值就用用户名 查询 ，如果用 户名 也没有值，就使 SQL 查询无结果 <br/
     *
     * @param sysUser
     * @return
     */
    List<SysUserEntity> selectByIdOrUserName(SysUserEntity sysUser);

    List<SysUserEntity> selectByIdOrUserName2(SysUserEntity sysUser);

    List<SysUserEntity> selectByUser(SysUserEntity sysUser);

    List<SysUserEntity> selectByIdList(List<Long> ids);

    int batchInsert1(List<SysUserEntity> entities);

    // --- 高级映射

    List<SysUserDTO> selectUserAndRoleById(Long id);

}
