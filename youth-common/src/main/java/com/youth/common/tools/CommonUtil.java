package com.youth.common.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassNamw CommonUtil
 * @Description TODO
 * @Author limaoda
 * @Date 2018/10/1317:41
 * @Version 1.0
 **/
public class CommonUtil {


    /**
     *
     * 功能描述:  结果集合并：两个list
     *
     *  @Author limaoda
     *  @Description //TODO
     *  @Date 17:24 2018/10/15
     *  @param
     *  @return
     **/
    public static List<Map<String,Object>> mergeList ( List<Map<String,Object>> totalList , List<Map<String,Object>>  partList){
        for (int i = 0; i < totalList.size(); i++) {
            boolean a = false;
            String monthTime = "";
            Long valueNumber = 0L;
            for (int j = 0; j < partList.size() ; j++) {
                if( totalList.get(i).get("monthTime").equals( partList.get(j).get("monthTime") )  ){
                    monthTime = partList.get(j).get("monthTime").toString();
                    valueNumber = (Long) partList.get(j).get("valueNumber");
                    a = true;
                    continue;
                }
            }
            if(a){
                totalList.get(i).put("monthTime",monthTime);
                totalList.get(i).put("valueNumber",valueNumber);
            }
        }
        /*for (int i = 0; i < totalList.size(); i++) {
            System.out.println(" monthTime "+ totalList.get(i).get("monthTime"));
            System.out.println(" valueNumber  "+ totalList.get(i).get("valueNumber"));
        }*/
        return  totalList;
    }

    /**
     * 根据当前时间获取N个月的开始、结束日期
     *
     * @param number  前几个月
     * @return 前N个月的开始、结束日期
     */
    public static List<String> getStartAndEndDate(int number){
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.MONTH,0);
        dateList.add(sj.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, -(number-1));
        dateList.add(sj.format(calendar.getTime()));

        return dateList;
    }


    /**
     * 根据当前时间获取N个月的所有日期  日期倒序
     *
     * @param number  前几个月
     * @param dateFormat 日期格式
     * @return 前N个月的所有日期
     */
    public static List<Map<String,Object>> getNumberPerDaysByStartAndEndDate(int number, String dateFormat){
        SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,0);
        String at = sj.format(calendar.getTime());
        calendar.add(Calendar.MONTH, -(number-1));
        String ot = sj.format(calendar.getTime());
        return getPerDaysByStartAndEndDate(ot,at,dateFormat);
    }


    /**
     * 获取某日期区间的所有日期  日期倒序
     *
     * @param startDate  开始日期
     * @param endDate    结束日期
     * @param dateFormat 日期格式
     * @return 区间内所有日期
     */
    public static List<Map<String,Object>> getPerDaysByStartAndEndDate(String startDate, String endDate, String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        try {
            Date sDate = format.parse(startDate);
            Date eDate = format.parse(endDate);
            long start = sDate.getTime();
            long end = eDate.getTime();
            if (start > end) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(eDate);
            List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();

            while (end >= start) {
                Map<String,Object> map = new HashMap<>();
                System.out.println(format.format(calendar.getTime()));
                //res.add(format.format(calendar.getTime()));
                map.put("monthTime",format.format(calendar.getTime()));
                map.put("valueNumber",0);
                res.add(map);
                calendar.add(Calendar.MONTH, -1);//上个月
                end = calendar.getTimeInMillis();
            }
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
