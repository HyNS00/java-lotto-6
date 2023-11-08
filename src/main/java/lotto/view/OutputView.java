package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.controller.LottoController.sortNumber;

public class OutputView {
    public static void printLottoList(List<Lotto> lottery){
        for (Lotto lotto : lottery){
            printLottoNumber(sortNumber(lotto));
        }
        System.out.println();
    }

    public static void printPurchaseLotto(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> lotto){
        List<String> tmpLotto = new ArrayList<>();
        for (int lottoNumber : lotto) {
            tmpLotto.add(String.valueOf(lottoNumber));
        }
        String allNumber = "[";
        allNumber += String.join(", ", tmpLotto);
        allNumber += "]";
        System.out.println(allNumber);
    }
    public static void printResultRank(HashMap<Rank, Integer> result) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Rank rank : Rank.values()) {
            if (result.containsKey(rank)) {
                count = result.get(rank);
            }
            sb.append(rank.getResultPrint()).append(count).append("개\n");
            count = 0;
        }
        System.out.print(sb);
    }

    public static void printCalRate(double mean) {
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ").append(String.format("%.1f",mean)).append("%입니다.");
        System.out.println(sb.toString());
    }
}
