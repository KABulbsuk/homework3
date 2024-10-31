package com.krf.bs.mapper;

import com.krf.bs.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-10-25 16:50:58
* @Entity po.domain.com.krf.bs.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




