package com.ssg.springex.dao;

import com.ssg.springex.samplejdbcex.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoTests {


    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }
        @Test
        public void testTime2() throws Exception{
            System.out.println(todoDAO.getTime2());

        }

    }

