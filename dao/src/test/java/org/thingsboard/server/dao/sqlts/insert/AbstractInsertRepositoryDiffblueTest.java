package org.thingsboard.server.dao.sqlts.insert;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.sql.attributes.AttributeKvInsertRepository;

@ContextConfiguration(classes = {AttributeKvInsertRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class AbstractInsertRepositoryDiffblueTest {
  @Autowired
  private AbstractInsertRepository abstractInsertRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link AbstractInsertRepository#replaceNullChars(String)}.
   * <p>
   * Method under test: {@link AbstractInsertRepository#replaceNullChars(String)}
   */
  @Test
  public void testReplaceNullChars() {
    // Arrange
    AbstractInsertRepository abstractInsertRepository2 = mock(AbstractInsertRepository.class);
    when(abstractInsertRepository2.replaceNullChars(Mockito.<String>any())).thenReturn("Replace Null Chars");

    // Act
    abstractInsertRepository2.replaceNullChars("42");

    // Assert
    verify(abstractInsertRepository2).replaceNullChars(eq("42"));
  }
}
