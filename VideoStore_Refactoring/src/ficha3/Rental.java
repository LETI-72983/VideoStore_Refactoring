package ficha3;

import v9.Movie;

public class Rental
{
    v9.Movie _movie;
    private int		_daysRented;

    public Rental(v9.Movie movie, int daysRented)
    {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented()
    {
        return _daysRented;
    }

    public Movie getMovie()
    {
        return _movie;
    }
}
