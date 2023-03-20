
import java.net.SocketImpl;
import java.util.Scanner;

class user {
    String name, address, phonenumber;
    int age;
    String v_id, v_type, vehicle, lot;
    int floor, inhr, inmin, exhr, exmin,store;

    public user(String name, String address, String phonenumber, int age, String v_id, String v_type, String vehicle,
            String lot, int floor, int inhr, int inmin,int store) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.age = age;
        this.v_id = v_id;
        this.v_type = v_type;
        this.vehicle = vehicle;
        this.lot = lot;
        this.floor = floor;
        this.inhr = inhr;
        this.inmin = inmin;
        this.store=store;
    }

    public int get_inhr() {
        return inhr;
    }

    public int get_inmin() {
        return inmin;
    }

    public int getfloor() {
        return floor;
    }

    public String getLot() {
        return lot;
    }
}

// ParkingLot class is mostly used to take inputs from the user and to
// instantiate objects of different classes.
// Several objects of different classes and their corresponding methods are
// called from this class.
class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        user[] users;
        users = new user[50];
        CarLot c1 = new CarLot();
        BikeLot b1 = new BikeLot();
        HandiCappedVehicleLot h1 = new HandiCappedVehicleLot();
        HeavyVehicleLot he1 = new HeavyVehicleLot();
        int Th = 0, Tm = 0;
        int count = 0;int store=0;
        int userstatus[] = new int[50];
        for (int i = 0; i < 50; i++) {
            userstatus[i] = 0;
        }
        while (true) {

            System.out.println(
                    "Please select from the following \n 1)DISPLAY SLOTS \n 2) NEW USER \n 3) USER EXIT \n 4)EXIT INTERFACE");

            int start = scan.nextInt();
            if (start == 1) {
                System.out.println("SLOT DISPLAY");
                for (int v = 0; v < 10; v++) {
                    
                        System.out.print("C"+v+"["
                                + c1.carLot[v]+ "] ");
                    
                }
                System.out.println("");

                for (int v = 0; v < 10; v++) {
                  
                        System.out.print("B"+v+"["
                                + b1.Bikelot[v] + "] ");
                    
                }
                System.out.println("");
                for (int v = 0; v < 10; v++) {
                 
                        System.out.print("H"+v+"["
                                + h1.HandiCappedVehiclelot[v] + "] ");
                    
                }
                System.out.println("");
                for (int v = 0; v < 10; v++) {
                    
                        System.out.print("H.V"+v+"["
                                + he1.HeavyVehiclelot[v] + "] ");
                    
                }
                System.out.println("");

            } else if (start == 2) {
                count++;
                userstatus[count - 1] = 1;
                System.out.println("");
                int userNumber = count;
                scan.nextLine();
                System.out.println("Enter Your Name");
                String name = scan.next();
                System.out.println("Enter Your AGE");
                int age = scan.nextInt();
                System.out.println("Enter Your address");
                String address = scan.next();
                System.out.println("Enter Your PhoneNumber");
                String phonenumber = scan.next();
                int count1=0,count2=0,count3=0,count4=0;
                
                while (true) {
                    System.out.println(
                            "SELECT YOUR VEHICLE TYPE  (1)car  (2)Bike  (3)Handicapped  (4)HeavyVehicle");
                    int input = scan.nextInt();
                    // This while loop allows a maximum of ten users to enter their details one
                    // after the other.
                    // we can increase the capacity of users by incrementing the value of p.

                    if (input == 1) {count1++;
                        System.out.print("Enter which floor you want to park :");
                        int fn = scan.nextInt();
                        System.out.println();
                        floor Fl = new floor(fn);

                        // class 'floor' has a field called 'Floor number' which is initialized
                        // automatically when an object of type 'floor' is
                        // created by passing the parameter.There is a constructor within the class
                        // 'floor' which will initialize this field
                        // floor number as soon as the object is created.
                        System.out.println("Enter your VehicleID");
                        String VId = scan.next();
                        System.out.println("VehicleType(Electric/Non-Electric)");
                        String Vtype = scan.next();
                        car A = new car(VId, Vtype);
                        // the class 'car' is a sub-class of the parent class 'Vehicle'.'Vehicle' class
                        // has the fields 'vehicle id'
                        // and 'vehicle type'.
                        // the constructor that we defined in the child class 'car' forms constructor
                        // chaining with the constructor present
                        // in the parent class and initialize the fields.
                        System.out.println("Enter Entry Time(hour)");
                        Th = scan.nextInt();
                        System.out.println("Enter Entry Time(Minutes)");
                        Tm = scan.nextInt();
                        EntryTerminal e = new EntryTerminal(Th, Tm);
                        // the entryterminal is the child class of the class 'terminal' in which the
                        // fields related to entrytime are defined.
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        System.out.println("PLEASE COLLECT YOUR PARKING TICKET");
                        System.out.println("Name :"+name+"\n"+"age :"+age+"\n"+"phoneNumber :"+phonenumber+"\n"+"address :"+address);
                        System.out.print(
                                "Vehicle ID :-" + A.getVehicleId() + "\n Vehicle Type:- " + A.getVehicleType()
                                        + "\n Entry Time:-");
                        // In the above line we have used getvehicleId and getvehicletype methods to
                        // access the corresponding fields because
                        // the fields are declared private and one cannot access the private fields
                        // outside the class directly.
                        e.GetTime();
                        System.out.println("");
                        System.out.println("Your parking Slot is floor number " + Fl.getFloorNumber() + " and " + "C["
                                + c1.getLot() + "] slot");
                                 store=c1.getLot();
                        c1.carLot[c1.getLot()] = 1;

                        // the class 'car lot' has the method 'getlot' which will return the value of
                        // the nearest empty slot .
                        // the above line will initialise the alloted slot to 1(indicating that the slot
                        // is filled).
                        String lot = "C[" + (char) (c1.getLot() + '0') + "]";
                        users[count - 1] = new user(name, address, phonenumber, age, A.getVehicleId(),
                                A.getVehicleType(), "car", lot, fn, Th, Tm,store);
                        System.out.println("Your Entrance is through 1st Gate");
                        System.out.println("    **FARING DETAILS**    ");
                        System.out.println("CUSTOMER HAS TO PAY ");
                        System.out.println("BASIC PRICE       :  $20 ");
                        System.out.println("1ST HOUR          :  $20 ");
                        System.out.println("2ND & 3RD HOURS   :  $10 ");
                        System.out.println("SUBSEQUENT HOURS  :  $5  ");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        break;

                    }

                    else if (input == 2) {count2++;
                        System.out.print("Enter which floor you want to park :");
                        int fn = scan.nextInt();
                        System.out.println();
                        floor Fl = new floor(fn);
                        System.out.println("Enter your VehicleID");
                        String VId = scan.next();
                        System.out.println("VehicleType(Electric/Non-Electric)");
                        String Vtype = scan.next();
                        Bike B = new Bike(VId, Vtype);
                        System.out.println("Enter Entry Time(hour)");
                        Th = scan.nextInt();
                        System.out.println("Enter Entry Time(Minutes)");
                        Tm = scan.nextInt();
                        EntryTerminal e = new EntryTerminal(Th, Tm);
                        System.out.println("PLEASE COLLECT YOUR PARKING TICKET");
                        System.out.println("Name :"+name+"\n"+"age :"+age+"\n"+"phoneNumber :"+phonenumber+"\n"+"address :"+address);
                        System.out
                                .println("Vehicle ID :-" + B.getVehicleId() + "\n Vehicle Type:- " + B.getVehicleType()
                                        + "\n Entry Time:-");
                        e.GetTime();
                        System.out.println("");
                        System.out.println("Your parking Slot is B[" + b1.getLot() + "]");
                        store=b1.getLot();
                        b1.Bikelot[b1.getLot()] = 1;
                        String lot = "B[" + (char) (b1.getLot() + '0') + "]";
                        users[count - 1] = new user(name, address, phonenumber, age, B.getVehicleId(),
                                B.getVehicleType(), "bike", lot, fn, Th, Tm,store);
                        System.out.println("Your Entrance is through 2nd Gate");
                        System.out.println("    **FARING DETAILS**    ");
                        System.out.println("CUSTOMER HAS TO PAY ");
                        System.out.println("BASIC PRICE       :  $20 ");
                        System.out.println("1ST HOUR          :  $20 ");
                        System.out.println("2ND & 3RD HOURS   :  $10 ");
                        System.out.println("SUBSEQUENT HOURS  :  $5  ");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        break;

                    } else if (input == 3) {count3++;
                        System.out.print("Enter which floor you want to park :");
                        int fn = scan.nextInt();
                        System.out.println();
                        floor Fl = new floor(fn);
                        System.out.println("Enter your VehicleID");
                        String VId = scan.next();
                        System.out.println("VehicleType(Electric/Non-Electric)");
                        String Vtype = scan.next();
                        HandiCappedVehcile H = new HandiCappedVehcile(VId, Vtype);
                        System.out.println("Enter Entry Time(hour)");
                        Th = scan.nextInt();
                        System.out.println("Enter Entry Time(Minutes)");
                        Tm = scan.nextInt();
                        EntryTerminal e = new EntryTerminal(Th, Tm);
                        System.out.println("PLEASE COLLECT YOUR PARKING TICKET");
                        System.out.println("Name :"+name+"\n"+"age :"+age+"\n"+"phoneNumber :"+phonenumber+"\n"+"address :"+address);
                        System.out
                                .println("Vehicle ID :-" + H.getVehicleId() + "\n Vehicle Type:- " + H.getVehicleType()
                                        + "\n Entry Time:-");
                        e.GetTime();
                        System.out.println("");
                        System.out.println("Your parking Slot is H[" + h1.getLot() + "]");
                        store=h1.getLot();
                        h1.HandiCappedVehiclelot[h1.getLot()] = 1;
                        String lot = "H[" + ((char) h1.getLot()) + '0' + "]";
                        users[count - 1] = new user(name, address, phonenumber, age, H.getVehicleId(),
                                H.getVehicleType(), "Handicapped vehicle", lot, fn, Th, Tm,store);
                        System.out.println("Your Entrance is through 3rd Gate");
                        System.out.println("    **FARING DETAILS**    ");
                        System.out.println("CUSTOMER HAS TO PAY ");
                        System.out.println("BASIC PRICE       :  $20 ");
                        System.out.println("1ST HOUR          :  $20 ");
                        System.out.println("2ND & 3RD HOURS   :  $10 ");
                        System.out.println("SUBSEQUENT HOURS  :  $5  ");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        break;

                    } else if (input == 4) {count4++;
                        System.out.print("Enter which floor you want to park :");
                        int fn = scan.nextInt();
                        System.out.println();
                        floor Fl = new floor(fn);
                        System.out.println("Enter your VehicleID");
                        String VId = scan.next();
                        System.out.println("VehicleType(Electric/Non-Electric)");
                        String Vtype = scan.next();
                        HeavyVehicle Hv = new HeavyVehicle(VId, Vtype);
                        System.out.println("Enter Entry Time(hour)");
                        Th = scan.nextInt();
                        System.out.println("Enter Entry Time(Minutes)");
                        Tm = scan.nextInt();
                        EntryTerminal e = new EntryTerminal(Th, Tm);
                        System.out.println("PLEASE COLLECT YOUR PARKING TICKET");
                        System.out.println("Name :"+name+"\n"+"age :"+age+"\n"+"phoneNumber :"+phonenumber+"\n"+"address :"+address);
                        System.out.println(
                                "Vehicle ID :-" + Hv.getVehicleId() + "\n Vehicle Type:- " + Hv.getVehicleType()
                                        + "\n Entry Time:-");
                        e.GetTime();
                        System.out.println("");
                        System.out.println("Your parking Slot is H.V.[" + he1.getLot() + "]");
                        store=he1.getLot();
                        he1.HeavyVehiclelot[he1.getLot()] = 1;
                        String lot = "H.V[" + ((char) he1.getLot()) + '0' + "]";
                        users[count - 1] = new user(name, address, phonenumber, age, Hv.getVehicleId(),
                                Hv.getVehicleType(), "Heavy vehicle", lot, fn, Th, Tm,store);
                        System.out.println("Your Entrance is through 4th Gate");
                        System.out.println("    **FARING DETAILS**    ");
                        System.out.println("CUSTOMER HAS TO PAY ");
                        System.out.println("BASIC PRICE       :  $20 ");
                        System.out.println("1ST HOUR          :  $20 ");
                        System.out.println("2ND & 3RD HOURS   :  $10 ");
                        System.out.println("SUBSEQUENT HOURS  :  $5  ");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        System.out.println("- - - - - - - - - - - - - - - - - -");
                        break;

                    } else {
                        continue;
                    }

                }

            }

            else if (start == 3) {
                System.out.println("ENTER USER NUMBER");

                for (int i = 1; i <= count; i++) {
                    if (userstatus[i - 1] == 1) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                int userchoice = scan.nextInt();
                int a2 = users[userchoice - 1].get_inhr();
                int a1 = users[userchoice - 1].get_inmin();
                System.out.println("Enter EXIT TIME in Hours");
                int a4 = scan.nextInt();
                System.out.println("Enter EXIT TIME in Minutes");
                int a3 = scan.nextInt();

                ExitTerminal eee = new ExitTerminal(a3, a4);
                eee.with_draw();
                while (true) {
                    // this loop will run as long as the user decides to withdraw or not.
                    // even when the user chooses option other than 1 or 2 ,the loop will give him
                    // another chance to choose the right option.

                    int choice6 = scan.nextInt();
                    if (choice6 == 1) {
                        checkout pp = new checkout(a1, a2, a3, a4);

                        pp.check_out();
                        int fare = 0;
                        int ph = a4 - a2;
                        int pm = a3 - a1;
                        int z = ph;
                        if (pm > 0) {
                            ph++;
                        }
                        if (ph == 1) {
                            fare = 20;
                        } else if (ph == 2) {
                            fare = 30;
                        } else if (ph == 3) {
                            fare = 40;
                        } else if (ph > 3) {
                            fare = 40 + (z - 2) * 5;
                        }
                        // the parameters passed while creating the object of checkout class are related
                        // to entry and exit time.

                        payment pay = new payment(fare + 20);

                        // we set the fare to be by-default 20 as mentioned in the question.
                        pay.do_pay();
                        if((users[userchoice-1].vehicle).equals("car")==true)
                        {
                            c1.carLot[users[userchoice-1].store]=0;
                        }
                        if((users[userchoice-1].vehicle).equals("bike")==true)
                        {
                            b1.Bikelot[users[userchoice-1].store]=0;
                        }
                        if((users[userchoice-1].vehicle).equals("Handicapped vehicle")==true)
                        {
                            h1.HandiCappedVehiclelot[users[userchoice-1].store]=0;
                        }
                        if((users[userchoice-1].vehicle).equals("Heavy vehicle")==true)
                        {
                            he1.HeavyVehiclelot[users[userchoice-1].store]=0;
                        }
                        userstatus[userchoice - 1] = 0;

                    } else if (choice6 == 2) {
                        System.out.println("Your checkout has been failed.");
                    } else {
                        continue;
                    }
                    break;
                }
                // System.out.println("ARE YOU CHECKING OUT? \n Type YES OR NO ACCORDINGLY");
                // String d=scan.next();
                // if(d.equals("YES")){
                // System.out.println("ENTER \n Intime in Minutes");
                // int a1= scan.nextInt();
                // System.out.println("ENTER \n Intime in hours");
                // int a2= scan.nextInt();
                // System.out.println("ENTER \n Outtime in Minutes");
                // int a3= scan.nextInt();
                // System.out.println("ENTER \n Outtime in Minutes");
                // int a4= scan.nextInt();

                // checkout ch = new checkout(a1,a2,a3,a4);
                // ch.check_out();

                // }

            } else if (start == 4) {
                break;
            } else {
                continue;
            }
        }
    }

}

