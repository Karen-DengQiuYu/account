package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cetc10.hjj.task.entity.Tax;
import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.mapper.TaxMapper;
import com.cetc10.hjj.task.util.DateUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class TaxService {

    @Autowired
    private TaxMapper taxMapper;

    @Autowired
    private UserService userService;

    public void add(String username, String name, Double tax, String comment, Date date) {
        User user = userService.selectByUsername(username);
        Tax taxAdd = new Tax();
        taxAdd.setUserId(user.getId());
        if (date == null) {
            taxAdd.setDate(new Date());
        } else {
            taxAdd.setDate(date);
        }
        taxAdd.setName(name);
        taxAdd.setTax(tax);
        taxAdd.setComment(comment);
        taxMapper.insert(taxAdd);
    }

    public double evaluation(Double account) {
        if(account<=3500){
            return 0;
        }else if (account<3500+1500){
            return (account-3500)*0.03;
        }else if(account<3500+4500){
            return (1500*0.03)+((account-3500-1500)*0.1);
        }else if(account<3500+9000){
            return (1500*0.03)+(3000*0.1)+((account-3500-4500)*0.2);
        }else {
            return (1500*0.03)+(3000*0.1)+(4500*0.2)+((account-3500-9000)*0.25);
        }
    }

    public List<Tax> taxEcharts(String username) {
        User user = userService.selectByUsername(username);
        List<Tax> taxList = taxMapper.selectList(new QueryWrapper<Tax>()
                .eq("user_id", user.getId())
                .last("limit 6")
                .orderByDesc("date"));
        return taxList;
    }
}




