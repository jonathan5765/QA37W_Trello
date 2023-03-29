package tests;

import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{


    @Test
    public void boardCreation1() {
        Board board = Board.builder().title("qa37").build();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm(board);
        //app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreate();

        Assert.assertTrue(app.getBoard().isCreate());

        //app.getBoard().pause(2000);
        //app.getBoard().returnHomePage();

        //Assert
    }
        @Test
    public void BoardCreation2(){
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
            app.getBoard().initBoardCreationFromHeader();
            app.getBoard().fillInBoardCreationForm("qa37");
            //app.getBoard().scrollDownTheForm();
            app.getBoard().pause(2000);
            app.getBoard().submitBoardCreation();
            app.getBoard().pause(2000);
            app.getBoard().returnHomePage();
            app.getBoard().pause(2000);

            int boardCountAfterCreation = app.getBoard().getBoardCount();

            Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation+1);



    }
    @Test
    public void boardCreation3(){
        Board board = Board.builder().title("qa37new").build();
        app.getBoard().startBoardCreation();
        app.getBoard().fillInBoardCreationForm(board);
        //app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreate();

        Assert.assertTrue(app.getBoard().isCreate());
    }
    @Test
    public void refuseCreateBoard(){
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().closeCreationWindow();
    }
    @Test
    public void refuseCreateBoard2(){
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().returnToCreationPage();
    }

}
