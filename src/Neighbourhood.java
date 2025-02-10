public class Neighbourhood
{
    private String name;
    private int populationDensity;
    private int transportInfrastructure;
    private int cost;
    private int environmentalImpact;
    private int socialBenefit;

    public Neighbourhood(String name, int populationDensity, int transportInfrastructure, int cost,
                         int environmentalImpact, int socialBenefit)
    {
        this.name = name;
        this.populationDensity = populationDensity;
        this.transportInfrastructure = transportInfrastructure;
        this.cost = cost;
        this.environmentalImpact = environmentalImpact;
        this.socialBenefit = socialBenefit;
    }
    // Getter metods
    public String getName()
    {
        return name;
    }
    public int getPopulationDensity()
    {
        return populationDensity;
    }
    public int getTransportInfrastructure()
    {
        return transportInfrastructure;
    }
    public int getCost()
    {
        return cost;
    }
    public int getEnvironmentalImpact()
    {
        return environmentalImpact;
    }
    public int getSocialBenefit()
    {
        return socialBenefit;
    }
}
