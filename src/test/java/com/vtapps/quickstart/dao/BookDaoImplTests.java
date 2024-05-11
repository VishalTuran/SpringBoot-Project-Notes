//package com.vtapps.quickstart.dao;
//
//import com.vtapps.quickstart.Domain.entities.AuthorEntity;
//import com.vtapps.quickstart.Domain.entities.BookEntity;
//import com.vtapps.quickstart.dao.Impl.AuthorDaoImpl;
//import com.vtapps.quickstart.dao.Impl.BookDaoImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class BookDaoImplTests {
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private BookDaoImpl underTest;
//
//    @Test
//    public void testThatCreateBookGeneratesCorrectSql(){
//        BookEntity book = BookEntity.builder()
//                .isbn("First BookEntity")
//                .title("Invisible Man")
//                .authorId(1L)
//                .build();
//        underTest.create(book);
//
//        verify(jdbcTemplate).update(eq("INSERT INTO book (isbn,title,author_id) VALUES (?,?,?)"),
//                eq("First BookEntity"),eq("Invisible Man"),eq(1L));
//    }
//}
