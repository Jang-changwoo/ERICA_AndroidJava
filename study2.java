import java.util.Random;

class study2{
    public static void main(String[] args){
        
        Random rand = new Random();

        String pnumber = "0";
        pnumber += rand.nextInt(4) + 2;
        pnumber += rand.nextInt(6) + 1;
        pnumber += "-";
        pnumber += rand.nextInt(10);
        pnumber += rand.nextInt(10);
        pnumber += rand.nextInt(10);
        pnumber += "-";
        pnumber += rand.nextInt(10);
        pnumber += rand.nextInt(10);
        pnumber += rand.nextInt(10);
        pnumber += rand.nextInt(10);
        System.out.println(pnumber);
    }
}

