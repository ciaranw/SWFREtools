package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Shape4;

/**
 * Node that represents a Shape3 object in the Flash tree.
 */
public final class FlashShape4Node extends FlashTreeNode<Shape4> {

	/**
	 * Creates a new node object
	 *
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShape4Node(final String name, final Shape4 value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("NumFillBits", getUserObject().getNumFillBits());
		addNode("NumLineBits", getUserObject().getNumLineBits());
		addNode("ShapeRecord", getUserObject().getShapeRecord());
	}

	@Override
	public String toString() {
		return String.format("%s : SHAPE", getName());
	}
}