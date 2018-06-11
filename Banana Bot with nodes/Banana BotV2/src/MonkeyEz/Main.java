package MonkeyEz;

import MonkeyEz.Nodes.BankNode;
import MonkeyEz.Nodes.QuestNode;
import MonkeyEz.Nodes.SearchNode;
import MonkeyEz.Nodes.WalkNode;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(author = "MonkeyEz",category = Category.MONEYMAKING, description = "Dunno", version = 1.0,name = "Banana BotV2")
public class Main extends AbstractScript {
    private Node[] nodes;

    @Override
    public void onStart() {
        nodes = new Node[]{
                new QuestNode(this),
                new BankNode(this),
                new WalkNode(this),
                new SearchNode(this),
        };
    }

    @Override
    public int onLoop() {
        for (Node node : nodes) {
            if(node.validate()){
                return node.execute();
            }
        }

        log("No Node Valid");
        return 1000;
    }
}
