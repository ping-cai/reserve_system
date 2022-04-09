package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.Dept;
import com.yanzhen.model.Node;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 科室 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2021-02-02
 */
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 查询所有的记录 带条件
     */
    List<Dept> queryDeptAll(Dept dept);


   //根据父节点查询list集合
    List<Dept> queryListByParentId(@Param("parentId") Long parentId);


    /**
     * 查询部门树
     */
    List<Node> queryDeptTree();



}
