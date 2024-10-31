package com.krf.threecs.service;

import com.krf.threecs.domain.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.krf.threecs.domain.po.dto.PageQueryDto;
import com.krf.threecs.result.PageResult;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Service
* @createDate 2024-10-25 15:08:05
*/
public interface UserService extends IService<User> {

    /**
     * 分页条件查询
     * @param pageQueryDto
     * @return
     */
    PageResult pageQueryByName(PageQueryDto pageQueryDto);
}
