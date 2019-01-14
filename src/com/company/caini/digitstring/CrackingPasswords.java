package com.company.caini.digitstring;
import java.lang.String;
/**
 * Created by Batman on 2018/7/5.
 */
public class CrackingPasswords {
    public static void main(String[] args){
        // 获取一个密码实例,获得密码
        Password psd = Password.getInstance();
        String passwordStr = psd.getPassword();
        System.out.printf("当前密码为:%s%n",passwordStr);

        String passwordstrs = CombineTest.init();
        char[] passwordCode = passwordstrs.toCharArray();

        char[] passwordTest = new char[3]; // 尝试输入的密码
        // 多层循环暴力寻找密码
        int count = 0;
        ID:
        for(int i=0; i<passwordCode.length; i++, count ++){
            passwordTest[0] = passwordCode[i];
            for(int j=0;j<passwordCode.length; j++, count++){
                passwordTest[1] = passwordCode[j];
                for (int z = 0;z<passwordCode.length; z++, count ++){
                    passwordTest[2] = passwordCode[z];
                    //System.out.println(String.valueOf(passwordTest));
                    // 密码实例调用检测方法,如果破解成功返回true;
                    if (psd.test(String.valueOf(passwordTest))) {
                        //System.out.println("尝试密码:" + String.valueOf(passwordTest));
                        //System.out.printf("登陆成功");
                        //System.out.printf("尝试了%d次%n", count);
                        break ID;   // 跳出标签
                    }
                    else{
                        //System.out.println("尝试密码:"+String.valueOf(passwordTest));
                        //System.out.println("密码错误");
                    }
                }
            }
        }
        System.out.printf("已经尝试了%d次%n",count);

    }
}
