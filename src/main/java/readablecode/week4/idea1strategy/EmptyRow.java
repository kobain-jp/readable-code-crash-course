package readablecode.week4.idea1strategy;

import java.util.List;

public class EmptyRow extends RepeatedCharacterRow {

	public EmptyRow(List<String> headerRowCaptions) {
		super(headerRowCaptions, " ");
	}
}