abstract class withdraw {
    int intime_min, intime_hr, outtime_min, outtime_hr;

    // we cannot create objects of abstract class.
    // there is a constructor chaining which will initialize the fields.
    public withdraw(int intime_min, int intime_hr, int outtime_min, int outtime_hr) {
        this.intime_min = intime_min;
        this.outtime_min = outtime_min;
        this.intime_hr = intime_hr;
        this.outtime_hr = outtime_hr;
    }

    // public abstract void proceedtopayment();
}

class checkout extends withdraw {
    // since checkout extends withdraw, we can access the fields inside withdraw.
    public checkout(int intime_min, int intime_hr, int outtime_min, int outtime_hr) {
        super(intime_min, intime_hr, outtime_min, outtime_hr);
    }

    int aaa = outtime_min;
    int bbb = intime_min;
    int time_parked_hrs = (outtime_hr - intime_hr + 24) % 24;
    int time_parked_mins = (outtime_min - intime_min + 60) % 60;
    {
        if (aaa - bbb < 0) {
            time_parked_hrs = time_parked_hrs - 1;
        }
    }

    public void check_out() {

        while (true) {
            System.out.println("Hi!" /* + name */);
            System.out.println("Are you already checking out?");
            System.out.println("(1)YES   (2)NO ");
            // this loop will run until the user chooses either option 1 or 2.
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You are about to checkout along with your vehicle!");
                // print details of owner and vehicle System.out.println("");
                System.out.println("you checked in with your vehicle at " + intime_hr + " : " + intime_min);
                System.out.println(
                        "You have parked your vehicle for " + time_parked_hrs + " hrs " + time_parked_mins + "mins ");
                System.out.println("Do you want to proceed to your payment?");
                System.out.println("(1)YES (2)NO");
                int choice2 = scan.nextInt();
                if (choice2 == 1) {

                    // System.out.println("The fare for your vehicle parking is: "+ fare);

                } else if (choice2 == 2) {
                    System.out.println("Your payment has been terminated.");
                    continue;
                } else {
                    continue;
                }
                break;
            } else if (choice == 2) {
                System.out.println("You are not ckecking out.");
            } else {
                System.out.println("please make a valid choice");
                continue;
            }
        }
    }
}

