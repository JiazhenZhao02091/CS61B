package Lab.lab5.tests.puzzle;

import Lab.lab5.src.puzzle.Puzzle;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class PuzzleTest {
    static final File HELLO_FILE = new File("F:\\workspace\\CS61B\\src\\Lab\\lab5\\src\\conflict\\hello.txt");
    static final File PUZZLE_FILE = new File("F:\\workspace\\CS61B\\src\\Lab\\lab5\\src\\puzzle\\Puzzle.java");
    static final File PUZZLE_REFERENCE = new File("F:\\workspace\\CS61B\\src\\Lab\\lab5\\tests\\puzzle\\PuzzleReference.txt");
    static final File SECRET_FILE = new File("F:\\workspace\\CS61B\\src\\Lab\\lab5\\src\\puzzle\\secret.txt");

    @Test
    public void testPuzzle() {
        assertThat(("" + Puzzle.puzzle()).hashCode()).isEqualTo(-32772622);

        assertWithMessage("Looks like you modified Puzzle.java! Be sure to undo those changes.")
                .that(readAllLines(PUZZLE_REFERENCE)).isEqualTo(readAllLines(PUZZLE_FILE));
    }

    /**
     * Test that secret.txt contains the correct secret.
     */
    @Test
    public void testSecret() {
        List<String> fileContents = readAllLines(HELLO_FILE);
        int secret = Puzzle.loadAnswer(SECRET_FILE);
        assertWithMessage("Wrong secret! Use watches or the expression evaluator " +
                "to find out what the correct value should be!")
                .that(secret == (fileContents.hashCode() + 1337)).isTrue();
    }

    /** Read all lines of a file into a string list, trimming whitespace. */
    private List<String> readAllLines(File f) {
        Scanner s;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> lst = new ArrayList<>();
        while (s.hasNextLine()) {
            String clean = s.nextLine().trim();
            if (!clean.isEmpty()) {
                lst.add(clean);
            }
        }
        return lst;
    }
}
