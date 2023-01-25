class Main{
    public static void main(String[] args) {
        Codec codec = new Codec(args[0].charAt(0));
        System.out.println(codec.getOffset());
    }
}