package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Shape3Record;
import tv.porst.swfretools.parser.structures.Shape3RecordList;
import tv.porst.swfretools.parser.structures.Shape4Record;
import tv.porst.swfretools.parser.structures.Shape4RecordList;

/**
 * Node that represents a ShapeRecord3List object in the Flash tree.
 */
public final class FlashShapeRecord4ListNode extends FlashTreeNode<Shape4RecordList> {

	/**
	 * Creates a new node object
	 *
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShapeRecord4ListNode(final String name, final Shape4RecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Shape4Record shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : SHAPERECORDLIST", getName());
	}
}