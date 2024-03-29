package com.kami.mall.java.verificationCode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yangzi
 * @date 2021-07-08 2:16 PM
 */
public class VerificationCodeDemo {

//    @ResponseBody
//    @RequestMapping("/login")
//    public Msg Login(HttpServletRequest request, String name, String password){
//
//        //根据账号判断数据库中是否存在该用户
//        List<User> userList = userService.selectByNameForId(name);
//        //如果不存在该用户
//        if (userList.size() == 0) {
//            //返回登录页面
//            return Msg.error().add("errMsg", ErrEnum.NAME_LOGIN_ERROR.getErrorMessage());
//
//            //如果存在该用户
//        } else {
//
//            //获得登录失败的次数
//            int intMissNumber = userList.get(0).getMissNumber();
//
//            //因为不能有相同的用户名，所以该List<User>只有一个值，可以直接使用获得id值
//            int intUserId = userList.get(0).getId();
//
//            //获得该用户上一次登录的时间
//            Date dateLogin = userList.get(0).getMissTime();
//
//            //获得允许登录时间的字段:allow_time
//            Date dateAllowTime = userList.get(0).getAllowTime();
//
//            //获得当前时间
//            Date dateNow = new Date();
//
//            //根据账号和密码判断是否输入的都正确
//            int num = userService.selectByNamePassword(name,password);
//
//            //begin:对能否登录时间的判断
//
//            //如果该时间允许登录
//            //如果现在的时间大于允许登录的时间
//            if (dateAllowTime == null ||dateNow.getTime() > dateAllowTime.getTime()) {
//
//                //begin:对错误登录次数的判断
//                //判断错误次数是否大于等于3
//                if (intMissNumber >= 3 ) {
//                    //已经登录失败了三次及以上，锁定账号，不允许登录
//                    //允许登录的时间加2分钟
//                    logger.info("允许登录的时间没有加2分钟前是:"+dateAllowTime);
//                    Date dateAfterAllowTime = new Date(dateNow .getTime() + 120000);
//                    logger.info("允许登录的时间加2分钟后是:"+dateAfterAllowTime);
//                    //修改数据库中的miss_number错误记录的数目
//                    //把错误次数清0
//                    intMissNumber = 0;
//                    User user = new User();
//                    user.setId(intUserId);
//                    user.setMissNumber(intMissNumber);
//                    user.setAllowTime(dateAfterAllowTime);
//                    int intFlag = userService.updateByPrimaryKeySelective(user);
//                    logger.info("intFlag:"+intFlag);
//                    logger.info("222时间允许登录，但是错误次数超过三次！");
//                    return Msg.error().add("errMsg", ErrEnum.MISS_LOGIN_ERROR.getErrorMessage());
//
//                    //错误次数小于三次，可以登录
//                }else {
//
//                    //begin:对密码是否正确的判断
//                    //如果密码对了
//                    if (num != 0) {
//                        //把错误次数清0
//                        intMissNumber = 0;
//                        //记录最新登录的时间
//                        dateLogin = new Date();
//                        //记录最新的允许登录时间
//                        dateAllowTime = new Date();
//
//                        //修改数据库中的miss_number错误记录的数目
//                        User user = new User();
//                        user.setId(intUserId);
//                        user.setMissTime(dateLogin);
//                        user.setMissNumber(intMissNumber);
//                        user.setAllowTime(dateAllowTime);
//
//                        int intFlag = userService.updateByPrimaryKeySelective(user);
//                        logger.info("intFlag:"+intFlag);
//                        //把id保存进session，在后面的文章发表、评论发表时候会用到
//                        HttpSession session = request.getSession();
//                        session.setAttribute("intUserId", intUserId);
//
//                        //begin:拦截器所需
//                        session.setAttribute("userList", userList);
//                        //end:拦截器所需
//                        return Msg.success();
//
//                        //如果密码错了
//                    }else {
//                        //把错误次数+1
//                        intMissNumber = intMissNumber + 1;
//                        //修改数据库中的miss_number错误记录的数目
//                        User user = new User();
//                        user.setId(intUserId);
//                        user.setMissNumber(intMissNumber);
//                        int intFlag = userService.updateByPrimaryKeySelective(user);
//                        logger.info("密码错误的intFlag:"+intFlag);
//
//                        return Msg.error().add("errMsg", ErrEnum.PASSWORD_LOGIN_ERROR.getErrorMessage());
//                    }
//                    //end:对密码是否正确的判断
//                }
//                //end:错误登录次数的判断
//
//                //该时间不允许登录
//            }else {
//                logger.info("111对时间的判断结果：当前时间不允许登录!");
//                return Msg.error().add("errMsg", ErrEnum.ALLOW_LOGIN_ERROR.getErrorMessage());
//            }
//
//            //end:对能否登录时间的判断
//        }
//
//
//    }
//    //end:login方法
}
