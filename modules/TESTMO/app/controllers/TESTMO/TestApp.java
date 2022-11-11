package controllers.TESTMO;

import play.mvc.Controller;

public class TestApp extends Controller {
    public static void index(){
        System.out.println("xxxx");

        renderText("hello module");
    }
}
