package  com.example.addmovie.DecoratorTest;

public class BasicText implements iEndingText {
    
        private StringBuilder sb = new StringBuilder();
    
	@Override
	public StringBuilder show() {
		sb.append("Welcome To Home");
                return sb;
		
	}

}
