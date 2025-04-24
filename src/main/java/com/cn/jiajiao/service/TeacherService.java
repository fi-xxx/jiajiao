package com.cn.jiajiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.jiajiao.domain.po.Teacher;
import com.cn.jiajiao.domain.vo.TeacherVo;

import java.util.List;

public interface TeacherService extends IService<Teacher> {

    /**
     * 根据科目查询教师
     * @param subject 科目
     * @return 教师列表
     */
    List<TeacherVo> getBySubject(String subject);
    
    /**
     * 根据科目和年级查询教师
     * @param subject 科目
     * @param grade 年级
     * @return 教师列表
     */
    List<TeacherVo> getBySubjectAndGrade(String subject, String grade);

    TeacherVo getByPhone(String phone);

} 