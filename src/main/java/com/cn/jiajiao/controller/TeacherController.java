package com.cn.jiajiao.controller;

import com.cn.jiajiao.common.R;
import com.cn.jiajiao.domain.vo.TeacherVo;
import com.cn.jiajiao.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    /**
     * 根据科目查询教师
     * @param subject 科目
     * @return 教师列表
     */
    @GetMapping("/by-subject")
    public R<List<TeacherVo>> getBySubject(@RequestParam String subject) {
        List<TeacherVo> teachers = teacherService.getBySubject(subject);
        return R.success(teachers);
    }

    /**
     * 根据科目和年级查询教师
     * @param subject 科目
     * @param grade 年级
     * @return 教师列表
     */
    @GetMapping("/by-subject-grade")
    public R<List<TeacherVo>> getBySubjectAndGrade(
            @RequestParam String subject,
            @RequestParam String grade) {
        List<TeacherVo> teachers = teacherService.getBySubjectAndGrade(subject, grade);
        return R.success(teachers);
    }
} 