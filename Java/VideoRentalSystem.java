package Java;
import java.util.Scanner;

class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;
    private int numberOfRatings;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
        this.numberOfRatings = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public void receiveRating(int rating) {
        averageRating = (averageRating * numberOfRatings + rating) / (numberOfRatings + 1);
        numberOfRatings++;
    }
}

class VideoStore {
    private Video[] inventory;

    public VideoStore() {
        this.inventory = new Video[10];
    }

    public void addVideo(String title) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = new Video(title);
                System.out.println("Video \"" + title + "\" added to inventory.");
                return;
            }
        }
        System.out.println("Inventory is full. Cannot add video \"" + title + "\".");
    }

    public void deleteVideo(String title) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getTitle().equals(title)) {
                inventory[i] = null;
                System.out.println("Video \"" + title + "\" deleted from inventory.");
                return;
            }
        }
        System.out.println("Video \"" + title + "\" not found in inventory.");
    }

    public void checkOut(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                if (!video.isCheckedOut()) {
                    video.checkOut();
                    System.out.println("Video \"" + title + "\" checked out.");
                } else {
                    System.out.println("Video \"" + title + "\" is already checked out.");
                }
                return;
            }
        }
        System.out.println("Video \"" + title + "\" not found in inventory.");
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                if (video.isCheckedOut()) {
                    video.returnVideo();
                    System.out.println("Video \"" + title + "\" returned.");
                } else {
                    System.out.println("Video \"" + title + "\" is not checked out.");
                }
                return;
            }
        }
        System.out.println("Video \"" + title + "\" not found in inventory.");
    }

    public void receiveRating(String title, int rating) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                video.receiveRating(rating);
                System.out.println("Rating received for video \"" + title + "\".");
                return;
            }
        }
        System.out.println("Video \"" + title + "\" not found in inventory.");
    }

    public void listInventory() {
        System.out.println("Inventory:");
        for (Video video : inventory) {
            if (video != null) {
                System.out.println("Title: " + video.getTitle() +
                        ", Checked Out: " + (video.isCheckedOut() ? "Yes" : "No") +
                        ", Average Rating: " + video.getAverageRating());
            }
        }
    }
}

public class VideoRentalSystem {
    public static void main(String[] args) {
        VideoStore videoStore = new VideoStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Video");
            System.out.println("2. Delete Video");
            System.out.println("3. Check Out Video");
            System.out.println("4. Return Video");
            System.out.println("5. Receive Rating");
            System.out.println("6. List Inventory");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter video title to add: ");
                    String addTitle = scanner.nextLine();
                    videoStore.addVideo(addTitle);
                    break;
                case 2:
                    System.out.print("Enter video title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    videoStore.deleteVideo(deleteTitle);
                    break;
                case 3:
                    System.out.print("Enter video title to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    videoStore.checkOut(checkOutTitle);
                    break;
                case 4:
                    System.out.print("Enter video title to return: ");
                    String returnTitle = scanner.nextLine();
                    videoStore.returnVideo(returnTitle);
                    break;
                case 5:
                    System.out.print("Enter video title to receive rating: ");
                    String ratingTitle = scanner.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int userRating = scanner.nextInt();
                    videoStore.receiveRating(ratingTitle, userRating);
                    break;
                case 6:
                    videoStore.listInventory();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
