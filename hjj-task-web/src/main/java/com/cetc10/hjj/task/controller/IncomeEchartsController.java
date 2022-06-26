package com.cetc10.hjj.task.controller;

import com.cetc10.hjj.task.entity.Bill;
import com.cetc10.hjj.task.service.BillService;
import com.cetc10.hjj.task.vo.BillVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/incomeEcharts")
@Api
public class IncomeEchartsController {
    @Autowired
    private BillService billService;
    @Autowired
    private HttpSession session;

    @ApiOperation(value="今日记录数量",notes = "今日记录数量")
    @GetMapping(value = "logNumToday")
    public int logNumToday(){
        return billService.logNumToday();
    }

    @ApiOperation(value="今日支出",notes = "今日支出")
    @GetMapping(value = "payAccountByToday")
    public Double payAccountByToday(){
        return billService.payAccountByToday();
    }

    @ApiOperation(value="本周支出",notes = "本周支出")
    @GetMapping(value = "payAccountByWeek")
    public LinkedHashMap<String,Double> payAccountByWeek(){
        String username = (String) session.getAttribute("username");
        return billService.payAccountByWeek(username);
    }

    @ApiOperation(value="本周收入",notes = "本周收入")
    @GetMapping(value = "saveAccountByWeek")
    public LinkedHashMap<String,Double> saveAccountByWeek(){
        String username = (String) session.getAttribute("username");
        return billService.saveAccountByWeek(username);
    }

    @ApiOperation(value="本周收支",notes = "本周收支")
    @GetMapping(value = "saveAndPayAccountByWeek")
    public LinkedHashMap<String, List<Double>>saveAndPayAccountByWeek(){
        String username = (String) session.getAttribute("username");
        return billService.saveAndPayAccountByWeek(username);
    }

    @ApiOperation(value="今日收入",notes = "今日收入")
    @GetMapping(value = "saveAccountByToday")
    public Double saveAccountByToday(){
        return billService.saveAccountByToday();
    }



    @ApiOperation(value="通过时间算收入金额",notes = "通过时间算收入金额")
    @GetMapping(value = "saveAcountByDate")
    public Double saveAcountByDate(@RequestParam(value = "start", required = false) String start
            ,@RequestParam(value = "end", required = false) String end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        Date parse1 = null;
        try {
            parse = sdf.parse(start);
            parse1 = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return billService.saveAcountByDate(parse,parse1);
    }
    @ApiOperation(value="通过时间算支出金额",notes = "通过时间算支出金额")
    @GetMapping(value = "payAcountByDate")
    public Double payAcountByDate(@RequestParam(value = "start", required = false) String start
            ,@RequestParam(value = "end", required = false) String end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        Date parse1 = null;
        try {
            parse = sdf.parse(start);
            parse1 = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return billService.payAcountByDate(parse,parse1);
    }

    @ApiOperation(value="类别算出本月剩余量 预算",notes = "类别算出本月剩余量 预算")
    @GetMapping("getAccontByType/{typeId}")
    public Double getAccontByType(@PathVariable int typeId){
        String username = (String) session.getAttribute("username");
        return billService.getAccontByType(typeId,username);
    }

    @ApiOperation(value="饼图 分类",notes = "饼图 分类")
    @GetMapping("getAccontByTypeAll")
    public List<BillVo> getAccontByTypeAll(@RequestParam(value = "start", required = false) String start,
                                           @RequestParam(value = "end", required = false) String end){
        String username = (String) session.getAttribute("username");
        return billService.getAccontByTypeAll(username,start,end);
    }

    @ApiOperation(value="折线图 细节 支出",notes = "折线图 细节 支出")
    @GetMapping("getAccontLinePay")
    public List<Bill> getAccontLinePay(@RequestParam(value = "start", required = false) String start,
                                         @RequestParam(value = "end", required = false) String end){
        String username = (String) session.getAttribute("username");
        return billService.getAccontLinePay(username,start,end);
    }

    @ApiOperation(value="折线图 细节 收入",notes = "折线图 细节 收入")
    @GetMapping("getAccontLineSave")
    public List<Bill> getAccontLineSave(@RequestParam(value = "start", required = false) String start,
                                         @RequestParam(value = "end", required = false) String end){
        String username = (String) session.getAttribute("username");
        return billService.getAccontLineSave(username,start,end);
    }


}
