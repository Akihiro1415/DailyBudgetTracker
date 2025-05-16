# DailyBudgetTracker
This is for our Java Proposal.

package MainProject;

import java.util.Scanner;

public class DailyBudgetTracker {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int maxTransacs = 100;
        
        double[] income = new double[maxTransacs];
        double[] savings = new double[maxTransacs];
        double[] budget = new double[maxTransacs];
            int budgetCount = 0; 
            
        double[] WB = new double[maxTransacs];
        double[] EB = new double[maxTransacs];
            
        int extraBillsNum;
        String[] extraBillsCategory = new String[maxTransacs];
        double[] extraBillsAmount = new double[maxTransacs];
        double[] totalBill = new double[maxTransacs];
            int billCount = 0;
            
        int expenses;
        String[] category = new String[maxTransacs];
        String[] description = new String[maxTransacs];
        double[] amount = new double[maxTransacs];
        double[] totalExp = new double[maxTransacs];
            int expensesCount = 0;
            
        int[] numOfDebts = new int[maxTransacs];
        String[] debtCat = new String[maxTransacs];
        double[] debtAmount = new double[maxTransacs];
        double[] totalD = new double[maxTransacs];
            int debtCount = 0;
            
        String yn;
        int choice;
        boolean running = true;
        
        while (running) {
            
            boolean isInvalid7 = false;
            
            while(!isInvalid7) {
                System.out.println("\n====Daily Budget Tracker====");
                System.out.println("[1] Add Budget");
                System.out.println("[2] Add Expenses");
                System.out.println("[3] Add Bills");
                System.out.println("[4] Add Debt");
                System.out.println("[5] Remove");
                System.out.println("[6] Transaction history");
                System.out.println("[7] Exit");
                System.out.print("Enter your choice: ");
                try{
                    choice = scan.nextInt();
                    isInvalid7 = true;
                
            System.out.println("");
                
            
            switch (choice) {
                
                //—————————— Income Tracker —————————
                case 1:
                if (budgetCount > maxTransacs){
                    System.out.print("You have exceed your limit.");
                } else {
                    System.out.println("—————————— Income Tracker —————————");
                    System.out.print("");
                        
                    System.out.print("Enter total income/budget: ");
                    income[budgetCount] = scan.nextDouble();
                            
                    System.out.print("Enter savings amount: ");
                    savings[budgetCount] = scan.nextDouble();
                    
                    budget[budgetCount] = income[budgetCount] + savings[budgetCount];
                            
                    budgetCount++;
                }
                break;
                
               // —————————— Expenses Tracker —————————
                case 2:
                if (expensesCount > maxTransacs){
                    System.out.print("You have reached your limit.");
                } else {
                    
                    System.out.println("—————————— Expenses Tracker —————————");
                    System.out.print("");
                    
                    System.out.println("NOTE: Avoid adding space to prevent error.");
                    
                    boolean isInvalid4 = false;
                    
                    while(!isInvalid4){
                        System.out.print("Enter Category: ");
                        try{
                            category[expensesCount] = scan.next();
                                    
                            System.out.print(" - enter description: ");
                            description[expensesCount] = scan.next();
                                    
                            System.out.print(" - enter price: ");
                            amount[expensesCount] = scan.nextDouble();
                            
                            budget[budgetCount] = budget[budgetCount] - amount[expensesCount];
                            
                            expensesCount++;
                            isInvalid4 = true;
                        } 
                        catch (Exception e) {
                            System.out.println("Invalid input.");
                            scan.next();
                        }
                        
                    }
                }
                
                break;
                
                // ————————— Bill Tracker —————————
                case 3:
                if (billCount > maxTransacs) {
                    System.out.println("You have reached your limit.");
                } 
                else {
                    boolean isInvalid = false;
                    
                    System.out.println("—————————— Bill Tracker —————————");
                    
                    while(!isInvalid){
                        System.out.print(" - Enter Electricity Bill: ");
                        try {
                            EB[billCount] = scan.nextDouble();
                            
                            System.out.print(" - Enter Water Bill: ");
                            WB[billCount] = scan.nextDouble();
                            
                            totalBill[billCount] = WB[billCount] + EB[billCount];
                            
                            isInvalid = true;
                        } 
                        catch (Exception e){
                            System.out.println("Invalid input.");
                            scan.nextLine();
                            
                        }
                    }
                    
                    System.out.println("Total bill: " + totalBill[billCount]);
                
                    boolean isInvalid6 = false;
                    
                    // extra bills
                    
                    while(!isInvalid6) {
                        System.out.print("Would you like to include other extra bills?(y/n): ");
                        try {
                            yn = scan.next();
                            isInvalid6 = true;
                            
                            // if the user says yes
                            
                            if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
                                System.out.print("Enter number of extra bills: ");
                                extraBillsNum = scan.nextInt();
                                
                                for (int i = 0; i < extraBillsNum; i++) {
                                    System.out.print("Extra Bill Description: ");
                                    extraBillsCategory[billCount] = scan.next();
                                    
                                    System.out.print("Bill Amount: ");
                                    extraBillsAmount[billCount] = scan.nextDouble();
                                    
                                    totalBill[billCount] += extraBillsAmount[billCount];
                                    
                                }
                                
                                if (budget[budgetCount] < totalBill[billCount]) {
                                    
                                    System.out.println("Your total bills is: " + totalBill[billCount]);
                                    System.out.println("You have lack or have no budget to pay this.");
                                    billCount++;
                                    
                                }
                                else {
                                    totalBill[billCount] = extraBillsAmount[billCount] + EB[billCount] + WB[billCount];
                                    
                                    System.out.println("Your total bills is: " + totalBill[billCount]);
                                    System.out.println("Your remaining budget is: " + budget[budgetCount]);
                                    billCount++;
                                    
                                }
                                
                            }
                            
                            // if the usee says no
                            
                            if (yn.equalsIgnoreCase("n") || (yn.equalsIgnoreCase("no"))) {
                                if (budget[budgetCount] < totalBill[billCount]) {
                                    
                                    System.out.println("Your total bills is: " + totalBill[billCount]);
                                    System.out.println("You have lack or have no budget to pay this.");
                                    
                                    billCount++;
                                    
                                }
                                
                                else {
                                    
                                    budget[budgetCount] = budget[budgetCount] - totalBill[billCount];
                                    
                                    System.out.println("Your total bills is: " + totalBill[billCount]);
                                    System.out.println("Your remaining budget is: " + budget[budgetCount]);
                                    
                                    billCount++;
                                    
                                }
                            }
                            
                        }
                            catch(Exception e) {
                            System.out.println("Invalid input.");
                            scan.nextLine();
                        }
                    
                    }
                }
                break;
                
                // ————————— debt Tracker —————————
                case 4:
                if (debtCount > maxTransacs) {
                    System.out.println("You have reached your limit.");
                }
                
                else {
                    System.out.println("—————————— Debt Tracker —————————");
                    System.out.println("Note: your debt balance will be deduct to your remaining budget.");
                    System.out.print("");
                    
                    boolean isInvalid5 = false;
                    
                    while(!isInvalid5) {
                        System.out.print("Enter the number of your debts: ");
                        try{
                            numOfDebts[debtCount] = scan.nextInt();
                            
                            for (int i = 1; i<=numOfDebts[debtCount]; i++){
                                System.out.print("\n Enter debt category: ");
                                debtCat[debtCount] = scan.nextLine();
                                
                                System.out.print(" Enter amount: ");
                                debtAmount[debtCount] = scan.nextDouble();
                                
                                debtCount++;
                            }
                            
                            isInvalid5 = true;
                        }
                        catch(Exception e) {
                            System.out.println("Invalid input.");
                            scan.nextLine();
                        }
                    }
                
                if (budget[budgetCount] < totalD[debtCount]) {
                    
                    totalD[debtCount] += debtAmount[debtCount];
                    
                    System.out.println("The total of your debt is: " + totalD[debtCount]);
                    System.out.println("You have lack or have no budget to pay this.");
                    
                }
                    else {
                        
                        totalD[debtCount] += debtAmount[debtCount];
                        budget[budgetCount] = budget[budgetCount] - totalD[debtCount];
                        
                        System.out.println("The total of your debt is: " + totalD[debtCount]);
                        System.out.println("remaining budget: " + budget[budgetCount]);
                        
                    }
                    
                }
                break;
                // ————————— Remove Item —————————
                case 5:
                
                break;
                
                //————————— History —————————
                case 6:
                System.out.println("\n Today's Transactions ");
                System.out.println("\n ——— budgets ———");
                for (int i = 0; i < budgetCount; i++) {
                    System.out.println(income[i]);
                    System.out.println(savings[i]);
                    
                    System.out.println("Your total budget is: " + budget[i]);
                }
                
                System.out.println("\n ——— expenses ——— ");
                for (int i = 0; i < expensesCount; i++) {
                    
                    System.out.println(category[i]);
                    System.out.println(description[i] + "    : " + amount[i]);
                    
                    System.out.println("");
                    
                }
                
                System.out.println("\n ——— Bills ——— ");
                for (int i = 0; i < billCount; i++) {
                    
                    System.out.println("Water Bill" + "    :" + WB[i]);
                    System.out.println("Electricity Bill" + "    :" + EB[i]);
                    
                    System.out.println("");
                    
                    System.out.println(extraBillsCategory[i] + "    :" + extraBillsAmount[i]);
                    
                    System.out.println("");
                    
                }
                
                System.out.println("\n ——— Debts ——— ");
                
                if(debtAmount[debtCount] < 0){
                    System.out.println("No transaction yet.");
                }
                else {
                    for (int i = 0; i < debtCount; i++) {
                    
                        System.out.println(debtCat[i] + "    :" + debtAmount[i]);
                        
                        System.out.println("");
                        
                        System.out.println("Total debt: " + totalD[i] + "\n");
                    
                    }
                }
                
                break;
                
                case 7:
                running = false;
                System.out.println("Exiting Budget Tracker...\nYou may now close the app :))");
                scan.close();
                break;
                
                default:
                System.out.println("Invalid input.");
                break;
            } 
            
                    //end of Switch case
                }
                catch(Exception e) {
                    System.out.println("Invalid input.");
                    scan.nextLine();
                }
            }
        }
        
    }
}
