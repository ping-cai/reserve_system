package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.PatientInfo;
import com.yanzhen.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 病人信息表 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2021-02-02
 */
@Component("patientDao")
public interface PatientInfoMapper extends BaseMapper<PatientInfo> {
    List<PatientInfo> queryAll(PatientInfo patientInfo);

    PatientInfo queryPatByUsernameAndPassword(@Param("username") String username,
                                              @Param("password") String password);

    PatientInfo queryPatByName(@Param("username") String username);

}
