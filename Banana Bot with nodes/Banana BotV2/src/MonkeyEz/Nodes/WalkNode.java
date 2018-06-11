package MonkeyEz.Nodes;

import MonkeyEz.Main;
import MonkeyEz.Node;

public class WalkNode extends Node {
    org.dreambot.api.methods.map.Area CrateArea = new org.dreambot.api.methods.map.Area(3011,3204,3010,3209);
    public WalkNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !CrateArea.contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
        main.getWalking().walk(CrateArea.getRandomTile());
        return 1000;
    }
}
