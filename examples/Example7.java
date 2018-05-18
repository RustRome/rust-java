
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Example7 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        final List<String> shoppingLists = new ArrayList<String>() {
            {
                add("latte");
                add("cioccolato");
            }
        };

        TotalPrice winner = buildStores().stream()
                .map((store) -> executor.submit(() -> new TotalPrice(store.name, store.getTotalPrice(shoppingLists))))
                .map((f) -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    return null;
                }).sorted(Comparator.comparing(s -> s.price)).findFirst().get();

        System.out.println("--> Go to " + winner.name);

        executor.shutdown();

    }

    static class Store {
        String name;
        List<Item> items;

        public Store(String name, List<Item> items) {
            this.name = name;
            this.items = items;
        }

        public void addItem(Item item) {
            this.items.add(item);
        }

        public Double getPrice(final String name) {
            return this.items.stream().filter((item) -> item.name.equalsIgnoreCase(name)).findFirst().get().price;
        }

        public Double getTotalPrice(List<String> names) {
            return names.stream().map((n) -> this.getPrice(n)).reduce(0.0, (a, b) -> {
                return a + b;
            });
        }
    }

    static class Item {

        String name;
        Double price;

        Item(String name, Double price) {
            this.name = name;
            this.price = price;
        }
    }

    static class TotalPrice {
        String name;
        Double price;

        TotalPrice(String name, Double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static List<Store> buildStores() {

        List<Store> stores = new ArrayList<>();

        List<Item> items = new ArrayList<Item>() {
            {
                add(new Item("latte", 5.0));
                add(new Item("cioccolato", 1.0));
                add(new Item("pane", 0.1));
            }
        };
        Store store = new Store("JavaStore", items);
        stores.add(store);

        items = new ArrayList<Item>() {
            {
                add(new Item("latte", 4.0));
                add(new Item("cioccolato", 1.0));
                add(new Item("pane", 0.2));
            }
        };
        store = new Store("RustStore", items);
        stores.add(store);

        return stores;
    }

}