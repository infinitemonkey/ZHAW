package ch.zhaw;

public class Login {

	private IFDatenbank datenbank;
	
	public Login() {
		datenbank = new Datenbank();
	}
	
	public boolean doLogin() throws NullPointerException {
		if (datenbank == null) {
			throw new NullPointerException();
		}
		return datenbank.connectDB();
	}
	
	public IFDatenbank getDatenbank() {
		return datenbank;
	}

	public void setDatenbank(IFDatenbank datenbank) {
		this.datenbank = datenbank;
	}
	
}
