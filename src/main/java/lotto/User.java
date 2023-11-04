package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

class User {

    public int inputPurchasingVolume(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int volume = Integer.parseInt(input);
        //        입력값 검증 함수
        return volume/1000;
    }

    public List<Integer> inputNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        Integer[] inputNums = Stream.of(input.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(inputNums));
//       입력값 검증 함수
        return numbers;
    }

    public List<Integer> getLottoNumbers (){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<List<Integer>> getLottoAsMuchAsVolume(int volume){
        List<List<Integer>> lottoPapers = new ArrayList<>();
        for(int i=0; i<volume; i++){
            List<Integer> lottoNumbers = getLottoNumbers();
            Collections.sort(lottoNumbers);
            lottoPapers.add(lottoNumbers);
        }
        return lottoPapers;
    }
}