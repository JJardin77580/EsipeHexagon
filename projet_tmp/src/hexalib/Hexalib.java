package hexalib;

import java.awt.Color;


// use axial coordinate (r, q)
// see http://www.redblobgames.com/grids/hexagons/
public interface Hexalib {
	public enum Direction {
		NORTH, NORTH_EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, NORTH_WEST
		;
		public int neighborQ(int q, int r) { return 0; }
		public int neighborR(int q, int r) { return 0; }
	}

	public interface HexaModel<T> {
		public int getMinQ();
		public int getMaxQ();
		public int getMinR();
		public int getMaxR();
		public T getData(int q, int r);

		public void addObserver(ModelObserver observer);
	}

	public interface ModelObserver {
		public void dataChanged(int q, int r);
	}

	public class HexaGridView<T> {


		HexaModel<? extends T> model;
		HexagonRenderer<? super T> renderer;
		public HexaGridView(HexaModel<? extends T> model, HexagonRenderer<? super T> renderer) {
			this.model=model;
			this.renderer=renderer;
		}

		public T getDataForPixel(int x, int y) { return null; }
	}

	public interface HexagonView {
		public void setColor(Color color);
		public void setEdge(Direction edge, Color color);
		public void setSize(int size);
		public Color getColor();
		public Color getEdgeColot(Direction edge);
		public int getSize();
		public void setCx( int ... cx);
		public void setCy(int ... cy);
		
	}

	public interface HexagonRenderer<T> {
		public void render(int q, int r, T data, HexagonView hexagonView);
	}
}
