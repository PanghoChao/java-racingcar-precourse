package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	

	public static String[] carNames() {
		String[] CarNameArray;
		while(true) {
			System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
	    	String Carstirng = Console.readLine();
	    	CarNameArray = StringToArray(Carstirng);
	    	if(exception(CarNameArray))
	    	{
	    		break;
	    	}
	    	
		}
    	return CarNameArray;
	}


	
	public static String[] StringToArray(String str) {
		String[] nameArray = str.split(",");
		
		for (int i=0; i<nameArray.length; i++) {
			String name = nameArray[i];
			nameArray[i] = name.trim();
		} 
		return nameArray;
	}
	
	public static boolean exception(String[] arr) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i].length() > 5 || arr[i].length() == 0) {
				IllegalArgumentException errorMessage = new IllegalArgumentException("[ERROR] �ڵ����̸��� 5�� ���Ͽ����Ѵ�.");
		    	System.out.println(errorMessage); 
				return false;
			}
		}
		return true;
	}
	
	
	
	
	public static int tryCount(){
		int tryNumberInt;
		String tryNumberString;
		//boolean check = true;
		
		while(true) { // check�� ������ �� ��ȯ�� ������ ���?
			System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
			tryNumberString = Console.readLine();
	    	
	    	if(numberCheck(tryNumberString)) {
	    		tryNumberInt = Integer.parseInt(tryNumberString);
	    		break;
	    	}
	    	//�߸��� �Է� ���� �޽��� ���
	    	IllegalArgumentException errorMessage = new IllegalArgumentException("[ERROR] �õ� Ƚ���� ���ڿ��� �Ѵ�.");
	    	System.out.println(errorMessage); 
		}
		return tryNumberInt;
	}
	
	

   
   private static boolean numberCheck(String str){
   	if(str.chars().allMatch(Character::isDigit)){
   		return true;
   	}
   	return false;
   
   	
   }
}
