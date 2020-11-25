package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean gameCoin = true;
        int a = 0;
        while(gameCoin){
            int ball = 0;
            int strike = 0;


            gameCoin=checkGameCoin();
        }
    }

    private static boolean checkGameCoin(){
        Scanner sc = new Scanner(System.in);  //왜 여기 이렇게 해줘야 오류(scanner cannot be resolved)없이 실행?
        int gameCoin=0;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        gameCoin = sc.nextInt();
        return gameCoin==1;
    }
}

