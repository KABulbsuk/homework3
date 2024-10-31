package com.krf.bs.controller;

import com.krf.bs.domain.po.User;
import com.krf.bs.domain.po.dto.PageQueryDto;
import com.krf.bs.result.PageResult;
import com.krf.bs.result.Result;
import com.krf.bs.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        log.info("新增联系人：{}",user);

        //调用service层
        userService.save(user);

        return Result.success();
    }
    @GetMapping("/page")
    public Result<PageResult> pageQueryByName(PageQueryDto pageQueryDto){
        log.info("根据name条件分页查询：{}",pageQueryDto);

        //调用service层
        PageResult pageResult = userService.pageQueryByName(pageQueryDto);

        return Result.success(pageResult);
    }
    @PutMapping("/update")
    public Result updateById(@RequestBody User user){
        log.info("修改联系人信息：{}",user);

        userService.updateById(user);

        return Result.success();
    }
    @GetMapping("/get/{id}")
    public Result<User> getById(@PathVariable Long id){
        log.info("根据id查询：{}",id);

        User user = userService.getById(id);

        return Result.success(user);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        log.info("根据id删除联系人：{}",id);
        userService.removeById(id);

        return Result.success();
    }
}
