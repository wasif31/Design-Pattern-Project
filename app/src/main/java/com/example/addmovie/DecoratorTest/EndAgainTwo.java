package  com.example.addmovie.DecoratorTest;

public class EndAgainTwo extends EndAgainText {
	
	public EndAgainTwo(iEndingText endText) {
		super(endText);
	}

	@Override
	public StringBuilder show() {
		return super.show().append(" and again");
	}

}
