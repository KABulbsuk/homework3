package com.krf.threecs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.krf.threecs.domain.po.User;
import com.krf.threecs.service.UserService;
import com.krf.threecs.domain.po.dto.PageQueryDto;
import com.krf.threecs.result.PageResult;
import com.krf.threecs.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-10-25 15:08:05
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    /**
     * 分页条件查询
     * @param pageQueryDto
     * @return
     */
    @Override
    public PageResult pageQueryByName(PageQueryDto pageQueryDto) {
        //设置分页条件，获取page对象
        Page<User> page = Page.of(pageQueryDto.getPageNum(), pageQueryDto.getPageSize());

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.like(User::getName,pageQueryDto.getName());

        //查询
        Page<User> p = page(page,wrapper);

        //封装PageResult对象
        PageResult pageResult = new PageResult();
        pageResult.setRecords(p.getRecords());
        pageResult.setTotal(p.getTotal());

        return pageResult;
    }
}




