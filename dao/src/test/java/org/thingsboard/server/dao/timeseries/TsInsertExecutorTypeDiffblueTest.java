package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.Test;

public class TsInsertExecutorTypeDiffblueTest {
  /**
   * Test {@link TsInsertExecutorType#parse(String)}.
   * <ul>
   *   <li>When {@code CACHED}.</li>
   *   <li>Then return {@link Optional#get()} is {@code CACHED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsInsertExecutorType#parse(String)}
   */
  @Test
  public void testParse_whenCached_thenReturnGetIsCached() {
    // Arrange and Act
    Optional<TsInsertExecutorType> actualParseResult = TsInsertExecutorType.parse("CACHED");

    // Assert
    assertEquals(TsInsertExecutorType.CACHED, actualParseResult.get());
    assertTrue(actualParseResult.isPresent());
  }
}
