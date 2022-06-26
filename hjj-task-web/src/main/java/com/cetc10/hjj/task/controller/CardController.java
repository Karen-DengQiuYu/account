package com.cetc10.hjj.task.controller;


import com.cetc10.hjj.task.entity.Card;
import com.cetc10.hjj.task.entity.Interest;
import com.cetc10.hjj.task.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private HttpSession session;

    @GetMapping("add")
    public void add(String cardName,Double account){
        String username = (String) session.getAttribute("username");
        cardService.add(username,cardName,account);

    }

    @DeleteMapping("delete")
    public void delete(int id){
        cardService.delete(id);
    }

    @PostMapping("updateByCardId")
    public void updateByCardId(int id,Double account){
        cardService.updateByCardId(id,account);
    }

    @GetMapping("selectByUser")
    public List<Card> selectByUser(){
        String username = (String) session.getAttribute("username");
        return cardService.selectByUser(username);
    }

    @GetMapping("selectAll")
    public List<Card> selectAll(){
        String username = (String) session.getAttribute("username");
        return cardService.selectAll(username);
    }

    @GetMapping("getRate")
    public Double getRate(int type){
        return cardService.getRate(type);
    }

    @GetMapping("addInterest")
    public void addInterest(String cardName,Double account,String rate,String date,String comment ){
        String username = (String) session.getAttribute("username");
        Date parse = null;
        if(rate!=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                parse = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cardService.addInterest(cardName,account,rate,parse,comment,username);
        }
        cardService.addInterest(cardName,account,rate,parse,comment,username);
    }
}
