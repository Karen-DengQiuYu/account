package com.cetc10.hjj.task.controller;

import com.cetc10.hjj.task.entity.Bill;
import com.cetc10.hjj.task.entity.Transfer;
import com.cetc10.hjj.task.service.TransferService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    TransferService transferService;

    @ApiOperation(value = "转账", notes = "转账")
    @PostMapping("transfer")
    public void transfer(int inId, int outId, Double account, String comment, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sdfDate = null;
        try {
            sdfDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        transferService.transfer(inId, outId, account, comment,sdfDate);
    }

    @ApiOperation(value = "转账列表", notes = "转账列表")
    @PostMapping(value = "transferList")
    public PageInfo<Transfer> transferList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        return transferService.transferList(page, size);
    }
}
