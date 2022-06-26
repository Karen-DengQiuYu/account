package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cetc10.hjj.task.cons.Rate;
import com.cetc10.hjj.task.entity.Card;
import com.cetc10.hjj.task.entity.Interest;
import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.mapper.CardMapper;
import com.cetc10.hjj.task.mapper.InterestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class CardService {

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private InterestMapper interestMapper;

    @Autowired
    private UserService userService;

    public void add(String username, String cardName, Double account) {
        User user = userService.selectByUsername(username);
        Card card = new Card();
        card.setCardName(cardName);
        card.setCardOverage(account);
        card.setUserId(user.getId());
        cardMapper.insert(card);
    }

    public void delete(int id) {
        cardMapper.deleteById(id);
    }

    public void updateByCardId(int id, Double account) {
        UpdateWrapper<Card> cardUpdateWrapper = new UpdateWrapper<>();
        cardUpdateWrapper.eq("id", id).set("card_overage", account);
        cardMapper.update(null, cardUpdateWrapper);
    }

    public void additionAndSubtractionByCardId(int id, Double account) {
        UpdateWrapper<Card> cardUpdateWrapper = new UpdateWrapper<>();
        Card card = cardMapper.selectById(id);
        cardUpdateWrapper.eq("id", id).set("card_overage", card.getCardOverage() + account);
        cardMapper.update(null, cardUpdateWrapper);
    }

    public List<Card> selectByUser(String name) {
        User user = userService.selectByUsername(name);
        QueryWrapper<Card> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", user.getId()).eq("interest_id",0);
        List<Card> cards = cardMapper.selectList(wrapper);
        return cards;
    }

    public void transfer(int inId, int outId, Double account, String comment) {
        Card incard = cardMapper.selectById(inId);
        cardMapper.update(null, new UpdateWrapper<Card>().eq("id", inId).set("card_overage", incard.getCardOverage() + account));
        Card outCard = cardMapper.selectById(outId);
        cardMapper.update(null, new UpdateWrapper<Card>().eq("id", outId).set("card_overage", outCard.getCardOverage() - account));
    }

    public List<Long> getIdByUser(String userName) {
        int userId = userService.getUserIdbyName(userName);
        List<Long> cards = new ArrayList<>();
        List<Card> cardList = cardMapper.selectList(new QueryWrapper<Card>().eq("user_id", userId));
        for (Card card : cardList) {
            cards.add(card.getId());
        }
        return cards;
    }

    public String getNameById(int id) {
        return cardMapper.selectById(id).getCardName();
    }

    public Double getRate(int type) {
        return (double) Rate.CARDRATE.get(type);
    }

    public Interest addIaddInterestBefore(String cardName, Double account, String rate, Date date, String comment, String username) {
        Interest interest = new Interest();
        if (date == null) {
            interest.setDate(new Date());
        } else {
            interest.setDate(date);
        }
        interest.setRate(rate);
        interest.setComment(comment);
        interestMapper.insert(interest);
        return interest;
    }

    public void addInterest(String cardName, Double account, String rate, Date date, String comment, String username) {
        User user = userService.selectByUsername(username);
        Card card = new Card();
        card.setCardName(cardName);
        card.setCardOverage(account);
        card.setUserId(user.getId());
        Interest interest = addIaddInterestBefore(cardName, account, rate, date, comment, username);
        card.setInterestId(interest.getId());
        cardMapper.insert(card);
    }

    public List<Card> selectAll(String username) {
        User user = userService.selectByUsername(username);
        QueryWrapper<Card> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", user.getId());
        List<Card> cards = cardMapper.selectList(wrapper);
        ArrayList<Card> cardNew = new ArrayList<>();
        for (Card card : cards) {
            if(card.getInterestId()==0){
                cardNew.add(card);
            }else {
                Interest interest = interestMapper.selectOne(new QueryWrapper<Interest>().eq("id", card.getInterestId()));
                if(interest!=null) {
                    card.setInterest(interest);
                    Date date = interest.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateFormat = sdf.format(date);
                    interest.setDateFomat(dateFormat);
                    long time = new Date().getTime() - date.getTime();
                    long day = time / 24 / 60 / 60 / 1000;
                    Double cardOverage = card.getCardOverage();
                    Double rate = Double.valueOf(interest.getRate()) / 100 / 365;
                    interest.setAccrual(Math.floor(cardOverage * rate * day));
                    cardNew.add(card);
                }
            }
        }
        return cardNew;
    }
}




