package org.charita.learning;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestClassOne extends BaseTest{


    public TestClassOne() throws IOException,FileNotFoundException
    {
        super();

    }

    @BeforeTest
    public void setUp() throws InterruptedException {
        launchBrowser();


    }

    @Test
    public void actualTest() throws InterruptedException, IOException {
        goToApp();
        searchProperty();
    }


    @AfterTest
    public void tearDown(){

        closeBrowser();
    }
}

