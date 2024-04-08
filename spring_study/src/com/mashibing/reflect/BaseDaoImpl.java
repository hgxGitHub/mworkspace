package com.mashibing.reflect;


import com.mashibing.bean.Emp;
import com.mashibing.bean.Msb;
import com.mashibing.util.MySQLDBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* 要查询N张表的数据，但是不想写N多的方法，能否写一个方法完成所有表的查询工作
* 1.获取与数据信息
* 2.获取元数据中有多少列
* 3.循环列，找到每列的值
* 4.循环列，找到每列列名
* 5.通过列名在java类中找到属性对象
* 6.通过列名在java类中找到set方法，需要手动转换，因为首字母大写
* 7.如果返回的值是number类型，将数据库返回值转成Number类型，其它类型直接调inwoke方法
* 8.通过属性类型找到java中具体数字类型（byte,short,int,long,float,double）
* 9.调用6返回的方法对象invoke（obj,7步获取的值）
*
* */
public class BaseDaoImpl {
    /**
     * 统一的查询表的方法
     * @param sql       不同的sql语句
     * @param params    sql语句的参数
     * @param clazz        sql语句查询返回的对象
     * @return
     */
    public List getRows(String sql,Object[] params,Class clazz){
        List list = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            //建立连接
            connection = MySQLDBUtil.getConnection();
            //创建pstmt对象
            pstmt = connection.prepareStatement(sql);
            //给sql语句填充参数
            if(params!=null){
                for(int i = 0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
            //开始执行查询操作,resultset中有返回的结果，需要讲返回的结果放置到不同的对象中
            resultSet = pstmt.executeQuery();
            //获取结果集合的元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //判断查询到的每一行记录中包含多少个列
            int columnCount = metaData.getColumnCount();
            //循环遍历resultset行
            while(resultSet.next()){
                //创建放置具体结果属性的对象
                Object obj = clazz.newInstance();
                for(int i= 0;i<columnCount;i++){
                    //从结果集合中获取单一列的值
                    Object objValue = resultSet.getObject(i+1);
                    //获取数据库列的名称
                    String columnName = metaData.getColumnName(i+1).toLowerCase();
                    //获取类中的属性对象
                    Field declaredField = clazz.getDeclaredField(columnName);
                    //获取类中属性对应的set方法第二个参数根据属性中的类型也就是方法类型
                    Method method = clazz.getMethod(getSetName(columnName),declaredField.getType());
                    if(objValue instanceof Number){
                        //将数据库值转换成Number对象
                        Number number = (Number) objValue;
                        //获取属性值类型名做判断
                        String fname = declaredField.getType().getName();
                        if("int".equals(fname)||"java.lang.Integer".equals(fname)){
                            method.invoke(obj,number.intValue());
                        }else if("byte".equals(fname)||"java.lang.Byte".equals(fname)){
                            method.invoke(obj,number.byteValue());
                        }else if("short".equals(fname)||"java.lang.Short".equals(fname)){
                            method.invoke(obj,number.shortValue());
                        }else if("long".equals(fname)||"java.lang.Long".equals(fname)){
                            method.invoke(obj,number.longValue());
                        }else if("float".equals(fname)||"java.lang.Float".equals(fname)){
                            method.invoke(obj,number.floatValue());
                        }else if("double".equals(fname)||"java.lang.Double".equals(fname)){
                            method.invoke(obj,number.doubleValue());
                        }
                    }else{
                        method.invoke(obj,objValue);
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLDBUtil.closeConnection(connection,pstmt,resultSet);
        }

        return list;
    }


    public String getSetName(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }

    public static void main(String[] args) {
        BaseDaoImpl baseDao = new BaseDaoImpl();
//        List rows = baseDao.getRows("select empno,ename,sal,deptno from emp where deptno =?", new Object[]{10}, Emp.class);
//        for(Iterator it = rows.iterator();it.hasNext();){
//            Emp emp = (Emp) it.next();
//            System.out.println(emp);
//        }
        /*List rows = baseDao.getRows("select id,empno,ename,sal from emp", new Object[]{}, Emp.class);
        for(Iterator it = rows.iterator();it.hasNext();){
            Emp emp = (Emp) it.next();
            System.out.println(emp);
        }*/
        List rows = baseDao.getRows("select id,name,age,address from msb", new Object[]{}, Msb.class);
        for(Iterator it = rows.iterator();it.hasNext();){
            Msb msb = (Msb) it.next();
            System.out.println(msb);
        }


    }
}
