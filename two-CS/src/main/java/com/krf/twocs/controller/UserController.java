package com.krf.twocs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.krf.twocs.domain.po.User;
import com.krf.twocs.domain.po.dto.PageQuery;
import com.krf.twocs.mapper.UserMapper;
import com.krf.twocs.result.PageResult;
import com.krf.twocs.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserMapper userMapper;

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        log.info("新增联系人：{}",user);

        userMapper.insert(user);

        return Result.success();
    }

    @GetMapping("/page")

    public Result<PageResult> pageQueryByName(PageQuery pageQuery){
        log.info("分页条件查询：{}",pageQuery);

        Page<User> page = Page.of(pageQuery.getPageNum(), pageQuery.getPageSize());

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName,pageQuery.getName());
        Page<User> p = userMapper.selectPage(page,wrapper);

        PageResult pageResult = new PageResult();

        pageResult.setRecords(p.getRecords());
        pageResult.setTotal(p.getTotal());

        return Result.success(pageResult);
    }

    @GetMapping("/get/{id}")
    public Result<User> getById(@PathVariable Long id){
        log.info("根据id查询：{}",id);

        User user = userMapper.selectById(id);

        return Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        log.info("修改联系人信息:{}",user);
        userMapper.updateById(user);

        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        log.info("根据id删除联系人：{}",id);
        User user = new User();
        user.setId(id);
        userMapper.deleteById(user);

        return Result.success();
    }
}
