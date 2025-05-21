package com.bite.friend.service.user;

import com.bite.api.domain.vo.UserQuestionResultVO;
import com.bite.common.core.domain.R;
import com.bite.friend.domain.user.dto.UserSubmitDTO;

public interface IUserQuestionService {
    R<UserQuestionResultVO> submit(UserSubmitDTO submitDTO);

    boolean rabbitSubmit(UserSubmitDTO submitDTO);

    UserQuestionResultVO exeResult(Long examId, Long questionId, String currentTime);
}
