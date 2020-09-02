package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.Callback;
import com.bimo.OnlineExam.service.CallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@RestController
@RequestMapping("/callback")
public class CallbackController {
    private CallbackService callbackService;

    @Autowired
    public void setCallbackService(CallbackService callbackService) {
        this.callbackService = callbackService;
    }

    @GetMapping
    public BaseResponse getCallback(Integer id) {
        Callback callback = callbackService.getById(id);
        if (callback == null) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前查询到的内容不存在！");
        }
        return new BaseResponse(HttpStatus.OK, callback);
    }

    @PostMapping
    public BaseResponse saveCallback(Callback callback) {
        boolean result = callbackService.save(callback);
        if (result) {
            return new BaseResponse(HttpStatus.OK, "信息上传成功!");
        }
        return new BaseResponse(HttpStatus.BAD_REQUEST, "信息上传失败！");
    }
}

