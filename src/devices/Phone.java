package devices;

import creatures.Human;

import java.util.*;

public class Phone extends Devices implements Rechargeable{
    String colour = "Black";
    private Boolean isAndroid = true;
    private Double screenSize;
    private ArrayList<Application> installedApps = new ArrayList<Application>();
    Comparator<Application> appComparatorByPrice = Comparator.comparing(Application::getValue);
    public List<Human> ownersList = new LinkedList<>();
    static final String urlAddres = "www.app.com";
    static final String urlProtocol = "UDP";
    static final String defaultVersion = "Latest";

    public Phone(String producer, String model, Integer yearOfProduction, Boolean isAndroid, String color, Double screenSize, Double value){
        super(producer, model, yearOfProduction, color, value);
        this.isAndroid = isAndroid;
        this.screenSize = screenSize;
        this.isOn = false;
    }
    public String toString(){
        return "Producer: " + producer + " Model: " + model + " Colour: " + colour + " isAndroid: " + isAndroid;
    }
    @Override
    public void turnOn() {
        System.out.println("Wciskam guzik");
        System.out.println("Telefon włączony");
        this.isOn = true;
    }
    @Override
    public void recharge() {
        System.out.println("Szukam ładowarki");
        System.out.println("Znalazłem ładowarkę");
        System.out.println("Podłączam telefon");
        System.out.println("Ładuję");
    }


    public void sell(Human seller, Human buyer, Double price){
        if(buyer.getCash() < price){
            return;
        }
        if(seller.getPhone() == this){
            buyer.setCash(buyer.getCash() - price);
            seller.setCash(seller.getCash() + price);
            seller.setPhone(null);
            buyer.setPhone((Phone) this);
            System.out.println("Buyer bought " + this);
        }
    }
    public void installAnnApp(String appToInstall){
        Application app = new Application(appToInstall, defaultVersion);
        installApp(app);
        System.out.println("Installing: " + app + " at : " + urlAddres + " Protocol :" + urlProtocol);
    }
    public void installAnnApp(String appToInstall, String appVersion){
        Application app = new Application(appToInstall, appVersion);
        installApp(app);
        System.out.println("Installing: " + app + " at : " + urlAddres + " Protocol :" + urlProtocol);
    }
    public void installAnnApp(String appToInstall, String appVersion, String serverForDownload){
        Application app = new Application(appToInstall, appVersion);
        installApp(app);
        System.out.println("Installing: " + app + " at : " + serverForDownload + " Protocol :" + urlProtocol);
    }
    public void installAnnApp(List<String> appsToInstall){
        for (String i: appsToInstall) {
            Application app = new Application(i, defaultVersion);
            installApp(app);
            System.out.println("Installing: " + app + " at : " + urlAddres + " Protocol :" + urlProtocol);
        }

    }
    public void installAnnApp(UrlClass appToInstall){
        Application app = new Application(appToInstall.application, appToInstall.appVersion);
        installApp(app);
    }
    public void installAnnApp(Application app){
        installApp(app);
    }

    private void installApp(Application app){
        if(checkOwnerMoney() > app.value){
            installedApps.add(app);
            Human owner = this.ownersList.get(this.ownersList.size() - 1);
            owner.setCash(owner.getCash() - app.value);
            System.out.println("Installing: " + app);
            return;
        }
        System.out.println("Not enough money to install this app");
    }

    public Double checkOwnerMoney(){
        return this.ownersList.get(this.ownersList.size() - 1).getCash();
    }
    public void addOwner(Human owner){
        ownersList.add(owner);
    }
    public Boolean checkIfAppIsInstalled(String appName) {
        for (Application app : installedApps) {
            if (appName == app.appName) {
                return true;
            }
        }
        return false;
    }
    public Boolean checkIfAppIsInstalled(Application app){
        for(Application i : installedApps){
            if(app.appName == i.appName){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Application> getAllFreeAppsInstalled(){
        ArrayList<Application> freeApps = new ArrayList<Application>();
        for(Application i : installedApps){
            if(i.value == 0.0){
                freeApps.add(i);
            }
        }
        return freeApps;
    }
    public Double getValueOfAllInstalledApps(){
        Double worth = 0.0;
        for(Application i : installedApps){
            worth += i.value;
        }
        return worth;
    }
    public ArrayList<Application> sortApps(){
        ArrayList<Application> sortedApps =  installedApps;
        Collections.sort(sortedApps);
        return sortedApps;
    }
    public ArrayList<Application> sortAppsByPrice(){
        ArrayList<Application> sortedApps =  installedApps;
        sortedApps.sort(Comparator.comparing(Application::getValue));
        return sortedApps;
    }

}
