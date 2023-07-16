package com.stream.eduservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.stream.eduservice.service.EduTeacherService;
import com.stream.eduservice.entity.EduTeacher;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author stream
 * @since 2023-07-17
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    // 查询讲师表所有数据
    @GetMapping("findAll")
    public List<EduTeacher> list(){
        return eduTeacherService.list(null);
    }
}

