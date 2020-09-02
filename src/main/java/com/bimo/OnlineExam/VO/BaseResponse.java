package com.bimo.OnlineExam.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @ClassName: BaseResponse
 * @Author: 13716
 * @Date: 2020/7/26 16:40
 * @Version: 1.0
 **/

@Getter
@Setter
@ToString
public class BaseResponse implements Serializable {
    private int httpStatus;
    private Object response;

    public BaseResponse() {
    }

    public BaseResponse(HttpStatus httpStatus, Object response) {
        this.httpStatus = httpStatus.value();
        this.response = response;
    }
}
