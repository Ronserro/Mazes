package blocks;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClosedBlock extends Block{

	public ClosedBlock() {
		Rectangle r = new Rectangle(Block.SIZE, Block.SIZE);
		r.setFill(Color.BLACK);
		Text t = new Text("( ͡° ͜ʖ ͡°)");
		t.setTranslateX(t.getTranslateX()+3);
		t.setTranslateY(t.getTranslateY()+22);
		t.setFont(new Font(12));
		t.setFill(Color.WHITE);
		this.getChildren().addAll(r,t);
	}
	
}
