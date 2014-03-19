package uml.spring2014;

/**
 * @author jtolla
 *
 */
public class Stock {

    private String tickerSymbol;
    private Double price;
    private Integer volume;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekLow;

    public Stock(String tickerSymbol, Double price, Integer volume,
                 Double fiftyTwoWeekHigh, Double fiftyTwoWeekLow) {

        this.tickerSymbol = tickerSymbol;
        this.price = price;
        this.volume = volume;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;

    }

    public String getTickerSymbol() {


        return tickerSymbol;
    }

    public Double getCurrentPrice() { return price; }

    public Integer getVolume() { return volume; }

    public Double getFiftyTwoWeekHigh() { return fiftyTwoWeekHigh; }

    public Double getFiftyTwoWeekLow() { return fiftyTwoWeekLow; }

}
