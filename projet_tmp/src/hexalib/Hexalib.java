package hexalib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;



// use axial coordinate (r, q)
// see http://www.redblobgames.com/grids/hexagons/
public interface Hexalib {
	public enum Direction {
		NORTH, NORTH_EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, NORTH_WEST
		;
		public int neighborQ(int q, int r) { return 0; }
		public int neighborR(int q, int r) { return 0; }
	}

	/**
	 * Fonction qui converti les coordonnées axial en coordonnées cubique	f.
	 * @param p Point à convertir
	 * @return Coordinates : c'est à dire coordonnées en Q et R 
	 */
	
	//JE ME SUIS PERMIS DE COMMENTER TON CODE POUR COMPILER ;) je te laisse le soin de le décommenter :)
	/*public static Coordinates cubetoHex(Point p){
		int q=p.x;
		int r=p.z;
		return new Coordinates(q, r);
	}

	/**
	 * Fonction qui converti les coordonnées axial en coordonnées cubique avec un EvenQ offset.
	 * @param p Point à convertir
	 * @return Coordinates : c'est à dire coordonnées en Q et R 
	 */
	/*public static Coordinates cubetoHexEvenQOffset(Point p){
		int q=p.x;
		int r=p.z + (p.x + (p.x&1)) / 2;
		return new Coordinates(q, r);
	}

	public static Point HexToCube(int q,int r){
		int x = q;
		int  z = r;
		int y = -x-z;
		return new Point(x,y,z);
	}


	public static Point PointRound(Point p){
		int rx = Math.round(p.x);
		int ry = Math.round(p.y);
		int rz = Math.round(p.z);
		int x_diff = Math.abs(rx - p.x);
		int y_diff = Math.abs(ry - p.y);
		int z_diff = Math.abs(rz - p.z);
		if ((x_diff > y_diff) && (x_diff > z_diff))
			rx = -ry-rz;
		else if (y_diff > z_diff)
			ry = -rx-rz;
		else
			rz = -rx-ry;
		return new Point(rx, ry, rz);
	}
	
	public static Coordinates PixelToCube(int x,int y,int size){
		 int q = x * 2/3 / size;
		 int r = (int) ((-x / 3.0 + Math.sqrt(3)/3 * y) / size);
		return cubetoHex(PointRound(HexToCube(q, r)));
	}*/

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
		HashMap<Coordinates, HexagonView> hexaviews=new HashMap<>();

		public HexaGridView(HexaModel<? extends T> model, HexagonRenderer<? super T> renderer) {
			this.model=model;
			this.renderer=renderer;
		}

		public void addHexagonView(int q, int r, HexagonView hexagonPanel){
			hexaviews.put(new Coordinates(q, r), hexagonPanel);
		}

	
		public HexagonView getHexagonView(int q,int r){
			return hexaviews.get(new Coordinates(q, r));
		}

		public void DrawGrid(Graphics2D g2){
			for (int q=model.getMinQ();q<=model.getMaxQ();q++) {
				{
					for(int r=model.getMinR();r<=model.getMaxR();r++){
						HexagonView views=hexaviews.get(new Coordinates(q, r));
						renderer.render(q, r, model.getData(q, r),views);
						views.drawHex(g2);
					}
				}

			}
			
		}

	/*	public T getDataForPixel(int x, int y) { 
			int s=renderer.getsize();
			Coordinates c=PixelToCube(x,y,s);
			return model.getData(c.q, c.r);


		}*/
	}

	public interface HexagonView {
		public void setColor(Color color);
		public void setEdge(Direction edge, Color color);
		public Color getColor();
		public Color getEdgeColor(Direction edge);
		public void setCx( int ... cx);
		public void setCy(int ... cy);
		public void drawHex(Graphics2D g2);
		
	}

	public interface HexagonRenderer<T> {
		public void render(int q, int r, T data, HexagonView hexagonView);
		public int getsize();
		
	}
}
