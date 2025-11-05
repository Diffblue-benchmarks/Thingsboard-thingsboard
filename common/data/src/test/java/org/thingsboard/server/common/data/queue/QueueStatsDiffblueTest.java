package org.thingsboard.server.common.data.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class QueueStatsDiffblueTest {
  /**
   * Test {@link QueueStats#equals(Object)}, and {@link QueueStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    QueueStats queueStats2 = new QueueStats();

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    assertEquals(queueStats.hashCode(), queueStats2.hashCode());
  }

  /**
   * Test {@link QueueStats#equals(Object)}, and {@link QueueStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setTenantId(TenantId.SYS_TENANT_ID);

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    assertEquals(queueStats.hashCode(), queueStats2.hashCode());
  }

  /**
   * Test {@link QueueStats#equals(Object)}, and {@link QueueStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setQueueName("Queue Name");

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setQueueName("Queue Name");

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    assertEquals(queueStats.hashCode(), queueStats2.hashCode());
  }

  /**
   * Test {@link QueueStats#equals(Object)}, and {@link QueueStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setServiceId("42");

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setServiceId("42");

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    assertEquals(queueStats.hashCode(), queueStats2.hashCode());
  }

  /**
   * Test {@link QueueStats#equals(Object)}, and {@link QueueStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    // Act and Assert
    assertEquals(queueStats, queueStats);
    int expectedHashCodeResult = queueStats.hashCode();
    assertEquals(expectedHashCodeResult, queueStats.hashCode());
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueStats(), 1);
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setServiceId("42");

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(queueStats, queueStats2);
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(queueStats, queueStats2);
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setServiceId("42");

    // Act and Assert
    assertNotEquals(queueStats, queueStats2);
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueStats(), null);
  }

  /**
   * Test {@link QueueStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueStats.equals(Object)", "int QueueStats.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueStats(), "Different type to QueueStats");
  }
}
