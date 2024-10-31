package com.krf.bs.service;

import com.krf.bs.domain.po.User;
import com.krf.bs.domain.po.dto.PageQueryDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.krf.bs.result.PageResult;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Service
* @createDate 2024-10-25 16:50:58
*/
public interface UserService extends IService<User> {
    /**
     * 分页条件查询
     * @param pageQueryDto
     * @return
     */
    PageResult pageQueryByName(PageQueryDto pageQueryDto);
}
