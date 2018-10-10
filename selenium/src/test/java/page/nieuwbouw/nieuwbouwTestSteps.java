package page.nieuwbouw;

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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class nieuwbouwTestSteps {

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

    private static String nieuwbouw="//*[@id=\"content\"]/div[1]/div[3]/form/nav/ul/li[3]/ul/li[1]/a";
    private static String location="//*[@id=\"autocomplete-input\"]";
    private static String zoek_button="//*[@id=\"content\"]/div[1]/div[3]/form/div[1]/div/div/button ";


    /**
     * Open the url
     */
    @Given("^that I am an end cutomer$")
    public void i_am_end_customer() {
        driver.navigate().to(baseUrl);
    }

    /**
     *
     * go to the rent page
     */
    @Given("^I want to search a house of new construction$")
    public void i_want_to_search_house_for_rent() {
        WebElement huurButton = driver.findElement(By.xpath(nieuwbouw));
        huurButton.click();
    }

    /**
     *
     * Select the location
     * @param location
     */
    @Given("^I entered the location \"([^\"]*)\"$")
    public void i_entered_the_location(String location) {
        this.sleepTime(1000);
        WebElement locationId = driver.findElement(By.name("filter_location"));
        locationId.sendKeys(location);
        this.sleepTime(1000);
        WebElement firstOption = driver.findElement(By.id("autocomplete-list-option0"));
        firstOption.click();

    }

    /**
     * sleep method
     * @param i
     */
    private void sleepTime(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Seelct the distance
     * @param distance1
     */
    @Given("^select the distance \"([^\"]*)\" km$")
    public void select_the_distance(String distance1) {
        WebElement distancekm = driver.findElement(By.xpath("//*[@id=\"Straal\"]"));
        Select dropdown = new Select(distancekm);
        dropdown.selectByVisibleText("+ " + distance1 + " km");
    }

    /**
     *
     * Select the search page
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
    @Then("^I should be on the Nieuwbouw  page$")
    public void i_should_be_on_the_nieuwbouw_page() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.funda.nl/nieuwbouw/amsterdam/+1km/");
    }
}
