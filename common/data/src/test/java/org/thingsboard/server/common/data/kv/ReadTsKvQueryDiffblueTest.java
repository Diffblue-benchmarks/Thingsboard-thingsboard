package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReadTsKvQueryDiffblueTest {
  /**
   * Test {@link ReadTsKvQuery#getInterval()}.
   *
   * <p>Method under test: {@link ReadTsKvQuery#getInterval()}
   */
  @Test
  @DisplayName("Test getInterval()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReadTsKvQuery.getInterval()"})
  void testGetInterval() {
    // Arrange, Act and Assert
    assertEquals(0L, new BaseReadTsKvQuery("Key", 1L, 1L).getInterval());
  }

  /**
   * Test {@link ReadTsKvQuery#getAggregation()}.
   *
   * <p>Method under test: {@link ReadTsKvQuery#getAggregation()}
   */
  @Test
  @DisplayName("Test getAggregation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aggregation ReadTsKvQuery.getAggregation()"})
  void testGetAggregation() {
    // Arrange, Act and Assert
    assertEquals(Aggregation.AVG, new BaseReadTsKvQuery("Key", 1L, 1L).getAggregation());
  }
}
