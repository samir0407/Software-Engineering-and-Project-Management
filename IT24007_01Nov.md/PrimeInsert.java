import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PrimeInsert {

    static boolean isPrime(long number) {
        if (number < 2)
            return false;

        for (long i = 2; i <= number / i; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static long nthPrime(int n) {
        int count = 0;
        long number = 1;

        while (count < n) {
            number++;
            if (isPrime(number))
                count++;
        }
        return number;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("n must be at least 1.");
                return;
            }

            long prime = nthPrime(n);

            String url = "jdbc:mysql://127.0.0.1:3306/testdb";
            String user = "root";
            String password = ""; // MySQL পাসওয়ার্ড থাকলে এখানে দিন

            String sql = """
                    INSERT INTO prime_numbers (n, prime_value)
                    VALUES (?, ?)
                    ON DUPLICATE KEY UPDATE prime_value = ?
                    """;

            try (Connection connection = DriverManager.getConnection(url, user, password);
                    PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, n);
                statement.setLong(2, prime);
                statement.setLong(3, prime);
                statement.executeUpdate();

                System.out.println(
                        "Saved: n = " + n + ", prime = " + prime);
            }
        }
    }
}