class payment {
    // this class is used to process all the payment related things.
    private int fare;

    public payment(int fare) {
        this.fare = fare;
    }

    public void do_pay() {
        System.out.println("Your bill is " + fare + "/-");

        while (true) {
            System.out.println("Select your payment medium.");
            System.out.println("(1)Terminal (2)Website");
            Scanner scan = new Scanner(System.in);
            int choice3 = scan.nextInt();
            if (choice3 == 1) {
                System.out.println("please select your payment method.");
                System.out.println("(1)Cash (2)Card (3)UPI");
                while (true) {
                    int choice4 = scan.nextInt();
                    if (choice4 == 1) {
                        System.out.println("Please pay the cash at the cash counter.");
                        int cash = scan.nextInt();
                        if (cash < fare) {
                            System.out.println("Cash is insufficient");
                        } else {
                            System.out.println("Your payment is successful.");
                            if (cash > fare) {
                                System.out.println("Please collect Your cash change of " + (cash - fare) + "/-");
                            }

                            System.out.println("Your payment is successful.");
                            System.out.println("Thanks for using our parking services, come again!");
                        }
                    } else if (choice4 == 2) {
                        System.out.println("Please enter your card details.");
                        System.out.println("proceed to pay");
                        System.out.println("Your payment is successful.");
                        System.out.println("Thanks for using our parking services, come again!");
                    } else if (choice4 == 3) {
                        System.out.println("Scan this QR code to complete the payment.");
                        System.out.println("Your payment is successful.");
                        System.out.println("Thanks for using our parking services, come again!");
                    } else {
                        System.out.println("please make a valid choice");
                        continue;
                    }
                    break;
                }
            } else if (choice3 == 2) {
                System.out.println("Your payment is being directed to the website.");

                while (true) {
                    System.out.println("Do you want to complete your payment?");
                    System.out.println("(1)Yes (2)No");
                    int choice5 = scan.nextInt();
                    if (choice5 == 1) {
                        System.out.println("Your payment is being initiated..");
                        System.out.println("Your payment is successful.");
                        System.out.println("Thanks for using our parking services, come again!");
                    } else if (choice5 == 2) {
                        System.out.println("The payment has been faied!");
                        continue;
                    } else {
                        System.out.println("please make a valid choice");
                        continue;
                    }
                    break;
                }

            } else {
                System.out.println("please make a valid choice");
                continue;
            }
            break;
        }

    }

}

