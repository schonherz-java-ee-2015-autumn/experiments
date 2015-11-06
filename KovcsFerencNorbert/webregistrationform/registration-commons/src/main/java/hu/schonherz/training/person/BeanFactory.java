package hu.schonherz.training.person;

public class BeanFactory <T> {

	BeanParser<T> parser;

	public BeanFactory(BeanParser<T> parser) {
		super();
		this.parser = parser;
	}
	
	public T getInstance(){
		return parser.parse();
	}

}
