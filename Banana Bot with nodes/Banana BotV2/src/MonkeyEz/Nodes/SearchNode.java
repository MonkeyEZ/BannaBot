package MonkeyEz.Nodes;

import MonkeyEz.Main;
import MonkeyEz.Node;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.tabs.Tab;

public class SearchNode extends Node {
    public SearchNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        if (main.getLocalPlayer().isAnimating()) {
            int n = Calculations.random(1, 200);
            int add = Calculations.random(1, 9999);
            if (n == 1) {
                main.getCamera().rotateToYaw(Calculations.random(1, 400));
                main.getCamera().rotateToPitch(Calculations.random(1, 400));
            }
            if (n == 2) {
                main.getCamera().rotateToYaw(Calculations.random(1, 400));
                main.getCamera().rotateToPitch(Calculations.random(1, 400));
            }
            if (n == 3) {
                main.getCamera().rotateToYaw(Calculations.random(1, 400));
                main.getCamera().rotateToPitch(Calculations.random(1, 400));
            }
            if (n == 4) {
                main.getCamera().rotateToYaw(Calculations.random(1, 400));
                main.getCamera().rotateToPitch(Calculations.random(1, 400));
            }
            if (n == 5) {
                main.getTabs().open(Tab.STATS);
                Main.sleep(1000);
                main.getTabs().open(Tab.INVENTORY);
            }
            if (n == 6) {
                main.getTabs().open(Tab.EMOTES);
                Main.sleep(1000);
                main.getTabs().open(Tab.INVENTORY);
            }
            if (n == 7) {
                main.getKeyboard().type("11111111111111111111111111" + (add), true);
            }
            if (n == 8) {
                main.getKeyboard().type("......................................" + (add), true);
            }
            if (n == 9) {
                main.getKeyboard().type("2222222222222222222222222222222222222222222" + (add), true);
            }
            if (n == 10) {
                main.getKeyboard().type("                                      " + (add), true);
            }
        }
            return !main.getLocalPlayer().isAnimating();


    }

    @Override
    public int execute() {
        main.sleep(1000);
        main.getGameObjects().closest(p -> p != null && p.getID() == 2071).interact("Search");
        main.sleep(3400);
        main.getDialogues().chooseOption(1);

        return 1000;
    }

}
