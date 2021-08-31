package readablecode.week4.idea1strategy;

import java.util.List;

public class SeparatorRow extends RepeatedCharacterRow {

	public SeparatorRow(List<String> headerRowCaptions) {
		super(headerRowCaptions, "-");
	}

}
