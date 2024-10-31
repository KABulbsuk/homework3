package com.krf.threecs.mapper;

import com.krf.threecs.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-10-25 15:08:05
* @Entity po.domain.com.krf.threecs.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




