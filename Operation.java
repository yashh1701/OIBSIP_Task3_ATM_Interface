package AtmInterface;
import java.util.HashMap;
import java.util.Map;

public class Operation implements AtmAnother
{
    ATM a = new ATM();
    Map<Double, String> ministmt = new HashMap<>();

    public void viewBalance()
    {
        System.out.println("Available Balance is : " + a.getBalance());
    }


    @Override
    public void withdrawAmount(double withdrawAmount)
    {
        if (withdrawAmount % 500 == 0)
        {
            if (withdrawAmount <= a.getBalance())
            {
                ministmt.put(withdrawAmount, "Amount Withdrawn");
                System.out.println("Collect the cash " + withdrawAmount);
                a.setBalance(a.getBalance() - withdrawAmount);
                viewBalance();
            }
            else
            {
                System.out.println("Insufficient Balance!!");
            }
        }
        else
        {
            System.out.println("Please enter the amount in multiple og 500");
        }
    }

      @Override
      public void depositAmount(double depositAmount)
      {
        ministmt.put(depositAmount, " Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully !!");
        a.setBalance(a.getBalance() + depositAmount);
        viewBalance();
        }

        @Override
        public void viewtransaction_history()
       {
            for (Map.Entry<Double, String> m : ministmt.entrySet())
            {
                System.out.println(m.getKey() + " " + m.getValue());
            }
       }
   }
