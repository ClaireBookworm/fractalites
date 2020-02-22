import java.util.Scanner;

public class Sierpinski {
	private static int red = 0;
	private static int green = 0;
	private static int blue = 0;
	public static void drawLine(final Point point1, final Point point2) {
		StdDraw.line(point1.x, point1.y, point2.x, point2.y);
	}
	private static void drawTriangle(final Point point1, final Point point2, final Point point3) {
		drawLine(point1, point2);
		drawLine(point2, point3);
		drawLine(point3, point1);
	}
	private static Point midpoint(final Point point1, final Point point2) {
		return new Point((point1.x + point2.x) / 2, (point1.y + point2.y) / 2);
	}
	public static void drawFractal(final Point point1, final Point point2, final Point point3, final int depth) {
		if (depth <= 0) {
			drawTriangle(point1, point2, point3);
			return;
		}
		StdDraw.setPenColor(red, green, blue);
		final Point midpointA = midpoint(point1, point2);
		final Point midpointB = midpoint(point2, point3);
		final Point midpointC = midpoint(point3, point1);
		// draw the three triangles
		drawFractal(point1, midpointA, midpointC, depth - 1);
		drawFractal(midpointA, point2, midpointB, depth - 1);
		drawFractal(midpointC, midpointB, point3, depth - 1);
		if (red <= 230 && red >= 0) {
			red += 1;
		}
		if (green <= 230 && green >= 0) {
			green += 1;
		}
		if (blue <= 230 && blue >= 0) {
			blue += 1;
		}
		
	}
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What depth do you want to draw the sierpinski triangle? (1-10):");
		int depth = scanner.nextInt();
		drawFractal(new Point(0,0), new Point(1, 0), new Point(0.5, 1), depth);
		scanner.close();
	}
}