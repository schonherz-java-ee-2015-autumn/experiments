package hu.schonherz.training.refresher;

public class RefreshRequestFactory {

	RefresherRequestGetter parser;
	
	public RefreshRequestFactory(RefresherRequestGetter parser) {
		this.parser = parser;
	}
	
	public RefreshRequest getInstance(){
		return parser.parseFromParameters();
	}

}
