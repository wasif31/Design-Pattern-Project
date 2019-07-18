package  com.example.addmovie.DecoratorTest;

public class MainDecorator {
    
	
	public static void main (String[] args) {
                StringBuilder sb = new StringBuilder();
		iEndingText endTxt = new BasicText();
		sb = endTxt.show();
                System.out.println(sb);
		
		endTxt = new EndAgainText(new BasicText());
		sb = endTxt.show();
                System.out.println(sb.toString());
		
		endTxt = new EndAgainTwo(new EndAgainText(new BasicText()));
		sb = endTxt.show();
                System.out.println(sb);
	}

    

}
