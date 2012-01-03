package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a ShapeWithStyle4 structure.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyle4 implements IFileElement {

	/**
	 * Array of fill styles.
	 */
	private final FillStyle3Array fillStyles;

	/**
	 * Array of line styles.
	 */
	private final LineStyle4Array lineStyles;

	/**
	 * Shape records.
	 */
	private final Shape4 shape;

	/**
	 * Creates a new ShapeWithStyle object.
	 * 
	 * @param fillStyles Array of fill styles.
	 * @param lineStyles Array of line styles.
	 * @param shape Shape records.
	 */
	public ShapeWithStyle4(final FillStyle3Array fillStyles, final LineStyle4Array lineStyles, final Shape4 shape) {

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
	public FillStyle3Array getFillStyles() {
		return fillStyles;
	}

	/**
	 * Returns the array of line styles.
	 *
	 * @return The array of line styles.
	 */
	public LineStyle4Array getLineStyles() {
		return lineStyles;
	}

	/**
	 * Returns the shape records.
	 *
	 * @return The shape records.
	 */
	public Shape4 getShape() {
		return shape;
	}
}