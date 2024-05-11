package com.vtapps.quickstart.dao;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtension.class)
//public class AuthorDaoImplTests {
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private AuthorDaoImpl underTest;
//
//    @Test
//    public void testThatCreateAuthorGeneratesCorrectSql(){
//        AuthorEntity authorEntity= AuthorEntity.builder()
//                .id(1L)
//                .name("Abiqail Rose")
//                .age(80)
//                .build();
//        underTest.create(authorEntity);
//
//        verify(jdbcTemplate).update(eq("INSERT INTO authors (id,name,age) VALUES (?,?,?)"),
//                eq(1L),eq("Abiqail Rose"),eq(80));
//    }
//
//    @Test
//    public void testTheFindOneGeneratesTheCorrectSql(){
//        underTest.findOne(1L);
//        verify(jdbcTemplate).query("SELECT id,name,age FROM authors WHERE id=? LIMIT 1",
//               ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
//                eq(1L));
//    }
//}
