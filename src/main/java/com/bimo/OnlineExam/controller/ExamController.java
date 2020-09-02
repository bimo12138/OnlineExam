package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.mapper.ExamMapper;
import com.bimo.OnlineExam.pojo.AnswerStatus;
import com.bimo.OnlineExam.pojo.Exam;
import com.bimo.OnlineExam.service.AsyncTask;
import com.bimo.OnlineExam.service.ExamService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@RestController
@EnableAsync
@RequestMapping("/exam")
public class ExamController {

    private ExamService examService;
    private AsyncTask asyncTask;
    @Resource
    private ExamMapper examMapper;

    @Autowired
    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    @Autowired
    public void setAsyncTask(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }

    @GetMapping("/new")
    public BaseResponse getNewExam() {
        return new BaseResponse(HttpStatus.OK, examMapper.getNewExams());
    }

    @GetMapping("/list")
    public BaseResponse getMyExam(Integer userId) {
        return new BaseResponse(HttpStatus.OK, examService.getMyExam(userId));
    }

    @GetMapping
    public BaseResponse getExam(String id) {
        Exam exam = examService.getById(id);
        if (exam == null) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前考试不存在！");
        }
        return new BaseResponse(HttpStatus.OK, examService.getById(id));
    }

    @PostMapping
    public BaseResponse saveExam(Exam exam, MultipartFile file) throws IOException {
        if (file == null) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "信息上传不完整，请重试！");
        }
        exam.setUploadTime(LocalDateTime.now());
        String ext = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\media\\excel\\";
        String filename = UUID.randomUUID().toString() + "." + ext;
        String filepath = path + filename;
        File excel = new File(filepath);
        file.transferTo(excel);
        exam.setRawFile(filename);
        boolean result = examService.save(exam);
        if (result) {
            asyncTask.loadExam(filepath, filename);
            return new BaseResponse(HttpStatus.OK, "试卷上传成功！");
        }
        return new BaseResponse(HttpStatus.BAD_REQUEST, "试卷上传失败, 出现未知错误！");
    }

    @PutMapping
    public BaseResponse updateExam(Exam exam, Integer userId) {
        if (!userId.equals(exam.getUploader())) {
            return new BaseResponse(HttpStatus.UNAUTHORIZED, "您没有权限操作此信息！");
        }
        boolean result = examService.updateById(exam);
        if (result) {
            return new BaseResponse(HttpStatus.OK, "信息修改成功！");
        }
        return new BaseResponse(HttpStatus.BAD_REQUEST, "信息修改失败！");
    }
    @DeleteMapping
    public BaseResponse deleteExam(Integer examId) {
        boolean result = examService.removeById(examId);
        if (result) {
            return new BaseResponse(HttpStatus.OK, examId + "的试卷信息删除成功！");
        } else {
            return new BaseResponse(HttpStatus.BAD_REQUEST, "试卷删除失败！");
        }
    }
}

