package com.cetc10.hjj.task.controller;

import com.cetc10.hjj.task.entity.Bill;
import com.cetc10.hjj.task.service.BillService;
import com.cetc10.hjj.task.vo.MsgVo;
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
@RequestMapping("/income")
@Api
@CrossOrigin
public class IncomeController {

    @Autowired
    private BillService billService;
    @Autowired
    private HttpSession session;

    @ApiOperation(value="支出",notes = "支出")
    @PostMapping(value = "pay")
    public void pay(String date,int typeId,Double account,int cardId,String comment){
        String username = (String) session.getAttribute("username");
        billService.insertBill(date,typeId,-account,cardId,comment,username);
    }
    @ApiOperation(value="收支",notes = "收支")
    @PostMapping(value = "payOrSave")
    public void payOrSave(String date,int typeId,Double account,int cardId,String comment,int state){
        String username = (String) session.getAttribute("username");
        if(state==1){
            billService.insertBill(date,typeId,account,cardId,comment,username);
        }else {
            billService.insertBill(date,typeId,-account,cardId,comment,username);
        }
    }

    @ApiOperation(value="修改",notes = "修改")
    @PostMapping(value = "updateById")
    public void updateById(int id,String date,int typeId,Double account,int cardId,String comment,int state){
        String username = (String) session.getAttribute("username");
        billService.updateById(id,date,typeId,account,cardId,comment,state,username);
    }

    @GetMapping("selectById/{id}")
    @ApiOperation(value="根据id查看",notes = "根据id查看")
    @ResponseBody
    public Bill selectById(@PathVariable int id) {
        Bill bill = billService.findById(id);
        return bill;
    }

    @ApiOperation(value="收入",notes = "收入")
    @PostMapping(value = "save")
    public void save(String date,int typeId,Double account,int cardId,String comment){
        String username = (String) session.getAttribute("username");
        billService.insertBill(date,typeId,account,cardId,comment,username);
    }

    @ApiOperation(value="账单列表",notes = "账单列表")
    @GetMapping(value = "billList")
    public PageInfo<Bill> billList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", required = false , defaultValue = "6") Integer size){
        String username = (String) session.getAttribute("username");
        return billService.billList(page,size,username);

    }

    @ApiOperation(value="删除通过id",notes = "删除通过id")
    @GetMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        billService.delete(id);
    }

    @ApiOperation(value="支出账单",notes = "支出账单")
    @GetMapping(value = "billListByPay")
    public PageInfo<Bill> billListByPay(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", required = false , defaultValue = "10") Integer size){
        String username = (String) session.getAttribute("username");
        return billService.billListByPay(page,size,username);
    }

    @ApiOperation(value="收入账单",notes = "收入账单")
    @GetMapping(value = "billListBySave")
    public PageInfo<Bill> billListBySave(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", required = false , defaultValue = "10") Integer size){
        String username = (String) session.getAttribute("username");
        return billService.billListBySave(page,size,username);
    }

    @ApiOperation(value="按时间显示",notes = "按时间显示")
    @GetMapping(value = "billListByDate")
    public PageInfo<Bill> billListByDate(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false , defaultValue = "6") Integer size,
            @RequestParam(value = "start", required = false) String start,
            @RequestParam(value = "end", required = false) String end,
            @RequestParam(value = "typeId", required = false) String typeId){
        String username = (String) session.getAttribute("username");
        if(typeId.equals("")||typeId==null){
            int typeIdNew = 0;

            return billService.billListByDate(page,size,start,end,username,typeIdNew);
        }else {
            return billService.billListByDate(page,size,start,end,username,Integer.valueOf(typeId));
        }

    }


    @ApiOperation(value="通过时间算收入账单",notes = "通过时间算收入账单")
    @GetMapping(value = "saveListByDate")
    public List<Bill> saveListByDate(@RequestParam(value = "start", required = false) String start
            , @RequestParam(value = "end", required = false) String end){
        String username = (String) session.getAttribute("username");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        Date parse1 = null;
        try {
            parse = sdf.parse(start);
            parse1 = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return billService.saveListByDate(parse,parse1,username);
    }
    @ApiOperation(value="通过时间算支出金额",notes = "通过时间算支出金额")
    @GetMapping(value = "payListByDate")
    public List<Bill> payListByDate(@RequestParam(value = "start", required = false) String start
            ,@RequestParam(value = "end", required = false) String end){
        String username = (String) session.getAttribute("username");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        Date parse1 = null;
        try {
            parse = sdf.parse(start);
            parse1 = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return billService.payListByDate(parse,parse1,username);
    }

    @ApiOperation(value="预警提示",notes = "预警提示")
    @GetMapping("getMsg")
    public List<MsgVo> getMsg(){
        String username = (String) session.getAttribute("username");
        return billService.getMsg(username);
    }
}
