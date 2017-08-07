package com.keruis.report.utils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */
public class TimeUtils {
    public static List getTime(Timestamp tsp,Timestamp tspend){
        List list = new ArrayList();

        List<String> strattime=TimeUtils.getTimeInfo(tsp.toString());
        Calendar start = Calendar.getInstance();
        start.set(Integer.parseInt(strattime.get(0)),(Integer.parseInt(strattime.get(1))-1),Integer.parseInt(strattime.get(2)),00,00,00);
        list.add(strattime.get(0)+"-"+strattime.get(1)+"-"+strattime.get(2)+" "+strattime.get(3)+":"+strattime.get(4)+":"+strattime.get(5));
        Long startTIme = start.getTimeInMillis();

        List<String> endtime=TimeUtils.getTimeInfo(tspend.toString());
        Calendar end = Calendar.getInstance();
        end.set(Integer.parseInt(endtime.get(0)),Integer.parseInt(endtime.get(1))-1,Integer.parseInt(endtime.get(2)),00,00,00);
        Long endTime = end.getTimeInMillis();
        Long oneDay = 1000 * 60 * 60 * 24l;
        Long time = startTIme;
        while (time <=endTime-oneDay) {
            time += oneDay;
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            list.add(df.format(d));
        }
        list.add((endtime.get(0))+"-"+(endtime.get(1))+"-"+(endtime.get(2))+" "+(endtime.get(3))+":"+(endtime.get(4))+":"+(endtime.get(5)));
        L.w("getTime:"+list.toString());
        return list;
    }
public static  List<String> getTimeInfo(String time){
    List list = new ArrayList();
    list.add(time.substring(0,4));
    list.add(time.substring(5,7));
    list.add(time.substring(8,10));
    list.add(time.substring(11,13));
    list.add(time.substring(14,16));
    list.add(time.substring(17,19));
    return  list;
}
public static String getDataBaseName(String time){
    return "gserver_"+time.substring(0,4)+time.substring(5,7);
}
public static String getTableName(String time){
    return "gps_"+time.substring(0,4)+time.substring(5,7)+time.substring(8,10);
}


}
