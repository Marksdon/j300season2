package priv.xzc.season2.compara;

public class Demo2 {

	public static void main(String[] args) {
		String[] arr = {"a","adb","sdf","sdf"};
		
		
	}


	public static void sort(int [] arr){

		boolean sorted = false;
		int temp = 0;
		for(int i = arr.length; i > 0; i -- ){
			for(int j = 0; j+1 < i ; j ++){
				if (arr[j] > arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					sorted = true;
				}
			}
			if (!sorted) {
				break;
			}

		}

	}
}
