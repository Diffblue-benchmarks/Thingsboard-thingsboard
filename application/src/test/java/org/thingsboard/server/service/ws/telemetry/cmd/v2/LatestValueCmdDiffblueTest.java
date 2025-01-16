package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;

class LatestValueCmdDiffblueTest {
  /**
   * Test {@link LatestValueCmd#equals(Object)}, and
   * {@link LatestValueCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LatestValueCmd#equals(Object)}
   *   <li>{@link LatestValueCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    LatestValueCmd latestValueCmd2 = new LatestValueCmd();
    latestValueCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertEquals(latestValueCmd, latestValueCmd2);
    int expectedHashCodeResult = latestValueCmd.hashCode();
    assertEquals(expectedHashCodeResult, latestValueCmd2.hashCode());
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}, and
   * {@link LatestValueCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LatestValueCmd#equals(Object)}
   *   <li>{@link LatestValueCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertEquals(latestValueCmd, latestValueCmd);
    int expectedHashCodeResult = latestValueCmd.hashCode();
    assertEquals(expectedHashCodeResult, latestValueCmd.hashCode());
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestValueCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<EntityKey> keys = new ArrayList<>();
    keys.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(keys);

    LatestValueCmd latestValueCmd2 = new LatestValueCmd();
    latestValueCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(latestValueCmd, latestValueCmd2);
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestValueCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<EntityKey> keys = new ArrayList<>();
    keys.add(mock(EntityKey.class));

    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(keys);

    LatestValueCmd latestValueCmd2 = new LatestValueCmd();
    latestValueCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(latestValueCmd, latestValueCmd2);
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestValueCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(latestValueCmd, null);
  }

  /**
   * Test {@link LatestValueCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestValueCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(latestValueCmd, "Different type to LatestValueCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LatestValueCmd}
   *   <li>{@link LatestValueCmd#setKeys(List)}
   *   <li>{@link LatestValueCmd#toString()}
   *   <li>{@link LatestValueCmd#getKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    LatestValueCmd actualLatestValueCmd = new LatestValueCmd();
    ArrayList<EntityKey> keys = new ArrayList<>();
    actualLatestValueCmd.setKeys(keys);
    String actualToStringResult = actualLatestValueCmd.toString();
    List<EntityKey> actualKeys = actualLatestValueCmd.getKeys();

    // Assert that nothing has changed
    assertEquals("LatestValueCmd(keys=[])", actualToStringResult);
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }
}
