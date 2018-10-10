package page.europa;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class europaTestSteps {
    private WebDriver driver;
    private String baseUrl = "https://www.funda.nl";

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/pritisuri/qa-framework/framework/drivers/2.29-win64/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.quit();
    }

    private static String europa = "//*[@id=\"content\"]/div[1]/div[3]/form/nav/ul/li[3]/ul/li[3]/a";

    private static String zoek_button = "//*[@id=\"content\"]/div[1]/div[3]/form/div[1]/div/div/button ";

    /**
     *
     *As the end customer
     */
    @Given("^that I am an end cutomer$")
    public void i_am_end_customer() {
        driver.navigate().to(baseUrl);
    }

    /**
     *
     * Select the europe tab
     */
    @Given("^I want to search a house in europe$")
    public void i_want_to_search_house_in_europe() {
        WebElement europeButton = driver.findElement(By.xpath(europa));
        europeButton.click();
    }

    /**
     * select the land name
     * @param location
     */

    @Given("^I select the location \"([^\"]*)\"$")
    public void i_entered_the_location(String location) {
        List<WebElement> listOfOptions = (List<WebElement>) driver.findElements(By.name("filter_Land"));
        for (WebElement webElement : listOfOptions) {
            System.out.println(webElement.getText());
        }
    }

    /**
     *
     * Select the search button
     */
    @When("^I click on Zoek$")
    public void i_click_on_zoek() {
        WebElement searchButton = driver.findElement(By.xpath(zoek_button));
        searchButton.click();
    }

    /**
     *
     * Check the URL of the page
     */
    @Then("^I should be on the europa page$")
    public void i_should_be_on_the_europe_options_page() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.funda.nl/europe/heel-europa/");
    }
}
