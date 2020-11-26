package baseball;

import java.util.Scanner;
import java.util.Arrays;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean gameCoin = true;
        while(gameCoin){
            String computerChoice = computerChoose();
            gameStart(computerChoice);
            gameCoin=checkGameCoin();
        }
    }

    private static boolean checkGameCoin(){
        Scanner sc = new Scanner(System.in);
        int gameCoin=0;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameCoin = sc.nextInt();
        return gameCoin==1;
    }

    private static String computerChoose(){
        int[] answer = new int[3];
        String computerChoice;
        answer[0] = RandomUtils.nextInt(1,9);
        do{
            answer[1] = RandomUtils.nextInt(1,9);
        }while(answer[0]==answer[1]);
        do{
            answer[2] = RandomUtils.nextInt(1,9);
        }while(answer[0]==answer[2] || answer[1]==answer[2]);
        
        computerChoice = Arrays.toString(answer).replaceAll("[^0-9]","");
        return computerChoice;
    }

    private static void gameStart(String computerChoice){
        int strike;
        String userChoice = userChoose();
        strike = umpireThePitch(computerChoice, userChoice);
        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }else{
            gameStart(computerChoice);
        }
    }

    private static String userChoose(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String userChoice = sc.nextLine();
            return userChoice;
    }

    private static int umpireThePitch(String computerChoice, String userChoice){
        int strike = 0;
        int ball = 0;
        
        for(int i=0; i< computerChoice.length(); i++){
            if(computerChoice.charAt(i)==userChoice.charAt(i)){
                strike+=1;
            }
        }
        for(int i=0; i< computerChoice.length(); i++){
            if(userChoice.charAt(0)==computerChoice.charAt(i)){
                ball+=1;
            }
        }
        for(int i=0; i< computerChoice.length(); i++){
            if(userChoice.charAt(1)==computerChoice.charAt(i)){
                ball+=1;
            }
        }
        for(int i=0; i< computerChoice.length(); i++){
            if(userChoice.charAt(2)==computerChoice.charAt(i)){
                ball+=1;
            }
        }
        ball-=strike;
        umpireCalls(strike,ball);
        return strike;
    }

    private static void umpireCalls(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }else if(strike == 0 && ball != 0){
            System.out.println(ball+"볼");
        }else if(strike !=0 && ball == 0){
            System.out.println(strike+"스트라이크");
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
}