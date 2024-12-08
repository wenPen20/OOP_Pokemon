import java.util.HashMap;

public class PokemonResult {
    private HashMap<String, String> pokemon;
    private String grade;
    private String name;
    private String type;

    // Constructor for Pokémon, grade, name, and type
    public PokemonResult(HashMap<String, String> pokemon, String grade) {
        this.pokemon = pokemon;
        this.grade = grade;
    }

    // Constructor for name, type, and grade
    public PokemonResult(String name, String type, String grade) {
        this.name = name;
        this.type = type;
        this.grade = grade;
    }

    public HashMap<String, String> getPokemon() {
        return pokemon;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}