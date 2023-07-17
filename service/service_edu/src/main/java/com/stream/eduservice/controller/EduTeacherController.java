package com.stream.eduservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.stream.eduservice.service.EduTeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.stream.commonutils.R;
import com.stream.eduservice.entity.EduTeacher;


/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author stream
 * @since 2023-07-17
 */
@Api(tags="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    // 查询讲师表所有数据
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public List<EduTeacher> list(){
        return eduTeacherService.list(null);
    }

    // 逻辑删除讲师信息
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/deleteTeacherById/{id}")
    public R deleteTeacherById(@PathVariable String id){
        if(eduTeacherService.removeById(id)){
            return R.ok();
        }
        else {
            return R.error();
        }
    }
}

