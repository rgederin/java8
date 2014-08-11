package java8.lambdas.integration;

public class Main {
	public static void main(String[] args) {
		MathIntegrationUtils.printExpectedAnswer(10, 100, "x^2",
				"100^3/3 - 10^3/3", Math.pow(100, 3) / 3.0 - Math.pow(10, 3)
						/ 3.0);
		MathIntegrationUtils.integrationTest(x ->{return x*x;}, 10.0, 100.0);

				
		MathIntegrationUtils.printExpectedAnswer(50, 500, "x^3",
				"500^4/4 - 50^4/4", Math.pow(500, 4) / 4.0 - Math.pow(50, 4)
						/ 4.0);
		MathIntegrationUtils.integrationTest(x -> Math.pow(x, 3), 50, 500);

		
		MathIntegrationUtils.printExpectedAnswer(0, Math.PI, "sin(x)",
				"-cos(pi) - -cos(0)", -Math.cos(Math.PI) - -Math.cos(0));
		MathIntegrationUtils.integrationTest(x -> Math.sin(x), 0, Math.PI);

		
		MathIntegrationUtils.printExpectedAnswer(2, 20, "e^x", "e^20 - e^2",
				Math.pow(Math.E, 20) - Math.pow(Math.E, 2));
		MathIntegrationUtils.integrationTest(x -> Math.exp(x), 2, 20);
	}
}
