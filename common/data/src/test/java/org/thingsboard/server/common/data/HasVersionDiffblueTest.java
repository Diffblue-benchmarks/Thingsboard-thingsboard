package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HasVersionDiffblueTest {
  /**
   * Test {@link HasVersion#setVersion(Long)}.
   *
   * <p>Method under test: {@link HasVersion#setVersion(Long)}
   */
  @Test
  @DisplayName("Test setVersion(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HasVersion.setVersion(Long)"})
  void testSetVersion() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setVersion(1L);

    // Assert
    assertEquals(1L, customer.getVersion().longValue());
  }
}
