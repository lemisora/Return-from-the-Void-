class PruebasAlex{
    public static void main(String[] args){
        String hola= "Alex";
        String pas ="1234";
        User user = new User(hola, pas);
        user.saveScore(3, 1000);
        user.saveScore(3, 1000);
        user.saveScore(3, 10200);
        user.saveScore(3, 1000);
        System.out.print(user.getMaxScore(3));
        }
}