//VirtPlotGraphのサブクラスのSinVPGraphクラスを書く

public class SinVPGraph extends VirtPlotGraph{

	protected int t;

	public SinVPGraph(char symbol, int t){
		super(symbol);
		this.t = t;
	}

	public int getT(){ return t; }
	public void setT(int i){ t = i; }

	@Override public void computeY(){
		double radians = 2 * Math.PI * getX() / (double) t;
		int y = (int) Math.round(Y_MAX * Math.sin(radians));
		setY(y);
	}

}
