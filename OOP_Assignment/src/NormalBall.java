import java.util.HashMap;

public class NormalBall extends Pokeball {
	
    public NormalBall() {
        super("Poke Ball");
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("★", 0.5);
        rates.put("★★", 0.3);
        rates.put("★★★", 0.1);
        rates.put("★★★★", 0.05);
        rates.put("★★★★★", 0.01);
        setCatchRates(rates);
    }
}
