package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 스트림
        Hashtable<String, Integer> hashtable = getInstance();
        ArrayList<String> departmentCode = new ArrayList<>(); // 학과코드를 저장하기 위한 임시 변수
        Set<String> count; // 중복되는 값의 개수를 카운트하기 위한 컬렉션
        int N = Integer.parseInt(br.readLine());
        String temp = "";
        for (int i = 0; i < N; i++) {
            temp = br.readLine();
            if (hashtable.containsKey(temp))
                hashtable.put(temp, 1);
            else
                departmentCode.add(temp.replaceAll("[0-9]", ""));
        }
        count = new HashSet<String>(departmentCode); // Set 컬렉션 인스턴스 할당
        for (String str : count) { // for-each
            System.out.println(str + " : " + Collections.frequency(departmentCode, str)); // Collections의 frequency를 사용하여 ArrayList 전체 중복 변수 갯수 서치
        }

    }

    public static Hashtable getInstance(){
        Hashtable<String,Integer> hashtable = new Hashtable<>();
        // 테이블 크기 20
        hashtable.put("NE301",1);
        hashtable.put("NS201",1);
        hashtable.put("NE101",1);
        hashtable.put("KY321",1);
        hashtable.put("KY205",1);
        hashtable.put("NE312",1);
        hashtable.put("NE201",1);
        hashtable.put("NS325",1);
        return hashtable;
    }
}