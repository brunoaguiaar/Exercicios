public class Jogo{
    public static void main(String[] args){
        System.out.println("EA Games chalenge is everything.");
        
        try{
            System.out.println(args[0]);
        } catch(Exception e){
            System.out.println(":(");
            e.printStackTrace();
        }
    
    
    }
}
