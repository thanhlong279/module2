package mini.test1;

public class Test {
    public static void main(String[] args) {
        Book[] fictionBook = new Book[3];
        fictionBook[0] = new FictionBook(1, "Vegar", "Galilei", 70, "Viễn tưởng 1");
        fictionBook[1] = new FictionBook(2, "Jupiter", "Copernicus", 80, "Viễn tưởng 2");
        fictionBook[2] = new FictionBook(3, "Saturn", "Einstein", 110, "Viễn tưởng 1");

        Book[] programmingBook = new Book[3];
        programmingBook[0] = new ProgrammingBook(1, "C", "A", 50, "Java", "A");
        programmingBook[1] = new ProgrammingBook(1, "HTML", "B", 70, "HTML", "B");
        programmingBook[2] = new ProgrammingBook(1, "Java", "C", 120, "Java", "C");
        double sumProgrammingBook = 0;
        double sumFictionBook = 0;

        for (Book book : fictionBook) {
            sumFictionBook += book.getAmount(7);
        }
        for (Book book : programmingBook) {
            sumProgrammingBook += book.getAmount(5);
        }

        System.out.println("Tổng giá tiền 6 quyển sách bằng: " + (sumProgrammingBook + sumFictionBook) + " VNĐ");
        int count1 = 0;
        int count2 = 0;
        String str1 = "Viễn tưởng 1";
        String str2 = "Java";

        for (Book book : fictionBook) {
            if (book instanceof FictionBook) {
                FictionBook fb = (FictionBook) book;
                String category = fb.getCategory();
                if (category.equals(str1)) {
                    count1++;
                }
            }
        }
        for (Book book : programmingBook) {
            if (book instanceof ProgrammingBook) {
                ProgrammingBook pb = (ProgrammingBook) book;
                String language = pb.getLanguage();
                if (language.equals(str2)) {
                    count2++;
                }
            }
        }
        System.out.println("số sách số sách mini.test1.FictionBook có category là \"Viễn tưởng 1\" là :" + count1);
        System.out.println("số sách số sách mini.test1.ProgrammingBook có language là \"Java\" là :" + count2);
    }
}
