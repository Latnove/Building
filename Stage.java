import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stage implements IStage {
	private final int price;
	private final String name;
	private final String startDate;
	private final String endDate;
	private Status status;
	public Stage next;
	public Stage prev;

	public Stage(String name, int price, String startDate, String endDate)  {
		this.name = name;
		this.price = price;
		checkDate(startDate);
		this.startDate = startDate;
		checkDate(endDate);
		this.endDate = endDate;
		this.status = Status.PLANNED;
	}


	@Override
	public Stage next() {
		return next;
	}

	@Override
	public Stage prev() {
		return prev;
	}

	@Override
	public void start() {
		this.status = Status.PROGRESS;
	}

	@Override
	public void stop() {
		this.status = Status.COMPLETED;
	}

	@Override
	public void reject() {
		this.status = Status.REJECTED;
	}

	public Status getStatus() {
		return this.status;
	}

	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	private void checkDate(String date) {
		Pattern pattern = Pattern.compile("[0-3][0-9]\\.[0-1][0-9]\\.[0-2][0-9][0-9][0-9]");
		Matcher matcher = pattern.matcher(date);
		if (!matcher.find()) {
			throw new WrongDateFormException("Неправильный формат даты: " + date);
		}
	} 
}