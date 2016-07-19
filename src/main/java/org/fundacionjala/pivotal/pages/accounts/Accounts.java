package org.fundacionjala.pivotal.pages.accounts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.pages.dashboard.ToolBar;
import org.fundacionjala.pivotal.pages.login.BasePage;

/**
 * This class represents Account page and its characteristics.
 * Created by brunobarrios on 7/15/2016.
 */
public class Accounts extends BasePage {

    private Logger LOGGER = Logger.getLogger(Accounts.class.getName());

    private ToolBarAccount toolBarAccount;

    @FindBy(id = "notice")
    private WebElement deleteAccountMessage;

    @FindBy(xpath = "//a[contains(.,'Manage Account')]")
    private WebElement manageAccountBtn;

    /**
     * This class instances a ToolBarAccount.
     */
    public Accounts() {
        toolBarAccount = new ToolBarAccount();
    }

    /**
     * This method is used to get into an Account properties and settings.
     *
     * @return ToolBarAccount
     */
    public ToolBarAccount manageAccount() {
        manageAccountBtn.click();
        return new ToolBarAccount();
    }

    /**
     * This method is used to catch the message that is diplayed after deleting an
     * account.
     *
     * @return the message of deleting an account.
     */
    public String getDeleteAccountMessage() {
        LOGGER.info("Message delete account " + deleteAccountMessage.getText());
        return deleteAccountMessage.getText();
    }

    public ToolBarAccount getToolBarAccount() {
        return toolBarAccount;
    }

    public ToolBar getToolBar() {
        return new ToolBar();
    }
}
