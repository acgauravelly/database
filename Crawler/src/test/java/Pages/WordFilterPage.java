package Pages;

import org.junit.Assert;

/**
 * Created by ajay on 23/08/2017.
 */
public class WordFilterPage extends BasePage {

    public void navigatetoMOTpage(String url){
        goToUrl(url);

    }

    public void expandFeatures(){
        System.out.println("Features expanded\n");
    }


public void searchForWord(String word){
        if(pageSource().contains(word)){
            Assert.fail("The mobile page consists of the word ***" +word);
        }
}

public void testPrint(){
    System.out.println("Test Passed\n");
}
}
