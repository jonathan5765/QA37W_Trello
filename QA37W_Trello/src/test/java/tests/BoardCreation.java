package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{


    @Test
    public void boardCreation(){
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm("qa37");
        //app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreate();

        Assert.assertTrue(app.getBoard().isCreate());



    }
}
