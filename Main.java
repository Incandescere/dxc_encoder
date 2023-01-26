class Main{
    public static void main(String[] args) {
//        new codec with offset char 'B'
        Codec codec = new Codec('B');
//        System.out.println("offset: "+codec.getOffset());
        System.out.println("Encode 'HELLO WORLD': "+codec.encode("HELLO WORLD"));
        System.out.println("Decode 'FC/GGJ RJMG.': "+codec.decode("FC/GGJ RJMG."));
    }
}