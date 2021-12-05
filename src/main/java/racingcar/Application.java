package racingcar;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		//

		String[] carNameArray = Input.carNames();

		// System.out.println(carNameArray.length); ���� üũ

		int tryNumber = Input.tryCount();

		Car[] carArray = new Car[carNameArray.length];

		for (int i = 0; i < carNameArray.length; i++) {
			carArray[i] = new Car(carNameArray[i]);
		}

		// ������
		for (int i = 0; i < tryNumber; i++) {
			for (int j = 0; j < carArray.length; j++) {
				int rand = carArray[j].randomNumber();
				carArray[j].positionMove(rand);
				carArray[j].visual();
			}
			System.out.println();
		}

		// ���� �����
		ArrayList<String> winers = finalWiner(carArray);
		System.out.print("���� ����� :");

		// �θ� �̻��ϰ�� �ۼ��ʿ�
		int index = 0;
		while (true) {
			System.out.print(winers.get(index));
			index++;
			if (index == winers.size()) {
				break;
			}
			System.out.print(", ");
		}

	}

	public static ArrayList<String> finalWiner(Car[] arr) {
		ArrayList<String> winers = new ArrayList<String>();
		int mx = 0;

		for (int i = 0; i < arr.length; i++) {
			int p = arr[i].getPosition();

			if (p == mx) {
				winers.add(arr[i].getName());
			}

			if (p > mx) {
				mx = p;
				winers.clear();
				winers.add(arr[i].getName());
			}
		}

		return winers;

	}

}
