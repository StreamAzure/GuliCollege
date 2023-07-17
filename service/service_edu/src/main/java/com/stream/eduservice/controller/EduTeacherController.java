package com.stream.eduservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.stream.eduservice.service.EduTeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stream.commonutils.R;
import com.stream.eduservice.entity.EduTeacher;
import com.stream.eduservice.entity.vo.TeacherQuery;


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

    // 分页查询讲师列表
    // page: 当前页
    // limit：每页显示记录数
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("pageTeacher/{page}/{limit}")
    public R pageList(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable Long page,
                      @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable Long limit
                      ){
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        // 分页查询，查询到数据后，会封装到pageParam对象里
        eduTeacherService.page(pageParam, null);
        // 获取查询到的数据
        List<EduTeacher> records = pageParam.getRecords();
        // 获取总记录数
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows", records);  
    }

    // 条件组合分页查询讲师列表
    @ApiOperation(value = "条件组合分页讲师列表")
    @PostMapping("pageTeacherCondition/{page}/{limit}")
    public R pageTeacherCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable Long page,
                                  @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable Long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        // 创建分页page对象
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        // 调用方法实现多条件分页查询，传入条件对象teacherQuery
        eduTeacherService.pageQuery(pageParam, teacherQuery);
        // 获取查询到的数据
        List<EduTeacher> records = pageParam.getRecords();
        // 获取总记录数
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows", records);
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