// we have created a separate class 'floor' and extended it to different floors
// of the building.
// this is done in order to add different functionality to different floors
// without disturbing the others.
class floor {
    int floorNumber;

    public floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

}

class floor1 extends floor {
    public floor1(int floorNumber) {
        super(floorNumber);
        // this super keyword is used to form constructor-chaining with the constructor
        // in the parent class.
    }

}

// we can add different functionalities to the floor 1 independent of other
// floors if we want to.
class floor2 extends floor {
    public floor2(int floorNumber) {
        super(floorNumber);
    }

}

class floor3 extends floor {
    public floor3(int floorNumber) {
        super(floorNumber);
    }

}

class vehicle {
    private String VehicleId;
    private String VehicleType;
    // since the fields are declared private.
    // we cannot directly access them while creating the object.so there has to be
    // get,set methods or constructor to initialize the fields.

    public vehicle(String VehicleId, String VehicleType) {
        this.VehicleId = VehicleId;
        this.VehicleType = VehicleType;

    }

    public String getVehicleId() {
        return VehicleId;
    }

    public String getVehicleType() {
        return VehicleType;
    }

}

class car extends vehicle {
    public car(String VehicleId, String VehicleType) {
        super(VehicleId, VehicleType);
    }

}

class HeavyVehicle extends vehicle {
    public HeavyVehicle(String VehicleId, String VehicleType) {
        super(VehicleId, VehicleType);
    }
}

