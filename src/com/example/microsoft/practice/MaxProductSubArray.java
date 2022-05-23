package com.example.microsoft.practice;


/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Return an integer corresponding to the maximum product possible.
 * <p>
 * Example :
 * <p>
 * Input : [2, 3, -2, 4]
 * Return : 6
 * <p>
 * Possible with [2, 3]
 */
public class MaxProductSubArray {
}
/*

class ChainResponseMain {
    public static void main(String[] args) {
        Manager m = new Manager();
        Director d = new Director();
        VP v = new VP();
        CEO c = new CEO();

        m.setSuccessor(d);
        d.setSuccessor(v);
        v.setSuccessor(c);

        //Purchase for 1000 bucks.
        PurchaseRequest r = new PurchaseRequest(1000);
        m.handleRequest(r);

        //Purchase for 1500 bucks.
        r = new PurchaseRequest(1500);
        m.handleRequest(r);

        //Purchase for 2000 bucks
        r = new PurchaseRequest(2000);
        m.handleRequest(r);

        //Purchase for 2500 bucks
        r = new PurchaseRequest(2500);
        m.handleRequest(r);
    }
}

abstract class Handler {
    protected Handler succesor;

    public void setSuccessor(Handler handler) {
        this.succesor = handler;
    }

    public abstract void handleRequest(PurchaseRequest req);
}

class Manager extends Handler {

    @Override
    public void handleRequest(PurchaseRequest req) {
        if (req.getAmount() <= 1000) {
            System.out.println("Request handled by Manager");
        } else {
            succesor.handleRequest(req);
        }
    }
}

class Director extends Handler {
    @Override
    public void handleRequest(PurchaseRequest req) {
        if (req.getAmount() <= 1500) {
            System.out.println("Request handled by Director");
        } else {
            succesor.handleRequest(req);
        }
    }
}

class VP extends Handler {
    @Override
    public void handleRequest(PurchaseRequest req) {
        if (req.getAmount() <= 2000) {
            System.out.println("Request handled by VP");
        } else {
            succesor.handleRequest(req);
        }
    }
}

class CEO extends Handler {
    @Override
    public void handleRequest(PurchaseRequest req) {
        System.out.println("Request handled by CEO");
    }
}

class PurchaseRequest {
    private int amount;
    PurchaseRequest(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

//Example
        class CommandPatternDemo{
            public static void main(String[] args) {
                Task task1 = new Task(10, 20);//Encapsulates request
                Task task2 = new Task(11, 22);//Encapsulates request

                Thread thread1 = new Thread(task1);
                thread1.start();//Invoker

                Thread thread2 = new Thread(task2);
                thread2.start();//Invoker
            }


        }

        class Task implements Runnable {

            private final int val1;
            private final int val2;

            public Task(int val1, int val2) {
                this.val1 = val1;
                this.val2 = val2;
            }

            @Override
            public void run() {
                System.out.println(val1 * val2);//Receiver
            }
        }

//Example
        class CommandDemo{
            public static void main(String[] args) {
                Light light  = new Light();
                Switch swich = new Switch();

//                Command toggleCommand = new ToggleCommand(light);
                swich.storeAndExecute(toggleCommand);
            }

        }
        interface Command{
            void execute();
        }

        //Receiver
        class Light{
            private boolean isOn = false;

            public void toggle(){
                if (isOn){
                    off();
                    isOn = false;
                }else{
                    on();
                    isOn = true;
                }
            }


            private void on(){
                System.out.println("Light switched on");
            }

            private void off(){
                System.out.println("Light switched off");
            }
        }

        //Invoker
        class Switch{
            public void storeAndExecute(Command command){
                command.execute();
            }
        }*/
//
//        //Concrete command
//        public class ToggleCommand implements Command {
//
//            private Light light;
//            public ToggleCommand(Light light) {
//                this.light= light;
//            }
//
//            @Override
//            public void execute() {
//                light.toggle();
//            }
//        }
