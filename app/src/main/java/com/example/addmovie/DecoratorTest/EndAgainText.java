package  com.example.addmovie.DecoratorTest;

public class EndAgainText extends DecoratorText {

	public EndAgainText(iEndingText endText) {
		super(endText);
	}

	@Override
	public StringBuilder show() {

                return super.show().append(" again");
	}
	
	

}
