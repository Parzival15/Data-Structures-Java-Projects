import java.util.*;
public class WaterTransfer{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int c1,c2,c3,d;
        c1 = scanner.nextInt();
        c2 = scanner.nextInt();
        c3 = scanner.nextInt();
        d = scanner.nextInt();
        transfer(c1,c2,c3,d);

    }
    static void transfer(int c1, int c2, int c3, int d){
        int jug1,jug2,jug3;
        jug1 = c1;
        jug2=jug3=0;
        int difference = 0;
        while(jug1 != d && jug2 != d && jug3 != d){
            if(jug1 == c1){
                System.out.println(jug1+" "+jug2+" "+jug3);
                jug2 = c2;
                jug1-=jug2;
                System.out.println(jug1+" "+jug2+" "+jug3);
            }
            if(jug2 > 0 && jug3 ==0){ //jug2> 0 and jug3 is empty
                if(jug1 == d || jug2 == d || jug3 == d){
                    jug1 = d;
                    break;
                }
                else if(jug2 < c3){
                    jug3 = jug2;
                    jug2 = 0;
                    System.out.println(jug1+" "+jug2+" "+jug3);
                }
                else{
                    jug3 = c3;
                    jug2-=jug3;
                    System.out.println(jug1+" "+jug2+" "+jug3);
                }
            }
            if(jug2 > 0 && jug3>0){//jug2 and jug3 are filled.
                if(jug1 == d || jug2 == d || jug3 == d) {
                    jug1 = d;
                    break;
                }
                for(int i = 1; i <= jug3;i++) {
                    if (jug3 + i == c3 && jug2 - i == d) {
                        System.out.println(jug1 + " " + (jug2 - i) + " " + (jug3 + i));
                        jug1 = d;
                        break;
                    }
                }

                if(jug3 == c3) {
                    jug1+=jug3;
                    jug3 = 0;
                    System.out.println(jug1+" "+jug2+" "+jug3);

                }
                else if(jug3 > jug2){
                    if(jug1+jug3 <= c1){
                        jug1 += jug3;
                        jug3 = 0;
                        System.out.println(jug1+" "+jug2+" "+jug3);
                    }


                }
                else{

                    difference = c3 - jug3;
                    jug2-=difference;
                    jug3+=difference;
                    System.out.println(jug1+" "+jug2+" "+jug3);
                    difference = 0;

                }

            }
            if(jug2 == 0 && jug3 >0){  //if jug2 is empty and jug3 has some.
                if(jug1 == d || jug2 == d || jug3 == d) {
                    jug1 = d;
                    break;
                }
                else if(jug1 > c2){
                    jug1-=c2;
                    jug2 = c2;
                    System.out.println(jug1+" "+jug2+" "+jug3);
                }
                else{
                    jug2 = jug1;
                    jug1 = 0;
                    System.out.println(jug1+" "+jug2+" "+jug3);
                }

            }

        }


    }


}
