package paint;

import java.util.Scanner;
import paint.service.Command;

public class DrawingApp {

    private DrawingTUI drawingTUI = new DrawingTUI();

    public void run() {
        System.out.println("------------------- Welcome to Drawing App --------------------");
        help();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your input(q for Quit,h for Help): ");
            String line = in.nextLine();
            if ("q".equalsIgnoreCase(line)) {
                break;
            } else if ("h".equalsIgnoreCase(line)) {
                help();
            } else if (line.contains("=") || line.contains("show") || line.contains("move")) {
                try {
                    Command command = drawingTUI.nextCommand(line.trim());
                    if (command != null) {
                        String res = command.execute();
                        System.out.println(res);
                    } else {
                        System.out.println("Wrong Input, Please Retry.");
                    }
                } catch (Exception e) {
                    System.out.println("Wrong Format Input, Please Retry.");
                }
            } else {
                System.out.println("Wrong Format Input, Please Retry.");
            }
        }
        System.out.println("Good-bye");
    }

    private void help() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Examples: ");
        System.out.println("Draw Cercle : c1 = Cercle((0,0),50)");
        System.out.println("Draw Rectangle : r1 = Rectangle((0,0),50,100)");
        System.out.println("Draw Des Carre : d1 = DesCarre((0,0),50)");
        System.out.println("Draw Triangle : t1 = Triangle((0,0),(1,0),(0,1))");
        System.out.println("Move One Shape : move (c1,(10,20))");
        System.out.println("Move many Shapes : move (c1,(10,20)) (r1,(10,20)) (d1,(10,20))");
        System.out.println("Show Shape : show c1");
        System.out.println("----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        new DrawingApp().run();
    }
}
