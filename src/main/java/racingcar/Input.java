package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static String[] carNames() {
		String[] CarNameArray = null;
		boolean right = true;
		while (right) {
			System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
			String Carstirng = Console.readLine();
			CarNameArray = StringToArray(Carstirng);
			try {
				right = exception(CarNameArray);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] �ڵ����̸��� 5�� ���Ͽ����Ѵ�.");
			}

		}
		return CarNameArray;
	}

	public static String[] StringToArray(String str) {
		String[] nameArray = str.split(",");

		for (int i = 0; i < nameArray.length; i++) {
			String name = nameArray[i];
			nameArray[i] = name.trim();
		}
		return nameArray;
	}

	public static boolean exception(String[] arr) throws IllegalArgumentException {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > 5 || arr[i].length() == 0) {
				throw new IllegalArgumentException("[ERROR] �ڵ����̸��� 5�� ���Ͽ����Ѵ�.");
			}
		}
		return false;
	}

	public static int tryCount() {
		int tryNumberInt;
		String tryNumberString = null;
		boolean check = false;

		while (!check) { // check�� ������ �� ��ȯ�� ������ ���?
			System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
			tryNumberString = Console.readLine();

			try {
				check = numberCheck(tryNumberString);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] �õ� Ƚ���� ���ڿ��� �Ѵ�.");
			}

		}
		tryNumberInt = Integer.parseInt(tryNumberString);
		return tryNumberInt;
	}

	private static boolean numberCheck(String str) throws IllegalArgumentException {
		boolean isNumber;
		if (str.chars().allMatch(Character::isDigit)) {
			isNumber = true;
			return isNumber;
		}
		throw new IllegalArgumentException("[ERROR] �õ� Ƚ���� ���ڿ��� �Ѵ�.");

	}
}
