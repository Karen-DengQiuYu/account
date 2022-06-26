package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cetc10.hjj.task.entity.Transfer;
import com.cetc10.hjj.task.mapper.TransferMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransferService {
    @Autowired
    private TransferMapper transferMapper;

    @Autowired
    private CardService cardService;

    public void transfer(int inId, int outId, Double account, String comment,Date date) {
        cardService.transfer(inId ,outId ,account,comment);
        Transfer transfer = new Transfer();
        transfer.setAccount(account);
        if(date==null){
            date = new Date();
        }
        transfer.setDate(date);
        transfer.setOutId(outId);
        transfer.setInId(inId);
        transfer.setComment(comment);
        transferMapper.insert(transfer);
    }

    public PageInfo<Transfer> transferList(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Transfer> lists = transferMapper.selectList(new QueryWrapper<Transfer>());
        return new PageInfo<>(lists);
    }
}
