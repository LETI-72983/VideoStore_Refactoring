package ficha3;

import v2.Movie;
import v2.Rental;

import java.util.Vector;

public class Customer
{
    private String			_name;
    private Vector<v2.Rental>	_rentals	= new Vector<v2.Rental>();

    public Customer(String _name)
    {
        this._name = _name;
    }

    public void addRental(v2.Rental arg)
    {
        _rentals.addElement(arg);
    }

    public String getName()
    {
        return _name;
    }

    public String statement()
    {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        // header
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each: _rentals)
        {

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getAmount() + "\n";
            totalAmount += each.getAmount();
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}


