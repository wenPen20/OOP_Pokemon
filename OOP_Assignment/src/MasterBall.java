import java.util.HashMap;

public class MasterBall extends Pokeball {
	
    public MasterBall() {
        super("Master Ball");
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("★", 0.9);
        rates.put("★★", 0.85);
        rates.put("★★★", 0.8);
        rates.put("★★★★", 0.75);
        rates.put("★★★★★", 0.7);
        setCatchRates(rates);
    }
}
