public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
    private int numberOfItems = 0;
    public void addDVD(DigitalVideoDisc disc) {
        if (numberOfItems < itemsInStore.length) {
            itemsInStore[numberOfItems] = disc;
            numberOfItems++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }
    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < numberOfItems; i++) {
            if (itemsInStore[i].equals(disc)) {
                found = true;
                // Shift elements left
                for (int j = i; j < numberOfItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numberOfItems - 1] = null;
                numberOfItems--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the store.");
        }
    }
    public void printStore() {
        System.out.println("\n***********************STORE***********************");
        System.out.println("Available Items:");
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***************************************************");
    }
}
