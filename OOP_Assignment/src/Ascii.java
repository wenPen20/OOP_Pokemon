
public class Ascii {
	
	public static void WelcomeMessage() {
		String red = "\u001B[31m";
		String gray = "\033[90m";
		String yellow = "\u001B[33m";
		String reset = "\u001B[0m";
		
		System.out.println("          __        __   _                            _        ");
        System.out.println("          \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___  ");
        System.out.println("           \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\ ");
        System.out.println("            \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |");
        System.out.println("             \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/ ");

        System.out.println(red + " ____       _     __                          " + yellow + "____                  ___  _   __ " + reset);
        System.out.println(red + "|  _ \\ ___ | | __/_/ _ __ ___   ___  _ __    " + yellow + "/ ___| __ _           / _ \\| | /_/ " + reset);
        System.out.println(red + "| |_) / _ \\| |/ / _ \\ '_ ` _ \\ / _ \\| '_ \\  " + yellow + "| |  _ / _` |  _____  | | | | |/ _ \\" + reset);
        System.out.println(gray + "|  __/ (_) |   <  __/ | | | | | (_) | | | | " + yellow + "| |_| | (_| | |_____| | |_| | |  __/" + reset);
        System.out.println("|_|   \\___/|_|\\_\\___|_| |_| |_|\\___/|_| |_|  " + yellow + "\\____|\\__,_|          \\___/|_|\\___|" + reset);

	}
	
	public static void BattleStartMessage() {
		String red = "\u001B[31m";
		String green = "\u001B[32m";
		String reset = "\u001B[0m";
		
		System.out.println(red + " ____        _   _   _        ____  _" + green + "             _     _ ");
		System.out.println(red + "| __ )  __ _| |_| |_| | ___  / ___|| " + green + "|_ __ _ _ __| |_  | |");
		System.out.println(red + "|  _ \\ / _` | __| __| |/ _ \\ \\" + green + "___ \\| __/ _` | '__| __| | |");
		System.out.println(red + "| |_) | (_| | |_| |_| |  " + green + "__/  ___) | || (_| | |  | |_  |_|");
		System.out.println(red + "|____/ \\__,_|\\__|\\" + green + "__|_|\\___| |____/ \\__\\__,_|_|   \\__| (_)" + reset);

	}
	
	public static void GameOverMessage() {
		String red = "\u001B[31m";
		String reset = "\u001B[0m";
		
		System.out.println(red + "  ____                         ___                 ");
		System.out.println(" / ___| __ _ _ __ ___   ___   / _ \\__   _____ _ __ ");
		System.out.println("| |  _ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|");
		System.out.println("| |_| | (_| | | | | | |  __/ | |_| |\\ V /  __/ |   ");
		System.out.println(" \\____|\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_|   " + reset);

	}
	
	public static void YouWonMessage() {
		String green = "\u001B[32m";
		String reset = "\u001B[0m";
		
		System.out.println(green + "__   __           __        __            _ ");
		System.out.println("\\ \\ / /__  _   _  \\ \\      / /__  _ __   | |");
		System.out.println(" \\ V / _ \\| | | |  \\ \\ /\\ / / _ \\| '_ \\  | |");
		System.out.println("  | | (_) | |_| |   \\ V  V / (_) | | | | |_|");
		System.out.println("  |_|\\___/ \\__,_|    \\_/\\_/ \\___/|_| |_| (_)" + reset);

	}
	public static void ThankYouMessage() {
		System.out.println(" _   _            _  _           _             _             _ _ ");
		System.out.println("| |_| |__ __  __ | || |    _ __ | | __ _ _   _(_)_ __   __ _| | |");
		System.out.println("| __| '_  \\ \\/ / | || |_  | '_ \\| |/ _` | | | | | '_ \\ / _` | | |");
		System.out.println("| |_| | | |>  <  |__   _| | |_) | | (_| | |_| | | | | | (_| |_|_|");
		System.out.println(" \\__|_| |_/_/\\_\\    |_|   | .__/|_|\\__,_|\\__, |_|_| |_|\\__, (_|_)\n                          |_|            |___/         |___/     ");
	
	}
	
	public static void YourScoreMessage() {
		String lYellow = "\033[93m";
		String reset = "\u001B[0m";
		
		System.out.println(lYellow + "__   __                 ____                      ");
        System.out.println("\\ \\ / /__  _   _ _ __  / ___|  ___ ___  _ __ ___  ");
        System.out.println(" \\ V / _ \\| | | | '__| \\___ \\ / __/ _ \\| '__/ _ \\ ");
        System.out.println("  | | (_) | |_| | |     ___) | (_| (_) | | |  __/ ");
        System.out.println("  |_|\\___/ \\__,_|_|    |____/ \\___\\___/|_|  \\___| " + reset);
	}
}
