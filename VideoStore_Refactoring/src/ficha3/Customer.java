package ficha3;

import java.util.Vector;

public class Customer
{
	private String			_name;
	private Vector<Rental>	_rentals	= new Vector<Rental>();

	public Customer(String _name)
	{
		this._name = _name;
	}

	public void addRental(Rental arg)
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
			double thisAmount = 0;



            frequentRenterPoints += getFrequentRentalPoints(each);

            // show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

    private int getFrequentRentalPoints(Rental each) {


        // add frequent renter points
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if ((each.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && each.getDaysRented() > 1)
            frequentRenterPoints = 2;
        return frequentRenterPoints;
    }

}
