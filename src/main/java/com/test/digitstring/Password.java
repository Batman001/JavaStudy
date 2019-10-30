package com.test.digitstring;


/**
 * Created by Batman on 2018/7/5.
 */
public class Password {
    private String passwrd;
    private Password(String passwrd){
        this.passwrd = passwrd;
    }


    private static class PasswordCreate{
        private static final Password INSTANCE = new Password(CombineTest.randomString(3));
    }

    public static final Password getInstance(){
        return PasswordCreate.INSTANCE;
    }

    public String getPassword(){
        return passwrd;
    }

    public boolean test(String string){
        boolean result = false;
        if(passwrd == string){
            result = true;
        }
        return result;
    }

}
