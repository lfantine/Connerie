public class Apple extends Fruit{
  
    @Override 
    public void taste(){
        System.out.println("pomme==sucré");
    }
    @Override 
    public int getSize() {
        return 1;
    }
    @Override 
    public boolean hasSeed() {
        return true;
    }
}
