import java.util.HashMap;

public class GreatBall extends Pokeball {
	
    public GreatBall() {
        super("Great Ball");
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("★", 0.6);
        rates.put("★★", 0.45);
        rates.put("★★★", 0.3);
        rates.put("★★★★", 0.2);
        rates.put("★★★★★", 0.1);
        setCatchRates(rates);
    }
}
