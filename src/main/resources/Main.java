package model;

public class AppUsage {
    private String name;
    private int time;

    public AppUsage(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + " - " + time + " mins";
    }
}
package tracker;

import model.AppUsage;
import java.util.*;

public class AppTracker {
    private List<AppUsage> list = new ArrayList<>();
    private Random rand = new Random();

    public void track() {
        String[] apps = {"Instagram", "YouTube", "WhatsApp", "Chrome"};

        for (int i = 0; i < 5; i++) {
            String app = apps[rand.nextInt(apps.length)];
            int time = rand.nextInt(60) + 10; // 10–69 mins
            list.add(new AppUsage(app, time));
            System.out.println("Used " + app + " for " + time + " mins");
        }
    }

    public List<AppUsage> getData() {
        return list;
    }
}
package service;

import model.AppUsage;
import java.util.*;

public class UsageAnalyzer {

    public void analyze(List<AppUsage> list) {
        int total = 0;
        AppUsage maxApp = list.get(0);

        for (AppUsage app : list) {
            total += app.getTime();

            if (app.getTime() > maxApp.getTime()) {
                maxApp = app;
            }

            // Overuse detection
            if (app.getTime() > 60) {
                System.out.println("⚠ Overuse: " + app.getName());
            }
        }

        System.out.println("\nTotal Screen Time: " + total + " mins");
        System.out.println("Most Used App: " + maxApp.getName());

        // Break suggestion
        if (total > 180) {
            System.out.println("👉 Suggestion: Take a break!");
        }

        // Late night detection (real system time)
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 23 || hour < 6) {
            System.out.println("🌙 Late night usage detected!");
        }
    }
}
package storage;

import model.AppUsage;
import java.io.*;
import java.util.*;

public class FileManager {

    public void save(List<AppUsage> list) {
        try (FileWriter fw = new FileWriter("usage.txt")) {
            for (AppUsage app : list) {
                fw.write(app.getName() + " " + app.getTime() + "\n");
            }
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package ui;

import tracker.AppTracker;
import service.UsageAnalyzer;
import storage.FileManager;
import java.util.*;

public class ConsoleUI {
    private Scanner sc = new Scanner(System.in);

    public void start() {
        AppTracker tracker = new AppTracker();
        UsageAnalyzer analyzer = new UsageAnalyzer();
        FileManager file = new FileManager();

        while (true) {
            System.out.println("\n===== DIGITAL DETOX =====");
            System.out.println("1. Start Tracking");
            System.out.println("2. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                tracker.track();
                List<AppUsage> data = tracker.getData();
                analyzer.analyze(data);
                file.save(data);
            } else if (choice == 2) {
                System.out.println("Goodbye! Stay mindful of your screen time.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
import ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}