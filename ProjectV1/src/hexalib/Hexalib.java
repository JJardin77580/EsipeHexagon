package hexalib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;



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
	public static Coordinates cubetoHex(Point p){
		int q=(int)p.x;
		int r=(int)p.z;
		return new Coordinates(q, r);
	}

	/**
	 * Fonction qui converti les coordonnées axial en coordonnées cubique avec un EvenQ offset.
	 * @param p Point à convertir
	 * @return Coordinates : c'est à dire coordonnées en Q et R 
	 */

	public static Point HexToCube(double q,double r){
		double x =  q;
		double  z = r;
		double y = -x-z;
		return new Point(x,y,z);
	}


	public static Point PointRound(Point p){
		double rx = Math.round(p.x);
		double ry = Math.round(p.y);
		double rz = Math.round(p.z);
		double x_diff = Math.abs(rx - p.x);
		double y_diff = Math.abs(ry - p.y);
		double z_diff = Math.abs(rz - p.z);
		if ((x_diff > y_diff) && (x_diff > z_diff))
			rx = -ry-rz;
		else if (y_diff > z_diff)
			ry = -rx-rz;
		else
			rz = -rx-ry;
		return new Point((rx), (ry), (rz));
	}
	
	public static Coordinates PixelToCube(int x,int y,int size){
		 double q = (x * 2.0/3.0 / size*1.0);
		 double r = ((-x*1.0 / 3.0 + Math.sqrt(3)/3.0 * y*1.0) / size*1.0);
		return cubetoHex(PointRound(HexToCube(q, r)));
	}

	public interface HexaModel<T> {
		public int getMinQ();
		public int getMaxQ();
		public int getMinR();
		public int getMaxR();
		public T getData(int q, int r);
		public void addObserver(ModelObserver observer);
		public void setData(int q,int r,T data);
		
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

		public HexaModel<? extends T> getModel(){
			return this.model;
		}
		public void addHexagonView(int q, int r, HexagonView hexagonPanel){
			hexaviews.put(new Coordinates(q, r), hexagonPanel);
		}

	
		public HexagonView getHexagonView(int q,int r){
			return hexaviews.get(new Coordinates(q, r));
		}

		public void DrawGrid(Graphics2D g2){
			int lim=0;
			for (int q=model.getMinQ();q<=model.getMaxQ();q++) {
				{
					for(int r=model.getMinR();r<=model.getMaxR();r++){
						lim=q+r;
						if((lim>=model.getMinQ())&&(lim<=model.getMaxQ())){
						HexagonView views=hexaviews.get(new Coordinates(q, r));
						renderer.render(q, r, model.getData(q, r),views);
						views.drawHex(g2);
						}
					}
				}

			}
			
		}

		
		
		public T getDataForPixel(int x, int y) { 
			int s=renderer.getsize();
			Coordinates c=PixelToCube(x,y,s);
			return model.getData(c.q, c.r);

		}
	}

	public interface HexagonView {
		public void setColor(Color color);
		public void setEdge(Direction edge, Color color);
		public Color getColor();
		public Color getEdgeColot(Direction edge);
		public void setCx( int ... cx);
		public void setCy(int ... cy);
		public void drawHex(Graphics2D g2);
		public void setDataString(String s);
		public void setCenter(Point center);
		
	}

	public interface HexagonRenderer<T> {
		public void render(int q, int r, T data, HexagonView hexagonView);
		public int getsize();
		
	}
}
