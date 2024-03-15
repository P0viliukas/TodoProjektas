package Pagedata;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodoPage extends Basepage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy(css = ".new-todo")
    private WebElement textToDoEnterField;

    @FindBy(css = ".todo-list label")
    private List<WebElement> todoListItem;
    @FindBy(css = ".toggle")
    private List<WebElement> buttonToggle;
    @FindBy(css = ".completed label")
    private List<WebElement> textToDoCompleted;
    @FindBy(css = ".destroy")
    private List<WebElement> buttonToDelete;
    @FindBy(css = ".main ul li")
    private List<WebElement> todoMainBody;
    @FindBy(css = ".toggle-all")
    private WebElement buttonToggleAll;
    @FindBy(css = ".clear-completed")
    private List<WebElement> buttonClearCompleted;
    @FindBy(css = ".todo-count strong")
    private WebElement todoItemsLeft;
    @FindBy(css = "a[href*='active']")
    private WebElement buttonFilterActive;
    @FindBy(xpath = "(//a[normalize-space()='Completed'])")
    private WebElement buttonFilterCompleted;
    @FindBy(css = "input,placeholder")
    private WebElement placeholder;
    @FindBy(xpath = "(//a[normalize-space()='All'])")
    private WebElement buttonFilterAll;


    public String getTodo(int nr) {
        return todoListItem.get(nr - 1).getText();
    }

    public void addTodo(String... txts) {
        for (String text : txts) {
            textToDoEnterField.sendKeys(text + Keys.ENTER);
        }
    }
    public void clickToggleButton(int nr){
        buttonToggle.get(nr-1).click();
    }
    public String getTodoCompleted(int nr) {
        return textToDoCompleted.get(nr-1).getText();
    }
    public void deleteTodo(int del){
        WebElement ele = buttonToggle.get(del-1);
        actions.moveToElement(ele).perform();
        buttonToDelete.get(del-1).click();
    }
        public int getTodosCount(){
        return todoMainBody.size();
}
    public void clickButtonToggleAll(){
        buttonToggleAll.click();
    }
    public void clickButtonClearCompleted(){
        buttonClearCompleted.get(0).click();
    }
    public int getButtonClearCompleted(){
        return buttonClearCompleted.size();
    }
    public String getTodoItemsLeft(){
        return todoItemsLeft.getText();
    }
    public void clickFilterActive(){
        buttonFilterActive.click();
    }
    public void clickFilterCompleted(){
        buttonFilterCompleted.click();
    }
    public String getPlaceholderText(){
        return placeholder.getAttribute("placeholder");
    }
    public void clickFilterAll(){
        buttonFilterAll.click();
    }

}
