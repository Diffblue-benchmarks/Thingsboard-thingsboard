package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SubscriptionServiceStatisticsDiffblueTest {
  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}, and {@link SubscriptionServiceStatistics#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SubscriptionServiceStatistics#equals(Object)}
   *   <li>{@link SubscriptionServiceStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertEquals(subscriptionServiceStatistics, subscriptionServiceStatistics);
    int expectedHashCodeResult = subscriptionServiceStatistics.hashCode();
    assertEquals(expectedHashCodeResult, subscriptionServiceStatistics.hashCode());
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    SubscriptionServiceStatistics subscriptionServiceStatistics2 = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics2.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, subscriptionServiceStatistics2);
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    SubscriptionServiceStatistics subscriptionServiceStatistics2 = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics2.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, subscriptionServiceStatistics2);
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    SubscriptionServiceStatistics subscriptionServiceStatistics2 = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics2.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics2.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, subscriptionServiceStatistics2);
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(null);
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    SubscriptionServiceStatistics subscriptionServiceStatistics2 = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics2.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics2.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, subscriptionServiceStatistics2);
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(null);
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    SubscriptionServiceStatistics subscriptionServiceStatistics2 = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics2.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics2.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setRegularQueryInvocationCnt(null);
    subscriptionServiceStatistics2.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, subscriptionServiceStatistics2);
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(null);
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(null);
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    SubscriptionServiceStatistics subscriptionServiceStatistics2 = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics2.setAlarmQueryInvocationCnt(null);
    subscriptionServiceStatistics2.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics2.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics2.setRegularQueryInvocationCnt(null);
    subscriptionServiceStatistics2.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, subscriptionServiceStatistics2);
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, null);
  }

  /**
   * Test {@link SubscriptionServiceStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionServiceStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionServiceStatistics.equals(Object)",
      "int SubscriptionServiceStatistics.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SubscriptionServiceStatistics subscriptionServiceStatistics = new SubscriptionServiceStatistics();
    subscriptionServiceStatistics.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setAlarmQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setDynamicQueryTimeSpent(new AtomicLong(1L));
    subscriptionServiceStatistics.setRegularQueryInvocationCnt(new AtomicInteger(1));
    subscriptionServiceStatistics.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act and Assert
    assertNotEquals(subscriptionServiceStatistics, "Different type to SubscriptionServiceStatistics");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SubscriptionServiceStatistics}
   *   <li>{@link SubscriptionServiceStatistics#setAlarmQueryInvocationCnt(AtomicInteger)}
   *   <li>{@link SubscriptionServiceStatistics#setAlarmQueryTimeSpent(AtomicLong)}
   *   <li>{@link SubscriptionServiceStatistics#setDynamicQueryInvocationCnt(AtomicInteger)}
   *   <li>{@link SubscriptionServiceStatistics#setDynamicQueryTimeSpent(AtomicLong)}
   *   <li>{@link SubscriptionServiceStatistics#setRegularQueryInvocationCnt(AtomicInteger)}
   *   <li>{@link SubscriptionServiceStatistics#setRegularQueryTimeSpent(AtomicLong)}
   *   <li>{@link SubscriptionServiceStatistics#toString()}
   *   <li>{@link SubscriptionServiceStatistics#getAlarmQueryInvocationCnt()}
   *   <li>{@link SubscriptionServiceStatistics#getAlarmQueryTimeSpent()}
   *   <li>{@link SubscriptionServiceStatistics#getDynamicQueryInvocationCnt()}
   *   <li>{@link SubscriptionServiceStatistics#getDynamicQueryTimeSpent()}
   *   <li>{@link SubscriptionServiceStatistics#getRegularQueryInvocationCnt()}
   *   <li>{@link SubscriptionServiceStatistics#getRegularQueryTimeSpent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscriptionServiceStatistics.<init>()",
      "AtomicInteger SubscriptionServiceStatistics.getAlarmQueryInvocationCnt()",
      "AtomicLong SubscriptionServiceStatistics.getAlarmQueryTimeSpent()",
      "AtomicInteger SubscriptionServiceStatistics.getDynamicQueryInvocationCnt()",
      "AtomicLong SubscriptionServiceStatistics.getDynamicQueryTimeSpent()",
      "AtomicInteger SubscriptionServiceStatistics.getRegularQueryInvocationCnt()",
      "AtomicLong SubscriptionServiceStatistics.getRegularQueryTimeSpent()",
      "void SubscriptionServiceStatistics.setAlarmQueryInvocationCnt(AtomicInteger)",
      "void SubscriptionServiceStatistics.setAlarmQueryTimeSpent(AtomicLong)",
      "void SubscriptionServiceStatistics.setDynamicQueryInvocationCnt(AtomicInteger)",
      "void SubscriptionServiceStatistics.setDynamicQueryTimeSpent(AtomicLong)",
      "void SubscriptionServiceStatistics.setRegularQueryInvocationCnt(AtomicInteger)",
      "void SubscriptionServiceStatistics.setRegularQueryTimeSpent(AtomicLong)",
      "String SubscriptionServiceStatistics.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SubscriptionServiceStatistics actualSubscriptionServiceStatistics = new SubscriptionServiceStatistics();
    AtomicInteger alarmQueryInvocationCnt = new AtomicInteger(1);
    actualSubscriptionServiceStatistics.setAlarmQueryInvocationCnt(alarmQueryInvocationCnt);
    AtomicLong alarmQueryTimeSpent = new AtomicLong(1L);
    actualSubscriptionServiceStatistics.setAlarmQueryTimeSpent(alarmQueryTimeSpent);
    AtomicInteger dynamicQueryInvocationCnt = new AtomicInteger(1);
    actualSubscriptionServiceStatistics.setDynamicQueryInvocationCnt(dynamicQueryInvocationCnt);
    AtomicLong dynamicQueryTimeSpent = new AtomicLong(1L);
    actualSubscriptionServiceStatistics.setDynamicQueryTimeSpent(dynamicQueryTimeSpent);
    AtomicInteger regularQueryInvocationCnt = new AtomicInteger(1);
    actualSubscriptionServiceStatistics.setRegularQueryInvocationCnt(regularQueryInvocationCnt);
    AtomicLong regularQueryTimeSpent = new AtomicLong(1L);
    actualSubscriptionServiceStatistics.setRegularQueryTimeSpent(regularQueryTimeSpent);
    String actualToStringResult = actualSubscriptionServiceStatistics.toString();
    AtomicInteger actualAlarmQueryInvocationCnt = actualSubscriptionServiceStatistics.getAlarmQueryInvocationCnt();
    AtomicLong actualAlarmQueryTimeSpent = actualSubscriptionServiceStatistics.getAlarmQueryTimeSpent();
    AtomicInteger actualDynamicQueryInvocationCnt = actualSubscriptionServiceStatistics.getDynamicQueryInvocationCnt();
    AtomicLong actualDynamicQueryTimeSpent = actualSubscriptionServiceStatistics.getDynamicQueryTimeSpent();
    AtomicInteger actualRegularQueryInvocationCnt = actualSubscriptionServiceStatistics.getRegularQueryInvocationCnt();

    // Assert
    assertEquals(
        "SubscriptionServiceStatistics(alarmQueryInvocationCnt=1, regularQueryInvocationCnt=1, dynamicQueryIn"
            + "vocationCnt=1, alarmQueryTimeSpent=1, regularQueryTimeSpent=1, dynamicQueryTimeSpent=1)",
        actualToStringResult);
    assertSame(alarmQueryInvocationCnt, actualAlarmQueryInvocationCnt);
    assertSame(dynamicQueryInvocationCnt, actualDynamicQueryInvocationCnt);
    assertSame(regularQueryInvocationCnt, actualRegularQueryInvocationCnt);
    assertSame(alarmQueryTimeSpent, actualAlarmQueryTimeSpent);
    assertSame(dynamicQueryTimeSpent, actualDynamicQueryTimeSpent);
    assertSame(regularQueryTimeSpent, actualSubscriptionServiceStatistics.getRegularQueryTimeSpent());
  }
}
