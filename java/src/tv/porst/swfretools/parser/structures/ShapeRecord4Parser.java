package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ShapeRecord4 structures.
 * 
 * @author sp
 *
 */
public final class ShapeRecord4Parser {

	/**
	 * Parses a ShapeRecord4 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param numFillBits Number of bits for fill style values.
	 * @param numLineBits Number of bits for line style values.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ShapeRecord parse(final SWFBinaryParser parser, final UBits numFillBits, final UBits numLineBits, final String fieldName) throws SWFParserException {

		final UBits first6 = parser.peekBits(6);

		if (first6.value() == 0) {
			return EndShapeRecordParser.parse(parser, fieldName);
		}
		else if ((first6.value() & 0x30) == 0x30) {
			return StraightEdgeRecordParser.parse(parser, fieldName);
		}
		else if ((first6.value() & 0x20) == 0x20) {
			return CurvedEdgeRecordParser.parse(parser, fieldName);
		}
		else {
			return StyleChangeRecord4Parser.parse(parser, numFillBits, numLineBits, fieldName);
		}
	}
}