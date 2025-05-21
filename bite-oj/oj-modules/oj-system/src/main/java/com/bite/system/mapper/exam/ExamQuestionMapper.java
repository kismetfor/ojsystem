package com.bite.system.mapper.exam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bite.system.domain.exam.Exam;
import com.bite.system.domain.exam.ExamQuestion;
import com.bite.system.domain.exam.dto.ExamQueryDTO;
import com.bite.system.domain.exam.vo.ExamVO;
import com.bite.system.domain.question.dto.QuestionQueryDTO;
import com.bite.system.domain.question.vo.QuestionVO;

import java.util.List;

public interface ExamQuestionMapper extends BaseMapper<ExamQuestion> {

    List<QuestionVO> selectExamQuestionList(Long examId);
}
