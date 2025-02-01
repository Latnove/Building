public class Main {
	public static void main(String[] args) {
		int count = 0;
		
		for (int i = 0; i < 1000; i++) {
			Building building = new Building();
			if (building.startBuilding()) 
				count++;
		}

		double rate = (double) count / 1000 * 100;
    System.out.printf("Процент успешного завершения: " + rate);
	}
}
