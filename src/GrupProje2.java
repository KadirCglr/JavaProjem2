
import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class GrupProje2 {

    public static void main(String[] args) {
        Scanner okuStr = new Scanner(System.in);
        Scanner okuInt = new Scanner(System.in);

        ArrayList<String> users=new ArrayList<>();
        users.add("User1");
        users.add("User2");
        users.add("User3");

        ArrayList<String> passwords=new ArrayList<>();
        passwords.add("123");
        passwords.add("456");
        passwords.add("789");

        ArrayList<Integer> accounts = new ArrayList<>();
        accounts.add(1234);
        accounts.add(5678);
        accounts.add(9999);

        ArrayList<Integer> funds = new ArrayList<>();
        funds.add(200);
        funds.add(1000);
        funds.add(5000);

        // TODO ONEMLI NOT : Yukarida gireceginiz listelerdeki veriler index numarasina gore birbirleri ile iliskilidir
        // TODO Mesela -> 'User1' in passwordu 'password1', hesap numarasi '1234' ve hesabindaki para miktari '200' dur...

        while (true) {
            System.out.print("Kullanıcı adınızı giriniz = ");
            String username=okuStr.nextLine();

            System.out.print("Şifrenizi giriniz = ");
            String password = okuStr.nextLine();

            if (passwords.contains(password)){
                confirmUsernameAndPassword(users,passwords,username,password);
                break;
            }
            else
                System.out.println("Sistemde böyle bir kullanıcı bulunamadı... Lütfen tekrar deneyiniz.");
            break;
        }

        int secim = 0;

        do {
            System.out.println("Yapmak istediğiniz işlemi seçiniz...\nPara Yatır - 1\nPara Çek -2\nTransfer -3\nÇıkış -4");
            secim = okuInt.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Bu bankamatik gecici olarak para yatirma islemine kapalidir...Uzgunuz");
                    break;
                case 2:
                    System.out.println("Hangi hesaptan para cekmek istiyorsunuz?");
                    System.out.println(accounts);
                    int hesap = okuStr.nextInt();
                    System.out.print("Lütfen çekmek istediğiniz miktarı giriniz = ");
                    int cekilecek=okuInt.nextInt();
                    withdraw(accounts,funds,hesap,cekilecek); break;
                case 3:
                    System.out.println("Bu islemi su an gerceklestiremiyoruz...");
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Basarili bir secim yapmadiniz...");
                    break;
            }
        } while (secim != 4);

    }

    private static void withdraw(List<Integer> accounts, List<Integer> funds, Integer choosenAccount, int money){
        int hesapp= accounts.indexOf(choosenAccount);
        while (true){

            if (funds.get(hesapp)>= money){
                System.out.println("Lütfen paranızı alınız, hesabınızda "+ (funds.get(hesapp) - money) + " dolar kalmıştır.");
                int yenihesap=accounts.indexOf(choosenAccount);
                int bakiye=(funds.get(yenihesap)-money);
                funds.set(yenihesap,bakiye);
                break;
            } else if (money >= funds.get(hesapp))
                System.out.println("Hesabınızda yeterli bakiye bulunmamaktadır.");break;
        }
    }

    private static boolean confirmUsernameAndPassword(List<String> users, List<String> passwords, String username, String password) {
        if (passwords.contains(password)) {
            System.out.println("Başarılı bir şekilde giriş yaptınız.");
        }
        else
            System.out.println("Sistemde böyle bir kullanıcı bulunamadı... Lütfen tekrar deneyiniz.");
        return false;
    }
}