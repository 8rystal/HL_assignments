public class TowerDefense {

    private static int totalTowers = 0;
    private static int totalHistoricalTowers = 0;
    private static int totalDPS = 0;

    private int range;
    private int DPS;
    private boolean active;

    public TowerDefense() {
        this(9, 3);
    }

    public TowerDefense(int troopRange, int troopDPS) {
        if (troopRange <= 0) {
            throw new IllegalArgumentException(
                "Range must be greater than zero."
            );
        }

        if (troopDPS < 0) {
            throw new IllegalArgumentException(
                "DPS cannot be negative."
            );
        }

        range = troopRange;
        DPS = troopDPS;
        active = true;

        totalTowers++;
        totalHistoricalTowers++;
        totalDPS += DPS;
    }

    public int getRange() {
        return range;
    }

    public int getDPS() {
        return DPS;
    }

    public boolean isActive() {
        return active;
    }

    public static int getTotalTowers() {
        return totalTowers;
    }

    public static int getTotalHistoricalTowers() {
        return totalHistoricalTowers;
    }

    public static int getTotalDPS() {
        return totalDPS;
    }

    public void setRange(int newRange) {
        if (newRange <= 0) {
            System.out.println(
                "[ERROR] Range must be greater than zero."
            );
            return;
        }

        range = newRange;
    }

    public void changeDPS(int newDPS) {
        if (newDPS < 0) {
            System.out.println(
                "[ERROR] DPS cannot be negative. Update rejected."
            );
            return;
        }

        int oldDPS = DPS;
        DPS = newDPS;

        if (active) {
            totalDPS += newDPS - oldDPS;
        }
    }

    public void upgradeTroop() {
        if (!active) {
            System.out.println(
                "[WARN] Cannot upgrade an inactive tower."
            );
            return;
        }

        int oldDPS = DPS;
        DPS = (int) Math.round(DPS * 1.5);
        totalDPS += DPS - oldDPS;

        System.out.println(
            "[SYSTEM] Tower upgraded to " + DPS + " DPS."
        );
    }

    public void removeTroop() {
        if (!active) {
            System.out.println(
                "[WARN] Tower is already inactive. Action skipped."
            );
            return;
        }

        active = false;
        totalTowers--;
        totalDPS -= DPS;

        System.out.println("[SYSTEM] Tower deactivated.");
    }

    public void displayState() {
        System.out.println(
            "[Range: " + range
            + " | DPS: " + DPS
            + " | Active: " + active + "]"
        );
    }

    public static void displayGlobalState() {
        System.out.println(
            "Global State -> Active Towers: " + totalTowers
            + " | Historical Towers: " + totalHistoricalTowers
            + " | Aggregate DPS: " + totalDPS
        );
    }

    public static void main(String[] args) {

        System.out.println(
            "=== TOWER DEFENSE TEST SUITE ==="
        );

        System.out.println("\n--- Phase 1: Instantiation ---");

        TowerDefense tower1 = new TowerDefense();
        TowerDefense tower2 = new TowerDefense(12, 5);
        TowerDefense tower3 = new TowerDefense(5, 20);

        tower1.displayState();
        tower2.displayState();
        tower3.displayState();

        displayGlobalState();

        System.out.println(
            "\n--- Phase 2: Mutator Bounds Validation ---"
        );

        int oldDPS = tower3.getDPS();
        tower3.changeDPS(-10);

        System.out.println(
            "DPS before: " + oldDPS
            + " | DPS after: " + tower3.getDPS()
        );

        displayGlobalState();

        System.out.println(
            "\n--- Phase 3: State Transformation ---"
        );

        tower1.upgradeTroop();
        tower1.displayState();
        displayGlobalState();

        System.out.println(
            "\n--- Phase 4: Lifecycle Transformation ---"
        );

        tower3.removeTroop();
        displayGlobalState();

        System.out.println(
            "\n--- Phase 5: Redundant Safeguards ---"
        );

        tower3.removeTroop();
        displayGlobalState();

        System.out.println("\n=== TEST SUITE COMPLETE ===");
    }
}
