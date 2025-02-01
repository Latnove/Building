import java.util.Random;

public class Building implements IBuilding {
	private Stage currentStage;

  public Building() {
		Project project = new Project();
		Foundation foundation = new Foundation();
    Walls walls = new Walls();
    Roof roof = new Roof();
    FinalStage finalStage = new FinalStage();

		project.next = foundation;
		foundation.prev = project;
    foundation.next = walls;
		walls.prev = foundation;
    walls.next = roof;
    roof.prev = walls;
    roof.next = finalStage;
    finalStage.prev = roof;

		this.currentStage = project;
	}

	@Override
	public boolean startBuilding() {
		Random random = new Random();

		while (currentStage != null) {
			currentStage.start();
			if (random.nextDouble() < 0.1) {
					currentStage.reject();
					if (currentStage.prev == null) {
						System.out.println("Отмена");
						return false;
					}
					currentStage = currentStage.prev();
			} else {
					currentStage.stop();
					currentStage = currentStage.next();
			}
		}

		endBuilding();
		return true;
	}

	@Override
	public void endBuilding() {
		System.out.println("Закончилась стройка");
	}
	
}
