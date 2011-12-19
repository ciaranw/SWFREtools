package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a ShapeWithStyle structure.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyle implements IFileElement {

	/**
	 * Array of fill styles.
	 */
	private final FillStyleArray fillStyles;

	/**
	 * Array of line styles.
	 */
	private final LineStyleArray lineStyles;


    /**
     * Shape record
     */
	private final Shape shape;

	/**
	 * Creates a new ShapeWithStyle object.
	 * 
	 * @param fillStyles Array of fill styles.
	 * @param lineStyles Array of line styles.
	 * @param shape Shape record.
	 */
	public ShapeWithStyle(final FillStyleArray fillStyles, final LineStyleArray lineStyles, final Shape shape) {

		this.fillStyles = fillStyles;
		this.lineStyles = lineStyles;
		this.shape = shape;

	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(fillStyles, lineStyles, shape);
	}

	@Override
	public int getBitPosition() {
		return fillStyles.getBitPosition();
	}

	/**
	 * Returns the array of fill styles.
	 *
	 * @return The array of fill styles.
	 */
	public FillStyleArray getFillStyles() {
		return fillStyles;
	}

	/**
	 * Returns the array of line styles.
	 *
	 * @return The array of line styles.
	 */
	public LineStyleArray getLineStyles() {
		return lineStyles;
	}

	/**
	 * Returns the shape.
	 *
	 * @return The shape.
	 */
	public Shape getShape() {
		return shape;
	}
}