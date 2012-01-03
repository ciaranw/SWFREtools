package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ShapeWithStyle4 structures.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyle4Parser {

	/**
	 * Parses a ShapeWithStyle4 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ShapeWithStyle4 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyle4Array lineStyles = LineStyle4ArrayParser.parse(parser, fieldName + "::LineStyles");
        final Shape4 shape = Shape4Parser.parse(parser, fieldName + "::Shape");

		parser.align();

		return new ShapeWithStyle4(fillStyles, lineStyles, shape);
	}
}