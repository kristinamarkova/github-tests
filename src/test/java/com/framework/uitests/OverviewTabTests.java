package com.framework.uitests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OverviewTabTests extends BaseTestClass{

    String user = "kristinamarkova";

    @BeforeEach
    void overviewTabSetup() {
        // Open the browser at a specific URL - https://github.com/kristinamarkova
        driver.get(BASE_URL + user);
    }

    @AfterEach
    void localCleanup() {
        // Nothing to do here now, but maybe in the future?
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {
        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(user, actualUserName);
    }

    @Test
    void repoLinkGoesToCorrectRepo() {
        // Act
        String repo = "gitCommandsPractice";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        String actualUrl = driver.getCurrentUrl();

        // Assert
        assertEquals(BASE_URL + "kristinamarkova/" + repo,actualUrl);
    }


//    @Test
//    void selectDateIsFunctional() {
//        // Act
//        //Cannot select a generic element
//        WebElement dateAugust10th = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]/svg/g/g[46]/rect[1]"));
//        dateAugust10th.click();
//
//        String expectedDateSelected = "August 13, 2020";
//        String actualDateSelected = driver.findElement(By.xpath("//*[@id=\"js-contribution-activity\"]/div[2]/div/h3")).getText();
//
//        // Assert
//        assertEquals(expectedDateSelected,actualDateSelected);
//    }
}
