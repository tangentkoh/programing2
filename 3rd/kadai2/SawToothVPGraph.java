// SinVPGraphのサブクラスのSawToothVPGraphクラスを書く

public class SawToothVPGraph extends SinVPGraph{

	public SawToothVPGraph(char symbol, int t){
		super(symbol, t);
	}

	@Override public void computeY(){
		int x = getX();
		int y = (2 * Y_MAX * (x % t)) / t - Y_MAX;
		setY(y);
	}

}
