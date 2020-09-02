package com.bimo.OnlineExam;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import java.io.IOException;

/**
 * @ClassName: ExcelTest
 * @Author: 13716
 * @Date: 2020/7/29 23:27
 * @Version: 1.0
 **/


public class ExcelTest {
    @Test
    public void ExcelLoadTest() throws IOException {
        String filePath = "F:\\Document\\FDM\\单选题.xlsx";
        EasyExcel.read(filePath, BaseLocalQuestion.class, new BaseLocalQuestionListener(3)).sheet().doRead();
    }
}
