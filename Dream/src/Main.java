import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int newFee;
//        ArrayList<String> u = new ArrayList<String>();
        BinaryTree u = new BinaryTree();
        
        System.out.println("WELCOME TO DREAM CORPORATION COMPANY.");
        System.out.print("Who are you [ADMIN/USER]? : ");
        String user = s.next();
        if (user.equalsIgnoreCase("admin")) {
            System.out.println("\nSelect your option!");
            System.out.println("\t1. COMPANY REVENUE\n" + 
                               "\t2. CREATE USERS\n" +
                               "\t3. DELETE USERS\n" +
                               "\t4. RETRIEVE USERS\n" +
                               "\t5. UPDATE USERS\n" +
                               "\t6. ENCRYPT & DECRYPT USERS\n" +
                               "\t7. USERS REVENUE\n" + 
                               "\t8. ABOUT REGISTRATION FEE");
            
            int choice;
            String newUser = null;
            do {
                System.out.print("\nMy choice [Press '0' to exit] : ");
                choice = s.nextInt();
                if (choice == 1) {
//                    System.out.println("CURRENT REVENUE");
//                    System.out.println("1ST GENERATION (ROOT)");
//                    System.out.println("2ND GENERATION");
//                    System.out.println("3RD GENERATION");
//                    System.out.println("4TH GENERATION");
//                    System.out.println("5TH GENERATION (CHILD)");
                }
                else if (choice == 2) {
                    System.out.print("Enter name : ");
                    newUser = s.next(); 
                    u.insert(newUser);
//                    System.out.println(u.getSize());
//                    try{
//                        PrintWriter p = new PrintWriter(new FileOutputStream("user.txt", true));
//                        p.println("\n" + newUser);
//                        p.close();
//                    }
//                    catch (Exception e) {
//                        System.out.println("File not found");
//                    }
                    System.out.println("Inserting to the list... and creating an encrypted name.");

                }
                else if (choice == 3) {
                    System.out.print("Which user you want to delete? Enter his/her name : ");
                    String deleteName = s.next();
//                    u.delete(deleteName);
                    System.out.println(deleteName + " is deleted...");
                    System.out.println("Updating the revenue...");
                }
                else if (choice == 4) {
                    System.out.print("Name to search : ");
                    String searchName = s.next();
                    System.out.println(u.isFound(searchName));

                }
                else if (choice == 5) {
                    
                }
                else if (choice == 6) {
                    System.out.print("Enter user's name : ");
                    String name = s.next();
                    
                    String enc = new String(u.encrypt(name.getBytes(), 127));
                    String dec = new String(u.decrypt(enc.getBytes(), 127));
                            
                    System.out.println("Encrypted name : " + enc);
                }
                else if (choice == 7) {
                    System.out.print("1. 1st generation\n" +
                                     "2. 2nd generation\n" +
                                     "3. 3rd generation\n" +
                                     "4. 4th generation\n" +
                                     "Choose the generation that you want to see : ");
                    int revChoice = s.nextInt();
                   
                    if (revChoice == 1) {
                        
                    }
                    else if (revChoice == 2) {
                        
                    }
                    else if (revChoice == 3) {
                        
                    }
                    else {
                        
                    }
                    
                }
                else {
                    if (choice != 0) {
                        int regFee = 50;
//                        u.regFee(regFee);
                        System.out.println("Current registration fee is : RM" + regFee);
                        System.out.print("Want to make any changes [Yes/No]? : ");
                        String changeFee = s.next();
                        if (changeFee.equalsIgnoreCase("yes")) {
                            System.out.print("Change to : RM");
                            newFee = s.nextInt();
//                            regFee = newFee;
                            System.out.println("The registration fee has changed to RM");
                        }
                    }
                }
            }
            while (!(choice == 0));
        }
        else {
            System.out.print("Are you already a member [Yes/No]? : ");
            String mem = s.next();
            if (mem.equalsIgnoreCase("Yes")) {
                System.out.print("Name : ");
                String name = s.next();
                
                Scanner txtscan = new Scanner(new File("user.txt"));
                while(txtscan.hasNextLine()){
                    String str = txtscan.nextLine();
                    if(str.indexOf(name) != -1){
                        System.out.print("\t1. My encrypted name\n" +
                                         "\t2. My revenue\n\n");
                        int userChoice;
                        do {
                            System.out.print("Your choice [0 to exit] : ");
                            userChoice = s.nextInt();

                            if (userChoice == 1) {
                                String enc = new String(u.encrypt(name.getBytes(), 127));
                                String dec = new String(u.decrypt(enc.getBytes(), 127));

                                System.out.print("Enter KEY :");
                                int KEY = s.nextInt();
                                if (KEY == 127) {
                                    System.out.println("Encrypted name : " + enc);
        //                            System.out.println(dec);
                                }
                                else {
                                    for (int i=1; i<3; i++) {
                                        System.out.print("Enter KEY :");
                                        KEY = s.nextInt();
                                        if (KEY == 127) {
                                            System.out.println("Encrypted name : " + enc);
                                            break;
                                        }
                                    }
                                }

                                } 
                            else {
                                if (userChoice == 2) {

                                }
                            }
                            System.out.println();
                        }
                        while (!(userChoice == 0)); 
                    }
                    else {
                    }
                    }
            }
            else {
                System.out.print("Want to sign up to be a member [Yes/No]? : ");
                String yesNo = s.next();
                if (yesNo.equalsIgnoreCase("Yes")) {
                    System.out.println("You need to pay RM");
                    System.out.print("Pay now [Yes/No]? :");
                    String pay = s.next();
                    if (pay.equalsIgnoreCase("yes")) {
                        System.out.println("Transfering money...");
                        System.out.print("Enter name : ");
                        String newUser = s.next(); 
                        u.insert(newUser);
                        System.out.println("Inserting to the list... and creating an encrypted name.");
                    }
                    else {
                        if (pay.equalsIgnoreCase("no")) {
                            System.out.println("Thank you, bye. Do join us next time for big reward!");
                        }
                    }
                }
                else {
                    System.out.println("Thank you, bye. Do join us next time for big reward!");
                }
            }
        }
    }
    
}
