package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JpaExecutorServiceDiffblueTest {
  /**
   * Test {@link JpaExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link JpaExecutorService#getThreadPollSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JpaExecutorService.getThreadPollSize()"})
  public void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new JpaExecutorService()).getThreadPollSize());
  }
}
