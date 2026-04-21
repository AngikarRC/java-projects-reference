package car.example.beans;

public class MyBean {
    private String meussage;

    public void setMeussage(String meussage) {
        this.meussage = meussage;
    }

    public void showMessage(){
        System.out.println("Message: " + meussage);
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "meussage='" + meussage + '\'' +
                '}';
    }
}
