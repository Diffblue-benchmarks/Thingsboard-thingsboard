package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2MOperationTypeDiffblueTest {
  /**
   * Test {@link LwM2MOperationType#fromType(String)}.
   * <ul>
   *   <li>When {@code Read}.</li>
   *   <li>Then return {@code READ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MOperationType#fromType(String)}
   */
  @Test
  @DisplayName("Test fromType(String); when 'Read'; then return 'READ'")
  void testFromType_whenRead_thenReturnRead() {
    // Arrange, Act and Assert
    assertEquals(LwM2MOperationType.READ, LwM2MOperationType.fromType("Read"));
  }

  /**
   * Test {@link LwM2MOperationType#fromType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MOperationType#fromType(String)}
   */
  @Test
  @DisplayName("Test fromType(String); when 'Type'; then return 'null'")
  void testFromType_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MOperationType.fromType("Type"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MOperationType#getCode()}
   *   <li>{@link LwM2MOperationType#getType()}
   *   <li>{@link LwM2MOperationType#isComposite()}
   *   <li>{@link LwM2MOperationType#isHasObjectId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    LwM2MOperationType valueOfResult = LwM2MOperationType.valueOf("READ");

    // Act
    int actualCode = valueOfResult.getCode();
    String actualType = valueOfResult.getType();
    boolean actualIsCompositeResult = valueOfResult.isComposite();

    // Assert
    assertEquals("Read", actualType);
    assertEquals(0, actualCode);
    assertFalse(actualIsCompositeResult);
    assertTrue(valueOfResult.isHasObjectId());
  }
}
