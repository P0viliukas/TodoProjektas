import Pagedata.TodoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DataGenerator.getRandomQuote;

public class TodoTest extends BaseTest{
    TodoPage todoPage;

    @Test
    void userCanAddToDosAndCheckCompleted()  {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        String item3 = getRandomQuote();
        String item4 = getRandomQuote();
        todoPage.addTodo(item1,item2,item3,item4);
        todoPage.clickToggleButton(3);
        assertEquals(item3 ,todoPage.getTodoCompleted(1));



        assertEquals(item1, todoPage.getTodo(1));
        assertEquals(item2, todoPage.getTodo(2));
//        Assertions.assertEquals(item3, todoPage.getListItemText(3));
        assertEquals(item4, todoPage.getTodo(4));


    }
    @Test
    void userCanAddAndRemove()  {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        todoPage.addTodo(item1);
        todoPage.addTodo(item2);

        todoPage.deleteTodo(2);
        assertEquals(item1, todoPage.getTodo(1));
        assertEquals(1,todoPage.getTodosCount());
    }
    @Test
    void userCanClearCompleted() {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        todoPage.addTodo(item1);
        todoPage.addTodo(item2);

        todoPage.clickToggleButton(1);
        todoPage.clickButtonClearCompleted();
        assertEquals(1,todoPage.getTodosCount());
    }
    @Test
    void userCanSeeTodosLeft() {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        todoPage.addTodo(item1);
        todoPage.addTodo(item2);
        Assertions.assertEquals(todoPage.getTodosCount(),Integer.parseInt(todoPage.getTodoItemsLeft()));
        todoPage.clickToggleButton(2);
        Assertions.assertEquals(1,Integer.parseInt(todoPage.getTodoItemsLeft()));
        todoPage.deleteTodo(1);
        Assertions.assertEquals(0,Integer.parseInt(todoPage.getTodoItemsLeft()));

    }
    @Test
    void userCanFilter() {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        String item3 = getRandomQuote();
        todoPage.addTodo(item1,item2,item3);
        todoPage.clickFilterActive();
        Assertions.assertEquals(3,todoPage.getTodosCount());
        assertEquals(item1, todoPage.getTodo(1));
        assertEquals(item2, todoPage.getTodo(2));
        assertEquals(item3, todoPage.getTodo(3));
        todoPage.clickToggleButton(2);
        Assertions.assertEquals(2,todoPage.getTodosCount());
        assertEquals(item1, todoPage.getTodo(1));
        assertEquals(item3, todoPage.getTodo(2));
        todoPage.clickFilterCompleted();
        Assertions.assertEquals(1,todoPage.getTodosCount());
        assertEquals(item2, todoPage.getTodo(1));

    }
    @Test
    void todoEmpty() {
        todoPage = new TodoPage(driver);
        assertEquals(0, todoPage.getTodosCount());
    }
    @Test
    void placeholderText() {
        todoPage = new TodoPage(driver);
        Assertions.assertEquals("What needs to be done?",todoPage.getPlaceholderText());
    }
    @Test
    void userCanCompletedAll() {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        todoPage.addTodo(item1);
        todoPage.addTodo(item2);
        todoPage.clickButtonToggleAll();
        todoPage.clickFilterCompleted();
        assertEquals(item1, todoPage.getTodo(1));
        assertEquals(item2, todoPage.getTodo(2));
    }
    @Test
    void userCanUncompleteTodo() {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        todoPage.addTodo(item1);
        todoPage.addTodo(item2);
        todoPage.clickToggleButton(2);
        todoPage.clickFilterCompleted();
        assertEquals(1, todoPage.getTodosCount());
        todoPage.clickToggleButton(1);
        assertEquals(0, todoPage.getTodosCount());
        todoPage.clickFilterActive();
        assertEquals(item1, todoPage.getTodo(1));
        assertEquals(item2, todoPage.getTodo(2));


    }
    @Test
    void buttonClearCompleted() {
        todoPage = new TodoPage(driver);
        String item1 = getRandomQuote();
        String item2 = getRandomQuote();
        todoPage.addTodo(item1);
        todoPage.addTodo(item2);
        todoPage.clickToggleButton(2);
        assertEquals(1,todoPage.getButtonClearCompleted());
        todoPage.clickToggleButton(2);
        assertEquals(0,todoPage.getButtonClearCompleted());
    }
}
