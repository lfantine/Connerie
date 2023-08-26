public class PineApple extends Fruit{
  
    @Override 
    public void taste(){
        System.out.println("Ananas==sucré et amer");
    }
    @Override 
    public int getSize() {
        return 3;
    }
    @Override 
    public boolean hasSeed() {
        return false;
    }
}
