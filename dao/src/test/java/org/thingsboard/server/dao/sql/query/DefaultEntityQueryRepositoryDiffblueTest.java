package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

public class DefaultEntityQueryRepositoryDiffblueTest {
  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevelAllowed()}.
   * <p>
   * Method under test: {@link DefaultEntityQueryRepository#getMaxLevelAllowed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DefaultEntityQueryRepository.getMaxLevelAllowed()"})
  public void testGetMaxLevelAllowed() {
    // Arrange
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();

    // Act and Assert
    assertEquals(0,
        (new DefaultEntityQueryRepository(jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent()))
            .getMaxLevelAllowed());
  }
}
