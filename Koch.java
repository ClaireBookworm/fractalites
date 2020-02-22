class Vector {
	// I'm so cool I'm using vectors
	public Point point;
	public double angle;
	Vector (Point point, double angle) {
		this.point = point;
		this.angle = angle;
	}
}
public class Koch {
	public static double radius = 0.02;
	public static void drawLine(final Point point1, final Point point2) {
		StdDraw.line(point1.x, point1.y, point2.x, point2.y);
	}
	public static void vecLine(Vector vec, double length) {
		Point newP = findGoal(vec.point, length, vec.angle);
		drawLine(vec.point, newP);
	}
	public static void forward(Vector vec, double length) {
		vecLine(vec, length);
		vec.point = findGoal(vec.point, length, vec.angle);
	}
	public static void drawHat(Vector start, double length) {
		vecLine(new Vector(start.point, start.angle + 60), length);
		Point newP = findGoal(start.point, length, start.angle);
		vecLine(new Vector(newP, start.angle - 60), length);
	}

	public static Point findGoal(Point start, double length, double angle) {
		double newX = start.x + Math.cos(angle * Math.PI/180) * length;
		double newY = start.y + Math.sin(angle * Math.PI/180) * length;
		return new Point(newX, newY);
	}

	public static void drawKoch(Vector start, double sideLength, double depth) {
		sideLength /= 3.0;
		if (depth == 0) {
			forward(start, sideLength);
			return;
		}
		StdDraw.setPenRadius(radius);
		drawKoch(start, sideLength, depth-1);
		start.angle += 60;
		drawKoch(start, sideLength, depth-1);
		start.angle -= 120;
		drawKoch(start, sideLength, depth-1);
		start.angle += 60;
		drawKoch(start, sideLength, depth-1);

		radius = (radius > 0.005) ? radius-0.001 : radius;
	}
	public static void main(String[] args) {
		drawKoch(new Vector(new Point(0, 0.1), 0), 3, 3);
	}
}