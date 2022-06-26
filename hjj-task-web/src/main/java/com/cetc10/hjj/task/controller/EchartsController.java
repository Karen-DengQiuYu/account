//package com.cetc10.hjj.task.controller;
//
//
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.cetc10.hjj.task.entity.Echarts;
//import com.cetc10.hjj.task.mapper.EchartsMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/echarts")
//public class EchartsController {
//
//    @Autowired
//    private EchartsMapper echartsMapper;
//
//    @GetMapping
//    @ResponseBody
//    public List<Echarts> echarts(){
//        //查询数据库echarts表的所有数据
//        return echartsMapper.selectList(Wrappers.lambdaQuery());
//    }
//}
