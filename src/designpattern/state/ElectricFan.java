package designpattern.state;

public class ElectricFan {
    private State state;

    public ElectricFan() {
        state = new Stop();
    }

    public void setState(State state){
        this.state = state;
    }

    public void on_push(){
        state.on_button(this);
    }

    public void off_push(){
        state.off_button(this);
    }

    public void operation(){
        off_push();
        on_push();
        on_push();
        on_push();
        off_push();
    }
}
