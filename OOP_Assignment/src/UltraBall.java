import java.util.HashMap;

public class UltraBall extends Pokeball {
	
    public UltraBall() {
        super("Ultra Ball");
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("★", 0.7);
        rates.put("★★", 0.55);
        rates.put("★★★", 0.4);
        rates.put("★★★★", 0.3);
        rates.put("★★★★★", 0.15);
        setCatchRates(rates);
    }
}
