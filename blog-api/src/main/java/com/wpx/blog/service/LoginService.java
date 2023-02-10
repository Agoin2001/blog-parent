package com.wpx.blog.service;

import com.wpx.blog.Vo.Result;
import com.wpx.blog.Vo.params.LoginParam;

public interface LoginService {
    Result login(LoginParam loginParam);

}
