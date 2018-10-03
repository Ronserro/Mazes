package map;

import java.util.ArrayList;
import blocks.GoalBlock;
import blocks.MovementBlock;
import blocks.OpenBlock;
import blocks.VisitedBlock;

public class MapSolver {
	private static int posX;
	private static int posY;
	private static int visitedbackwards;

	public static Map solveMap(Map map) {

		ArrayList<Integer> alredyMovedX = MovementBlock.movementBlockX();
		ArrayList<Integer> alredyMovedY = MovementBlock.movementBlockY();

		if (map.getBlock(posX, posY) instanceof GoalBlock) {
			MovementBlock.startAnimation();
			return map;
		}

		if (alredyMovedX.size() == 0 && alredyMovedY.size() == 0) {
			posX = map.getStartX();
			posY = map.getStartY();
			visitedbackwards = 2;
			MovementBlock b = new MovementBlock(posX, posY, posX, posY);
			map.getChildren().add(b);
		} else {

			boolean f;
			MovementBlock b;

			if (map.getBlock(posX + 1, posY) instanceof OpenBlock
					|| map.getBlock(posX + 1, posY) instanceof GoalBlock) {// Höger
				f = true;

				for (int j = 0; j < alredyMovedX.size(); j++) {

					if (alredyMovedX.get(j) == posX + 1 && alredyMovedY.get(j) == posY) {
						f = false;
					}
				}

				if (f == true) {
					posX++;
					visitedbackwards = 2;
					b = new MovementBlock(posX - 1, posY, posX, posY);
					map.getChildren().add(b);
					return solveMap(map);
				}

			}

			if (map.getBlock(posX, posY - 1) instanceof OpenBlock
					|| map.getBlock(posX, posY - 1) instanceof GoalBlock) {// Upp
				f = true;
				for (int j = 0; j < alredyMovedY.size(); j++) {

					if (alredyMovedY.get(j) == posY - 1 && alredyMovedX.get(j) == posX) {
						f = false;
					}
				}

				if (f == true) {
					posY--;
					visitedbackwards = 2;
					b = new MovementBlock(posX, posY + 1, posX, posY);
					map.getChildren().add(b);
					return solveMap(map);
				}

			}

			if (map.getBlock(posX, posY + 1) instanceof OpenBlock
					|| map.getBlock(posX, posY + 1) instanceof GoalBlock) {// Ner

				f = true;

				for (int j = 0; j < alredyMovedY.size(); j++) {

					if (alredyMovedY.get(j) == posY + 1 && alredyMovedX.get(j) == posX) {
						f = false;
					}
				}

				if (f == true) {
					posY++;
					visitedbackwards = 2;
					b = new MovementBlock(posX, posY - 1, posX, posY);
					map.getChildren().add(b);
					return solveMap(map);
				}

			}

			if (map.getBlock(posX - 1, posY) instanceof OpenBlock
					|| map.getBlock(posX - 1, posY) instanceof GoalBlock) {// Vänster
				f = true;

				for (int j = 0; j < alredyMovedX.size(); j++) {

					if (alredyMovedX.get(j) == posX - 1 && alredyMovedY.get(j) == posY) {
						f = false;

					}
				}

				if (f == true) {

					posX--;
					visitedbackwards = 2;
					b = new MovementBlock(posX + 1, posY, posX, posY);
					map.getChildren().add(b);
					return solveMap(map);
				}

			}

			posX = alredyMovedX.get(alredyMovedX.size() - visitedbackwards);
			posY = alredyMovedY.get(alredyMovedY.size() - visitedbackwards);
			visitedbackwards++;
			int tempPosX = (int) (alredyMovedX.get(alredyMovedX.size() - visitedbackwards + 2));
			int tempPosY = (int) (alredyMovedY.get(alredyMovedY.size() - visitedbackwards + 2));
			VisitedBlock r = new VisitedBlock(tempPosX, tempPosY);
			map.getChildren().add(r);

		}
		return solveMap(map);

	}

	public static void score() {
		ArrayList<Integer> alredyMovedX = MovementBlock.movementBlockX();
		ArrayList<Integer> alredyMovedY = MovementBlock.movementBlockY();
		ArrayList<Integer> alredyVisitedX = VisitedBlock.visitedBlockX();
		ArrayList<Integer> alredyVisitedY = VisitedBlock.visitedBlockY();
		for (int i = 0; i < alredyMovedX.size(); i++) {
			for (int j = 0; j < alredyVisitedX.size(); j++) {
				if (alredyVisitedX.get(j) == alredyMovedX.get(i) && alredyVisitedY.get(j) == alredyMovedY.get(i)) {
					alredyMovedX.remove(i);
					alredyMovedY.remove(i);
					i = 0;
				}
			}
		}

		System.out.println("Det tog " + alredyMovedX.size() + " Steg för algoritmen");

	}

}
