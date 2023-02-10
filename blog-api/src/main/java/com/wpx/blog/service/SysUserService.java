package com.wpx.blog.service;

import com.wpx.blog.dao.pojo.SysUser;

public interface SysUserService {

    SysUser findSysUserById(Long authorId);

    SysUser findUser(String account, String pwd);
}
