package University;

public interface IService {

	default boolean nameValidation(String str) {
		String expression = "^[a-zA-Z']*$";
		return str.matches(expression);
	}

	

	default boolean numValidation(String str, int nums) {
		String expression = "^([0-9]{" + nums + "})$";
		return str.matches(expression);
	}



}
