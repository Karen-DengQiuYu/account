package com.cetc10.hjj.task.controller;

import com.cetc10.hjj.task.entity.Tax;
import com.cetc10.hjj.task.entity.Transfer;
import com.cetc10.hjj.task.service.TaxService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tax")
@Api
@CrossOrigin
public class TaxController {
    @Autowired
    private TaxService taxService;
    @Autowired
    private HttpSession session;

    @ApiOperation(value = "个人税", notes = "个人税")
    @GetMapping(value = "add")
    public void add(String name,Double tax,String comment,String date) {
        String username = (String) session.getAttribute("username");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taxService.add(username,name,tax,comment,parse);
    }
    @ApiOperation(value = "计算", notes = "计算")
    @GetMapping(value = "evaluation")
    public Double evaluation(Double account) {
        return taxService.evaluation(account);
    }

    @ApiOperation(value = "图表", notes = "图表")
    @GetMapping(value = "taxEcharts")
    public List<Tax> taxEcharts() {
        String username = (String) session.getAttribute("username");
        return taxService.taxEcharts(username);
    }
}
