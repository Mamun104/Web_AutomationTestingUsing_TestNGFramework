package utils;

import com.github.javafaker.Faker;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Login;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Utils {
    private String firstName;
    private String lastName;
    public static void scrollDown(WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,3000)");
    }
    public static int generateRandomNumber(int min, int max){

        int number = (int)Math.floor(Math.random()*(max-min)+min);

        return  number;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void generateRandomData(){

        Faker faker = new Faker();

        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());

        //String fName =  faker.name().firstName();
        //String lName =  faker.name().lastName();
    }

    public void saveJsonList(String userName, String password) throws IOException, ParseException {

        String fileName = "./src/test/resources/Users.json";

        JSONParser jsonParser = new JSONParser();// parser er kaj hosshe file name ka parse kore niye asha

        Object obj =  jsonParser.parse(new FileReader(fileName));// file read korar karon holo json file take object a convert korve
        JSONArray jsonArray = (JSONArray) obj; // obj take json arry hishabe convert kora hoiche

        // normal object create kortechi

        JSONObject userObject = new JSONObject();
        userObject.put("userName", userName);
        userObject.put("password",password);

        // object take json arry er bitor add kore dite hobe

        jsonArray.add(userObject);

        // userobject ka save kora hoiche

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();

        System.out.println("Save data ");

    }

    // json file theke data read kora and niye ashaaa

    public static List readJSONArray(String firstName) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj =  jsonParser.parse(new FileReader(firstName));
        JSONArray jsonArray = (JSONArray) obj;

        return jsonArray;
    }
    public static void waitForElement(WebDriver driver, WebElement element, int TIME_UNIT_SECONDS){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_UNIT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
