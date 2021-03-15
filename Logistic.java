package Factory;

import java.util.*;

public abstract class Logistic
{
    abstract Transport createTransport(); //method create transport and return that

    public void deliver() //method for deliver a transport
    {
        Transport transport = createTransport(); //create instance of Transport interface
        transport.deliver(); //calling deliver method
    }
}

class RoadLogistic extends Logistic
{
    @Override
    public Transport createTransport()
    {
        return new Truck(); //here we will return new Truck
    }
}

class SeaLogistic extends Logistic
{
    @Override
    public Transport createTransport()
    {
        return new Ship(); //return new Ship
    }
}

interface Transport //Transport interface, something like a button
{
    public void deliver();
}

class Ship implements Transport
{
    @Override
    public void deliver()
    {
        System.out.println("Ship = " + this + "."); //return this
        System.out.println("Ship delivering !!!");
    }

}

class Truck implements Transport //Truck code structure same as Ship
{
    @Override
    public void deliver()
    {
        System.out.println("Truck = " + this + "."); //return this
        System.out.println("Truck delivering !!!");
    }
}

class Main
{
    public static void main(String[] args) throws Exception
    {
        Logistic log; //Logistic class instance

        System.out.println("Enter logistic (sea / road):");

        Scanner in = new Scanner(System.in);
        String enteredLogistic = in.next(); //entering decision of user

        if(enteredLogistic.toUpperCase().equals("SEA"))
        {
            log = new SeaLogistic(); //SeaLogistic class constructor
        }
        else if(enteredLogistic.toUpperCase().equals("ROAD"))
        {
            log = new RoadLogistic(); //RoadLogistic class constructor
        }
        else
        {
            throw new Exception("System don't know this logistic, sorry ...");
        }
    }
}
