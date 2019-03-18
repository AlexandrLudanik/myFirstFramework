package com.epam.home.pages;

import com.epam.home.model.Instance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {

    public static String totalEstimatedCost = null;
    WebDriverWait wait;

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

    @FindBy(xpath = "//md-option/div[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")
    private WebElement freeDebianCentOSCoreOSUbuntuOrOtherUserProvidedOSOption;

    @FindBy(xpath = "//*[@id='select_value_label_41']")
    private WebElement vmClassDropDownList;

    @FindBy(xpath = "//*[@id='select_option_60']/div[1]")
    private WebElement regularOption;

    @FindBy(xpath = "//*[@id='select_value_label_42']")
    private WebElement instanceTypeDropDownList;

    @FindBy(xpath = "//*[@id='select_option_70']/div[1]")
    private WebElement n1Standard8vCPUs8RAM30GbOption;

    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//*[@placeholder=\"Number of GPUs\"]")
    private WebElement numberOfGPUsDropDownList;

    @FindBy(xpath = "//div[text()='1']")
    private WebElement gpuOption;

    @FindBy(xpath = "//*[@placeholder=\"GPU type\"]")
    private WebElement gpuTypeDropDownList;

    @FindBy(xpath = "//div[text()='NVIDIA Tesla V100']")
    private WebElement nVIDIATeslaV100Option;

    @FindBy(xpath = "//*[@id='select_value_label_43']")
    private WebElement localSSDDropDownList;

    @FindBy(xpath = "//div[text()='2x375 GB']")
    private WebElement x2x375GbOption;

    @FindBy(xpath = "//*[@id='select_value_label_44']")
    private WebElement datacenterLocationDropDownList;

    @FindBy(xpath = "//*[@id='select_option_196']")
    private WebElement frankfurtEuropeWest3Option;

    @FindBy(xpath = "//*[@id='select_value_label_45']")
    private WebElement commitedUsageDropDownList;

    @FindBy(xpath = "//*[@id='select_option_100']")
    private WebElement yearOption;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[2]")
    private WebElement vMClassInfo;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[3]")
    private WebElement instanceTypeInfo;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[4]")
    private WebElement regionInfo;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[5]")
    private WebElement totalAvailableLocalSSDSpaceInfo;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[6]")
    private WebElement commitmentTermInfo;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[7]/div/b")
    private WebElement estimatedComponentCostInfo;

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b")
    private WebElement totalEstimatedCostInfo;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateButton;


    @FindBy(xpath = "//*[@id='mailAddress']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//[@id='ui-id-1']/span[@class='inc-mail-address']")
    private WebElement infoLineAboutLetter;

    @FindBy(xpath = "//*[@id=\"messagesList\"]")
    private WebElement incomingLetter;

    @FindBy(xpath = "//*[@id=\"mobilepadding\"]/td/table/tbody/tr[1]/td[1]/img")
    private WebElement logoInTable;

    @FindBy(xpath = "//table//td[2]/h3")
    private WebElement totalEstimatedMonthlyCostIneLetter;


    public CalculatorPage enterIntoFrame() {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='cp-header']//iframe")));
        logger.info("switching to frame");
        return this;
    }

    public CalculatorPage chooseComputerEngine() {
        getClickableElement(computeEngineLink).click();
        logger.info("Click on icon 'COMPUTE ENGINE'");
        return this;
    }

    public CalculatorPage inputNumberOfInstances(Instance instance) {
        getClickableElement(numberOfInstancesField).sendKeys(instance.getNumberOfInstances());
        logger.info("input 'Number of instances': " + instance.getNumberOfInstances());
        return this;
    }

    public CalculatorPage inputWhatAreTheseInstancesFor(Instance instance) {
        getClickableElement(whatAreTheseInstancesForField).sendKeys(instance.getWhatAreTheseInstancesFor());
        logger.info("input 'What are these instances for?': " + instance.getWhatAreTheseInstancesFor());
        return this;
    }


    public CalculatorPage chooseOperatingSystem(Instance instance) {
        String optionOperatingSystem = String.format("//md-option/div[text()='%s']", instance.getOperationSystem());
        getClickableElement(operationSystemDropDownList).click();
        logger.info("Click on drop down 'Operating System / Software'");
        getClickableElement(By.xpath(optionOperatingSystem)).click();
        logger.info("Choose 'Operating System / Software': " + instance.getOperationSystem());
        return this;
    }


    public CalculatorPage chooseVMClass(Instance instance) {
        String optionVMClass = String.format("(//md-option/div[text()='%s'])[2]", instance.getVMClass());
        getClickableElement(vmClassDropDownList).click();
        logger.info("Click on drop down 'VM Class'");
        getClickableElement(By.xpath(optionVMClass)).click();
        logger.info("Choose 'VM Class': " + instance.getVMClass());
        return this;
    }


    public CalculatorPage chooseInstanceType(Instance instance) {
        String optionInstanceType = String.format("//div[text()[contains(.,'%s')]]", instance.getInstanceType());
        getClickableElement(instanceTypeDropDownList).click();
        logger.info("Click on drop down 'Instance type'");
        getClickableElement(By.xpath(optionInstanceType)).click();
        logger.info("Choose 'Instance type': " + instance.getInstanceType());
        return this;
    }

    public CalculatorPage clickOnCheckboxAddGPUs() {
        getClickableElement(addGPUsCheckbox).click();
        logger.info("Click on checkbox 'Add GPUs'");
        return this;
    }


    public CalculatorPage chooseNumberOfGPU(Instance instance) {
        String optionGPU = String.format("//div[text()='%s']", instance.getNumberOfGPU());
        getClickableElement(numberOfGPUsDropDownList).click();
        logger.info("Click on drop down 'Number of GPUs'");
        getClickableElement(By.xpath(optionGPU)).click();
        logger.info("Choose 'Number of GPUs': " + instance.getNumberOfGPU());
        return this;
    }


    public CalculatorPage chooseGPUType(Instance instance) {
        String optionGPUType = String.format("//div[text()='%s']", instance.getGpuType());
        getClickableElement(gpuTypeDropDownList).click();
        logger.info("Click on drop down 'GPU type'");
        getClickableElement(By.xpath(optionGPUType)).click();
        logger.info("Choose 'GPU type': " + instance.getGpuType());
        return this;
    }

    public CalculatorPage chooseLocalSSD(Instance instance) {
        String optionLocalSSD = String.format("//div[text()='%s']", instance.getLocalSSD());
        getClickableElement(localSSDDropDownList).click();
        logger.info("Click on drop down 'Local SSD'");
        getClickableElement(By.xpath(optionLocalSSD)).click();
        logger.info("Choose 'Local SSD': " + instance.getLocalSSD());
        return this;
    }


    public CalculatorPage chooseDataCenterLocation(Instance instance) {
        String optionDataCentrLocation = String.format("//*[@id='select_option_196']/div[text()='%s']", instance.getDataCenterLocation());
        getClickableElement(datacenterLocationDropDownList).click();
        logger.info("Click on drop down 'Datacenter location'");
        getClickableElement(By.xpath(optionDataCentrLocation)).click();
        logger.info("Choose 'Datacenter location': " + instance.getDataCenterLocation());
        return this;
    }


    public CalculatorPage chooseCommitedUsage(Instance instance) {
        String optionCommitedUsage = String.format("(//div[text()='%s'])[2]", instance.getCommittedUsage());
        getClickableElement(commitedUsageDropDownList).click();
        logger.info("Click on drop down 'Commited usage'");
        getClickableElement(By.xpath(optionCommitedUsage)).click();
        logger.info("Choose 'Commited usage': " + instance.getCommittedUsage());
        return this;
    }

    public CalculatorPage clickButtonAddToEstimate() {
        getClickableElement(addToEstimateButton).click();
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

    public String getCommitmentTerm() {
        return commitmentTermInfo.getText();
    }

    public String getEstimatedComponentCost() {
        return estimatedComponentCostInfo.getText();
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCostInfo.getText();
    }

    public CalculatorPage totalEstimatedCost() {
        totalEstimatedCost = totalEstimatedCostInfo.getText().substring(22, 34);
        return this;
    }


    public CalculatorPage clickEmailEstimateButton() {
        getClickableElement(emailEstimateButton).click();
        return this;
    }

    public String nameTab() {
        return driver.getWindowHandle();
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

    public void setAddress(String address) {
        driver.get(address);

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
        return emailAddress.getAttribute("value");
    }

    public void inputEmailAdderess(String address) {
        getClickableElement(emailField).sendKeys(address);
        logger.info("input address: " + address);
    }

    public void clickSendEmailButton() {
        getClickableElement(sendEmailButton).click();
        logger.info("Click on button 'SEND EMAIL'");
    }


    public String getTotalEstimatedMonthlyCostFromLetter() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logoInTable));
        return totalEstimatedMonthlyCostIneLetter.getText().substring(0, 12);
    }

    public void clickOnIncomingLetter() {
        getClickableElement(infoLineAboutLetter).click();
    }

    public void switchTabString(String tab) {
        driver.switchTo().window(tab);
    }
}