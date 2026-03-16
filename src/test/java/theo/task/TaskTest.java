package theo.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TaskTest {

    @Test
    void toString_forToDo_showsCorrectOutput() {
        Task todo = new ToDo("read book");

        assertEquals("[T][ ] read book", todo.toString());

        todo.markDone();
        assertEquals("[T][X] read book", todo.toString());

        todo.markUndone();
        assertEquals("[T][ ] read book", todo.toString());
    }

    @Test
    void toString_forDeadline_showsCorrectOutput() {
        LocalDateTime by = LocalDateTime.of(2023, 12, 2, 23, 59);
        Task deadline = new Deadline("return book", by);

        assertEquals("[D][ ] return book (by: Dec 02 2023, 11:59 pm)", deadline.toString());

        deadline.markDone();
        assertEquals("[D][X] return book (by: Dec 02 2023, 11:59 pm)", deadline.toString());

        deadline.markUndone();
        assertEquals("[D][ ] return book (by: Dec 02 2023, 11:59 pm)", deadline.toString());
    }

    @Test
    void toString_forEvent_showsCorrectOutput() {
        LocalDateTime from = LocalDateTime.of(2023, 8, 12, 0, 0);
        LocalDateTime to = LocalDateTime.of(2023, 8, 12, 23, 59);
        Task event = new Event("birthday", from, to);

        assertEquals("[E][ ] birthday (from: Aug 12 2023, 12:00 am to: Aug 12 2023, 11:59 pm)", event.toString());

        event.markDone();
        assertEquals("[E][X] birthday (from: Aug 12 2023, 12:00 am to: Aug 12 2023, 11:59 pm)", event.toString());

        event.markUndone();
        assertEquals("[E][ ] birthday (from: Aug 12 2023, 12:00 am to: Aug 12 2023, 11:59 pm)", event.toString());
    }

    @Test
    void getType_forToDo_returnsT() {
        Task todo = new ToDo("read book");

        assertEquals("T", todo.getType());
    }

    @Test
    void getType_forDeadline_returnsD() {
        LocalDateTime by = LocalDateTime.of(2023, 12, 2, 23, 59);
        Task deadline = new Deadline("return book", by);

        assertEquals("D", deadline.getType());
    }

    @Test
    void getType_forEvent_returnsE() {
        LocalDateTime from = LocalDateTime.of(2023, 8, 12, 0, 0);
        LocalDateTime to = LocalDateTime.of(2023, 8, 12, 23, 59);

        Task event = new Event("birthday", from, to);
        assertEquals("E", event.getType());
    }
}