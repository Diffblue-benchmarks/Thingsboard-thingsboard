package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class EntityCountUnsubscribeCmdDiffblueTest {
  /**
   * Test {@link EntityCountUnsubscribeCmd#equals(Object)}, and
   * {@link EntityCountUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountUnsubscribeCmd#equals(Object)}
   *   <li>{@link EntityCountUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityCountUnsubscribeCmd entityCountUnsubscribeCmd = new EntityCountUnsubscribeCmd(1);
    EntityCountUnsubscribeCmd entityCountUnsubscribeCmd2 = new EntityCountUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(entityCountUnsubscribeCmd, entityCountUnsubscribeCmd2);
    int expectedHashCodeResult = entityCountUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityCountUnsubscribeCmd2.hashCode());
  }

  /**
   * Test {@link EntityCountUnsubscribeCmd#equals(Object)}, and
   * {@link EntityCountUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountUnsubscribeCmd#equals(Object)}
   *   <li>{@link EntityCountUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityCountUnsubscribeCmd entityCountUnsubscribeCmd = new EntityCountUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(entityCountUnsubscribeCmd, entityCountUnsubscribeCmd);
    int expectedHashCodeResult = entityCountUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityCountUnsubscribeCmd.hashCode());
  }

  /**
   * Test {@link EntityCountUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityCountUnsubscribeCmd entityCountUnsubscribeCmd = new EntityCountUnsubscribeCmd(2);

    // Act and Assert
    assertNotEquals(entityCountUnsubscribeCmd, new EntityCountUnsubscribeCmd(1));
  }

  /**
   * Test {@link EntityCountUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountUnsubscribeCmd(1), null);
  }

  /**
   * Test {@link EntityCountUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountUnsubscribeCmd(1), "Different type to EntityCountUnsubscribeCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountUnsubscribeCmd#EntityCountUnsubscribeCmd(int)}
   *   <li>{@link EntityCountUnsubscribeCmd#toString()}
   *   <li>{@link EntityCountUnsubscribeCmd#getCmdId()}
   *   <li>{@link EntityCountUnsubscribeCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityCountUnsubscribeCmd actualEntityCountUnsubscribeCmd = new EntityCountUnsubscribeCmd(1);
    String actualToStringResult = actualEntityCountUnsubscribeCmd.toString();
    int actualCmdId = actualEntityCountUnsubscribeCmd.getCmdId();

    // Assert
    assertEquals("EntityCountUnsubscribeCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.ENTITY_COUNT_UNSUBSCRIBE, actualEntityCountUnsubscribeCmd.getType());
  }
}
