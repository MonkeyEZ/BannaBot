package MonkeyEz.Nodes;

import MonkeyEz.Main;
import MonkeyEz.Node;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.quest.Quest;
import org.dreambot.api.wrappers.items.GroundItem;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class QuestNode extends Node {
    private final Area Pirate_Area = new Area(3054,3248,3048,3245);
    private final Area Rune_Area = new Area(3012,3257,3015,3260);
    private final Area BlueMen_Area = new Area(3023,3222,3028,3214);
    private final Area Karam_Area = new Area(2959,3146,2953,3151);
    private final Area Beer_Area = new Area(2930,3147,2918,3142);
    private final Area Banana_Area = new Area(2925,3170,2915,3166);
    private final Area Job1_Area = new Area(2935,3156,2941,3152);
    private final Area Crate_Area = new Area(2941,3150,2942,3151);
    private final Area Apron_Area = new Area(3016,3228,3016,3227);
    private final Area Last_Area = new Area(3012,3203,3016,3209);
    public int n = 0;
    public QuestNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return (!main.getQuests().isStarted(Quest.PIRATES_TREASURE) || n == 1 || n == 2 || n == 3 || n == 4  || n == 5 || n == 6  || n == 7 || n == 8  || n == 9 || n == 10 || n == 11);
    }

    @Override
    public int execute() {
        if (!main.getInventory().contains(995) && n == 0 && !Rune_Area.contains(main.getLocalPlayer())) {
            //walk to rune shop and sell all runes
            main.getWalking().walk(Rune_Area.getRandomTile());
        }
        if (main.getInventory().contains(557) && n == 0 && Rune_Area.contains(main.getLocalPlayer())) {
            main.getNpcs().closest("Betty").interact("Trade");
            WidgetChild Open = main.getWidgets().getWidgetChild(300,1);
            if (Open.isVisible()) {
                main.getShop().sellFifty(556);
                main.getShop().sellFifty(555);
                main.getShop().sellFifty(558);
                main.getShop().sellFifty(559);
                main.getShop().sellFifty(557);
            }
        }

        if (!Pirate_Area.contains(main.getLocalPlayer()) && main.getInventory().contains(995,60) && n == 0 ) {
            main.getWalking().walk(Pirate_Area.getRandomTile());
        }
        if (Pirate_Area.contains(main.getLocalPlayer()) && !main.getQuests().isStarted(Quest.PIRATES_TREASURE )&& main.getInventory().contains(841)) {
                n = 1;
            }

        if (n==1){
            main.getNpcs().closest("Redbeard Frank").interact("Talk-to");
            main.sleep(Calculations.random(10000, 22222));
            main.getDialogues().clickContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().chooseOption(1);
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().spaceToContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().spaceToContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().clickContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().clickContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().clickContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().chooseOption(1);
            main.sleep(Calculations.random(2437, 4281));
            main.getInventory().drop(841);
            n = 2;
            }
        if (n==2) {
            main.getWalking().walk(BlueMen_Area.getRandomTile());
        }
        if (BlueMen_Area.contains(main.getLocalPlayer()) && !main.getInventory().contains("Banana")) {
            n = 3;
        }
        if (n==3 && Karam_Area.contains(main.getLocalPlayer())) {
            n = 4;
        }
        if (n==3) {
            main.getNpcs().closest("Captian Tobias","Seaman Lorris","Seaman Thresnor").interact("Pay-fare");
            if (main.getDialogues().inDialogue()) {
                main.sleep(Calculations.random(6437, 8281));
                main.getDialogues().spaceToContinue();
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().chooseOption(1);
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().spaceToContinue();
                main.sleep(15000);
                main.getGameObjects().closest("Gangplank").interact("Cross");
                main.sleep(Calculations.random(2437, 4281));
            }
        }

        if (n == 4 && !Beer_Area.contains(main.getLocalPlayer())) {
            main.getWalking().walk(Beer_Area.getRandomTile());
        }
        if (n == 4 && Beer_Area.contains(main.getLocalPlayer())) {
            main.getNpcs().closest("Zambo").interact("Trade");
            WidgetChild Beer = main.getWidgets().getWidgetChild(300,1);
            if (Beer.isVisible()) {
                main.getShop().purchaseOne(431);

            }
            if (main.getInventory().contains(431)) {
                n = 5;
            }
        }
        if (n == 5  && !Banana_Area.contains(main.getLocalPlayer())) {
            main.getWalking().walk(Banana_Area.getRandomTile());
        }
        if (n == 5  && Banana_Area.contains(main.getLocalPlayer())) {
            main.getGameObjects().closest(2073,2074,2075,2076,2077).interact("Pick");
        }
        if (n == 5 && main.getInventory().isFull()) {
            n = 6;
        }
        if (n==6 && !Job1_Area.contains(main.getLocalPlayer())) {
            main.getWalking().walk(Job1_Area.getRandomTile());
        }
        if (n == 6 && Job1_Area.contains(main.getLocalPlayer())) {
            main.sleep(5000);
            main.getNpcs().closest("Luthas").interact("Talk-to");
            if (main.getDialogues().inDialogue()) {
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().chooseOption(1);
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().spaceToContinue();
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 4281));
                n = 7;
            }
        }
        if (n == 7 && !Crate_Area.contains(main.getLocalPlayer())) {
            main.getWalking().walk(Crate_Area.getRandomTile());
        }
        if (n == 7 && Crate_Area.contains(main.getLocalPlayer())) {
            main.getGameObjects().closest("Crate").interact("Fill");
            main.sleep(Calculations.random(2437, 4281));
            main.getInventory().interact("Karamjan rum","Use");
            main.sleep(Calculations.random(2437, 4281));
            main.getGameObjects().closest("Crate").interact("Use");
            main.sleep(Calculations.random(2437, 4281));
            n = 8;
        }
        if (n==8 && !Job1_Area.contains(main.getLocalPlayer())) {
            main.getInventory().drop(431);
            main.sleep(Calculations.random(5437, 8281));
            main.getWalking().walk(Job1_Area.getRandomTile());
        }
        if (n == 8 && Job1_Area.contains(main.getLocalPlayer())) {
            main.sleep(Calculations.random(5437, 7281));
            main.getNpcs().closest("Luthas").interact("Talk-to");
            main.sleep(Calculations.random(12437, 17281));
            main.getDialogues().spaceToContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().spaceToContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().spaceToContinue();
            main.sleep(Calculations.random(2437, 4281));
            n = 9;
        }
        if (n == 9 && !Karam_Area.contains(main.getLocalPlayer())) {
            main.getWalking().walk(Karam_Area.getRandomTile());
        }
        if (n == 9 && Karam_Area.contains(main.getLocalPlayer())) {
            main.getNpcs().closest("Customs officer").interact("Pay-Fare");
            if (main.getDialogues().inDialogue()) {
                main.sleep(Calculations.random(5437, 7281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().chooseOption(1);
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 3281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 3281));
                main.getDialogues().chooseOption(2);
                main.sleep(Calculations.random(2437, 3281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 3281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(2437, 3281));
                main.getDialogues().chooseOption(1);
                main.sleep(Calculations.random(2437, 4281));
                main.getDialogues().clickContinue();
                main.sleep(Calculations.random(8437, 11281));
                main.getGameObjects().closest("Gangplank").interact("Cross");
                main.sleep(Calculations.random(5437, 7281));
                n = 10;
            }
        }

        if (n== 10 && !Apron_Area.contains(main.getLocalPlayer())) {
            main.getWalking().walk(Apron_Area.getRandomTile());
        }
        if (n== 10 && Apron_Area.contains(main.getLocalPlayer())) {
            main.getCamera().rotateTo(227,0);
            GroundItem White = main.getGroundItems().closest("White apron");
            White.interact("Take");
            main.sleep(Calculations.random(5437, 7281));
            main.getInventory().interact("White apron", "Wear");
            n = 11;
        }
        if (n==11 && !Last_Area.contains(main.getLocalPlayer())) {
            main.getWalking().walk(Last_Area.getRandomTile());
        }
        if (n==11 && Last_Area.contains(main.getLocalPlayer())) {
            main.getNpcs().closest("Wydin").interact("Talk-to");
            main.sleep(Calculations.random(8437, 11281));
            main.getDialogues().clickContinue();
            main.sleep(Calculations.random(2437, 3281));
            main.getDialogues().chooseOption(4);
            main.sleep(Calculations.random(2437, 3281));
            main.getDialogues().clickContinue();
            main.sleep(Calculations.random(2437, 3281));
            main.getDialogues().clickContinue();
            main.sleep(Calculations.random(2437, 3281));
            main.getDialogues().spaceToContinue();
            main.sleep(Calculations.random(2437, 4281));
            main.getDialogues().spaceToContinue();
            main.sleep(Calculations.random(2437, 4281));

            n = 0;
        }
        return 2000;
    }
}
