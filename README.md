# Mahalle Güzergâh Optimizasyonu / Neighbourhood Route Optimization 

Bu proje, farklı mahalleleri çeşitli kriterlere göre değerlendirerek en uygun güzergâhı belirleyen bir karar destek sistemidir. Değerlendirme sürecinde mahallelerin çeşitli kriterler bazında puanları hesaplanır, softmax algoritması ile normalleştirilir ve en uygun mahalle seçilir.

This project is a decision support system that evaluates different neighborhoods based on various criteria to determine the optimal route. During the evaluation process, scores for neighborhoods are calculated based on various criteria, normalized using the softmax algorithm, and the most suitable neighborhood is selected.

## Proje İçeriği / Project Content

Bu proje aşağıdaki bileşenlerden oluşmaktadır:

- **Neighbourhood.java**: Mahalleleri temsil eden sınıf. Her mahalle için adı, nüfus yoğunluğu, ulaşım altyapısı, maliyet, çevresel etki ve sosyal fayda gibi özellikler içerir.
- **Main.java**: Programın ana çalışma mantığını içerir. Mahalleleri oluşturur, kriter ağırlıklarına göre puan hesaplar, softmax algoritmasını uygular ve en uygun mahalleyi belirler.

This project consists of the following components:

- **Neighbourhood.java**: Class representing neighborhoods. Each neighborhood includes attributes such as name, population density, transport infrastructure, cost, environmental impact, and social benefit.
- **Main.java**: Contains the main logic of the program. It creates neighborhoods, calculates scores based on criteria weights, applies the softmax algorithm, and determines the most suitable neighborhood.

## Kullanılan Kriterler ve Ağırlıklar / Used Criteria and Weights

Mahalleler aşağıdaki beş kritere göre değerlendirilir:

1. **Nüfus Yoğunluğu (populationDensity)**: Mahallenin nüfus yoğunluğu, daha yüksek yoğunluk daha fazla avantaj sağlayabilir.
2. **Ulaşım Altyapısı (transportInfrastructure)**: Ulaşım olanaklarının yeterliliği, daha iyi altyapıya sahip mahalleler daha yüksek puan alır.
3. **Maliyet (cost)**: Mahallede yapılacak yatırımın maliyeti, düşük maliyetler tercih edilir.
4. **Çevresel Etki (environmentalImpact)**: Bölgenin çevresel etkileri, çevre dostu bölgeler daha avantajlı kabul edilir.
5. **Sosyal Fayda (socialBenefit)**: Mahallenin sunduğu sosyal faydalar, yüksek sosyal fayda mahalleyi daha cazip hale getirir.

Bu kriterlerin her birine belirli ağırlıklar atanır ve her mahalle için toplam puan bu ağırlıklarla hesaplanır.

Neighborhoods are evaluated based on the following five criteria:

1. **Population Density (populationDensity)**: The population density of the neighborhood, higher density may provide more advantages.
2. **Transport Infrastructure (transportInfrastructure)**: The adequacy of transportation facilities, neighborhoods with better infrastructure receive higher scores.
3. **Cost (cost)**: The cost of investment in the neighborhood, lower costs are preferred.
4. **Environmental Impact (environmentalImpact)**: The environmental impacts of the area, environmentally friendly areas are considered more advantageous.
5. **Social Benefit (socialBenefit)**: The social benefits offered by the neighborhood, high social benefit makes the neighborhood more attractive.

Each of these criteria is assigned specific weights, and the total score for each neighborhood is calculated using these weights.

## Softmax Algoritması Nedir? / What is the Softmax Algorithm?

Softmax algoritması, bir dizi puanı olasılık dağılımına dönüştüren matematiksel bir fonksiyondur. Bu algoritma, her bir puanın toplam içindeki önemini belirlemek için kullanılır. Softmax fonksiyonu aşağıdaki formüle sahiptir:

The softmax algorithm is a mathematical function that converts a set of scores into a probability distribution. This algorithm is used to determine the importance of each score within the total. The softmax function has the following formula:

$$ P(i) = \frac{e^{s_i}}{\sum e^{s_j}} $$

Burada:

- <i>P(i)</i>, <i>i</i>. mahalleye ait softmax olasılığıdır.
- <i>s<sub>i</sub></i>, <i>i</i>. mahalleye ait toplam puandır.
- ∑ e<sup>s<sub>j</sub></sup>, tüm mahallelerin üstel fonksiyonlarının toplamıdır.

Bu yöntem, puanları normalleştirerek tüm değerlerin toplamının 1 olmasını sağlar ve mahallelerin birbirleriyle kıyaslanmasını kolaylaştırır.

Here:

- <i>P(i)</i> is the softmax probability for the <i>i</i>th neighborhood.
- <i>s<sub>i</sub></i> is the total score for the <i>i</i>th neighborhood.
- ∑ e<sup>s<sub>j</sub></sup> is the sum of the exponential functions of all neighborhoods.

This method normalizes the scores so that the sum of all values is 1, making it easier to compare neighborhoods with each other.

## Çalışma Mantığı / Working Logic

1. **Mahallelerin Tanımlanması**: Programda belirli mahalleler tanımlanır ve her biri için kriter değerleri atanır.
2. **Kriterlere Göre Puan Hesaplama**: Belirlenen ağırlıklara göre mahallelerin toplam puanı hesaplanır.
3. **Softmax Algoritması Uygulanması**: Hesaplanan puanlar softmax algoritması ile normalleştirilerek mahallelerin göreceli önem dereceleri belirlenir.
4. **En Uygun Güzergâhın Seçilmesi**: En yüksek softmax olasılığına sahip mahalle en uygun güzergâh olarak belirlenir.
5. **Maliyet-Fayda Analizi**: Her mahalle için maliyetin sosyal faydaya oranı hesaplanarak bir değerlendirme yapılır.
<br>

1. **Defining Neighborhoods**: Specific neighborhoods are defined in the program, and criteria values are assigned to each.
2. **Calculating Scores Based on Criteria**: The total score for neighborhoods is calculated based on the determined weights.
3. **Applying the Softmax Algorithm**: The calculated scores are normalized using the softmax algorithm to determine the relative importance of neighborhoods.
4. **Selecting the Optimal Route**: The neighborhood with the highest softmax probability is selected as the optimal route.
5. **Cost-Benefit Analysis**: A cost-benefit ratio is calculated for each neighborhood by comparing the cost to the social benefit.

## Çıktı Örneği / Sample Output

```
Karakaş Mah. Softmax Probability: 0.45
İstasyon Mah. Softmax Probability: 0.35
Bademlik Mah. Softmax Probability: 0.20

Most convenient route: Karakaş Mah.

Cost-Benefit Analysis:
Karakaş Mah. Cost-Benefit Ratio: 1.4
İstasyon Mah. Cost-Benefit Ratio: 1.2
Bademlik Mah. Cost-Benefit Ratio: 1.6
```

