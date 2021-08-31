package readablecode.week4.idea1strategy;

import java.util.List;
import java.util.StringJoiner;

import com.google.common.base.Strings;

public class RepeatedCharacterRow implements Row {

	private List<String> headerRowCaptions;
	private String repeatedCharacter;

	public RepeatedCharacterRow(List<String> headerRowCaptions, String repeatedCharacter) {
		this.headerRowCaptions = headerRowCaptions;
		this.repeatedCharacter = repeatedCharacter;
	}

	@Override
	public String toString() {
		StringJoiner row = new StringJoiner("|", "|", "|" + System.lineSeparator());
		for (String caption : this.headerRowCaptions) {
			row.add(Strings.repeat(repeatedCharacter, caption.length()));
		}
		return row.toString();
	}
}
