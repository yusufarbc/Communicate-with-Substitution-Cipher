# communicate-with-substitution-cipher
Proje java dilinde yazılmış olup, ikame şifresini kullanarak bir ip adresine şifreli mesaj iletimini hedeflemektedir. <br>
Bu amaç doğrultusunda proje, 10 java sınıfı ile gerçekleştirilmiştir. Bunlar:
<ul>
  <li>Main: Programın başlatıldığı sınıf.</li>
  <li>KeyGenerator: Şifreleme için şifreleme anahtarının üretildiği sınıf.</li>
  <li>Encryption: Şifreleme işleminin yapıldığı sınıf.</li>
  <li>Decryption: Şifre çözme işleminin yapıldığı sınıf.</li>
  <li>Send: Soket açarak mesajın göndeildiği sınıf.</li>
  <li>Listen: Server Soket açarak gelecek mesajın dinlendiği sınıf.</li>
  <li>MainWindow: Projenin ana penceresini açan grafik arayüz sınıfı.</li>
  <li>EncryptWindow: Encryption pencerisini açan grafik arayüz sınıfı.</li>
  <li>DecryptWindow: Decrption penceresini açan grafik arayüz sınıfı.</li>
  <li>KeyWindow: Key Generator penceresini açan grafik arayüz sınıfı.</li>
</ul>
Mesaj gönderme ve alma işlemini aynı program üzerinden yapılamaz. Aynı bilgisayar üzerinde kullanacaksa programın 2 defa çalıştırması gerekir, birisi mesajı gönderen taraf diğeri ise measajı alan taraf için.
<br>

<br>

Program başlatıldığında, ana pencere açılır ve kullanıcıdan yapmak istediği işlemi seçmesi beklenir.<br><br>
![main](https://user-images.githubusercontent.com/77548038/156741855-574054fa-08f6-49a5-a9b1-46c3058329b1.PNG)
<br>
Kullanıcı için oluşturulmuş 3 buton vardır. Bunlar:
<ul>
  <li>Generate Key: Key Generator penceresini açar.</li>
  <li>Encryption: Encryption pencersini açar.</li>
  <li>Decryption: Decryption penceresini açar.</li>
</ul>
<br>

Key generator penceresi açıldığında arka planda KeyGenerator sınıfı da çağrılır. Bu sınıfta, şifreleme için gereki olan gizli anahtar oluşturulur. Anahtar, ASCII tablosundaki 32 ila 127'nci karakterlerin karıştırılmasından oluşmuştur. Şifreleme için her bir karakter, karıştırılmış karakterleri içeren dizide karşılık gelen değeriyle değiştirilir. bknz. <a href="https://en.wikipedia.org/wiki/Substitution_cipher">ikame şifresi.</a><br>

![key generator](https://user-images.githubusercontent.com/77548038/156741843-74975e4e-24d1-4949-af40-5d6bd2cbd1c0.PNG)
<br>
Pencerede açıldığında gelen anahtar kopyalanıp, encriyption ve decryption kısmına yapıştırılır.
<br>
<br>
<br>
Encryption penceresi açıldığında pencerede, gönderilmek istenen mesajın yazılacağı plain text alanı, anahtarın yazılacağı key alanı, şifreleme işlemini gerçekleştiren encrypt butonu, şifrelenmiş mesajın görüneceği cipher text alanı, bu mesajın gönderileceği ip ve port alanları ve gönderme işlemini yapan send butonu yer alır. <br> 

![Encryption](https://user-images.githubusercontent.com/77548038/156741866-6b4ec4b6-f8bb-4e5b-a6b0-3008c515a5bc.PNG)
<br>
Bu pencerede, gönderilmek istenen mesaj palin text alanına yazılır ardından encrypt butonuna basılır. Bu butona basıldığında arka planda Encryption sınıfı çağrılır ve bu sınıfa plain text ve key bilgileri verilir. Bu sınıfta şifreleme işlemi yapılır ve bulunan şifre cipher Text alanına yazdırılır. Bu şifreli mesajın gönderileceği ip ve port bilgisi ilgili bölümlere yazılır ve ardından send butonuna basılır. Bu butona basıldığında arka planda Send sınıfı çalışır. Soket açılır, karşı tarafla bağlantı kurulur ve ardından dataOutputStream ile mesaj gönderilir.
<br>
<br>
<br>
Decryption penceresi açıldığında pencerede, dinlenecek port numarasının yazılacağı bir alan, gelecek mesajı dinlemek için Listen butonu, gelen şifreli mesajın gösterileceği cipher text alanı, anahtarın yazılacağı key alanı, şifre çözme işlemini gerçekleştiren decrypt butonu ve şifresi çözülmüş mesajın gösterileceği plain text alanı yer alır. <br>

![decryption](https://user-images.githubusercontent.com/77548038/156741858-27a58d5e-63f8-4687-9f63-3b03def801f9.PNG)
<br>
Bu pencerede, mesajın geleceği port numarası yazılır ve Listen butonuna basılır. Bu butona basıldığında arka planda Listen sınıfı çağrılır ve bir server soket açılır. Bu sayede, program gelecek mesajı dinler, karşı taraftan mesaj gönderildiği anda bu mesajı yakalar ve cipher text bölümüne yazdırır. Key alanına şifrelemede kullanılan anahtar girilir, şifreli mesaj geldiğinde Decrypt butonuna basılır. Bu butona basıldığında arka planda decrypt sınıfı çağrılır e bu sınıfa cipher text ve key bilgileri verilir. Bu sınıfta şifre çözme işlemi yapılır ve çıkan düz metin plain text alanına yazdırılır. Bu sayede mesaj şifreli bir biçimde karşı tarafa iletilmiş ve iletişim sağlanmış olur.
