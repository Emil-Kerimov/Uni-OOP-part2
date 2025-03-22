package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 enter data");
            System.out.println("2 auto-generate data");
            System.out.println("3 exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    manualInput();
                    break;
                }
                case 2: {
                    autoGenerate();
                    break;
                }
                case 3: {
                    return;
                }
                default:
                    System.out.println("try again");
            }
        }

    }

    private static void manualInput() {
        System.out.println("Enter the tank capacity");
        Scanner scanner = new Scanner(System.in);
        double c = scanner.nextInt();
        Container cont = new Container(c);
        System.out.println("Enter the tank initial volume");
        double v = scanner.nextInt();
        try {
            cont.setVolume(v);
        } catch (OutOfTankVolumeLimitException e) {
            System.out.println(e.getMessage());
        }
        while (true) {
            System.out.println(" 1 to add a cube");
            System.out.println(" 2 to add a cylinder");
            System.out.println(" 3 to add a paralelepiped");
            System.out.println(" 4 to add a regular pyramid ");
            System.out.println(" 5 to add a sphere");
            System.out.println(" 6 to add a trunc cone");
            System.out.println(" 7 to exit");
            int menubar = scanner.nextInt();
            switch (menubar) {
                case 1: {
                    System.out.println("Enter cube side");
                    double side = scanner.nextDouble();
                    try {
                        cont.fit(new Cube(side));
                    } catch (OutOfTankVolumeLimitException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter cylinder height");
                    double h = scanner.nextDouble();
                    System.out.println("Enter cylinder radius");
                    double r = scanner.nextDouble();
                    try {
                        cont.fit(new Cylinder(h, r));
                    } catch (OutOfTankVolumeLimitException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter paralelepiped square");
                    double s = scanner.nextDouble();
                    System.out.println("Enter height square");
                    double h = scanner.nextDouble();
                    try {
                        cont.fit(new Parallelepiped(s, h));
                    } catch (OutOfTankVolumeLimitException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter pyramid square");
                    double s = scanner.nextDouble();
                    System.out.println("Enter pyramid square");
                    double h = scanner.nextDouble();
                    try {
                        cont.fit(new RegPyramid(s, h));
                    } catch (OutOfTankVolumeLimitException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter Sphere radius");
                    double r = scanner.nextDouble();
                    try {
                        cont.fit(new Sphere(r));
                    } catch (OutOfTankVolumeLimitException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter Cone radius");
                    double r = scanner.nextDouble();
                    System.out.println("Enter Cone height");
                    double h = scanner.nextDouble();
                    try {
                        cont.fit(new TruncCone(r, h));
                    } catch (OutOfTankVolumeLimitException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 7: {
                    return;
                }
                default:{
                    System.out.println("try again");
                    break;
                }
            }
            cont.display();
        }


    }

    private static void autoGenerate() {
        double c = (int) (Math.random() * 50);
        System.out.println("generated tank capacity: " + c + "\n");
        Container cont = new Container(c);
        double v = (int) (Math.random() * 30);
        System.out.println("generated tank volume: " + v + "\n");
        try {
            cont.setVolume(v);
        } catch (OutOfTankVolumeLimitException e) {
            System.out.println(e.getMessage());
        }
        Random r = new Random();
        int i = 0;
        while (i != 10) {
            int menubar = r.nextInt(6) + 1;
            switch (menubar) {
                case 1: {
                    double side = r.nextDouble() + 0.2 * 10;
                    System.out.println("generated cube side: " + side);
                    Shape cube = new Cube(side);
                    addShapeToContainer(cube, cont);
                    break;
                }
                case 2: {
                    double h = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated cyl h: " + h);
                    double rad = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated cyl r: " + rad);
                    Shape cyl = new Cylinder(h,rad);
                    addShapeToContainer(cyl, cont);
                    break;
                }
                case 3: {
                    double s = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated paralelepiped square: " + s);
                    double h = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated paralelepiped h: " + h);
                    Shape paralelepiped = new Parallelepiped(s,h);
                    addShapeToContainer(paralelepiped, cont);
                    break;
                }
                case 4: {
                    double s = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated pyramid square: " + s);
                    double h = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated pyramid h: " + h);
                    Shape pyramid = new RegPyramid(s,h);
                    addShapeToContainer(pyramid, cont);
                    break;
                }
                case 5: {
                    double rad = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated sphere rad: " + rad);
                    Shape sphere = new Sphere(rad);
                    addShapeToContainer(sphere, cont);
                    break;
                }
                case 6: {
                    double rad = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated Cone rad: " + rad);
                    double h = r.nextDouble()+ 0.2 * 10;
                    System.out.println("generated Cone h: " + h);
                    Shape cone = new TruncCone(rad, h);
                    addShapeToContainer(cone, cont);
                    break;
                }
            }
            cont.display();
            i++;
        }
    }
    private static void addShapeToContainer(Shape shape, Container container){
        try {
            container.fit(shape);
        } catch (OutOfTankVolumeLimitException e) {
            System.out.println(e.getMessage());
        }
    }
}