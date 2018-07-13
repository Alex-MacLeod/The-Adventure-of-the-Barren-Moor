package game.util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class Input {

	private Input() {

	}

	public static final Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8.name());
}
