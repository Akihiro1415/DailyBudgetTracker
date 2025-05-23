package Personal_Projects;
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

        while (!isInvalid7) {
            System.out.println("\n====Daily Budget Tracker====");
            System.out.println("[1] Add Budget");
            System.out.println("[2] Add Expenses");
            System.out.println("[3] Add Bills");
            System.out.println("[4] Add Debt");
            System.out.println("[5] Remove");
            System.out.println("[6] Transaction history");
            System.out.println("[7] Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scan.nextInt();
                isInvalid7 = true;

                System.out.println("");

                switch (choice) {

                    //—————————— Income Tracker —————————
                    case 1:
                        if (budgetCount >= maxTransacs) {
                            System.out.print("You have exceeded your limit.");
                        } else {
                            System.out.println("—————————— Income Tracker —————————");
                            System.out.print("");

                            double incomeInput = 0;
                            while (true) {
                                System.out.print("Enter total income/budget: ");
                                try {
                                    incomeInput = scan.nextDouble();
                                    if (incomeInput < 0) {
                                        System.out.println("Income cannot be negative.\nPlease enter again.");
                                        continue;
                                    }
                                    break; // valid input, exit loop
                                } catch (Exception e) {
                                    System.out.println("Invalid input. Please enter a valid number for income.");
                                    scan.next(); // clear invalid entry
                                }
                            }
                            income[budgetCount] = incomeInput;

                            double savingsInput = 0;
                            while (true) {
                                System.out.print("Enter savings amount: ");
                                try {
                                    savingsInput = scan.nextDouble();
                                    if (savingsInput < 0) {
                                        System.out.println("Savings cannot be negative. Please enter again.");
                                        continue;
                                    }
                                    break; // valid input, exit loop
                                } catch (Exception e) {
                                    System.out.println("Invalid input. Please enter a valid number for savings.");
                                    scan.next(); // clear invalid entry
                                }
                            }
                            savings[budgetCount] = savingsInput;

                            budget[budgetCount] = income[budgetCount] + savings[budgetCount];
                            budgetCount++;
                        }
                        break;

                    // —————————— Expenses Tracker —————————
                    case 2:
                    if (expensesCount >= maxTransacs) {
                        System.out.print("You have reached your limit.");
                    }
                    else {
                        
                        System.out.println("—————————— Expenses Tracker —————————");
                        System.out.print("");
                        
                        System.out.println("NOTE: Only letters allowed in category. Avoid adding space to prevent error.");
                        
                        // Category input with confirmation loop
                        boolean categoryConfirmed = false;
                        String inputCat = "";
                        while (!categoryConfirmed) {
                            
                            boolean validCategory = false;
                            while (!validCategory) {
                                
                                System.out.print("Enter Category: ");
                                inputCat = scan.next().trim();
                                
                                // Validate that the input consists only of letters and no spaces
                                if (inputCat.isEmpty() || inputCat.contains(" ")) {
                                    System.out.println("Invalid input. Category must contain only letters without spaces. Please try again.");
                                    continue; // Prompt for input again
                                }
                                
                                // Check if all characters are letters
                                validCategory = true; // Assume valid until proven otherwise
                                for (int i = 0; i < inputCat.length(); i++) {
                                    if (!Character.isLetter(inputCat.charAt(i))) {
                                        validCategory = false; // Found a non-letter character
                                        break;
                                    }
                                }
                                
                                if (!validCategory) {
                                    System.out.println("Invalid input. Category must contain only letters. Please try again.");
                                }
                            }
                            
                            System.out.print("You entered category: \"" + inputCat + "\". Is this correct? (y/n): ");
                            String confirmation = scan.next();
                            if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
                                categoryConfirmed = true;
                            }
                            else {
                                System.out.println("Try entering the category again.");
                            }
                        }
                        category[expensesCount] = inputCat;

                        // Amount input with confirmation loop
                        boolean amountConfirmed = false;
                        double enteredAmount = 0;
                        while (!amountConfirmed) {
                            
                            boolean validAmount = false;
                            while (!validAmount) {
                                
                                System.out.print(" - enter price: ");
                                try {
                                    enteredAmount = scan.nextDouble();
                                    if (enteredAmount <= 0) {
                                        System.out.println("Amount must be greater than zero.\n Please enter again.");
                                        continue;
                                    }
                                    validAmount = true;
                                } catch (Exception e) {
                                    System.out.println("Invalid input. Please enter a valid number for the price.");
                                    scan.next(); // Clear invalid input
                                }
                                
                            }
                            
                            System.out.print("You entered price: " + enteredAmount + ".\n Is this correct? (y/n): ");
                            scan.nextLine();
                            
                            String confirmation = scan.nextLine();
                            if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
                                amountConfirmed = true;
                            }
                            else {
                                System.out.println("Let's try entering the amount again.");
                            }
                        }
                        
                        amount[expensesCount] = enteredAmount;
                        
                        if (budgetCount > 0) {
                            budget[budgetCount - 1] = budget[budgetCount - 1] - amount[expensesCount];
                        }
                        expensesCount++;
                    }
                    break;

                    // ————————— Bill Tracker —————————
                    case 3:
                        if (billCount >= maxTransacs) {
                            System.out.println("You have reached your limit.");
                        } else {
                            boolean isInvalid = false;

                            System.out.println("—————————— Bill Tracker —————————");

                            while (!isInvalid) {
                                System.out.print(" - Enter Electricity Bill: ");
                                try {
                                    EB[billCount] = scan.nextDouble();

                                    System.out.print(" - Enter Water Bill: ");
                                    WB[billCount] = scan.nextDouble();

                                    totalBill[billCount] = WB[billCount] + EB[billCount];

                                    isInvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Invalid input.");
                                    scan.nextLine();

                                }
                            }

                            System.out.println("Total bill: " + totalBill[billCount]);

                            boolean isInvalid6 = false;

                            // extra bills
                            while (!isInvalid6) {
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
                                            extraBillsCategory[billCount] = scan.next().trim();

                                            System.out.print("Bill Amount: ");
                                            extraBillsAmount[billCount] = scan.nextDouble();

                                            totalBill[billCount] += extraBillsAmount[billCount];
                                        }

                                        if (budgetCount > 0 && budget[budgetCount - 1] < totalBill[billCount]) {

                                            System.out.println("Your total bills is: " + totalBill[billCount]);
                                            System.out.println("You have lack or have no budget to pay this.");
                                            billCount++;

                                        } else {
                                            totalBill[billCount] = extraBillsAmount[billCount] + EB[billCount] + WB[billCount];

                                            System.out.println("Your total bills is: " + totalBill[billCount]);
                                            if (budgetCount > 0) {
                                                System.out.println("Your remaining budget is: " + budget[budgetCount - 1]);
                                            }
                                            billCount++;

                                        }

                                    }

                                    // if the user says no
                                    if (yn.equalsIgnoreCase("n") || (yn.equalsIgnoreCase("no"))) {
                                        if (budgetCount > 0 && budget[budgetCount - 1] < totalBill[billCount]) {

                                            System.out.println("Your total bills is: " + totalBill[billCount]);
                                            System.out.println("You have lack or have no budget to pay this.");

                                            billCount++;

                                        } else {
                                            if (budgetCount > 0) {
                                                budget[budgetCount - 1] = budget[budgetCount - 1] - totalBill[billCount];
                                            }

                                            System.out.println("Your total bills is: " + totalBill[billCount]);
                                            if (budgetCount > 0) {
                                                System.out.println("Your remaining budget is: " + budget[budgetCount - 1]);
                                            }

                                            billCount++;

                                        }
                                    }

                                } catch (Exception e) {
                                    System.out.println("Invalid input.");
                                    scan.nextLine();
                                }
                            }
                        }
                        break;

                    // ————————— debt Tracker —————————
                    case 4:
                        if (debtCount >= maxTransacs) {
                            System.out.println("You have reached your limit.");
                        } else {
                            System.out.println("—————————— Debt Tracker —————————");
                            System.out.println("Note: your debt balance will be deducted from your remaining budget.");
                            System.out.print("");

                            boolean isInvalid5 = false;

                            while (!isInvalid5) {
                                System.out.print("Enter the number of your debts: ");
                                try {
                                    numOfDebts[debtCount] = scan.nextInt();
                                    scan.nextLine(); // consume newline after nextInt

                                    totalD[debtCount] = 0; // reset total debt for this entry

                                    for (int i = 0; i < numOfDebts[debtCount]; i++) {
                                        System.out.print("\nEnter debt category: ");
                                        debtCat[debtCount] = scan.nextLine();

                                        System.out.print("Enter amount: ");
                                        double singleDebtAmount = scan.nextDouble();
                                        scan.nextLine(); // consume newline

                                        // Store each debt amount in a separate array
                                        debtAmount[debtCount] += singleDebtAmount; // accumulate total debt
                                        totalD[debtCount] += singleDebtAmount; // accumulate total debt for budget check
                                    }

                                    // After entering all debts, check the budget
                                    if (budgetCount > 0) {
                                        if (budget[budgetCount - 1] < totalD[debtCount]) {
                                            System.out.println("The total of your debt is: " + totalD[debtCount]);
                                            System.out.println("You have insufficient budget to pay this.");
                                        } else {
                                            budget[budgetCount - 1] -= totalD[debtCount]; // deduct total debt from budget
                                            System.out.println("The total of your debt is: " + totalD[debtCount]);
                                            System.out.println("Remaining budget: " + budget[budgetCount - 1]);
                                        }
                                    }
                                    debtCount++; // Increment debt count after processing
                                    isInvalid5 = true; // exit loop
                                } catch (Exception e) {
                                    System.out.println("Invalid input.");
                                    scan.nextLine(); // clear invalid input
                                }
                            }
                        }
                        break;

                    // ————————— Remove Item —————————
                    case 5:
                        System.out.println("\nWhat type of item would you like to remove?");
                        System.out.println("[1] Budget");
                        System.out.println("[2] Expense");
                        System.out.println("[3] Bill");
                        System.out.println("[4] Debt");
                        System.out.print("Your choice: ");
                        int removeChoice = scan.nextInt();
                        scan.nextLine(); // consume newline

                        switch (removeChoice) {
                            case 1:
                                if (budgetCount == 0) {
                                    System.out.println("No budgets to remove.");
                                    break;
                                }
                                System.out.println("Budgets:");
                                for (int i = 0; i < budgetCount; i++) {
                                    System.out.println(i + ": Income = " + income[i] + "\nSavings = " + savings[i] + "\nTotal Budget = " + budget[i]);
                                }
                                System.out.print("Enter index to remove: ");
                                int bIndex = scan.nextInt();
                                scan.nextLine();
                            
                                if (bIndex < 0 || bIndex >= budgetCount) {
                                    System.out.println("Invalid index.");
                                    break;
                                }
                                for (int i = bIndex; i < budgetCount - 1; i++) {
                                    income[i] = income[i + 1];
                                    savings[i] = savings[i + 1];
                                    budget[i] = budget[i + 1];
                                }
                                budgetCount--;
                                System.out.println("Budget removed.");
                                break;
                            
                            case 2:
                                if (expensesCount == 0) {
                                    System.out.println("No expenses to remove.");
                                    break;
                                }
                            
                            System.out.println("");
                            System.out.println("Expenses:");
                            for (int i = 0; i < expensesCount; i++) {
                                System.out.println("");
                                System.out.println(i + ": Category = " + category[i] + "\nAmount = " + amount[i]);
                            }
                            System.out.print("Enter index to remove: ");
                            int eIndex = scan.nextInt();
                            scan.nextLine();
                            if (eIndex < 0 || eIndex >= expensesCount) {
                                System.out.println("Invalid index.");
                                break;
                            }
                            for (int i = eIndex; i < expensesCount - 1; i++) {
                                category[i] = category[i + 1];
                                description[i] = description[i + 1];
                                amount[i] = amount[i + 1];
                            }
                            expensesCount--;
                            System.out.println("Expense removed.");
                            break;
                            case 3:
                            
                            if (billCount == 0) {
                                System.out.println("No bills to remove.");
                                break;
                            }
                            System.out.println("Bills:");
                            for (int i = 0; i < billCount; i++) {
                                System.out.println(i + ": Water Bill = " + WB[i] + "\nElectricity Bill = " + EB[i] + "\n Extra Bill = " + extraBillsCategory[i] + " : " + extraBillsAmount[i] + "\nTotal Bill = " + totalBill[i]);
                            }
                            System.out.print("Enter index to remove: ");
                            int billIndex = scan.nextInt();
                            scan.nextLine();
                            if (billIndex < 0 || billIndex >= billCount) {
                                System.out.println("Invalid index.");
                                break;
                            }
                            for (int i = billIndex; i < billCount - 1; i++) {
                                WB[i] = WB[i + 1];
                                EB[i] = EB[i + 1];
                                extraBillsCategory[i] = extraBillsCategory[i + 1];
                                extraBillsAmount[i] = extraBillsAmount[i + 1];
                                totalBill[i] = totalBill[i + 1];
                            }
                            billCount--;
                            System.out.println("Bill removed.");
                            break;
                            case 4:
                            if (debtCount == 0) {
                                System.out.println("No debts to remove.");
                                break;
                            }
                            System.out.println("Debts:");
                            for (int i = 0; i < debtCount; i++) {
                                System.out.println(i + ": Category = " + debtCat[i] + "\nTotal Debt = " + totalD[i]);
                            }
                            System.out.print("Enter index to remove: ");
                            int dIndex = scan.nextInt();
                            scan.nextLine();
                            if (dIndex < 0 || dIndex >= debtCount) {
                                System.out.println("Invalid index.");
                                break;
                            }
                            for (int i = dIndex; i < debtCount - 1; i++) {
                                debtCat[i] = debtCat[i + 1];
                                totalD[i] = totalD[i + 1];
                                numOfDebts[i] = numOfDebts[i + 1];
                                debtAmount[i] = debtAmount[i + 1];
                            }
                            debtCount--;
                            System.out.println("Debt removed.");
                            break;
                            default:
                            System.out.println("Invalid choice.");
                            break;
                        }
                    break;
                    
                    //————————— History —————————
                    case 6:
                    System.out.println("\nToday's Transactions");
                    
                    // ——— Budgets ———
                    System.out.println("\n——— Budgets ———");
                    for (int i = 0; i < budgetCount; i++) {
                        System.out.println("Income:           " + income[i]);
                        System.out.println("Savings:          " + savings[i]);
                        System.out.println("Your total budget: " + budget[i]);
                        System.out.println();
                    }
                    
                    // ——— Expenses ———
                    System.out.println("\n——— Expenses ———");
                    for (int i = 0; i < expensesCount; i++) {
                        System.out.println(category[i] + " : " + amount[i]);
                        System.out.println();
                    }
                    
                    // ——— Bills ———
                    System.out.println("\n——— Bills ———");
                    for (int i = 0; i < billCount; i++) {
                        System.out.println("Water Bill:       " + WB[i]);
                        System.out.println("Electricity Bill: " + EB[i]);
                        System.out.println();
                        System.out.println(extraBillsCategory[i] + " : " + extraBillsAmount[i]);
                        System.out.println();
                    }
                    
                    // ——— Debts ———
                    System.out.println("\n——— Debts ———");
                    if (debtCount == 0) {
                        System.out.println("No transactions yet.");
                    }
                    else {
                        for (int i = 0; i < debtCount; i++) {
                            System.out.println(debtCat[i] + " : " + totalD[i]);
                            System.out.println("Total debt:       " + totalD[i]);
                            System.out.println();
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
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scan.nextLine();
            }
        }
    }
        
    }
    
}
