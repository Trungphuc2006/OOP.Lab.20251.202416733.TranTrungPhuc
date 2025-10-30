public class Aims {
    public static void main(String[] args) {
    	Cart anOrder = new Cart() 
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3); 
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost()); 
        System.out.println("Attempting to remove 'Star Wars'...");
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total cost after removal: " + anOrder.totalCost());
        System.out.println("\nAttempting to remove 'Non-Existent DVD'...");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Non-Existent DVD", "Unknown", 0f);
        anOrder.removeDigitalVideoDisc(dvd4);
    }
}