package Main;

import Logic.Logic;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("######## Bienvenido a tu Conversor de Moneda ########");
        System.out.println("Escribe tu nombre por favor");
        Scanner scanner = new Scanner(System.in);
        Scanner scannerCurrency = new Scanner(System.in);
        int x = 1;
        String localCurrency;
        String toCurrency;
        int sel;
        while (x != 0){
            System.out.println("Que deseas realizar: ");
            System.out.println("1. Convertir la moneda");
            System.out.println("2. Mirar las monedas admitidas (Si es tu primera vez usando el programa te recomiendo entrar aqui)");
            sel= scanner.nextInt();
            switch (sel){
                case 1:
                    System.out.println("Escribe la moneda en la que tienes el dinero (Ej: si la tienes en dolares escribe USD)");
                    localCurrency = scannerCurrency.nextLine();
                    System.out.println("Escribe la moneda a la que deseas convertir tu dinero");
                    toCurrency = scannerCurrency.nextLine();
                    new Logic().getConvertion(localCurrency,toCurrency);
                    break;
                case 2:
                    new Logic().allCurrencies();
                    break;
            }
            System.out.println("Deseas hacer otra conversion? si= 1 o no=0");
            x= scanner.nextInt();
            }
        }
    }