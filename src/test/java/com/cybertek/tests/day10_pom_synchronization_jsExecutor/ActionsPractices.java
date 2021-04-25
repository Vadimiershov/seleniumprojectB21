package com.cybertek.tests.day10_pom_synchronization_jsExecutor;

import com.cybertek.utilities.BrowsersUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void p3_drag_and_drop(){
        //1.Go to	https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement cookieAgreeButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        BrowsersUtils.sleep(2);
        cookieAgreeButton.click();
        // 2.Drag	and	drop	the	small	circle	to	bigger	circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions action = new Actions(Driver.getDriver());
        BrowsersUtils.sleep(2);
        action.dragAndDrop(smallCircle,bigCircle).perform();

        // 3.Assert:	-Text	in	big	circle	changed to:	“You	did	great!"
        String expectedText = "You did great!";
       String actualText = bigCircle.getText();
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void p2_double_click_test(){

        //1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2


        // 4.Assert:	Text’s	“style”	attribute	value	co
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // 2.Switch	to	iframe.
        Driver.getDriver().switchTo().frame("iframeResult");
        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        // 3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(textToDoubleClick).perform();

        // 4.Assert:	Text’s	“style”	attribute	value	co
        String expected = "red";
        String actual = textToDoubleClick.getAttribute("style"); // will return attribute of style
        Assert.assertTrue(actual.contains(expected));



    }
   // @AfterMethod
    public void tearDownMethod(){
        BrowsersUtils.sleep(10);
        Driver.closeDriver();
    }



}
