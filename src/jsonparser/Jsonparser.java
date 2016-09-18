/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Samual Young User
 */
public class Jsonparser {

    /**
     * @param args the command line arguments
     */
   
    public class result
    {
        Account[] results;
    }
    public class Account
    {
        String _id;
        double balance;
        String customer_id;
        String nickname;
        double rewards;
        String type;
        public String toString()
        {
            return _id + " " + Double.toString(balance) + " " + 
                    customer_id + nickname + Double.toString(rewards) + 
                    type;
        }
    }
    public class trResults
    {
        transfer[] results;
    }
    public class transfer
    {
        String _id;
        String amount;
        String description;
        String medium;
        String payee_id;
        String payer_id;
        String status;
        String transaction_date;
        String type;
        public String toString()
        {
            return _id +  " " + amount + " " + description + " " + medium + " " +
                    payee_id + " "  + payer_id + " " + status + " " + transaction_date + " " + 
                    type;
        }
    }
    public class bills
    {
        Bill[] results;
    }
    public class Bill
    {
        String _id;
        String account_id;
        String creation_date;
        String payee;
        String nickname;
        int recurring_date;
        String status;
        double payment_amount;
        String upcoming_payment_date;
        String payment_date;
        public String toString()
        {
            return _id + account_id + creation_date + payee + nickname + Integer.toString(recurring_date) + 
                    status + Double.toString(payment_amount) + upcoming_payment_date + payment_date;
        }
    }
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            URL url = new URL("http://api.reimaginebanking.com/enterprise/accounts?key=d96941a990d4ff44d967a6481cc36d44");
            InputStreamReader reader = new InputStreamReader(url.openStream());
            result r = new Gson().fromJson(reader, result.class);
            ArrayList<String> accountsid = new ArrayList<>();
//            
            for (Account a : r.results) accountsid.add(a._id);
            
//            {
//                System.out.println(a);
//            }
            URL url1 = new URL("http://api.reimaginebanking.com/enterprise/transfers?key=d96941a990d4ff44d967a6481cc36d44");
            reader = new InputStreamReader(url1.openStream());
            trResults r1 = new Gson().fromJson(reader, trResults.class);
//            for (transfer a : r1.results)
//            {
//                System.out.println(a);
//            }
            URL url2 = new URL("http://api.reimaginebanking.com/enterprise/bills?key=d96941a990d4ff44d967a6481cc36d44");
            reader = new InputStreamReader(url2.openStream());
            bills r2 = new Gson().fromJson(reader, bills.class);
//            for (Bill a : r2.results)
//            {
//                System.out.println(a);
//            }
//            for (Bill a : r2.results) System.out.println(accountsid.contains(a.account_id));
            for (transfer a : r1.results)
            {
                System.out.println(accountsid.contains(a.payee_id) + " " + accountsid.contains(a.payer_id));
            }
        } catch (IOException ex) {
            Logger.getLogger(Jsonparser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    public class CustomComparator implements Comparator<hasid>
//    {
//
//        @Override
//        public int compare(hasid o1, hasid o2) {
//            return o1.account_id.equalsIgnoreCase(o2.account_id) ? 0 : 1;
//        }
//        
//    };T;kktl
}
