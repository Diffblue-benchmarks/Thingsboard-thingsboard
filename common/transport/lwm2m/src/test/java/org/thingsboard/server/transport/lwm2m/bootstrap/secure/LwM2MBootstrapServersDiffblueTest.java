package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MBootstrapServersDiffblueTest {
  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}, and {@link
   * LwM2MBootstrapServers#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    assertEquals(lwM2MBootstrapServers.hashCode(), lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}, and {@link
   * LwM2MBootstrapServers#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding(null);
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding(null);
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    assertEquals(lwM2MBootstrapServers.hashCode(), lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}, and {@link
   * LwM2MBootstrapServers#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(null);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(null);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    assertEquals(lwM2MBootstrapServers.hashCode(), lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}, and {@link
   * LwM2MBootstrapServers#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(null);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(null);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    assertEquals(lwM2MBootstrapServers.hashCode(), lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}, and {@link
   * LwM2MBootstrapServers#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(null);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(null);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    assertEquals(lwM2MBootstrapServers.hashCode(), lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}, and {@link
   * LwM2MBootstrapServers#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers);
    int expectedHashCodeResult = lwM2MBootstrapServers.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapServers.hashCode());
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding(null);
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("UQ");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(3);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(null);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(3);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(null);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(false);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(2);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(null);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, null);
  }

  /**
   * Test {@link LwM2MBootstrapServers#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapServers.equals(Object)",
    "int LwM2MBootstrapServers.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, "Different type to LwM2MBootstrapServers");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MBootstrapServers}
   *   <li>{@link LwM2MBootstrapServers#setBinding(String)}
   *   <li>{@link LwM2MBootstrapServers#setDefaultMinPeriod(Integer)}
   *   <li>{@link LwM2MBootstrapServers#setLifetime(Integer)}
   *   <li>{@link LwM2MBootstrapServers#setNotifIfDisabled(boolean)}
   *   <li>{@link LwM2MBootstrapServers#setShortId(Integer)}
   *   <li>{@link LwM2MBootstrapServers#toString()}
   *   <li>{@link LwM2MBootstrapServers#getBinding()}
   *   <li>{@link LwM2MBootstrapServers#getDefaultMinPeriod()}
   *   <li>{@link LwM2MBootstrapServers#getLifetime()}
   *   <li>{@link LwM2MBootstrapServers#getShortId()}
   *   <li>{@link LwM2MBootstrapServers#isNotifIfDisabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapServers.<init>()",
    "String LwM2MBootstrapServers.getBinding()",
    "Integer LwM2MBootstrapServers.getDefaultMinPeriod()",
    "Integer LwM2MBootstrapServers.getLifetime()",
    "Integer LwM2MBootstrapServers.getShortId()",
    "boolean LwM2MBootstrapServers.isNotifIfDisabled()",
    "void LwM2MBootstrapServers.setBinding(String)",
    "void LwM2MBootstrapServers.setDefaultMinPeriod(Integer)",
    "void LwM2MBootstrapServers.setLifetime(Integer)",
    "void LwM2MBootstrapServers.setNotifIfDisabled(boolean)",
    "void LwM2MBootstrapServers.setShortId(Integer)",
    "String LwM2MBootstrapServers.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MBootstrapServers actualLwM2MBootstrapServers = new LwM2MBootstrapServers();
    actualLwM2MBootstrapServers.setBinding("Binding");
    actualLwM2MBootstrapServers.setDefaultMinPeriod(1);
    actualLwM2MBootstrapServers.setLifetime(1);
    actualLwM2MBootstrapServers.setNotifIfDisabled(true);
    actualLwM2MBootstrapServers.setShortId(1);
    String actualToStringResult = actualLwM2MBootstrapServers.toString();
    String actualBinding = actualLwM2MBootstrapServers.getBinding();
    Integer actualDefaultMinPeriod = actualLwM2MBootstrapServers.getDefaultMinPeriod();
    Integer actualLifetime = actualLwM2MBootstrapServers.getLifetime();
    Integer actualShortId = actualLwM2MBootstrapServers.getShortId();
    boolean actualIsNotifIfDisabledResult = actualLwM2MBootstrapServers.isNotifIfDisabled();

    // Assert
    assertEquals("Binding", actualBinding);
    assertEquals(
        "LwM2MBootstrapServers(shortId=1, lifetime=1, defaultMinPeriod=1, notifIfDisabled=true,"
            + " binding=Binding)",
        actualToStringResult);
    assertEquals(1, actualDefaultMinPeriod.intValue());
    assertEquals(1, actualLifetime.intValue());
    assertEquals(1, actualShortId.intValue());
    assertTrue(actualIsNotifIfDisabledResult);
  }
}
