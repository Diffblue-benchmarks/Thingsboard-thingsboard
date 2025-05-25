package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GuavaSessionUtilsDiffblueTest {
  /**
   * Test {@link GuavaSessionUtils#builder()}.
   * <p>
   * Method under test: {@link GuavaSessionUtils#builder()}
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GuavaSessionBuilder GuavaSessionUtils.builder()"})
  void testBuilder() {
    // Arrange, Act and Assert
    GuavaSession wrapResult = GuavaSessionUtils.builder().wrap(null);
    assertTrue(wrapResult instanceof DefaultGuavaSession);
    assertNull(((DefaultGuavaSession) wrapResult).getDelegate());
  }
}
