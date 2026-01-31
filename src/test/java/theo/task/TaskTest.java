package theo.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
        Task deadline = new Deadline("return book", "2/12/2023 2359");
        assertEquals("[D][ ] return book (by: Dec 02 2023, 11:59 pm)", deadline.toString());

        deadline.markDone();
        assertEquals("[D][X] return book (by: Dec 02 2023, 11:59 pm)", deadline.toString());

        deadline.markUndone();
        assertEquals("[D][ ] return book (by: Dec 02 2023, 11:59 pm)", deadline.toString());
    }

    @Test
    void toString_forEvent_showsCorrectOutput() {
        Task event = new Event("birthday", "12/08/2023 0000", "12/08/2023 2359");
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
        Task deadline = new Deadline("return book", "2/12/2023 2359");
        assertEquals("D", deadline.getType());
    }

    @Test
    void getType_forEvent_returnsE() {
        Task event = new Event("birthday", "12/08/2023 0000", "12/08/2023 2359");
        assertEquals("E", event.getType());
    }
}
