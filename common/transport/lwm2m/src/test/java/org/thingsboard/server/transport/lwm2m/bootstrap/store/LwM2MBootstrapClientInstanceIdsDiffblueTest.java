package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MBootstrapClientInstanceIdsDiffblueTest {
  /**
   * Test {@link LwM2MBootstrapClientInstanceIds#equals(Object)}, and {@link
   * LwM2MBootstrapClientInstanceIds#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapClientInstanceIds.equals(Object)",
    "int LwM2MBootstrapClientInstanceIds.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds2 =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds2.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds2.setServerInstances(new HashMap<>());

    // Act and Assert
    assertEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds2);
    assertEquals(
        lwM2MBootstrapClientInstanceIds.hashCode(), lwM2MBootstrapClientInstanceIds2.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapClientInstanceIds#equals(Object)}, and {@link
   * LwM2MBootstrapClientInstanceIds#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapClientInstanceIds.equals(Object)",
    "int LwM2MBootstrapClientInstanceIds.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    // Act and Assert
    assertEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds);
    int expectedHashCodeResult = lwM2MBootstrapClientInstanceIds.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapClientInstanceIds.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapClientInstanceIds#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapClientInstanceIds.equals(Object)",
    "int LwM2MBootstrapClientInstanceIds.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<Integer, Integer> securityInstances = new HashMap<>();
    securityInstances.put(1, 42);

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(securityInstances);
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds2 =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds2.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds2.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds2);
  }

  /**
   * Test {@link LwM2MBootstrapClientInstanceIds#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapClientInstanceIds.equals(Object)",
    "int LwM2MBootstrapClientInstanceIds.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<Integer, Integer> serverInstances = new HashMap<>();
    serverInstances.put(1, 42);

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(serverInstances);

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds2 =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds2.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds2.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds2);
  }

  /**
   * Test {@link LwM2MBootstrapClientInstanceIds#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapClientInstanceIds.equals(Object)",
    "int LwM2MBootstrapClientInstanceIds.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, null);
  }

  /**
   * Test {@link LwM2MBootstrapClientInstanceIds#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapClientInstanceIds.equals(Object)",
    "int LwM2MBootstrapClientInstanceIds.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds =
        new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        lwM2MBootstrapClientInstanceIds, "Different type to LwM2MBootstrapClientInstanceIds");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MBootstrapClientInstanceIds}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#setSecurityInstances(Map)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#setServerInstances(Map)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#toString()}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#getSecurityInstances()}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#getServerInstances()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapClientInstanceIds.<init>()",
    "Map LwM2MBootstrapClientInstanceIds.getSecurityInstances()",
    "Map LwM2MBootstrapClientInstanceIds.getServerInstances()",
    "void LwM2MBootstrapClientInstanceIds.setSecurityInstances(Map)",
    "void LwM2MBootstrapClientInstanceIds.setServerInstances(Map)",
    "String LwM2MBootstrapClientInstanceIds.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MBootstrapClientInstanceIds actualLwM2MBootstrapClientInstanceIds =
        new LwM2MBootstrapClientInstanceIds();
    HashMap<Integer, Integer> securityInstances = new HashMap<>();
    actualLwM2MBootstrapClientInstanceIds.setSecurityInstances(securityInstances);
    HashMap<Integer, Integer> serverInstances = new HashMap<>();
    actualLwM2MBootstrapClientInstanceIds.setServerInstances(serverInstances);
    String actualToStringResult = actualLwM2MBootstrapClientInstanceIds.toString();
    Map<Integer, Integer> actualSecurityInstances =
        actualLwM2MBootstrapClientInstanceIds.getSecurityInstances();
    Map<Integer, Integer> actualServerInstances =
        actualLwM2MBootstrapClientInstanceIds.getServerInstances();

    // Assert
    assertEquals(
        "LwM2MBootstrapClientInstanceIds(securityInstances={}, serverInstances={})",
        actualToStringResult);
    assertTrue(actualSecurityInstances.isEmpty());
    assertTrue(actualServerInstances.isEmpty());
    assertSame(securityInstances, actualSecurityInstances);
    assertSame(serverInstances, actualServerInstances);
  }
}
