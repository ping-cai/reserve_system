package com.yanzhen.model;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class UserInfoVo {
    private Integer id;
    private String username;
    private String type;
}
