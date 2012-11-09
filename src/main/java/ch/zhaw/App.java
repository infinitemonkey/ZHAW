package ch.zhaw;

public class App {
	
	private static Init init;
	
    public static void main( String[] args ) {
    	start();
    }
    
    public static void start() {
    	init = new Init();
    }
    
    public static void restart() {
    	init.closeWindow();
    	init = null;
    	init = new Init();
    }
}
