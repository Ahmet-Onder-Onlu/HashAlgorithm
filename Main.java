public class Main {
    public static void main(String[] args) {
        TelBook HT = new TelBook();

        HT.insert("Ahmet","555 7332298");
        HT.insert("Mehmet","546 2342453");
        HT.insert("Zeynep","535 2332256");
        HT.insert("ayse","566 4332298");
        HT.insert("Mehmet","546 2342453");
        HT.insert("Duman","534 4636798");
        HT.insert("Berna","523 6732298");
        HT.search("Zeynep");
        HT.search("Safa");

        long startTime = System.currentTimeMillis();

        HT.delete("Mehmet");
        HT.delete("Ferit");

        long endTime = System.currentTimeMillis();

        long calismaSuresi = endTime - startTime;

        System.out.println("Çalışma süresi: " + calismaSuresi + " milisaniye");
    }
}