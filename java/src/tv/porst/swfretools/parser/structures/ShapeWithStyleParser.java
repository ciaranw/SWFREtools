package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ShapeWithStyle structures.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyleParser {

	/**
	 * Parses a ShapeWithStyle structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ShapeWithStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyleArray fillStyles = FillStyleArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyleArray lineStyles = LineStyleArrayParser.parse(parser, fieldName + "::LineStyle");
		final Shape shape = ShapeParser.parse(parser, fieldName + "::Shape");

		parser.align();

		return new ShapeWithStyle(fillStyles, lineStyles, shape);
	}
}