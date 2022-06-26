package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cetc10.hjj.task.entity.Bill;
import com.cetc10.hjj.task.entity.Type;
import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.mapper.BillMapper;
import com.cetc10.hjj.task.util.DateUtill;
import com.cetc10.hjj.task.vo.BillVo;
import com.cetc10.hjj.task.vo.MsgVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private BillMapper billMapper;
    @Autowired
    private CardService cardService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private UserService userService;

    public void insertBill(String date, int typeId, Double account, int cardId, String comment, String username) {
        User user = userService.selectByUsername(username);
        Bill bill = new Bill();
        bill.setTypeId(typeId);
        bill.setAccount(account);
        bill.setPayMethod(cardId);
        if (date == null || "".equals(date)) {
            bill.setDate(new Date());
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date dateSetting = sdf.parse(date);
                bill.setDate(dateSetting);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        bill.setUserId(user.getId());
        if (account < 0) {
            bill.setState(-1);
            cardService.additionAndSubtractionByCardId(cardId, account);
        } else {
            bill.setState(1);
            cardService.additionAndSubtractionByCardId(cardId, account);
        }
        bill.setComment(comment);
        billMapper.insert(bill);

    }

    public PageInfo<Bill> billList(int pageSize, int currentPage, String username) {
        User user = userService.selectByUsername(username);
        PageHelper.startPage(pageSize, currentPage);
        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>().eq("user_id", user.getId()).orderByDesc("date"));
        PageInfo<Bill> billPageInfo = new PageInfo<>(billList);
        List<Bill> billListOld = billPageInfo.getList();
        List<Bill> billLisNew = new ArrayList<>();
        for (Bill bill : billListOld) {
            Integer method = bill.getPayMethod();
            String nameById = cardService.getNameById(method);
            bill.setPayMethodName(nameById);
            Integer state = bill.getState();
            if (state == -1) {
                bill.setStateName("支出");
            } else if (state == 1) {
                bill.setStateName("收入");
            }
            Integer typeId = bill.getTypeId();
            String typeName = typeService.NameById(typeId);
            bill.setTypeName(typeName);
            Date date = bill.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateFormat = sdf.format(date);
            bill.setDateFomat(dateFormat);
            billLisNew.add(bill);
        }

//        List<Long> payMethods = cardService.getIdByUser(username);
//        List<Bill> billInfo = new ArrayList<>();
//        for (Long payMethod : payMethods) {
//            List<Bill> bills = billMapper.selectList(new QueryWrapper<Bill>().eq("pay_method", payMethod));
//            for (Bill bill : bills) {
//                Integer method = bill.getPayMethod();
//                String nameById = cardService.getNameById(method);
//                bill.setPayMethodName(nameById);
//                Integer state = bill.getState();
//                if (state == -1) {
//                    bill.setStateName("支出");
//                } else if (state == 1) {
//                    bill.setStateName("收入");
//                }
//                Integer typeId = bill.getTypeId();
//                String typeName = typeService.NameById(typeId);
//                bill.setTypeName(typeName);
//                Date date = bill.getDate();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String dateFormat = sdf.format(date);
//                bill.setDateFomat(dateFormat);
//                billInfo.add(bill);
//            }
//        }
//        //按照时间进行排序
//        List<Bill> newList = billInfo.stream().sorted(Comparator.comparing(Bill::getDate)).collect(Collectors.toList());
//        Collections.reverse(newList);
//        int totalSize = newList.size();// 总记录数
//        int totalPage = 0;// 总页数
//        if (totalSize % pageSize == 0) {
//            totalPage = totalSize / pageSize;
//        } else {
//            totalPage = totalSize / pageSize + 1;
//        }
//        currentPage = currentPage > totalPage ? totalPage : currentPage;
//        if (currentPage < 1) {
//            currentPage = 1;
//        }
//        int start = (currentPage - 1) * pageSize;
//        List<Bill> list = new ArrayList<>();
//        for (int i = 0; i < currentPage; i++) {
//
//            list.add(newList.get(start+i));
//        }
//        Pager<Bill> pager = new Pager<Bill>(currentPage, totalPage, pageSize, totalSize, list);
        return billPageInfo;
    }

    public PageInfo<Bill> billListByPay(Integer page, Integer size, String username) {
        PageHelper.startPage(page, size);
        List<Long> payMethods = cardService.getIdByUser(username);
        ArrayList<Bill> billInfo = new ArrayList<>();
        for (Long payMethod : payMethods) {
            List<Bill> bills = billMapper.selectList(
                    new QueryWrapper<Bill>()
                            .eq("state", -1)
                            .eq("pay_method", payMethod
                            ));
            for (Bill bill : bills) {
                billInfo.add(bill);
            }
        }
        return new PageInfo<>(billInfo);
    }

    public PageInfo<Bill> billListBySave(Integer page, Integer size, String username) {
        PageHelper.startPage(page, size);
        List<Long> payMethods = cardService.getIdByUser(username);
        ArrayList<Bill> billInfo = new ArrayList<>();
        for (Long payMethod : payMethods) {
            List<Bill> bills = billMapper.selectList(
                    new QueryWrapper<Bill>()
                            .eq("state", 1)
                            .eq("pay_method", payMethod
                            ));
            for (Bill bill : bills) {
                billInfo.add(bill);
            }
        }

        return new PageInfo<>(billInfo);
    }

    public Double payAcountByDate(Date start, Date end) {
        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>().between("date", start, end).eq("state", -1));
        Double account = 0.0;
        for (Bill bill : billList) {
            account = bill.getAccount() + account;
        }
        return account;
    }

    public Double saveAcountByDate(Date start, Date end) {
        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>().between("date", start, end).eq("state", 1));
        Double account = 0.0;
        for (Bill bill : billList) {
            account = bill.getAccount() + account;
        }
        return account;
    }

    public PageInfo<Bill> billListByDate(int pageSize, int currentPage, String start, String end, String username, int typeid) {
//        List<Long> payMethods = cardService.getIdByUser(username);
//        ArrayList<Bill> billInfo = new ArrayList<>();
//        for (Long payMethod : payMethods) {
//            List<Bill> bills = billMapper.selectList(
//                    new QueryWrapper<Bill>()
//                            .between("date", start, end)
//                            .eq("pay_method", payMethod
//                            ));
//            for (Bill bill : bills) {
//                billInfo.add(bill);
//            }
//        }
//        return billInfo;

        User user = userService.selectByUsername(username);
        PageHelper.startPage(pageSize, currentPage);
        QueryWrapper<Bill> wrapper = new QueryWrapper<Bill>()
                .eq("user_id", user.getId())
                .orderByDesc("date")
                .between(start != null && !"".equals(start) && end != null && !"".equals(end), "date", start + " 00:00:00", end + " 23:59:59")
                .eq(typeid != 0, "type_id", typeid);
        List<Bill> billList = billMapper.selectList(wrapper);
        boolean b = (typeid != 0);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = null;
//        Date parse1 = null;
//        try {
//            parse = sdf.parse(start);
//            parse1 = sdf.parse(end);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        PageInfo<Bill> billPageInfo = new PageInfo<>(billList);
        List<Bill> billListOld = billPageInfo.getList();
        List<Bill> billLisNew = new ArrayList<>();
        for (Bill bill : billListOld) {
            Integer method = bill.getPayMethod();
            String nameById = cardService.getNameById(method);
            bill.setPayMethodName(nameById);
            Integer state = bill.getState();
            if (state == -1) {
                bill.setStateName("支出");
            } else if (state == 1) {
                bill.setStateName("收入");
            }
            Integer typeId = bill.getTypeId();
            String typeName = typeService.NameById(typeId);
            bill.setTypeName(typeName);
            Date date = bill.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateFormat = sdf.format(date);
            bill.setDateFomat(dateFormat);
            billLisNew.add(bill);
        }
        return billPageInfo;
    }

    public List<Bill> saveListByDate(Date start, Date end, String username) {
        List<Long> payMethods = cardService.getIdByUser(username);
        ArrayList<Bill> billInfo = new ArrayList<>();
        for (Long payMethod : payMethods) {
            List<Bill> bills = billMapper.selectList(
                    new QueryWrapper<Bill>()
                            .between("date", start, end)
                            .eq("state", 1)
                            .eq("pay_method", payMethod
                            ));
            for (Bill bill : bills) {
                billInfo.add(bill);
            }
        }
        return billInfo;

    }

    public List<Bill> payListByDate(Date start, Date end, String username) {
        List<Long> payMethods = cardService.getIdByUser(username);
        ArrayList<Bill> billInfo = new ArrayList<>();
        for (Long payMethod : payMethods) {
            List<Bill> bills = billMapper.selectList(
                    new QueryWrapper<Bill>()
                            .between("date", start, end)
                            .eq("state", -1)
                            .eq("pay_method", payMethod
                            ));
            for (Bill bill : bills) {
                billInfo.add(bill);
            }
        }
        return billInfo;
    }

    public Double payAccountByToday() {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(d);
        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>().between("date", format + " 00:00:00", format + " 23:59:59").eq("state", -1));
        Double account = 0.0;
        for (Bill bill : billList) {
            account = bill.getAccount() + account;
        }
        return Math.abs(account);
    }

    public Double payAccountBydate(Date date, String username) {
        User user = userService.selectByUsername(username);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(date);
        List<Bill> billList = billMapper.selectList(
                new QueryWrapper<Bill>()
                        .between("date", format + " 00:00:00", format + " 23:59:59")
                        .eq("state", -1).eq("user_id", user.getId()));
        Double account = 0.0;
        for (Bill bill : billList) {
            account = bill.getAccount() + account;
        }
        return Math.abs(account);
    }

    public Double saveAccountBydate(Date date, String username) {
        User user = userService.selectByUsername(username);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(date);
        List<Bill> billList = billMapper.selectList(
                new QueryWrapper<Bill>()
                        .between("date", format + " 00:00:00", format + " 23:59:59")
                        .eq("state", 1).eq("user_id", user.getId()));
        Double account = 0.0;
        for (Bill bill : billList) {
            account = bill.getAccount() + account;
        }
        return Math.abs(account);
    }

    public Double saveAccountByToday() {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(d);
        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>().between("date", format + " 00:00:00", format + " 23:59:59").eq("state", 1));
        Double account = 0.0;
        for (Bill bill : billList) {
            account = bill.getAccount() + account;
        }
        return account;
    }

    public LinkedHashMap<String, Double> payAccountByWeek(String username) {
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        Date date = new Date();
        for (int i = 6; i >= 0; i--) {
            Date date1 = new Date(date.getTime() - i * 1000 * 86400);
            String week = getWeek(date1);
            map.put(week, payAccountBydate(date1, username));
        }
        return map;
    }

    public LinkedHashMap<String, Double> saveAccountByWeek(String username) {
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        Date date = new Date();
        for (int i = 6; i >= 0; i--) {
            Date date1 = new Date(date.getTime() - i * 1000 * 86400);
            String week = getWeek(date1);
            map.put(week, saveAccountBydate(date1, username));
        }

        return map;
    }

    public LinkedHashMap<String, List<Double>> saveAndPayAccountByWeek(String username) {
        LinkedHashMap<String, List<Double>> map = new LinkedHashMap<>();
        Date date = new Date();
        for (int i = 6; i >= 0; i--) {
            List<Double> account = new ArrayList<>();
            Date date1 = new Date(date.getTime() - i * 1000 * 86400);
            String week = getWeek(date1);
            account.add(saveAccountBydate(date1, username));
            account.add(payAccountBydate(date1, username));
            map.put(week, account);
        }
        return map;
    }

    /**
     * 根据日期转变为星期(方法一)
     */
    public String getWeek(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public int logNumToday() {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(d);
        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>().between("date", format + " 00:00:00", format + " 23:59:59"));
        return billList.size();
    }

    public List<BillVo> getAccontByTypeAll(String username, String start, String end) {
        User user = userService.selectByUsername(username);
        QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
        List<Bill> bills = billMapper.selectList(queryWrapper
                .eq("user_id", user.getId())
                .eq("state", -1)
                .groupBy("type_id")
                .between(start != null && !"".equals(start) && end != null && !"".equals(end), "date", start + " 00:00:00", end + " 23:59:59")
        );
        ArrayList<BillVo> billVoList = new ArrayList<>();
        for (Bill bill : bills) {
            BillVo billVo = new BillVo();
            Integer typeId = bill.getTypeId();
            billVo.setTypeId(typeId);
            String nameById = typeService.NameById(typeId);
            billVo.setName(nameById);
            billVoList.add(billVo);
        }

        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>()
                .eq("user_id", user.getId())
                .eq("state", -1)
                .between(start != null && !"".equals(start) && end != null && !"".equals(end), "date", start + " 00:00:00", end + " 23:59:59")
        );
        for (BillVo vo : billVoList) {
            Double accountAll = 0.0;
            for (Bill bill : billList) {
                if(bill.getTypeId()==vo.getTypeId()){
                    accountAll = accountAll+bill.getAccount();
                }
                vo.setAccountAllBytypeId(accountAll);
            }
        }
        return billVoList;

    }

    public List<Bill> getAccontLinePay(String username, String start, String end) {
        User user = userService.selectByUsername(username);


        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>()
                .eq("user_id", user.getId())
                .eq("state", -1)
                .between(start != null && !"".equals(start) && end != null && !"".equals(end), "date", start + " 00:00:00", end + " 23:59:59")
        );
        for (Bill bill : billList) {
            Date date = bill.getDate();
            SimpleDateFormat df = new SimpleDateFormat("MM-dd");
            String format = df.format(date);
            bill.setDateFomat(format);
            Integer typeId = bill.getTypeId();
            String typeName = typeService.NameById(typeId);
            bill.setTypeName(typeName);
        }

        return billList;

    }

    public List<Bill> getAccontLineSave(String username, String start, String end) {
        User user = userService.selectByUsername(username);
        List<Bill> billList = billMapper.selectList(new QueryWrapper<Bill>()
                .eq("user_id", user.getId())
                .eq("state", 1)
                .between(start != null && !"".equals(start) && end != null && !"".equals(end), "date", start + " 00:00:00", end + " 23:59:59")
        );

        for (Bill bill : billList) {
            Date date = bill.getDate();
            SimpleDateFormat df = new SimpleDateFormat("MM-dd");
            String format = df.format(date);
            bill.setDateFomat(format);
            Integer typeId = bill.getTypeId();
            String typeName = typeService.NameById(typeId);
            bill.setTypeName(typeName);
        }

        return billList;

    }

    public Double getAccontByType(int typeId, String username) {
        User user = userService.selectByUsername(username);
        List<String> months = DateUtill.getFormatDate("month");
        String first = months.get(0);
        String end = months.get(months.size() - 1);
        List<Bill> bills = billMapper.selectList(new QueryWrapper<Bill>()
                .eq("user_id", user.getId())
                .eq("type_id", typeId).between("date", first, end));
        Double res = 0.0;
        for (Bill bill : bills) {
            res = res + bill.getAccount();
        }
        return res;
    }

    public void delete(Integer id) {
        billMapper.deleteById(id);
    }

    public Bill findById(int id) {
        Bill bill = billMapper.selectOne(new QueryWrapper<Bill>().eq("id", id));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat = sdf.format(bill.getDate());
        bill.setDateFomat(dateFormat);
        return bill;
    }

    public void updateById(int id, String date, int typeId, Double account, int cardId, String comment, int state, String username) {
        User user = userService.selectByUsername(username);
        UpdateWrapper<Bill> wrapper = new UpdateWrapper<Bill>().eq("id", id);
        Bill bill = new Bill();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateSetting = sdf.parse(date);
            bill.setDate(dateSetting);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bill.setState(state);
        bill.setTypeId(typeId);
        bill.setAccount(account);
        bill.setPayMethod(cardId);
        bill.setComment(comment);
        bill.setUserId(user.getId());
        billMapper.update(bill, wrapper);
    }

    public List<MsgVo> getMsg(String username) {
        ArrayList<MsgVo> list = new ArrayList<>();
        List<Type> typeList = typeService.selectByUserName(username);
        for (Type type : typeList) {
            MsgVo msgVo = new MsgVo();
            Double real = getAccontByType(type.getId(), username);
            double hope = type.getHope();
            if(Math.abs(real)>=hope){
                msgVo.setState(1);
                msgVo.setMsg(type.getName()+"类型超过预算");
                list.add(msgVo);
            }
        }
        return list;
    }
}
