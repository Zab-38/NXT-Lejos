package seph;

public class Rectanglearea {
int length = 20;
int width = 30;

public void area() {
	System.out.println(length * width);
}

public static void main(String[] args) {
	Rectanglearea rect = new Rectanglearea();
	rect.area();
}
}
