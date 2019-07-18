package  com.example.addmovie.DecoratorTest;

public class DecoratorText implements iEndingText {
	
	private iEndingText endText;
        private StringBuilder sb = new StringBuilder();
	

	public DecoratorText(iEndingText endText) {
		this.endText = endText;
	}

    @Override
    public StringBuilder show() {
        return this.endText.show();
    }

	

}
