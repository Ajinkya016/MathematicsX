import java.util.Scanner;

/**
 * Calculator for calculatable things  of icse class x mathematics
 *
 * @author Ajinkya Kamble
 * @version 23/3/2023
 */
public class MathematicsX
{
    public static double Quadratic(double a, double b, double c) 
    {
        return  (-b+ Math.sqrt( (Math.pow(b, 2))- (4*a*c)))/(2*a);   
    }
    public static double QuadraticNeg(double a, double b, double c) 
    {
        return  (-b- Math.sqrt( (Math.pow(b, 2))- (4*a*c)))/(2*a);   
    }
    public static void displayTable(String [][] chapters)
    {
            System.out.printf("----------------------------------------------------------------------%n");
            System.out.printf(" MATHEMATICS CALCULATOR         %n");
            System.out.printf(" (Ajinkya Kamble X-D)         %n");
            
            System.out.printf("+-----+-------------------------------------+-----------------+------+%n");
            System.out.printf("| %-2s | %-35s | %-15s | %-4s |%n", "NO.", "CHAPTER", "AVAILABLITY", "CODE");
            System.out.printf("+-----+-------------------------------------+-----------------+------+%n");
            int i = 1;
            char code = 'A';
            for(String[] chapter: chapters)
            {
                System.out.printf("| %03d | %-35s | %-15s | %-4s |%n", i, chapter[0], chapter[1], code);
                i++;
                code++;
            }
            
            System.out.printf("+-----+-------------------------------------+-----------------+------+%n");
    }
    public static int input(String[][] chapterAvailableTestArr)
    {
        Scanner sc = new Scanner(System.in);
        char value = sc.next().charAt(0);
        char code = 'A';
        boolean proceed = false;
        int specialCode = 0;
        for(String ch[]: chapterAvailableTestArr)
        {
            //if the value entered does not matche the code, skip the iteration.
            if(value != code) 
            {
                code++;//increase the char and then continue the loop
                continue;
            }
            
            //Value == code here,
            //if matched then, check if it is available or not.
            if(ch[1].equals("Available"))
            {
                proceed = true;
                specialCode = Integer.parseInt(ch[2]);
                break;
            }
            else 
            {
                System.out.println("Chapter not available. Please try again");
                return input(chapterAvailableTestArr);   
            }
        } 
        if(!proceed)
        {
            System.out.println(" Invalid option");
            return input(chapterAvailableTestArr);   
        }
        return specialCode;//will return 0 if value is invalid... loop will always go in continue and end.
    }
    public static void main(String[] args)
    {
            String chaptersMath[][] = {
                {"GST", "Not Available", "1"}, 
                {"Banking", "Available", "2"},
                {"Quadratic equations", "Available", "3"},
                {"Measures of central tendendcies*", "Available", "4"}
            };
            displayTable(chaptersMath);
            Scanner sc1 = new Scanner(System.in);
            System.out.println();
            System.out.println();
            System.out.println("Please enter the code beside the desired chapter to calculate.");
            int opt = input(chaptersMath);
            switch(opt)
            {
                //Banking
                case 2:
                    System.out.println("--------------------------------BANKINGS------------------------------");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println("Enter the type of Problem to be solved.");
                    System.out.println("1) Find Principal");
                    System.out.println("2) Find Maturity Value");
                    System.out.println("3) Find time (in years and months)");
                    System.out.println("4) Find Rate");
                    
                    
                    int optIn = sc1.nextInt();
                    double p, mv, n, r;
                switch(optIn)
                    {
                        case 1:
                           
                           System.out.println("Enter Maturity value");
                            mv = sc1.nextDouble();
                           System.out.println("Enter number of months");
                            n = sc1.nextDouble();
                           System.out.println("Enter rate per annum");
                            r = sc1.nextDouble();
                           System.out.println("Principal is : \u20B9"+((2400*mv)/((2400*n)+(n*(n+1)*r))));
                           break;
                        
                        case 2:
                           
                           System.out.println("Enter Principal");
                            p = sc1.nextDouble();
                           System.out.println("Enter number of months");
                            n = sc1.nextDouble();
                           System.out.println("Enter rate per annum");
                            r = sc1.nextDouble();
                           System.out.println("Maturity Value is : \u20B9"+((p*n)+ ((p*n*(n+1)*r)/(2400))));
                           break;
                           
                        case 3:
                           
                           System.out.println("Enter Maturity Value");
                            mv = sc1.nextDouble();
                           System.out.println("Enter Principal");
                            p = sc1.nextDouble();
                           System.out.println("Enter rate per annum");
                            r = sc1.nextDouble();
                    
                            n=  Quadratic(p*r, (2400+r)*p, -2400*mv);
                           System.out.println("Time needed is : "+ (n/12) + " years and " + (n%12) + " months");
                           break;
                           
                        case 4:
                           
                           System.out.println("Enter Maturity Value");
                            mv = sc1.nextDouble();
                           System.out.println("Enter Principal");
                            p = sc1.nextDouble();
                           System.out.println("Enter number of months");
                            n = sc1.nextDouble();
                           System.out.println("Rate is : "+(2400*(mv-(p*n)))/(n*p*(n+1)) +"%");
                           break;
                        default:
                            System.out.println("Kindly enter a valid possibility");
                            break;
                    }
                    break;
                    case 3:
                        System.out.println("--------------------------------Quadratic-----------------------------");
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println();
                        System.out.println();
                        
                        System.out.println("A QUADRATIC EQUATION looks like, ax2 + bx + c");
                         System.out.println("Enter a");
                            double a1 = sc1.nextDouble();
                           System.out.println("Enter b");
                            double b1 = sc1.nextDouble();
                           System.out.println("Enter c");
                            double c1 = sc1.nextDouble();
                            System.out.println();
                            System.out.println("x ="+ Quadratic(a1,b1,c1) + " or "+ QuadraticNeg(a1,b1,c1));
                        break;
                case 4:
                    System.out.println("------------------------Measures of central tendendcies-------------------");
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println();
                        System.out.println();
                        
                        System.out.println("Enter what data you want");
                        System.out.println("1) Volume of Cylinder");
                        System.out.println("2) Volume of Cone");
                        System.out.println("3) Volume of Sphere");
                        System.out.println("4) Volume of Hemisphere");
                        System.out.println("5) Volume of Hollow Cylinder");
                        System.out.println("6) Volume of Spherical Shell");
                        System.out.println("7) S.A of Cylinder");
                        System.out.println("8) S.A of Cone");
                        System.out.println("9) S.A of Sphere");
                        int optIn2 = sc1.nextInt();
                        double h, ra, H, R, l;
                        switch(optIn2)
                        {
                            case 1:
                                System.out.println("Enter height");
                                 h = sc1.nextDouble();
                                System.out.println("Enter radius");
                                 ra = sc1.nextDouble();
                                System.out.println("Volume of Cylinder is "+ (Math.PI*ra*ra*h) + " cubic units");
                                break;
                            case 2:
                                System.out.println("Enter height");
                                 h = sc1.nextDouble();
                                System.out.println("Enter radius");
                                 ra = sc1.nextDouble();
                                System.out.println("Volume of Cone is "+ (Math.PI*ra*ra*h/3) + " cubic units");
                                break;
                            case 3:
                                System.out.println("Enter radius");
                                 ra = sc1.nextDouble();
                                System.out.println("Volume of Sphere is "+ (Math.PI*ra*ra*ra*4/3) + " cubic units");
                                break;
                            case 4:
                                System.out.println("Enter height");
                                 h = sc1.nextDouble();
                                System.out.println("Enter radius");
                                 ra = sc1.nextDouble();
                                System.out.println("Volume of heisphere is "+ (Math.PI*ra*ra*ra*2/3) + " cubic units");
                                break;
                            case 5:
                                System.out.println("Enter height of inner cylinder");
                                 h = sc1.nextDouble();
                                System.out.println("Enter radius of inner cylinder");
                                 ra = sc1.nextDouble();
                                 System.out.println("Enter height of outer cylinder");
                                 H= sc1.nextDouble();
                                System.out.println("Enter radius of outer cylinder");
                                 R = sc1.nextDouble();
                                System.out.println("Volume of hollow cylinder is "+ (Math.PI*((R*R*H) - (ra*ra*h))) + " cubic units");
                                break;
                            case 6:
                                System.out.println("Enter radius of inner sphere");
                                 ra = sc1.nextDouble();
                                System.out.println("Enter radius of outer sphere");
                                 R = sc1.nextDouble();
                                System.out.println("Volume of spherical shell is "+ (Math.PI*( (R*R*R)-(ra*ra*ra) )*4.0/3.0) + " cubic units");
                                break;
                            case 7:
                                System.out.println("Enter height");
                                 h = sc1.nextDouble();
                                System.out.println("Enter radius");
                                 ra = sc1.nextDouble();
                                System.out.println("L.S.A of Cylinder is "+ (2*Math.PI*ra*h) + " sq units");
                                System.out.println("T.S.A of Cylinder is "+ ( (Math.PI*ra*ra) + (2*Math.PI*ra*h) ) + " sq units");
                                break;
                            case 8:
                                System.out.println("Enter height");
                                 h = sc1.nextDouble();
                                System.out.println("Enter radius");
                                 ra = sc1.nextDouble();
                                l = Math.sqrt((h*h) + (ra*ra));
                                System.out.println("L.S.A of Cone is "+ (Math.PI*ra*l) + " sq units");
                                System.out.println("T.S.A of Cone is "+ ( Math.PI*ra*(l+ra) ) + " sq units");
                                break;
                            case 9:
                                System.out.println("Enter radius");
                                 ra = sc1.nextDouble();
                                System.out.println("Surface area of Sphere is "+ (Math.PI*ra*ra*4) + " cubic units");
                                break;
                            default:
                                System.out.println("Kindly enter a valid possibility");
                                break;
                        }
                    break;
                default:
                    System.out.println("Unexpected error occured. please contact me.");
                    break;
            }
    }
}
