package devices;

public class Application implements Comparable<Application>{
    String appName;
    String appVersion = "Latest";
    Double value = 0.0;

    public Application(String appName, String appVersion, Double value){
        this.appName = appName;
        this.appVersion = appVersion;
        if(value < 0.0){
            value = 0.0;
        }
        this.value = value;
    }
    public Application(String appName, String appVersion){
        this.appName = appName;
        this.appVersion = appVersion;
    }
    public Application(String appName, Double value){
        this.appName = appName;
        if(value < 0.0){
            value = 0.0;
        }
        this.value = value;
    }
    public Double getValue(){
        return this.value;
    }
    public void setValue(Double value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", value=" + value +
                '}';
    }
    @Override
    public int compareTo(Application o) {
        return this.appName.compareTo(o.appName);
    }

}
