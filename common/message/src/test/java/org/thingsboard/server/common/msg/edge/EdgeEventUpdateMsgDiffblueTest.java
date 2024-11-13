package org.thingsboard.server.common.msg.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeEventUpdateMsgDiffblueTest {
  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}, and
   * {@link EdgeEventUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventUpdateMsg#equals(Object)}
   *   <li>{@link EdgeEventUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
    int expectedHashCodeResult = edgeEventUpdateMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeEventUpdateMsg2.hashCode());
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), mock(EdgeId.class));

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), mock(EdgeId.class)), "42");
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, mock(EdgeId.class));

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, mock(EdgeId.class));

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(null, null));
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(null, new EdgeId(UUID.randomUUID())));
  }
}
