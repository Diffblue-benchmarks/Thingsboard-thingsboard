package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThingsboardKafkaClientErrorDiffblueTest {
  /**
   * Test {@link ThingsboardKafkaClientError#ThingsboardKafkaClientError(String)}.
   * <p>
   * Method under test: {@link ThingsboardKafkaClientError#ThingsboardKafkaClientError(String)}
   */
  @Test
  @DisplayName("Test new ThingsboardKafkaClientError(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ThingsboardKafkaClientError.<init>(String)"})
  void testNewThingsboardKafkaClientError() {
    // Arrange and Act
    ThingsboardKafkaClientError actualThingsboardKafkaClientError = new ThingsboardKafkaClientError(
        "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualThingsboardKafkaClientError.getMessage());
    assertNull(actualThingsboardKafkaClientError.getCause());
    assertEquals(0, actualThingsboardKafkaClientError.getSuppressed().length);
  }
}
