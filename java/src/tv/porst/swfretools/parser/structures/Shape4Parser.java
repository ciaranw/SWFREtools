package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

import java.util.ArrayList;
import java.util.List;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;

/**
 * Parses Shape3 structure.
 * 
 * @author sp
 *
 */
public final class Shape4Parser {

	/**
	 * Parses a Shape3Record structure.
	 *
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 *
	 * @return The parsed structure.
	 *
	 * @throws tv.porst.swfretools.parser.SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Shape4 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UBits numFillBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final UBits numLineBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final List<ShapeRecord> shapeRecords = new ArrayList<ShapeRecord>();

		ShapeRecord shapeRecord = null;

		UBits currentNumFillBits = numFillBits;
		UBits currentNumLineBits = numLineBits;

		do {

			shapeRecord = ShapeRecord4Parser.parse(parser, currentNumFillBits, currentNumLineBits, fieldName + "::ShapeRecord");

			shapeRecords.add(shapeRecord);

			if (shapeRecord instanceof StyleChangeRecord4 && ((StyleChangeRecord4) shapeRecord).getStateNewStyles().value()) {
				currentNumFillBits = ((StyleChangeRecord4) shapeRecord).getNumFillBits();
				currentNumLineBits = ((StyleChangeRecord4) shapeRecord).getNumLineBits();
			}

		} while (!(shapeRecord instanceof EndShapeRecord));

		parser.align();

		return new Shape4(numFillBits, numLineBits, new Shape4RecordList(shapeRecords));
	}
}