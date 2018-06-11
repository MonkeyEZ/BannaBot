package MonkeyEz.Nodes;

import MonkeyEz.Main;
import MonkeyEz.Node;
import org.dreambot.api.methods.map.Tile;

public class BankNode extends Node {
    private static final Tile Deposit_Tile = new Tile(3045,3235);
    public BankNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return main.getInventory().isFull();
    }

    @Override
    public int execute() {
        main.getDepositBox().open();
        main.sleep(3400);
        if (main.getDepositBox().isOpen()) {
            main.getDepositBox().depositAllItems();
        }else {
            main.getWalking().walk(Deposit_Tile);
        }
        return 1000;
    }
}