package readablecode.week4.idea1strategy;

import java.util.List;

public class HeaderRow implements Row {

	private List<String> captions;

	public HeaderRow(List<String> captions) {
		this.captions = captions;
	}

	@Override
	public String toString() {
		return "|" + String.join("|", captions) + "|" + System.lineSeparator();
	}

}
