package com.bite.system.controller.user;

import com.bite.common.core.controller.BaseController;
import com.bite.common.core.domain.R;
import com.bite.common.core.domain.TableDataInfo;
import com.bite.system.domain.user.dto.UserDTO;
import com.bite.system.domain.user.dto.UserQueryDTO;
import com.bite.system.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制器
 * 该控制器提供了用户管理相关的接口，包括用户列表查询和用户状态管理
 * 继承自BaseController，获取通用的控制器功能
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    /**
     * 用户服务接口
     * 通过Spring的依赖注入，自动注入用户服务实现类
     * 用于处理用户相关的业务逻辑
     */
    @Autowired
    private IUserService userService;

    /**
     * 获取用户列表
     * 接口路径：GET /user/list
     *
     * 功能说明：
     * 1. 支持分页查询用户列表
     * 2. 可以根据条件筛选用户
     * 3. 返回标准的分页数据格式
     *
     * 参数说明：
     * @param userQueryDTO 用户查询条件DTO，包含：
     *                    - pageNum：当前页码
     *                    - pageSize：每页大小
     *                    - 其他查询条件（如用户名、状态等）
     *
     * 返回说明：
     * @return TableDataInfo 包含：
     *                    - 总记录数
     *                    - 当前页数据
     *                    - 分页信息
     */
    @GetMapping("/list")
    public TableDataInfo list(UserQueryDTO userQueryDTO) {
        return getTableDataInfo(userService.list(userQueryDTO));
    }

    /**
     * 更新用户状态
     * 接口路径：PUT /user/updateStatus
     *
     * 功能说明：
     * 1. 用于管理员对用户进行状态管理
     * 2. 支持拉黑用户（限制用户操作）
     * 3. 支持解禁用户（恢复用户权限）
     *
     * 实现细节：
     * 1. 更新数据库中的用户状态
     * 2. 同步更新缓存中的用户状态
     * 3. 实时生效，无需重启服务
     *
     * 参数说明：
     * @param userDTO 用户状态更新DTO，包含：
     *               - userId：用户ID
     *               - status：用户状态（0-正常，1-禁用）
     *
     * 返回说明：
     * @return R<Void> 统一响应格式：
     *               - 成功：返回成功状态码
     *               - 失败：返回错误信息
     *
     * 安全说明：
     * 1. 需要管理员权限
     * 2. 通过token验证身份
     * 3. 记录操作日志
     */
    @PutMapping("/updateStatus")
    public R<Void> updateStatus(@RequestBody UserDTO userDTO) {
        return toR(userService.updateStatus(userDTO));
    }
}