class Bike extends vehicle {
    public Bike(String VehicleId, String VehicleType) {
        super(VehicleId, VehicleType);
    }

}

class HandiCappedVehcile extends vehicle {
    public HandiCappedVehcile(String VehicleId, String VehicleType) {
        super(VehicleId, VehicleType);
    }
}

class CarLot extends ParkingLot {

    int carLot[] = new int[10];
    // there are 10 slots which are only for parking cars.
    // when a slot is alloted then its boolean value has to be set to 1 which is
    // done in the main function of the program.
    // we can also change the boolean value in this class itself.

    public int getLot() {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            if (carLot[i] == 0) {
                k = i;

                break;

            }

        }
        return k;
        // this will return the nearest slot to the user as it is the first slot which
        // is empty.
    }

}

class BikeLot extends ParkingLot {
    int Bikelot[] = new int[10];

    public int getLot() {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            if (Bikelot[i] == 0) {
                k = i;

                break;

            }

        }
        return k;
    }

}

class HeavyVehicleLot extends ParkingLot {
    int HeavyVehiclelot[] = new int[10];

    public int getLot() {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            if (HeavyVehiclelot[i] == 0) {
                k = i;

                break;

            }

        }
        return k;
    }

}

class HandiCappedVehicleLot extends ParkingLot {
    int HandiCappedVehiclelot[] = new int[10];

