package backtracking;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArbitraryPhoneNumberChess {
    public List<String> solve(String input) throws IOException {
        var reader = new BufferedReader(new StringReader(input));
        var figure = reader.readLine();
        var n = Integer.valueOf(reader.readLine());
        var firstChars = Arrays.stream(reader.readLine().split(" ")).map(s -> s.charAt(0)).toList();
        var nrows = Integer.valueOf(reader.readLine());
        var ncols = Integer.valueOf(reader.readLine());
        var matrix = new Character[nrows][ncols];

        for (int i = 0; i < nrows; i++) {
            var rowElements = Arrays.stream(reader.readLine().split(" ")).map(s -> s.charAt(0)).toList();
            if(rowElements.size() != ncols)
                throw new RuntimeException("size don't match");
            for (int j = 0; j < ncols; j++)
                matrix[i][j] = rowElements.get(j);
        }
        printParams(figure, n, firstChars, nrows, ncols, matrix);
        firstChars.forEach(firstC -> {
            var startIdxm = findFirstCharacter(matrix, firstC, nrows, ncols);
            System.out.println("All numbers for: " + firstC);
            solve(figure, startIdxm, n, nrows, ncols, matrix, new LinkedList<>());
        });

        return null;
    }

    static Idxm findFirstCharacter(Character[][] matrix, Character c, int nrows, int ncols) {
        for (int i = 0; i < nrows; i++)
            for (int j = 0; j < ncols; j++)
                if(matrix[i][j] == c)
                    return new Idxm(i,j);
        return null;
    }

    static void solve(String figure, Idxm cur, Integer n, int nrows, int ncols, Character[][] matrix, LinkedList<Character> result) {
        var currC = matrix[cur.i][cur.j];
        if(Character.isDigit(currC))
            result.add(currC);
        if(result.size() == n) {
            System.out.println(result);
        } else {
            List<Idxm> nextMoves = null;
            if(figure.equals("knight"))
                nextMoves = findNextMovesKnight(cur, matrix, nrows, ncols);
            else if(figure.equals("bishop"))
                nextMoves = findNextMovesBishop(cur, matrix, nrows, ncols);

            for (Idxm idxm : nextMoves) {
                var c = matrix[idxm.i][idxm.j];
                solve(figure, idxm, n, nrows, ncols, matrix, result);
            }
        }
        if(Character.isDigit(currC))
            result.removeLast();
    }

    private static List<Idxm> findNextMovesBishop(Idxm cur, Character[][] matrix, int nrows, int ncols) {
        throw  new RuntimeException("not impl");
    }

    static List<Idxm> findNextMovesKnight(Idxm cur, Character[][] matrix, int nrows, int ncols) {
        var moves = new ArrayList<Idxm>();
        moves.add(new Idxm(cur.i - 2, cur.j + 1));
        moves.add(new Idxm(cur.i - 1, cur.j + 2));
        moves.add(new Idxm(cur.i + 1, cur.j + 2));
        moves.add(new Idxm(cur.i + 2, cur.j + 1));
        moves.add(new Idxm(cur.i + 1, cur.j - 2));
        moves.add(new Idxm(cur.i + 2, cur.j - 1));
        moves.add(new Idxm(cur.i - 2, cur.j - 1));
        moves.add(new Idxm(cur.i - 1, cur.j - 2));
        return moves.stream().filter(idxm -> idxm.i >= 0 && idxm.i < nrows && idxm.j >= 0 && idxm.j < ncols).toList();
    }

    static record Idxm(int i, int j){}

    private static void printParams(String figure, Integer n, List<Character> firstChars, Integer nrows, Integer ncols, Character[][] matrix) {
        System.out.println(figure);
        System.out.println(n);
        System.out.println(firstChars);
        System.out.println(nrows);
        System.out.println(ncols);
        System.out.println(Arrays.deepToString(matrix));
    }

    @Test
    public void test1() throws IOException {
        ArbitraryPhoneNumberChess sol = new ArbitraryPhoneNumberChess();
        String input =
                """
                knight
                4
                1 2
                3
                3
                1 2 3
                4 5 6
                7 8 9
                """;
        List<String> result = sol.solve(input);
    }
    @Test
    public void test2() throws IOException {
        ArbitraryPhoneNumberChess sol = new ArbitraryPhoneNumberChess();
        String input =
                """
                knight
                4
                1
                4
                3
                1 2 3
                4 5 6
                7 8 9
                * 0 #
                """;
        sol.solve(input);
    }

    @Test
    public void test3() throws IOException {
        ArbitraryPhoneNumberChess sol = new ArbitraryPhoneNumberChess();
        String input =
                """
                knight
                5
                1 5
                4
                3
                1 2 3
                4 5 6
                7 8 9
                * 0 #
                """;
        sol.solve(input);
    }

}
