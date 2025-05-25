package org.thingsboard.server.dao.sql.relation;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JpaRelationQueryExecutorServiceDiffblueTest {
  /**
   * Test {@link JpaRelationQueryExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link JpaRelationQueryExecutorService#getThreadPollSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JpaRelationQueryExecutorService.getThreadPollSize()"})
  public void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new JpaRelationQueryExecutorService()).getThreadPollSize());
  }
}
