package com.stream.eduservice.service.impl;

import com.stream.eduservice.entity.EduTeacher;
import com.stream.eduservice.entity.vo.TeacherQuery;
import com.stream.eduservice.mapper.EduTeacherMapper;
import com.stream.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author stream
 * @since 2023-07-17
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery){
        // 构造条件
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        
        // 取条件值
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        // 判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)){
            // 模糊查询姓名
            queryWrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level)){
            // 指定教师头衔
            queryWrapper.eq("level", level);
        }
        if(!StringUtils.isEmpty(begin)){
            // 时间段起始时间
            queryWrapper.ge("gmt_create", begin);
        }
        if(!StringUtils.isEmpty(end)){
            // 时间段结束时间
            queryWrapper.le("gmt_create", end);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
