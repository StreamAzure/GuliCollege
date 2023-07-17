package com.stream.eduservice.service;

import com.stream.eduservice.entity.EduTeacher;
import com.stream.eduservice.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author stream
 * @since 2023-07-17
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
