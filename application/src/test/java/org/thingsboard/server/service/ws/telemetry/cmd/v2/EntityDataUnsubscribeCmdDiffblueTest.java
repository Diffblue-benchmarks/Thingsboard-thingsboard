package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class EntityDataUnsubscribeCmdDiffblueTest {
  /**
   * Test {@link EntityDataUnsubscribeCmd#equals(Object)}, and {@link EntityDataUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataUnsubscribeCmd#equals(Object)}
   *   <li>{@link EntityDataUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUnsubscribeCmd.equals(Object)", "int EntityDataUnsubscribeCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataUnsubscribeCmd entityDataUnsubscribeCmd = new EntityDataUnsubscribeCmd(1);
    EntityDataUnsubscribeCmd entityDataUnsubscribeCmd2 = new EntityDataUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(entityDataUnsubscribeCmd, entityDataUnsubscribeCmd2);
    int expectedHashCodeResult = entityDataUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityDataUnsubscribeCmd2.hashCode());
  }

  /**
   * Test {@link EntityDataUnsubscribeCmd#equals(Object)}, and {@link EntityDataUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataUnsubscribeCmd#equals(Object)}
   *   <li>{@link EntityDataUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUnsubscribeCmd.equals(Object)", "int EntityDataUnsubscribeCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataUnsubscribeCmd entityDataUnsubscribeCmd = new EntityDataUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(entityDataUnsubscribeCmd, entityDataUnsubscribeCmd);
    int expectedHashCodeResult = entityDataUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityDataUnsubscribeCmd.hashCode());
  }

  /**
   * Test {@link EntityDataUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUnsubscribeCmd.equals(Object)", "int EntityDataUnsubscribeCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityDataUnsubscribeCmd entityDataUnsubscribeCmd = new EntityDataUnsubscribeCmd(2);

    // Act and Assert
    assertNotEquals(entityDataUnsubscribeCmd, new EntityDataUnsubscribeCmd(1));
  }

  /**
   * Test {@link EntityDataUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUnsubscribeCmd.equals(Object)", "int EntityDataUnsubscribeCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataUnsubscribeCmd(1), null);
  }

  /**
   * Test {@link EntityDataUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUnsubscribeCmd.equals(Object)", "int EntityDataUnsubscribeCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataUnsubscribeCmd(1), "Different type to EntityDataUnsubscribeCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataUnsubscribeCmd#EntityDataUnsubscribeCmd(int)}
   *   <li>{@link EntityDataUnsubscribeCmd#toString()}
   *   <li>{@link EntityDataUnsubscribeCmd#getCmdId()}
   *   <li>{@link EntityDataUnsubscribeCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityDataUnsubscribeCmd.<init>(int)", "int EntityDataUnsubscribeCmd.getCmdId()",
      "WsCmdType EntityDataUnsubscribeCmd.getType()", "String EntityDataUnsubscribeCmd.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataUnsubscribeCmd actualEntityDataUnsubscribeCmd = new EntityDataUnsubscribeCmd(1);
    String actualToStringResult = actualEntityDataUnsubscribeCmd.toString();
    int actualCmdId = actualEntityDataUnsubscribeCmd.getCmdId();

    // Assert
    assertEquals("EntityDataUnsubscribeCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.ENTITY_DATA_UNSUBSCRIBE, actualEntityDataUnsubscribeCmd.getType());
  }
}
