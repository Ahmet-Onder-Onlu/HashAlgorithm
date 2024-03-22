import java.util.Objects;
// !!! Gerekli cevaplar burada verilmiştir !!!

// Linked list ile bağlı HashTable kullandım
// Cunku arama islemini cok kolaylastiriyor.
// Ayryetten en az grup cakimasi adina
// Max 20 boyutlu bir dizi olusturdum.
// Cunku tum isimler farkli olursa 20 satir dolar
// Ve daha fazla isim eklenemeyeceginden max 20
// boyutlu sabit dizi olusturdum.
// Calisma süresini her fonksiyon için ölçdüğümüzde
// arama isleminin en uzun sürdüğünü ve ekleme, silme
// işleminin ise yaklaşık ayni sürede gerçekleştiğini söyleyebilirim.
// Fonksiyonlar diğer algoritmalara göre daha az
// calisma süresine sahip cunku gruplama yapildigindan
// tum verileri taramak yerine belli bir grupta arama yapıyor.
// Cakisma yine var ama sadece 5 tane indiste.
public class TelBook {
    // HashTable
    // A->65, Z->90(ASCII) get mode depend on 20
    Person[] arr;
    int size=20;//Most optimum array size
    int counter = 0;// 20 den fazla kisi eklenemez
    public TelBook(){
        arr = new Person[size];
        for (int i = 0; i< arr.length; i++){
            arr[i] = new Person();// null degerler atandi.
        }
    }

    //Ismin daha once var olup olmadigi kontrol edildi.
    //Ve ayrilan alanin dolu olup olmadigi kontrol edildi.
    void insert(String name, String tel_no){
        if(isFull()){
            System.out.println(name + " was reached to limit");
        }
        else {
            // ilk harf index olusurulmaya gonderildi.
            int index = get_index(name.charAt(0));
            Person per = new Person(name, tel_no);
            if(isThere(name)){
                System.out.println("It was already added! ");
                return;
            }
            Person temp = arr[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = per;
            System.out.println(name + " was added!");
            counter++;
        }
    }

    // Aranan kisi yoksa bulunamadi uyarisi verildi.
    // ve eger bulunursa 2 temp ile kolaylıkla atildi.
    void delete(String name){
         int index = get_index(name.charAt(0));
         Person temp = arr[index];
         Person temp2 = temp;
         boolean flag = false;// Kontrol ifadesi
         if(temp.next == null){
             flag = true;
             System.out.println(name + "not found!");
         }
         else if(temp.next.next == null && Objects.equals(temp.next.name, name)){
             flag = true;
             temp.next=null;
             System.out.println(name+ " was deleted!");
             counter--;
         }
         else{
             while(temp.next != null){
                 temp2 = temp;
                 temp = temp.next;

                 if(Objects.equals(temp.name, name)){
                     flag = true;
                     temp2.next = temp.next;
                     System.out.println(name + " was deleted!");
                     counter--;
                 }

             }

         }
         // Yukarida islem gerceklesmezse flag false durumda kalir.
         if(flag == false){
             System.out.println(name + " was not registered!");
         }

    }

    // Kisi aramada bulunamazsa uyari verildi.
    void search(String name){
        boolean flag = false;
        int index = get_index(name.charAt(0));
        Person temp = arr[index];
        while(temp.next != null){
            if(Objects.equals(temp.next.name,name)){
                flag = true;
                System.out.println(name + ": " + temp.next.tel_no);
                break;
            }
            temp = temp.next;
        }
        if(flag == false){
            System.out.println(name + " is not found!");
        }
    }

    // Daha onceden kayitli mi kontrolu yapilir.
    private boolean isThere(String name){
        boolean flag = false;
        int index = get_index(name.charAt(0));
        Person temp = arr[index];
        while(temp.next != null){
            if(Objects.equals(temp.next.name,name)){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    // index uretir.
    private int get_index(char ch){
        char ch_new = Character.toUpperCase(ch);
        int index = ( (int) ch_new) % size;
        return index;
    }

    // Tamamen bos olup olmadigi kontrolu
    private boolean isEmpty(){
        boolean flag = true;
        for(int i=0; i < arr.length;i++){
            if(arr[i] != null){
                flag = false;
            }
        }
        return flag;
    }

    // Sinira ulasilirsa true donecek!
    private boolean isFull(){
        return counter == 20;
    }

}
