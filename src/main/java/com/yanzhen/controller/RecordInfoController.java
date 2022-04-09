package com.yanzhen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yanzhen.model.OrderInfo;
import com.yanzhen.model.RecordInfo;
import com.yanzhen.service.IOrderInfoService;
import com.yanzhen.service.IRecordInfoService;
import com.yanzhen.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 就诊记录信息 前端控制器
 * </p>
 *
 * @author kappy
 * @since 2021-02-02
 */
@Api(tags = {"就诊记录信息"})
@RestController
@RequestMapping("/record")
public class RecordInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRecordInfoService recordInfoService;

    @Resource
    private IOrderInfoService orderInfoService;

    @RequestMapping("/queryRecordInfoAllById")
    public List<RecordInfo> queryRecordInfoAllById(Integer id){
         return recordInfoService.queryRecordInfoByPatientId(id);
    }


    @ApiOperation(value = "新增就诊记录信息")
    @RequestMapping("/add")
    public R add(@RequestBody RecordInfo recordInfo){
        recordInfo.setDay(new Date());
        recordInfo.setDayTime(new Date());
        recordInfo.setStatus(1);
        int num= recordInfoService.add(recordInfo);
        //修改状态  根据用户id和医生id 查询最后一条然后更改状态
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setUserId(recordInfo.getUserId());
        orderInfo.setPatientId(recordInfo.getPatientId());
        OrderInfo info=orderInfoService.queryByRecordInfo(orderInfo);
        info.setStatus(1);//更改状态
        orderInfoService.updateData(info);
        if(num>0){
            return  R.ok();
        }
        return R.fail(405,"添加失败");
    }


    @ApiOperation(value = "更新就诊记录信息")
    @PutMapping()
    public int update(@RequestBody RecordInfo recordInfo){
        return recordInfoService.updateData(recordInfo);
    }

    @ApiOperation(value = "查询就诊记录信息分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<RecordInfo> findListByPage(@RequestParam Integer page,
                                            @RequestParam Integer pageCount){
        return recordInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询就诊记录信息")
    @GetMapping("{id}")
    public RecordInfo findById(@PathVariable Long id){
        return recordInfoService.findById(id);
    }

}
