package com.epam.home.pages;

import com.epam.home.model.Instance;
import com.epam.home.utils.StringParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends AbstractPage {

    public static Double totalEstimatedCost = null;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='tab-holder compute']")
    private WebElement computeEngineLink;

    @FindBy(xpath = "//input[@id='input_46']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//input[@id='input_47']")
    private WebElement whatAreTheseInstancesForField;

    @FindBy(xpath = "//*[@id='select_value_label_40']")
    private WebElement operationSystemDropDownList;

    @FindBy(xpath = "//*[@id='select_value_label_41']")
    private WebElement vmClassDropDownList;

    @FindBy(xpath = "//*[@id='select_value_label_42']")
    private WebElement instanceTypeDropDownList;

    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//*[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsDropDownList;

    @FindBy(xpath = "//*[@placeholder='GPU type']")
    private WebElement gpuTypeDropDownList;

    @FindBy(xpath = "//*[@id='select_value_label_43']")
    private WebElement localSSDDropDownList;

    @FindBy(xpath = "//*[@id='select_value_label_44']")
    private WebElement datacenterLocationDropDownList;

    @FindBy(xpath = "//*[@id='select_value_label_45']")
    private WebElement commitedUsageDropDownList;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//div[text()[contains(.,'VM class')]]")
    private WebElement vMClassInfo;

    @FindBy(xpath = "//div[text()[contains(.,'Instance type')]]")
    private WebElement instanceTypeInfo;

    @FindBy(xpath = "//div[text()[contains(.,'Region')]]")
    private WebElement regionInfo;

    @FindBy(xpath = "//div[text()[contains(.,'Total available local SSD space')]]")
    private WebElement totalAvailableLocalSSDSpaceInfo;

    @FindBy(xpath = "//div[text()[contains(.,'Commitment term')]]")
    private WebElement commitmentTermInfo;

    @FindBy(xpath = "//b[text()[contains(.,'Total Estimated Cost')]]")
    private WebElement totalEstimatedCostInfo;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//*[@id='fe_text']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//*[@class='cp-header']//iframe")
    private WebElement iframe;


    public CalculatorPage enterIntoFrame() {
        driver.switchTo().frame(waitForElement(iframe));
        logger.info("switching to frame");
        return this;
    }

    public CalculatorPage chooseComputerEngine() {
        waitUntilElementBeClicable(computeEngineLink).click();
        logger.info("Click on icon 'COMPUTE ENGINE'");
        return this;
    }

    public CalculatorPage inputNumberOfInstances(Instance instance) {
        waitUntilElementBeClicable(numberOfInstancesField).sendKeys(instance.getNumberOfInstances());
        logger.info("input 'Number of instances': " + instance.getNumberOfInstances());
        return this;
    }

    public CalculatorPage inputWhatAreTheseInstancesFor(Instance instance) {
        waitUntilElementBeClicable(whatAreTheseInstancesForField).sendKeys(instance.getWhatAreTheseInstancesFor());
        logger.info("input 'What are these instances for?': " + instance.getWhatAreTheseInstancesFor());
        return this;
    }

    public CalculatorPage chooseOperatingSystem(Instance instance) {
        String optionOperatingSystem = String.format("//md-option/div[text()='%s']", instance.getOperationSystem());
        waitUntilElementBeClicable(operationSystemDropDownList).click();
        logger.info("Click on drop down 'Operating System / Software'");
        waitUntilElementBeClicable(By.xpath(optionOperatingSystem)).click();
        logger.info("Choose 'Operating System / Software': " + instance.getOperationSystem());
        return this;
    }

    public CalculatorPage chooseVMClass(Instance instance) {
        String optionVMClass = String.format("(//md-option/div[text()='%s'])[2]", instance.getVMClass());
        waitUntilElementBeClicable(vmClassDropDownList).click();
        logger.info("Click on drop down 'VM Class'");
        waitUntilElementBeClicable(By.xpath(optionVMClass)).click();
        logger.info("Choose 'VM Class': " + instance.getVMClass());
        return this;
    }

    public CalculatorPage chooseInstanceType(Instance instance) {
        String optionInstanceType = String.format("//div[text()[contains(.,'%s')]]", instance.getInstanceType());
        waitUntilElementBeClicable(instanceTypeDropDownList).click();
        logger.info("Click on drop down 'Instance type'");
        waitUntilElementBeClicable(By.xpath(optionInstanceType)).click();
        logger.info("Choose 'Instance type': " + instance.getInstanceType());
        return this;
    }

    public CalculatorPage clickOnCheckboxAddGPUs() {
        waitUntilElementBeClicable(addGPUsCheckbox).click();
        logger.info("Click on checkbox 'Add GPUs'");
        return this;
    }

    public CalculatorPage chooseNumberOfGPU(Instance instance) {
        String optionGPU = String.format("//div[text()='%s']", instance.getNumberOfGPU());
        waitUntilElementBeClicable(numberOfGPUsDropDownList).click();
        logger.info("Click on drop down 'Number of GPUs'");
        waitUntilElementBeClicable(By.xpath(optionGPU)).click();
        logger.info("Choose 'Number of GPUs': " + instance.getNumberOfGPU());
        return this;
    }

    public CalculatorPage chooseGPUType(Instance instance) {
        String optionGPUType = String.format("//div[text()='%s']", instance.getGpuType());
        waitUntilElementBeClicable(gpuTypeDropDownList).click();
        logger.info("Click on drop down 'GPU type'");
        waitUntilElementBeClicable(By.xpath(optionGPUType)).click();
        logger.info("Choose 'GPU type': " + instance.getGpuType());
        return this;
    }

    public CalculatorPage chooseLocalSSD(Instance instance) {
        String optionLocalSSD = String.format("//div[text()='%s']", instance.getLocalSSD());
        waitUntilElementBeClicable(localSSDDropDownList).click();
        logger.info("Click on drop down 'Local SSD'");
        waitUntilElementBeClicable(By.xpath(optionLocalSSD)).click();
        logger.info("Choose 'Local SSD': " + instance.getLocalSSD());
        return this;
    }

    public CalculatorPage chooseDataCenterLocation(Instance instance) {
        String optionDataCentrLocation = String.format("//*[@id='select_option_196']/div[text()[contains(.,'%s')]]", instance.getDataCenterLocation());
        waitUntilElementBeClicable(datacenterLocationDropDownList).click();
        logger.info("Click on drop down 'Datacenter location'");
        waitUntilElementBeClicable(By.xpath(optionDataCentrLocation)).click();
        logger.info("Choose 'Datacenter location': " + instance.getDataCenterLocation());
        return this;
    }

    public CalculatorPage chooseCommitedUsage(Instance instance) {
        String optionCommitedUsage = String.format("(//div[text()='%s'])[2]", instance.getCommittedUsage());
        waitUntilElementBeClicable(commitedUsageDropDownList).click();
        logger.info("Click on drop down 'Commited usage'");
        waitUntilElementBeClicable(By.xpath(optionCommitedUsage)).click();
        logger.info("Choose 'Commited usage': " + instance.getCommittedUsage());
        return this;
    }

    public CalculatorPage clickButtonAddToEstimate() {
        waitUntilElementBeClicable(addToEstimateButton).click();
        logger.info("Click on button 'Add to Estimate'");
        return this;
    }

    public String getVmClass() {
        return vMClassInfo.getText();
    }

    public String getInstanceType() {
        return instanceTypeInfo.getText();
    }

    public String getRegion() {
        return regionInfo.getText();
    }

    public String getTotalAvailaleLocalSSDspace() {
        return totalAvailableLocalSSDSpaceInfo.getText();
    }

    public Double getTotalEstimatedCost() {
        return StringParser.getDoubleFromString(totalEstimatedCostInfo.getText());
    }

    public CalculatorPage totalEstimatedCost() {
        totalEstimatedCost = StringParser.getDoubleFromString(totalEstimatedCostInfo.getText());
        return this;
    }

    public CalculatorPage clickEmailEstimateButton() {
        waitUntilElementBeClicable(emailEstimateButton).click();
        return this;
    }

    public void openNewTab() {
        ((ChromeDriver) driver).executeScript("window.open()");
        logger.info("open new tab");
    }

    public void swithTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        logger.info("switching in new tab");
    }

    public MinutEmailPage sendLetter(String address) {
        String firstTab = driver.getWindowHandle();
        openNewTab();
        swithTab();
        String secondTab = driver.getWindowHandle();
        driver.get(address);
        logger.info("input address: " + address);
        String email = saveEmailAddress();
        driver.switchTo().window(firstTab);
        logger.info("switching in previous tab");
        enterIntoFrame();
        inputEmailAdderess(email);
        clickSendEmailButton();
        driver.switchTo().window(secondTab);
        logger.info("switching in new tab");
        return new MinutEmailPage(driver);
    }

    public String saveEmailAddress() {
        waitUntilElementBeClicable(emailAddress);
        return emailAddress.getAttribute("value");
    }

    public void inputEmailAdderess(String address) {
        waitUntilElementBeClicable(emailField).sendKeys(address);
        logger.info("input address: " + address);
    }

    public void clickSendEmailButton() {
        waitUntilElementBeClicable(sendEmailButton).click();
        logger.info("Click on button 'SEND EMAIL'");
    }
}