package com.wpx.blog;







import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wpx.blog.dao.mapper.SysUserMapper;
import com.wpx.blog.dao.pojo.SysUser;
import com.wpx.blog.service.SysUserService;
import net.minidev.json.JSONUtil;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
public class test {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void test01(){
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm");
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //等价于now.toLocaleString()
        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        SimpleDateFormat myFmt4=new SimpleDateFormat("一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
        SimpleDateFormat myFmt5=new SimpleDateFormat("今年是yyyy，这个月是MM月了，今天是dd号啊");
        Date now=new Date();
//        System.out.println(myFmt.format(now));
//        System.out.println(myFmt1.format(now));
//        System.out.println(myFmt2.format(now));
//        System.out.println(myFmt3.format(now));
//        System.out.println(myFmt4.format(now));
//        System.out.println(myFmt5.format(now));
//        System.out.println(now.toString());
//        System.out.println(now.toGMTString());
//        System.out.println(now.toLocaleString());

        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        final int year = localDate.getYear();
        System.out.println(localDate);
        System.out.println(year);

        final ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

//        for (int i:
//             integers) {
//            System.out.println(i);
//
//        }

        final Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Arrays.asList("1");

        final long l = Long.parseLong("123456");

        System.out.println(l);


    }

    @Test
    public void test02(){

        final LambdaQueryWrapper<SysUser> sysUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysUserLambdaQueryWrapper.eq(SysUser::getId, "1404446129264832513");

        final List<SysUser> sysUsers = sysUserMapper.selectList(sysUserLambdaQueryWrapper);

       // System.out.println(sysUsers);

        final Class<int[]> aClass = int[].class;

        final String name = aClass.getSuperclass().getName();

        System.out.println(name);

    }
    @Test
    public void test03(){
//        int i=10.0;
//        float f=3.14;
//        char c="c";
//        Boolean b=null;


    }

    @Test
    public void test04(){
//        int i=10.0;
//        float f=3.14;
//        char c="c";
//        Boolean b=null;
//
//        String[] strs =new String{"a" "b" "c"};
//
//        String strs1[] ={"a" ,"b" ,"c"};
//
//        String[] strs2 =new String[]{"a","b" ,"c"};
//
//        String strs3[] =new String[]{"a","b","c"};
//
//        String[] strs4 ={"a" ,"b" ,"c"};


//        String[] strs =new String[3]{"a","b","c"};
//
//        String[] strs1 ={"a" ,"b" ,"c"};
//
//        String strs2[] ={'a','b' ,"c"};
//
//        String[] strs3 =new String{"a","b","c"};
//
//        String strs4[] =new String[]{"a" ,"b" ,"c"};



    }
}
