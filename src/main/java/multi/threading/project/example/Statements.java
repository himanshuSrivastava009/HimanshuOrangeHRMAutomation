package multi.threading.project.example;

public class Statements {

	private String effect;
	private String action;
	private String resource;
	
	public Statements() {
		
	}

	public Statements(String effect, String action, String resource) {
		super();
		this.effect = effect;
		this.action = action;
		this.resource = resource;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}
