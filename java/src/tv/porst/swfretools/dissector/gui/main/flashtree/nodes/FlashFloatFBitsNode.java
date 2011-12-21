package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.FloatFBits;

public class FlashFloatFBitsNode extends FlashTreeNode<FloatFBits> {

    public FlashFloatFBitsNode(String name, FloatFBits userObject) {
        super(name, userObject);
    }

    @Override
    public String toString() {
        return String.format("%s : FLOATFBITS (%f)", getName(), getUserObject().value());
    }
}
