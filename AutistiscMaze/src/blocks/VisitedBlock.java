package blocks;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VisitedBlock extends Block {

	private static ArrayList<Integer> visitedBlockX = new ArrayList<Integer>();
	private static ArrayList<Integer> visitedBlockY = new ArrayList<Integer>();
	private static ArrayList<VisitedBlock> blocks = new ArrayList<VisitedBlock>();

	public VisitedBlock(int posX, int posY) {
		this.setVisible(false);
		Circle r = new Circle(15);
		r.setFill(Color.BLUE);
		this.setTranslateX(posX * Block.SIZE + Block.SIZE/2);
		this.setTranslateY(posY * Block.SIZE + Block.SIZE/2);
		visitedBlockX.add(posX);
		visitedBlockY.add(posY);
		blocks.add(this);
		Text t = new Text("( ͡° ͜ʖ ͡°)");
		t.setTranslateX(t.getTranslateX() - 16);
		t.setTranslateY(t.getTranslateY() + 4);
		t.setFont(new Font(12));
		t.setFill(Color.BLACK);
		this.getChildren().addAll(r, t);

	}

	public static ArrayList<Integer> visitedBlockX() {
		return visitedBlockX;
	}

	public static ArrayList<Integer> visitedBlockY() {
		return visitedBlockY;
	}

	public static void setVisible() {
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).setVisible(true);
		}
	}

}
