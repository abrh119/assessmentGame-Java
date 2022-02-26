package Main;
import java.util.Random;
/**
 * @author AbRh
 *
 */
public class GameFunction {

	private static Random ranNum;
	public int randomNumb1;
	public int randomNumb2;
	private String operand = " ";
	private static int[] threeNumbers;
	private static int[] endAnswers;
	public static boolean check;
	public boolean lastCheck;
	
	
	// Encapsulation, sensitive data hidden from users.
	

	public GameFunction() {
		chances();
		solution(); // checks solutions
	}

	public String getOperand() {
		return operand;
	}

	public int[] ranNumbers() { // generate random numbers from 0 to 9 with the base of 50

		int count = MainGUI.getCount();
		int[] numbers = new int[2];
		if (count < 5) {
			ranNum = new Random();
			numbers[0] = ranNum.nextInt(10);
			ranNum = new Random();
			numbers[1] = ranNum.nextInt(10);

		} else if (count < 10) {
			ranNum = new Random();
			numbers[0] = ranNum.nextInt(20);
			ranNum = new Random();
			numbers[1] = ranNum.nextInt(20);

		} else if (count < 15) {
			ranNum = new Random();
			numbers[0] = ranNum.nextInt(30);
			ranNum = new Random();
			numbers[1] = ranNum.nextInt(30);

		} else {
			ranNum = new Random();
			numbers[0] = ranNum.nextInt(50);
			ranNum = new Random();
			numbers[1] = ranNum.nextInt(50);
		}
		return numbers;
	}

	public static String operatorGen() { // generates the random operator from array and passes it down

		ranNum = new Random();
		int RanOp = ranNum.nextInt(4);

		String[] opSigns = { "+", "-", "*", "/" };
		String ans = "";

		switch (RanOp) {
		case 0:
			ans = opSigns[0];
			break;
		case 1:
			ans = opSigns[1];
			break;
		case 2:
			ans = opSigns[2];
			break;
		case 3:
			ans = opSigns[3];
			break;
		}

		return ans;
	}

	public int[] chances() { //generates random equations with 3 entities from above
		ranNum = new Random();

		endAnswers = new int[3];

		int ranNumb = ranNum.nextInt(2) + 1;

		int[] answer = new int[3];
		int[] ranNumbers = new int[3]; 
		ranNumbers = ranNumbers();
		operand = operatorGen();
		switch (ranNumb) {
	
		case 1:
			switch (operand) {
			case "+":
				answer[2] = ranNumbers[0] + ranNumbers[1];
				operand = "+";
				break;
			case "-":
				answer[2] = ranNumbers[0] - ranNumbers[1];
				operand = "-";
				break;
			case "*":
				answer[2] = (ranNumbers[0]) * ranNumbers[1];
				operand = "*";
				break;
			case "/":
				if (ranNumbers[1] == 0) {
					ranNumbers[1] += 1;

					answer[2] = ranNumbers[0] / ranNumbers[1];
				} else
					answer[2] = ranNumbers[0] / ranNumbers[1];
				operand = "/";
				break;
			}

			break;

		// equation generation
		case 2:
			switch (operand) {
			case "+":
				answer[2] = (ranNumbers[0]) + ranNumbers[1] + ranNum.nextInt(50);
				operand = "+";
				break;
			case "-":
				answer[2] = ranNumbers[0] - ranNumbers[1] + ranNum.nextInt(50);
				operand = "-";
				break;
			case "*":
				answer[2] = ranNumbers[0] * ranNumbers[1] + ranNum.nextInt(50);
				operand = "*";
				break;
			case "/":
				if (ranNumbers[1] == 0) {
				
					ranNumbers[1] += 1;
					answer[2] = ranNumbers[0] / ranNumbers[1];
				} else {
					answer[2] = ranNumbers[0] / ranNumbers[1];
				}

				operand = "/";
				break;
			}
			break;
		}
		answer[0] = ranNumbers[0];
		answer[1] = ranNumbers[1];

		endAnswers = answer;

		return answer;
	}

	public int[] getendAnswers() {
		
		return endAnswers;
	}

	public boolean solution() {

		int[] solutionsNumbers = new int[3];
		int[] numbers = getendAnswers();

		threeNumbers = new int[3];
		threeNumbers = numbers;
		solutionsNumbers = threeNumbers;

		int numb1 = solutionsNumbers[0];
		int numb2 = solutionsNumbers[1];
		int solution = solutionsNumbers[2]; // assigns 3 elements each from final answers

		boolean answer = false;

		switch (operand) {
		case "+":
			answer = (numb1 + numb2) == solution;
			break;
		case "-":
			answer = (numb1 - numb2) == solution;
			break;
		case "*":
			answer = (numb1 * numb2) == solution;
			break;
		case "/":
			answer = (numb1 / numb2) == solution;
			break;
		}
	
		check = answer;
		return answer;
	}
// bool to check answer
	public static boolean checkAnswer() {
		return check;
	}


}