    public int getLot() {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            if (HandiCappedVehiclelot[i] == 0) {
                k = i;

                break;

            }

        }
        return k;
    }
}

// the class 'terminal' is used to work with the entry and exit time of the
// user.
// there are no four different fields for entry and exit times.there are only
// two fields which can be entry or exit based on the childclass from which the
// constructor is called.
class terminal {
    private int TimeInHour;
    private int TimeInMinutes;

    // since the fields are private they cannot be initialized directly.so we have
    // used constructor to inititalize the fields.
    public terminal(int TimeInHour, int TimeInMinutes) {
        this.TimeInHour = TimeInHour;
        this.TimeInMinutes = TimeInMinutes;
    }

    public void GetTime() {
        System.out.print(TimeInHour + ":" + TimeInMinutes);
    }

}

class EntryTerminal extends terminal {
    public EntryTerminal(int TimeInHour, int TimeInMinutes) {
        super(TimeInHour, TimeInMinutes);
    }

}

// we have created two subclasses for terminal,to work with the two classes
// independently when needed.
class ExitTerminal extends terminal {
    public ExitTerminal(int TimeInHour, int TimeInMinutes) {
        super(TimeInHour, TimeInMinutes);
    }

    public void with_draw() {
        System.out.println("Do you want to withdraw your vehicle?");
        System.out.println("(1)YES (2)NO");
    }

}