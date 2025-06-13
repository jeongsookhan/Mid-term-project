import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Schedule> schedules = new ArrayList<>();

        while (true)
        {
            System.out.println("---일정 관리 앱---");
            System.out.println("1.일정 추가");
            System.out.println("2.전체 일정 보기");
            System.out.println("3.가까운 일정 보기");
            System.out.println("4. 종료");
            System.out.println("메뉴 선택");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("과목명 입력: ");
                    String subject = sc.next();
                    System.out.println("일정 종류 (과제/시험): ");
                    String type = sc.next();
                    System.out.println("며칠 남았나요? (숫자): ");
                    int dday = Integer.parseInt(sc.next());

                    schedules.add(new Schedule(subject, type, dday));
                    System.out.println("일정이 추가되었습니다.");
                    break;

                case 2:
                    if (schedules.isEmpty())
                        System.out.println("등록된 일정이 없습니다.");
                    else
                        schedules.sort(Comparator.comparingInt(Schedule::getDday));
                        System.out.println("전체 일정:");
                        for (Schedule s : schedules)
                        {
                            System.out.println(" - " + s);
                        }
                    break;

                case 3:
                    List<Schedule> upcoming = new ArrayList<>();
                    for (Schedule s : schedules) {
                        if (s.getDday() >= 0)
                            upcoming.add(s);
                    }

                    if (upcoming.isEmpty())
                        System.out.println("다가오는 일정이 없습니다.");
                    else
                        upcoming.sort(Comparator.comparingInt(Schedule::getDday));
                        System.out.println("다가오는 일정:");
                        for (Schedule s : upcoming) {
                            System.out.println(" - " + s);
                        }
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
