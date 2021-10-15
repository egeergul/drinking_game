package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private TextView text;
    private ImageButton next;
    private Button pass;
    private ArrayList<String> deck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        next = findViewById(R.id.next);
        text = findViewById(R.id.card_text);
        pass = findViewById(R.id.pass);

        next.setClickable(false);
        pass.setClickable(false);
        createCards();
        selectCard();

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passCard();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectCard();
            }
        });

    }

    private void createCards() {
        tempCardCreation();
        next.setClickable(true);
        pass.setClickable(true);
    }

    private void selectCard() {
        if(!deck.isEmpty()){
            int random = (int) (Math.random() * deck.size());
            String textToDisplay = deck.get(random);
            deck.remove(random);
            text.setText(textToDisplay);
        } else {
            text.setText("GAME OVER!");
            next.setVisibility(View.GONE);
        }

        Log.d("remaining_card_num: " , ""+ deck.size());
    }

    private void passCard() {
        int random = (int) (Math.random() * deck.size());
        String textToDisplay = deck.get(random);
        text.setText(textToDisplay);

        Log.d("remaining_card_num: " , ""+ deck.size());

    }

    private void tempCardCreation() {

    String[] cards= {
        	"İki solundaki kişinin sırtına parmağınla 4 harfli bir kelime yaz. Eğer doğru tahmin ederse içeceğini bitir, eğer yanlış tahmin ederse o 2 shot içsin.",
        	"Amuda kalkarak birinin sana içeceğini içirmesine izin ver. Bunu yap, 3 shot iç veya oyunu bırak.",
        	"Utanç verici bir selfie çekip Instagram hikayende paylaş. Bunu yap ya da 1 shot iç.",
        	"Oynayan herkesin dahil olacağı bir amigo takımı pozu yapın ve fotoğrafını çekin. Bunu yapın, herkes 1 shot içsin veya oyunu bırakın.",
        	"En az üç tane porno yıldızının ismini say ya da içkinden üç yudum al.",
        	"Hemen şimdi, hangi koşullarda olursan ol, herhangi bir su kaynağına gir. Bunu yap ya da 3 shot iç.",
        	"Bir kategori (araba markaları gibi) seç ve seninle birlikte saat yönünde herkes o kategoriye uyan bir şey söylesin. Başarısız olan içkisinden 2 yudum alsın.",
        	"Bütün sarışınlar içsin.",
        	"Formunu bozmadan başarılı bir şekilde 10 tane şınav çek. Bunu yap ya da 2 shot iç.",
        	"Baş aşağı 20 saniye twerk yap. Bunu yap veya içkinden 5 yudum al.",
        	"Gruba arama geçmişini göster ya da içkini bitir.",
        	"Kronometre tut ve 20 saniye içinde 10 alkol çeşidi say. Başarısız olursan 1 shot iç.",
        	"Solundaki kişinin göbeğinden içki iç. Bunu yap, 3 shot iç veya oyunu bırak.",
        	"Instagram hikayene “Soru” stickerını kullanarak “Any porn recommendations?” diye paylaş. Oyunun sonunda gelen cevapları grupla paylaş. Bunu yap ya da 3 shot at.",
        	"Sağındaki kişinin seçtiği bir kişiye “Uyanık mısın?” diye mesaj at. Bunu yap ya da içeceğinden 2 yudum al.",
        	"Parende at ya da 1 shot iç.",
        	"Her küfrettiğinde giydiğin bir şeyi çıkar. Bunu yap veya oyunu bırak.",
        	"Grubun sana istediği gibi poz verdirmesine izin ver ve bir tur öyle kal. Pozunu bozarsan 3 shot at.",
        	"Eğil ve beline bir bardak koy. Twerk yaparak bu bardağı çevirmeye çalış. Bunu üç denemede yapamazsan 3 shot iç veya oyunu bırak.",
        	"Solundaki kişiye sadece ayaklarını kullanarak içeceğini içir. Bunu yap veya bir sonraki turda sıra hakkını kaybet.",
        	"Karşındaki kişiye telefonunu ver ve galerinden istediği bir fotoğrafını Instagram’a koymasına izin ver. Bunu yap veya içeceğini bitir.",
        	"Bir oyuncuyla bakışma yarışması yap. İlk gülen 2 shot içer.",
        	"Bütün erkekler içsin.",
        	"Bütün kızlar içsin.",
        	"Yere yat ve 10 tane dondurma çeşidini sayarken sağındaki veya solundaki kişinin göğsüne oturup alnını dürtüklemesine izin ver. Bunu yap ya da 4 shot iç.",
        	"Karşındaki kişinin çıplak karnından ellerini kullanmadan bir şeyler ye ya da ikiniz de içkinizden 3 yudum alın.",
        	"Bir kaşık dolusu acı sos iç. Eğer yapamazsan 3 shot iç. Acı sos yoksa 5 şınav çek veya öl. :))",
        	"Solundaki kişi omzuna al veya içkini bitir.",
        	"Solundaki kişiyle seçtiğiniz bir dizideki herhangi kısa bir diyaloğu canlandırdığınız bir videoyu çekip Instagram’a yükleyin. Bunu yapın veya 3 shot için.",
        	"3’e kadar sayın ve herkes gruptaki en zeki olduğunu düşündüğü kişiyi göstersin. En çok oyu alan kişi 1 shot içer.",
        	"Gruptaki herkesin en seksi özelliğini söyle ya da içeceğinden bir yudum al.",
        	"30 saniyeliğine Instagram canlı yayını aç ve katılan her izleyici için bir shot at.",
        	"Karşındaki kişiyi 45 saniye boyunca kucağında tut. Bunu yap, 3 shot iç veya oyunu bırak.",
        	"Kronometre tut ve 10 saniye içinde 5 yabancı dizi ismi söyle. Başarısız olursan 1 shot iç.",
        	"Sağındaki kişiyle iç çamaşırların dışında bütün kıyafetlerini değiştir ve oyunun sonuna kadar o kıyafetlerle kal. Bunu yapın ya da içkilerinizi değiştirin.",
        	"Herkes bir solundaki kişinin tişörtünü giysin. 3 tur boyunca böyle kalın.",
        	"3’e kadar sayın ve grupta içmesini en çok istediğiniz kişiyi gösterin. En çok oyu alan 1 shot içer.",
        	"3’e kadar sayın ve grupta içmesini en çok istediğiniz kişiyi gösterin. En az oyu alan/alanlar 1 shot içer.",
        	"İki sağındaki kişiyle göz teması kurarak 60 saniye boyunca burunlarınızı değdirin. Bunu yapın, içeceğinizi bitirin veya oyunu bırakın.",
        	"Masanın üstünde grubun seçtiği bir şarkıya en az 30 saniye dans et. Bunu yap ya da 2 shot at.",
        	"Telefonunun camı kırık olanlar içsin.",
        	"Bütün gücünle “Memeler!” diye bağır. Bunu yap, içeceğinden 5 yudum al veya oyunu bırak.",
        	"15 saniye boyunca bacağını aç veya 1 shot iç.",
        	"Ellerini kullanmadan içeceğinden bir yudum al. Bunu yap, içeceğini bitir ya da oyunu bırak.",
        	"Karşındaki kişinin en iyi fiziksel özelliğini söyle. Eğer iyi bir fiziksel özelliği olmadığını düşünüyorsan 2 shot iç ve arkadaşından özür dile.",
        	"En az 3 tane sex oyuncağının ismini söyle ya da içkinden 3 yudum al, seni saf taklidi yapan kişi.",
        	"Ellerinin ve dizlerinin dur ve bir kişi sırtının üzerine bir içki yerleştirsin. Bir sonraki tura kadar öyle kal ya da 3 yudum iç.",
        	"Grubun ortasında grubun seçtiği bir şarkıya 30 saniye boyunca twerk yap. Bunu yap 2 shot iç veya oyunu bırak.",
        	"Kronometre tut ve 30 saniye içinde 5 araba markası söyle. Başarısız olursan 1 shot iç.",
        	"Seçtiğin bir veya daha fazla kişiyle herhangi bir tiktok trendini yapıp varsa private hesabında, yoksa hikayende paylaş. Bunu yap veya içeceğini bitir.",
        	"Oyunun sonunda kadar telefonunu kapa. Herhangi bir sebepten dolayı telefonunu açarsan içkini bitir.",
        	"“the worm” hareketini yap veya içeceğinden iki yudum al.",
        	"Bu kartı içmek gerekeni başkasına içirmek için kullanabilirsin.",
        	"Solundaki kişiyi direk olarak kullanarak grubun seçtiği bir şarkıya 30 saniye boyunca direk dansı yap. Bunu yap, 3 shot iç veya oyunu bırak.",
        	"Ezik gibi bir tur boyunca yerde otur ya da 1 shot iç.",
        	"İstediğin bir oyuncunun alnını öp, 1 shot iç veya oyunu bırak.",
        	"Gruptaki oyunculardan kimin en “ateşli” babaya sahip olduğunu söyle. Bunu yap, 2 shot iç veya oyunu bırak.",
        	"Kızlar bütün erkeklere oje sürsün. Oje sürmek istemeyen erkekler üçer shot içsin.",
        	"Bir dilim limonu yüzünü ekşitmeden ye. Başarısız olursan 1 shot iç.",
        	"İçeceğini bitir veya oyunu bırak.",
        	"Bu kartı tek seferliğine içmemek için kullanabilirsin.",
        	"Annene veya babana galerindeki en yeni 12. fotoğrafı at veya içkini bitir.",
        	"Sandalyene kucak dansı yap ya da 2 shot iç.",
        	"Karşındaki kişinin galerine 1 dakika boyunca bakmasına izin ver. Bunu yap ya da 2 shot iç.",
        	"Eski sevgilini ya da flörtünü ara ve yeniden beraber olmak istediğini söyle. Oyunun sonunda kadar gerçeği onlara söyleme. Bunu yap, 3 shot iç veya oyunu bırak.",
        	"Tek elinle 3 şınav çek veya 1 shot iç.",
        	"Kızlar! En güzel popolu erkeği seçme vakti. Seçtiğiniz kişi 2 shot içsin.",
        	"Grubun seni 30 saniye boyunca gıdıklamasına izin ver. Bunu yap veya içkinden iki yudum al.",
        	"Oturduğun sandalyeye kucak dansı yap veya 2 shot iç.",
        	"3’e kadar sayın ve grupta yatakta en iyi olacağını düşündüğünüz kişiyi gösterin. En çok oyu alan 2 shot içer.",
        	"2 shot iç veya oyunu bırak.",
        	"Kişilerindeki rastgele bir kişiye “Uyanık mısın?” diye mesaj at ya da iki shot iç.",
        	"Bütün kumrallar içsin.",
        	"Bir selfie çekip üstüne de “Dm me to get freaky tonight ;)” yaz ve hikayende paylaş ya da içkinin geri kalanını bitir.",
        	"Karşındaki kişiye istediği bir kişiyi araması ve 1 dakika sohbet etmesi için telefonunu ver. Bunu yap ya da 2 shot iç.",
        	"İç çamaşırlarınla kalıncaya kadar etrafındakiler her 3 shot içtiklerinde üstündeki bir giysi veya aksesuarı çıkar. Bunu yap, 2 shot iç veya oyunu bırak.",
        	"Seçtiğin iki kişiyle bir insan piramidi oluşturun. Bunu yapın veya birer shot için.",
        	"Bütün kızlar içsin.",
        	"1 tur boyunca tişörtsüz dur veya içkini bitir.",
        	"Başka bir oyuncuyu dans düellosuna davet et. Grup tarafından en çok oy al kaybedene istediği kadar içirir.",
        	"İçeceğinden 3 yudum al veya oyunu bırak.",
        	"Karşındaki kişiye 15 saniye boyunca ayak masajı yap veya ikiniz de ikişer shot için.",
        	"Şu anda kimden hoşlandığını söyle. Birinden hoşlanmıyorsan 1 shot iç.",
        	"İki solundaki kişiye kendin hakkında bir doğru-yanlış sorusu sor. Eğer doğru bilirlerse sen iç, bilemezlerse o 2 shot içsin.",
        	"Bir oyuncuyu bilek güreşine davet et. Kaybeden 3 shot içer veya oyunu bırakır.",
        	"Solundaki kişi artık senin efendin. Bir tur boyunca dedikleri her şeyi yapmak zorundasın. Bunu yapmazsan içkinin geri kalanını iç.",
        	"Oyunculardan kimin en ateşli anneye sahip olduğunu seç. Bunu yap veya 2 shot iç.",
        	"Sağındakinin en sevdiğin üç kişilik özelliğini söyle. Eğer kişiliksiz olduğunu düşünüyorsan 2 shot iç.",
        	"Instagram’ı aç, karşına çıkan ilk kişinin profilini aç ve bir yıl geriye kadar bütün resimlerini beğen ya da içkini bitir.",
        	"Sağındaki kişinin kucağında sonraki 2 tur boyunca otur. Bunu yap veya 2 shot iç.",
        	"Bir şişe çevir, şişenin denk geldiği kişilerden ikişer kişilik iki takım oluştur (sen de takımlardan birinde olmalısın). Bu takımlarla bir sokağın başından sonuna kadar birbirinizin sırtında yarış yapın. Kaybeden takım iki shot içer.",
        	"Gözlerini bağla ve gruptaki bir kişi seni döndürsün. İlk çarptığın kişiyi öp. Bunu yapın ya da ikiniz de 2 shot için.",


			// English Cards
			"If u chose someone among us to write a smut novel or a book containing explicit scenes with you, who would that person be?",
			"Have u ever seen an elder or a parent having sex? Tell us about that experience.",
			"Which sex toy would you like to try on yourself?",
			"Which sex toy would u like to try on someone else?",
			"About whose sexual life would u like to be informed?",
			"If u ever had a chance to have sex with a politician (turkish or foreigner), who would he/she/them be? 7. Choose three or more people to do a wild three/polysome and explain why.",
			"Among us who do u think have erotic books under her/his/their pillow or bed? ",
			"If you mastrubated while looking someone's photo secretly, who would that person be?",
			"Find and tell a person who would be a whore if that person wasn't majoring xxx (med for ex.).",
			"Who is the person among us that wouldn't be ashamed to get caught by a friend/parent while doing a blowjob?",
			"Who has the best kinks among us and what is her/his/their kink? ",
			"Choose a person and guess her/his/their most cherished sex toy.",
			"Who would be the person that wear or make other person wear a condom wrong?",
			"After her/his/their first sexual intercourse, who would be dead ass embarrassed to confront the partner?",
			"Tell about us your/someone else's fav sex position?",
			"Choose a genre of sex such as (theacher-student/ boss-worker writer-fan etc.) to display with a partner or a future-to-be-partner.",
			"Sit on a self-decided person's lab for three questions.",
			"Lick a person's neck. ",
		 	"Choose a person and apply a kink on her/him/their.",
			"Say 2 truth and 1 lie. If a person chosen by you guesses lie, put your tshirt off.",
			"Twerk.",
			"Call one of your friends and confess your love 'seriously'.",
			"French kiss with a toy in front of everyone.",
			"Call one of your exes and talk like u have connected them last day.",

			"Kendini 'insecure' hissettiğin gecelerde ne yaparsın? Bizimle paylaş ya da 2 şot iç.",
			"En son birisinin önünde ne zaman ağlamıştın? KArşı cinsten birini seçip anlat ya da oyunu bırak.",
			"En utandığın an neydi? Anlat ya da 3 şot iç.",
			"Bir sıçma anın ya da fantazin? Anlat ya da oyunu bırak.",
			"'Guilty pleasure'ın ne? Film? Aktivite?",
			"Bu hayatta seni en çok ne heyecanlandırır? HErkese anlat ya da 3 şot iç."
    	};
        deck = new ArrayList<String>();
        for (String card: cards)
            deck.add(card);

    }

}