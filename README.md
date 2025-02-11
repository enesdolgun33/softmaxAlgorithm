# Neighbourhood Route Optimization

Bu proje, farklı mahalleleri çeşitli kriterlere göre değerlendirerek en uygun güzergâhı belirleyen bir karar destek sistemidir. Değerlendirme sürecinde mahallelerin çeşitli kriterler bazında puanları hesaplanır, softmax algoritması ile normalleştirilir ve en uygun mahalle seçilir.

## Proje İçeriği

Bu proje aşağıdaki bileşenlerden oluşmaktadır:

- **Neighbourhood.java**: Mahalleleri temsil eden sınıf. Her mahalle için adı, nüfus yoğunluğu, ulaşım altyapısı, maliyet, çevresel etki ve sosyal fayda gibi özellikler içerir.
- **Main.java**: Programın ana çalışma mantığını içerir. Mahalleleri oluşturur, kriter ağırlıklarına göre puan hesaplar, softmax algoritmasını uygular ve en uygun mahalleyi belirler.

## Kullanılan Kriterler ve Ağırlıklar

Mahalleler aşağıdaki beş kritere göre değerlendirilir:

1. **Nüfus Yoğunluğu (populationDensity)**: Mahallenin nüfus yoğunluğu, daha yüksek yoğunluk daha fazla avantaj sağlayabilir.
2. **Ulaşım Altyapısı (transportInfrastructure)**: Ulaşım olanaklarının yeterliliği, daha iyi altyapıya sahip mahalleler daha yüksek puan alır.
3. **Maliyet (cost)**: Mahallede yapılacak yatırımın maliyeti, düşük maliyetler tercih edilir.
4. **Çevresel Etki (environmentalImpact)**: Bölgenin çevresel etkileri, çevre dostu bölgeler daha avantajlı kabul edilir.
5. **Sosyal Fayda (socialBenefit)**: Mahallenin sunduğu sosyal faydalar, yüksek sosyal fayda mahalleyi daha cazip hale getirir.

Bu kriterlerin her birine belirli ağırlıklar atanır ve her mahalle için toplam puan bu ağırlıklarla hesaplanır.

## Softmax Algoritması Nedir?

Softmax algoritması, bir dizi puanı olasılık dağılımına dönüştüren matematiksel bir fonksiyondur. Bu algoritma, her bir puanın toplam içindeki önemini belirlemek için kullanılır. Softmax fonksiyonu aşağıdaki formüle sahiptir:

$$ P(i) = \frac{e^{s_i}}{\sum e^{s_j}} $$

Burada:

- <p><i>P(i)</i>, <i>i</i>. mahalleye ait softmax olasılığıdır.</p>
- <p><i>s<sub>i</sub></i>, <i>i</i>. mahalleye ait toplam puandır.</p>
- <p>∑ e<sup>s<sub>j</sub></sup>, tüm mahallelerin üstel fonksiyonlarının toplamıdır.</p>

Bu yöntem, puanları normalleştirerek tüm değerlerin toplamının 1 olmasını sağlar ve mahallelerin birbirleriyle kıyaslanmasını kolaylaştırır.

## Çalışma Mantığı

1. **Mahallelerin Tanımlanması**: Programda belirli mahalleler tanımlanır ve her biri için kriter değerleri atanır.
2. **Kriterlere Göre Puan Hesaplama**: Belirlenen ağırlıklara göre mahallelerin toplam puanı hesaplanır.
3. **Softmax Algoritması Uygulanması**: Hesaplanan puanlar softmax algoritması ile normalleştirilerek mahallelerin göreceli önem dereceleri belirlenir.
4. **En Uygun Güzergâhın Seçilmesi**: En yüksek softmax olasılığına sahip mahalle en uygun güzergâh olarak belirlenir.
5. **Maliyet-Fayda Analizi**: Her mahalle için maliyetin sosyal faydaya oranı hesaplanarak bir değerlendirme yapılır.

## Çıktı Örneği

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

