package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Basket extends CommonFunctions {

    WebDriverWait wait = new WebDriverWait(driver, 10);
    @Given("I am on the Home Page {string}")
    public void homePage(String url)
    {
        driver.get(url);
        driver.manage().window().fullscreen();
        //WebElement searchBar = driver.findElement(By.xpath("//input[@class ='SearchBox open']"));
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='sli_search_1']")));
        Assert.assertTrue(searchBar.isDisplayed());
    }

    @When( "I enter item into the search bar {string}")
    public void enterSearchItem(String item)
    {
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='sli_search_1']"));
        searchBar.sendKeys(item);
    }

    @When ("I click on Search Item button")
    public void clickOnSearchButton()
    {
        driver.findElement(By.xpath("//input[@class='SearchButton']")).click();
    }

    @Then("I should be redirected to Item Listing Page with Title contains {string}")
    public void redirectedToItemListingPage(String expectedTitle)
    {
        String actualTitle = driver.getTitle();
        expectedTitle.contains(actualTitle);
    }

    @When ("I click on selected item")
    public void clickOnItem()
    {
        //WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Black Cap Sleeve Sports T-Shirt\"]")));
        //WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-label='Black Cap Sleeve Sports T-Shirt'/span[text()='Black Cap Sleeve Sports T-Shirt']")));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"i1\"]/section/div[1]/h2/a/span")));
        //*[@id="i1"]/section/div[1]/h2/a/span
        product.click();

        //driver.findElement(By.xpath("//a[@title='Embellished Star Charcoal Curved Hem T-Shirt (955639) | £18']")).click();
    }

    @Then ("I should be redirected to product description Page with Title contains {string}")
    public void redirectedToProductDescriptionPage(String expectedTitle)
    {
        String actualTitle = driver.getTitle();
        expectedTitle.contains(actualTitle);
    }

   @ When ("I select Size {string}")
    public void selectSize(String size)
   {

       WebElement eleSize = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Choose Size']")));
       eleSize.click();
       driver.findElement(By.xpath("//*[@id=\"dk_container_Size-841-451\"]/div/ul/li[3]/a")).click();
       //WebElement sizeList = driver.findElement(By.xpath("//ul[@class='dk_options_inner']"));
       //sizeList.getText().equals(size);
       /*List <WebElement> allSuggestions = driver.findElements(By.xpath("//ul[@class='dk_options_inner']"));
       for (WebElement suggestion : allSuggestions)
       {
           if (suggestion.getText().equals(size))
               suggestion.click();


       }*/

       //*[@id="dk_container_Size-841-451"]/div/ul/li[3]/a/text()
      // Select selectSize = new Select(driver.findElement(By.xpath("//a[text()='Choose Size']")));
       //selectSize.selectByVisibleText(size);
   }
   @When ("I click on Add to Bag button")
    public void clickOnAddToBagButton()
   {
       //driver.findElement(By.xpath("//a[text()='Add To Bag']")).click();
       WebElement addT0Bag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add To Bag']")));
       addT0Bag.click();
   }

    @When ("I click on the Basket")
    public void clickOnBasket()
    {
        driver.findElement(By.xpath("//a[@data-link-name='Shopping Bag']")).click();
    }
   @Then ("I should see that item {string} of size {string} is added into the basket")
    public void verifyItemAddedToBasket(String expectedItem, String expectedSize)
   {
       String actualItem = driver.findElement(By.xpath("//span[@class='itemDesc']")).getText();
       expectedItem.contains(actualItem);
       String actualSize = driver.findElement(By.xpath("//span[@class='itemSize']")).getText();
       expectedSize.contains(actualSize);
   }


}
