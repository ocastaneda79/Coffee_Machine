package machine;

import java.util.Scanner;


public class CoffeeMachine {


    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public void printAmount() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println(this.money + " of money");
    }

    private void tryMakeCoffee(String coffeeOption) {

        switch (coffeeOption) {
            case "1": // espresso

                if (water >= 250 && beans >= 16 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                }

                else if (water<250)
                    System.out.println("Sorry, not enough water!");
                else if (beans<16)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (cups<=0)
                    System.out.println("Sorry, not enough cups!");
                break;

                case "2": // latte

                if (water >= 350 && milk>= 75 &&  beans >= 20 && cups > 0) {
                System.out.println("I have enough resources, making you a coffee!");

                water -= 350;
                milk -= 75;
                beans -= 20;
                cups--;
                money += 7;
                }
                else if (water<350)
                    System.out.println("Sorry, not enough water!");
                else if (milk<75)
                    System.out.println("Sorry, not enough milk!");
                else if (beans<20)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (cups<=0)
                    System.out.println("Sorry, not enough cups!");
                break;

            case "3": // cappuccino
                if (water >= 200 && milk>= 100 &&  beans >= 12 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                water -= 200;
                milk -= 100;
                beans -= 12;
                cups--;
                money += 6;}
                else if (water<200)
                    System.out.println("Sorry, not enough water!");
                else if (milk<100)
                    System.out.println("Sorry, not enough milk!");
                else if (beans<12)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (cups<=0)
                    System.out.println("Sorry, not enough cups!");
                break;
            default:
                break;
        }

    }

    public void DoAction(String action) {
        Scanner scanner = new Scanner(System.in);
        switch (action) {
            case "buy":

                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String buyOption = scanner.nextLine();
                tryMakeCoffee(buyOption);
                break;

            case "fill":

                System.out.println("Write how many ml of water do you want to add: ");
                water += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                beans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                cups += scanner.nextInt();
                break;

            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                break;

            case "remaining":
                printAmount();
                break;

            default:
                break;
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        var coffeeMachine = new CoffeeMachine();

        while (!exit) {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            if (action.equals("exit"))
                exit = true;
            else
                coffeeMachine.DoAction(action);
        }
    }
}



