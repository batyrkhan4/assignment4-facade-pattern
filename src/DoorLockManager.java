public class DoorLockManager {
    public boolean isLocked = false;

    public void lockAllDoors() {
        isLocked = true;
        System.out.println("Doors: All doors are securely locked.");
    }
    public void unlockAllDoors() {
        isLocked = false;
        System.out.println("Doors: All doors are unlocked.");
    }

    public boolean isLocked() {
        return isLocked;
    }
}
