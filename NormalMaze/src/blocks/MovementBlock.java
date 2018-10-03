package blocks;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import map.MapSolver;

public class MovementBlock extends Block {

	private static ArrayList<Integer> movementBlockX = new ArrayList<Integer>();
	private static ArrayList<Integer> movementBlockY = new ArrayList<Integer>();
	private static ArrayList<MovementBlock> blocks = new ArrayList<MovementBlock>();
	private int posY;
	private int posX;

	public MovementBlock(int startX, int startY, int posX, int posY) {
		this.setVisible(false);
		Circle r = new Circle(15);
		r.setFill(Color.YELLOW);
		this.setTranslateX(startX * Block.SIZE + Block.SIZE/2);
		this.setTranslateY(startY * Block.SIZE + Block.SIZE/2);
		movementBlockX.add(posX);
		movementBlockY.add(posY);
		this.posY = posY;
		this.posX = posX;
		blocks.add(this);
		this.getChildren().add(r);

	}

	public static void startAnimation() {
		AnimationTimer movementMove = new AnimationTimer() {

			private long timer = 0;

			@Override
			public void handle(long now) {
				try {
					if (now - timer >= 2_000_000_00) {
						MovementBlock mb = blocks.get(0);
						blocks.remove(0);
						mb.setVisible(true);

						TranslateTransition trans = new TranslateTransition(Duration.seconds(0.1), mb);
						trans.setFromX(mb.getTranslateX());
						trans.setToX(mb.posX * Block.SIZE + 17.5);
						trans.setFromY(mb.getTranslateY());
						trans.setToY(mb.posY * Block.SIZE + 17.5);
						trans.play();

						timer = now;
					}
				} catch (Exception e) {
					VisitedBlock.setVisible();
					MapSolver.score();
					this.stop();
				}

			}
		};
		movementMove.start();

	}

	public static ArrayList<Integer> movementBlockX() {
		return movementBlockX;
	}

	public static ArrayList<Integer> movementBlockY() {
		return movementBlockY;
	}

}
