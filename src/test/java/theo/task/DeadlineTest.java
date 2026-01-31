package theo.task;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeadlineTest {

    @Test
    void getDeadline_withValidDateTime_formatsCorrectly() {
        Task deadline = new Deadline(
                "submit report",
                "2/12/2023 2359"
        );

        assertEquals(
                " (by: Dec 02 2023, 11:59 pm)",
                deadline.getDeadline()
        );
    }

    @Test
    void constructor_withInvalidDate_throwsException() {
        assertThrows(
                DateTimeParseException.class,
                () -> new Deadline("task", "31-12-2023 2359")
        );
    }
}
