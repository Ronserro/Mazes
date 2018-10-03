package blocks;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
		this.getChildren().add(r);

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
