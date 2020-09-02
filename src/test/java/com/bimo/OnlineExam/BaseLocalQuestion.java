package com.bimo.OnlineExam;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName: BaseLocalQuestion
 * @Author: 13716
 * @Date: 2020/7/30 20:25
 * @Version: 1.0
 **/

@Data
public class BaseLocalQuestion {
    private String type;
    private String baseType;
    private String knowledge;
    private String level;
    private String score;
    private String title;
    private String chooseA;
    private String chooseB;
    private String chooseC;
    private String chooseD;
    private String chooseE;
    private String chooseF;
    private String rightAnswer;
    private String analyse;
    @ExcelIgnore
    private Integer test_id;
}
