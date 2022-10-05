package clasur.falabella.pageobject;

import clasur.falabella.helper.UtilHelper;
import org.openqa.selenium.WebDriver;

public class SearchFalabellaPage extends BasePage{
    //Atributos
    private String inputId = "testId-SearchBar-Input";
    private String wordItem = "ps4";

    private String selectItemXPath = "/html/body/div[1]/div/div/div[1]/section[2]/div/div[2]/div[3]";
    //Constructor parecido  a googlePage
    public SearchFalabellaPage(WebDriver webDriver) {
        super(webDriver);
    }
    //Metodos con  sus Argumentos-->lo que recibe para que funcione el metodo

    public void viewDetailsItem(){
        UtilHelper.exploreByIdAndWaitIntro(this.webDriver, this.inputId, this.wordItem);
        UtilHelper.exploreByXPathAndWaitClick(this.webDriver, this.selectItemXPath);
    }
}
