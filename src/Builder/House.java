package Builder;

public class House {
    private final int walls; // Mandatory
    private final int doors; // Mandatory
    private final int windows; // Optional
    private final boolean hasRoof; // Optional
    private final boolean hasGarage; // Optional

    // Private constructor, only accessible via Builder
    private House(HouseBuilder builder) {
        this.walls = builder.walls;
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.hasRoof = builder.hasRoof;
        this.hasGarage = builder.hasGarage;
    }

    // Getters
    @Override
    public String toString() {
        return "House [walls=" + walls + ", doors=" + doors + ", windows=" + windows +
                ", hasRoof=" + hasRoof + ", hasGarage=" + hasGarage + "]";
    }

    // Static Builder Class
    public static class HouseBuilder {

        private final int walls; // Mandatory
        private final int doors; // Mandatory

        private int windows = 0; // Optional, default value
        private boolean hasRoof = false; // Optional, default value
        private boolean hasGarage = false; // Optional, default value

        // Constructor for mandatory fields
        public HouseBuilder(int walls, int doors) {
            this.walls = walls;
            this.doors = doors;
        }

        // Setter methods for optional fields (return Builder for chaining)
        public HouseBuilder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder setHasRoof(boolean hasRoof) {
            this.hasRoof = hasRoof;
            return this;
        }

        public HouseBuilder setHasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        // Build method to create the final House object
        public House build() {
            return new House(this);
        }
    }

    public static void main(String[] args) {
        // House with only mandatory fields
        House basicHouse = new House.HouseBuilder(4, 2).build();
        System.out.println("Basic House: " + basicHouse);
    
        // House with mandatory and some optional fields
        House luxuryHouse = new House.HouseBuilder(6, 4)
                .setWindows(10)
                .setHasRoof(true)
                .setHasGarage(true)
                .build();
        System.out.println("Luxury House: " + luxuryHouse);
    }
}