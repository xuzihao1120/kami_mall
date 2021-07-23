package com.kami.mall.java.comons;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangzi
 * @date 2021-07-07 4:35 PM
 */
    //java爬取电话号码
public class TelDemo {
    //java程序入口，main函数
    public static void main(String[]  args) {
        //将变量声明在外面，成为一个全局的，因为作用域的原因，防止finally里无法关流
        //如果在try里声明，就需要在try里关，但是如果运行失败，就关不了，finally里就不用担心
        BufferedReader br = null;
        PrintWriter pw = null;
        //目标网址的爬取，随意找的一个
        String path =  "https://cloud.tencent.com/developer/article/1607643";
        try {
            //创建一个url对象，一new一对象。
            URL url = new URL(path);
            //打开网络链接
            URLConnection urlconn =  url.openConnection();
            //创建一个指定的存储文件,后面的true表示如果文件存在，会在原文件基础上续写
            FileWriter fw = new  FileWriter("/Users/byai/test/tel.txt",true);
            //流
            //首先创建一个输入流
            InputStream is =  urlconn.getInputStream();
            //is是一个字节流，为了让我们的效率更高，将字节流转为字符流
            InputStreamReader isr = new  InputStreamReader(is);
            //因为网页上的是一行一行的，所以还需要将字符流转为包装的字符缓冲流
            br = new BufferedReader(isr);
            //精简的写法
            //BufferedReader br = new  BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            //创建一个缓冲字符输出流
            pw = new PrintWriter(fw);
            //定一个字符串来接收读取到的内容
            String str = null;
            //手机号的正则表达式,首先是1开头，然后是3456789的第二位，接下来后面9位没有要求,就用\d{9}表示，并且在Java里用\来转义
            String regex =  "1[3456789]\\d{9}";
            //将上面的正则表达式编译成一种可以用来比较的方法，模式
            Pattern p =  Pattern.compile(regex);
            //按行循环的去读取内容
            while ((str = br.readLine()) !=  null){
                //创建一个指定模式的匹配器
                Matcher m =  p.matcher(str);
                //循环匹配
                while (m.find()){
                    //使用输出流写到指定的位置,m.group把匹配到的转成字符串
                    pw.println(m.group());
                }
            }
//控制台提示完成
            System.out.println("获取完成!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关流，不要忘记了,释放资源
        finally {
            try {
                br.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


