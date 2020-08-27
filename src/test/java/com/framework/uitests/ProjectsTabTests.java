package com.framework.uitests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectsTabTests extends BaseTestClass {

    String user = "kristinamarkova";
    String projectsTab = "?tab=projects";

    @BeforeEach
    void projectsTabSetup() {
        // Open the browser at a specific URL - https://github.com/kristinamarkova?tab=projects
        driver.get(BASE_URL + user + projectsTab);
    }

    @AfterEach
    void localCleanup() {
        // Nothing to do here now, but maybe in the future?
    }

    @Test
    void sortProjectsIsFunctional() {
        // Act
        String sortedByNewest = "is:open sort:created-desc "; // The default sorting (by Newest)
        String sortedByOldest = "is:open sort:created-asc "; // What we will select (by Oldest)

        // Assert
        String sortedByNewestQuery = driver.findElement(By.id("query")).getAttribute("value");
        assertEquals(sortedByNewest, sortedByNewestQuery);

        // Act
        driver.findElement(By.className("select-menu-button")).click();
        driver.findElement(By.linkText("Oldest")).click();

        // Assert
        String sortedByOldestQuery = driver.findElement(By.id("query")).getAttribute("value");
        assertEquals(sortedByOldest, sortedByOldestQuery);
    }
}
