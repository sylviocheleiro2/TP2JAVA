package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @DisplayName("Task verificando nome e titulo")
    @Test
    void verificarTask() {
        //1 -A Arrumaçãp:
        Task t1 = new Task("matematica", "calculo", "14/03/2005");
        //2 - A Action:
        String nome = t1.setTitle("a");
        //3 - A Assert:
        assertEquals(nome, t1.getTitle());

    }

    @DisplayName("Task esta completa?")
    @Test
    void isTaskDone(){
        Task t1 = new Task("matematica", "calculo", "14/03/2005");
        assertFalse(t1.isCompleted());
    }


}
