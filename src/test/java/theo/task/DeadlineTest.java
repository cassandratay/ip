package theo.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DeadlineTest {

    @Test
    void toString_formatsDeadlineCorrectly() {
        LocalDateTime by = LocalDateTime.of(2023, 12, 2, 23, 59);
        Task deadline = new Deadline("submit report", by);

        assertEquals(
                "[D][ ] submit report (by: Dec 02 2023, 11:59 pm)",
                deadline.toString()
        );
    }

    @Test
    void markDone_updatesToString() {
        LocalDateTime by = LocalDateTime.of(2023, 12, 2, 23, 59);
        Task deadline = new Deadline("submit report", by);

        deadline.markDone();

        assertEquals(
                "[D][X] submit report (by: Dec 02 2023, 11:59 pm)",
                deadline.toString()
        );
    }

    @Test
    void formatForFile_formatsCorrectly() {
        LocalDateTime by = LocalDateTime.of(2023, 12, 2, 23, 59);
        Deadline deadline = new Deadline("submit report", by);

        assertEquals(
                "D | 0 | submit report | 2/12/2023 2359",
                deadline.formatForFile()
        );
    }

    @Test
    void isOnDate_returnsCorrectResult() {
        LocalDateTime by = LocalDateTime.of(2023, 12, 2, 23, 59);
        Deadline deadline = new Deadline("submit report", by);

        assertTrue(deadline.isOnDate(LocalDate.of(2023, 12, 2)));
        assertTrue(deadline.isOnDate(LocalDate.of(2023, 12, 1)));
        assertFalse(deadline.isOnDate(LocalDate.of(2023, 12, 3)));
    }
}