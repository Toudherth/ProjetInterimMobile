package com.example.myapplication;

import static org.junit.Assert.assertEquals;

import com.example.myapplication.util.Common.VacancyValidation;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class IT20133290_UnitTest {
    private static VacancyValidation vacancyValidation;
    private String name;
    private String password;
    private String email;
    private String tp;


    @BeforeClass
    public static void createObject(){
        vacancyValidation = new VacancyValidation();
    }

    @Before
    public void setup(){
        name = "";
        password = "";
        email = "";
        tp="";
    }

    @Test
    public void validEmail(){
        email = "asdSaa";
        boolean result = vacancyValidation.isEmailValid(email);
        assertEquals( "invalid email",false, result);
    }

    @Test
    public void validPassword(){
        password = "abc1234";
        boolean result = vacancyValidation.isPasswordValid(password);
        assertEquals( "invalid password",false,result);

    }

    @Test
    public void validName(){
        name = "";
        boolean result = vacancyValidation.isNameEmpty(name);
        assertEquals("empty name",true, result);
    }

    @Test
    public void validTp(){
        tp = "";
        boolean result = vacancyValidation.isTpValid("0812674985");
        assertEquals("valid tp number",true, result);

    }


    @After
    public void clear(){
       name = "";
       password = "";
       email = "";
       tp = "";
    }

    @AfterClass
    public static void clearAll(){
        vacancyValidation = null;
    }

}
