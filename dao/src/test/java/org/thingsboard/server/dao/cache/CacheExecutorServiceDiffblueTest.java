package org.thingsboard.server.dao.cache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CacheExecutorServiceDiffblueTest {
  /**
   * Test {@link CacheExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link CacheExecutorService#getThreadPollSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CacheExecutorService.getThreadPollSize()"})
  public void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new CacheExecutorService()).getThreadPollSize());
  }
}
