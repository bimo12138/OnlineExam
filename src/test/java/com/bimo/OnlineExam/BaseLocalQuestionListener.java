package com.bimo.OnlineExam;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BaseLocalQuestionListener
 * @Author: 13716
 * @Date: 2020/7/30 21:24
 * @Version: 1.0
 **/


public class BaseLocalQuestionListener extends AnalysisEventListener<BaseLocalQuestion> {

    private static final int BATCH_COUNT = 10;
    List<BaseLocalQuestion> list = new ArrayList<BaseLocalQuestion>();
    Integer exam_id;
    public BaseLocalQuestionListener() {
    }

    public BaseLocalQuestionListener(Integer exam_id) {
        this.exam_id = exam_id;
    }

    @Override
    public void invoke(BaseLocalQuestion baseLocalQuestion, AnalysisContext analysisContext) {
        baseLocalQuestion.setTest_id(exam_id);
        System.out.println(baseLocalQuestion);
        list.add(baseLocalQuestion);
        if (list.size() >= BATCH_COUNT) {
            System.out.println("信息已经保存！");
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("所有信息已经解析完成！");
    }
}
