package com.framework.uitests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepoTabTests extends BaseTestClass{

    String user = "kristinamarkova";
    String repoTab = "?tab=repositories";

    @BeforeEach
    void repoTabSetup() {
        // Open the browser at a specific URL - https://github.com/kristinamarkova?tab=repositories
        driver.get(BASE_URL + user + repoTab);
    }

    @AfterEach
    void localCleanup() {
        // Nothing to do here now, but maybe in the future?
    }

    @Test
    void repositoryCountIsCorrect() {
        // Act
        List<WebElement> repos =  driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // Assert
        assertEquals(5, repos.size());
    }

    @Test
    void searchRepositoryIsFunctional() {
        // Act
        String repoName = "setec-web-automation";
        driver.findElement(By.id("your-repos-filter")).sendKeys(repoName);

        String expectedMatchingRepoSearchValue = "1 result for repositories matching setec-web-automation";
        String actualMatchingRepoSearchValue = driver.findElement(By.className("user-repo-search-results-summary")).getText();

        // Assert
        assertEquals(expectedMatchingRepoSearchValue, actualMatchingRepoSearchValue);
    }
}
