import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create neighborhoods
        List<Neighbourhood> neighbourhoods = new ArrayList<>();
        neighbourhoods.add(new Neighbourhood("Karakaş Mah.", 8, 7, 5, 6, 7));
        neighbourhoods.add(new Neighbourhood("İstasyon Mah.", 6, 6, 3, 9, 8));
        neighbourhoods.add(new Neighbourhood("Bademlik Mah.", 4, 4, 8, 4, 5));

        // Define criterion weights
        double populationDensityWeight = 0.3;
        double transportInfrastructureWeight = 0.2;
        double costWeight = 0.3;
        double environmentalImpactWeight = 0.1;
        double socialBenefitWeight = 0.1;

        // Calculate scores for each neighborhood
        double[] scores = new double[neighbourhoods.size()];
        for (int i = 0; i < neighbourhoods.size(); i++) {
            Neighbourhood neighborhood = neighbourhoods.get(i);
            scores[i] = neighborhood.getPopulationDensity() * populationDensityWeight +
                    neighborhood.getTransportInfrastructure() * transportInfrastructureWeight +
                    neighborhood.getCost() * costWeight +
                    neighborhood.getEnvironmentalImpact() * environmentalImpactWeight +
                    neighborhood.getSocialBenefit() * socialBenefitWeight;
        }

        // Calculate Softmax probabilities
        double[] softmax = calculateSoftmax(scores);

        // Print Softmax probabilities
        for (int i = 0; i < neighbourhoods.size(); i++) {
            System.out.println(neighbourhoods.get(i).getName() + " Softmax Probability: " + softmax[i]);
        }

        // Determine the optimal route
        int optimalIndex = findOptimalRoute(softmax);
        System.out.println("\nMost convenient route: " + neighbourhoods.get(optimalIndex).getName());

        // Perform cost-benefit analysis
        System.out.println("\nCost-Benefit Analysis:");
        for (int i = 0; i < neighbourhoods.size(); i++) {
            Neighbourhood neighborhood = neighbourhoods.get(i);
            double costBenefitRatio = (double) neighborhood.getCost() / neighborhood.getSocialBenefit();
            System.out.println(neighborhood.getName() + " Cost-Benefit Ratio: " + costBenefitRatio);
        }
    }

    // Softmax calculation method
    public static double[] calculateSoftmax(double[] scores) {
        double[] expScores = new double[scores.length];
        double sumExp = 0.0;

        // Calculate exponential of scores and their sum
        for (int i = 0; i < scores.length; i++) {
            expScores[i] = Math.exp(scores[i]);
            sumExp += expScores[i];
        }

        // Calculate Softmax probabilities
        double[] softmax = new double[scores.length];
        for (int i = 0; i < scores.length; i++) {
            softmax[i] = expScores[i] / sumExp;
        }

        return softmax;
    }

    // Find the optimal route based on Softmax probabilities
    public static int findOptimalRoute(double[] softmax) {
        int optimalIndex = 0;
        double maxProbability = softmax[0];

        for (int i = 1; i < softmax.length; i++) {
            if (softmax[i] > maxProbability) {
                maxProbability = softmax[i];
                optimalIndex = i;
            }
        }

        return optimalIndex;
    }
}