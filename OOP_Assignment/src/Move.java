// a pokemon can only have one move
public class Move {
	private String moveType;
	private String moveName;
	
	public Move() {
		this.moveType = "Normal";
		this.moveName = "Basic Attack";
	}

	public Move(String moveType, String moveName) {
		this.moveType = moveType;
		this.moveName = moveName;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

	public String getMoveName() {
		return moveName;
	}

	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}

	@Override
	public String toString() {
		return String.format("Move [moveType=%s, moveName=%s]", moveType, moveName);
	}
	
	// attack enemy pokemon
	public void useMove(String target) {
		
	}
	
}
