package com.keruis.report.testing;

import com.keruis.report.utils.L;
import com.keruis.report.utils.SqlServerJDBCUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/1/4.
 */
public class SqlServerTesting  extends  SqlServerJDBCUtils{
    public static  void main(String[] strings) throws  Exception{



        Date date = new Date();
        Timestamp tsp = new Timestamp(date.getTime());
        L.w(tsp.toString());
        L.w("nian："+tsp.toString().substring(0,4));
        L.w("yue："+tsp.toString().substring(5,7));
        L.w("ri："+tsp.toString().substring(8,10));
        L.w("shi："+tsp.toString().substring(11,13));
        L.w("fen："+tsp.toString().substring(14,16));
        L.w("miao："+tsp.toString().substring(17,19));

        Calendar start = Calendar.getInstance();
        start.set(2016, -1, 11,01,00,00);
        Long startTIme = start.getTimeInMillis();

        Calendar end = Calendar.getInstance();
        end.set(2017, 11, 16,20,00,00);
        Long endTime = end.getTimeInMillis();

        Long oneDay = 1000 * 60 * 60 * 24l;

        Long time = startTIme;
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.println(df.format(d));
            time += oneDay;
        }
//        SqlServerJDBCUtils.DatabaseName="gserver_201701";
//
//        SqlServerJDBCUtils result = new SqlServerJDBCUtils();
//        String sql="select '移动冷链方舱-2' shebei_name,VehicleID code,recvtime,temperature wendu1 from [dbo].[gps_20170103] where [VehicleID]=? and recvtime >='2017-01-03 00:00:00' and recvtime <='2017-01-03 23:59:59' and recvtime is not null and temperature is  not null  order by recvtime";
//        String[] pags ={"7146111"};
//        L.w("sql:"+sql);
//        List list= result.getResultSet(sql,pags);
//        if(StringUtils.isEmpty(list)){
//            L.w("this is null");
//        }else{
//            //list.addAll(list);
//            L.w(""+list.toString());
//            for(int i=0;i<list.size();i++)
//            {
//                L.w(list.get(i).toString());
//            }
//        }
//
   }

}
