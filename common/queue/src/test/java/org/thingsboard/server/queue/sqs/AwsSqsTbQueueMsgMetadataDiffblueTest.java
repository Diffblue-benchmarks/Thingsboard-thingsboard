package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.amazonaws.http.SdkHttpMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AwsSqsTbQueueMsgMetadataDiffblueTest {
  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}, and
   * {@link AwsSqsTbQueueMsgMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata2 = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(awsSqsTbQueueMsgMetadata, awsSqsTbQueueMsgMetadata2);
    int expectedHashCodeResult = awsSqsTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, awsSqsTbQueueMsgMetadata2.hashCode());
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}, and
   * {@link AwsSqsTbQueueMsgMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(awsSqsTbQueueMsgMetadata, awsSqsTbQueueMsgMetadata);
    int expectedHashCodeResult = awsSqsTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, awsSqsTbQueueMsgMetadata.hashCode());
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(mock(SdkHttpMetadata.class));

    // Act and Assert
    assertNotEquals(awsSqsTbQueueMsgMetadata, new AwsSqsTbQueueMsgMetadata(null));
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertNotEquals(awsSqsTbQueueMsgMetadata, new AwsSqsTbQueueMsgMetadata(mock(SdkHttpMetadata.class)));
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AwsSqsTbQueueMsgMetadata(null), null);
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AwsSqsTbQueueMsgMetadata(null), "Different type to AwsSqsTbQueueMsgMetadata");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AwsSqsTbQueueMsgMetadata#AwsSqsTbQueueMsgMetadata(SdkHttpMetadata)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#toString()}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#getMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AwsSqsTbQueueMsgMetadata actualAwsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);
    String actualToStringResult = actualAwsSqsTbQueueMsgMetadata.toString();

    // Assert
    assertEquals("AwsSqsTbQueueMsgMetadata(metadata=null)", actualToStringResult);
    assertNull(actualAwsSqsTbQueueMsgMetadata.getMetadata());
  }
}
