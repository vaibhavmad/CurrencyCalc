package com.gl.currencycalc.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.gl.currencycalc.services.Denomination;
import com.gl.currencycalc.services.Approach;

public class PaymentCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of currency denominations:");
        int size = scanner.nextInt();
        
        Denomination[] denominations = new Denomination[size];
        
        System.out.println("Enter the currency denominations value:");
        for (int i = 0; i < size; i++) {
            denominations[i] = new Denomination(scanner.nextInt());
        }
        
        sortDenominations(denominations); // Sort denominations in descending order
        
        System.out.println("Enter the amount you want to pay:");
        int amount = scanner.nextInt();
        
        Approach[] approaches = calculateApproach(amount, denominations);
        
        System.out.println("Your payment approach in order to give min no of notes will be:");
        for (Approach approach : approaches) {
            System.out.print(approach.getDenomination().getValue() + ":" + approach.getCount() + " ");
        }
    }
    
    private static void sortDenominations(Denomination[] denominations) {
        int n = denominations.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (denominations[j].getValue() < denominations[j + 1].getValue()) {
                    // Swap denominations[j] with denominations[j+1]
                    Denomination temp = denominations[j];
                    denominations[j] = denominations[j + 1];
                    denominations[j + 1] = temp;
                }
            }
        }
    }
    
    private static Approach[] calculateApproach(int amount, Denomination[] denominations) {
        List<Approach> approaches = new ArrayList<>();
        
        for (Denomination denomination : denominations) {
            int count = amount / denomination.getValue();
            if (count > 0) {
                approaches.add(new Approach(denomination, count));
                amount %= denomination.getValue();
            }
        }
        
        return approaches.toArray(new Approach[0]);
    }
}
