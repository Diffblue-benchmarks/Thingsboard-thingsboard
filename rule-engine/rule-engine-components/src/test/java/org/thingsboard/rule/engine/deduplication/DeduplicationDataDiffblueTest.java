package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.server.common.msg.TbMsg;

class DeduplicationDataDiffblueTest {
  /**
   * Test {@link DeduplicationData#equals(Object)}, and {@link DeduplicationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    DeduplicationData deduplicationData2 = new DeduplicationData();

    // Act and Assert
    assertEquals(deduplicationData, deduplicationData2);
    assertEquals(deduplicationData.hashCode(), deduplicationData2.hashCode());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}, and {@link DeduplicationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();

    // Act and Assert
    assertEquals(deduplicationData, deduplicationData);
    int expectedHashCodeResult = deduplicationData.hashCode();
    assertEquals(expectedHashCodeResult, deduplicationData.hashCode());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), 1);
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    deduplicationData.setTickScheduled(true);

    // Act and Assert
    assertNotEquals(deduplicationData, new DeduplicationData());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    deduplicationData.add(msg);

    // Act and Assert
    assertNotEquals(deduplicationData, new DeduplicationData());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), null);
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), "Different type to DeduplicationData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeduplicationData}
   *   <li>{@link DeduplicationData#setTickScheduled(boolean)}
   *   <li>{@link DeduplicationData#toString()}
   *   <li>{@link DeduplicationData#getMsgList()}
   *   <li>{@link DeduplicationData#isTickScheduled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeduplicationData.<init>()",
    "List DeduplicationData.getMsgList()",
    "boolean DeduplicationData.isTickScheduled()",
    "void DeduplicationData.setTickScheduled(boolean)",
    "String DeduplicationData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeduplicationData actualDeduplicationData = new DeduplicationData();
    actualDeduplicationData.setTickScheduled(true);
    String actualToStringResult = actualDeduplicationData.toString();
    List<TbMsg> actualMsgList = actualDeduplicationData.getMsgList();
    boolean actualIsTickScheduledResult = actualDeduplicationData.isTickScheduled();

    // Assert
    assertEquals("DeduplicationData(msgList=[], tickScheduled=true)", actualToStringResult);
    assertTrue(actualMsgList.isEmpty());
    assertTrue(actualIsTickScheduledResult);
  }

  /**
   * Test {@link DeduplicationData#size()}.
   *
   * <p>Method under test: {@link DeduplicationData#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DeduplicationData.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new DeduplicationData().size());
  }

  /**
   * Test {@link DeduplicationData#add(TbMsg)}.
   *
   * <ul>
   *   <li>Then {@link DeduplicationData} (default constructor) MsgList size is one.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#add(TbMsg)}
   */
  @Test
  @DisplayName("Test add(TbMsg); then DeduplicationData (default constructor) MsgList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeduplicationData.add(TbMsg)"})
  void testAdd_thenDeduplicationDataMsgListSizeIsOne() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    deduplicationData.add(msg);

    // Assert
    List<TbMsg> msgList = deduplicationData.getMsgList();
    assertEquals(1, msgList.size());
    assertEquals(1, deduplicationData.size());
    assertFalse(deduplicationData.isEmpty());
    assertSame(msg, msgList.get(0));
  }

  /**
   * Test {@link DeduplicationData#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link DeduplicationData} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given DeduplicationData (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeduplicationData.isEmpty()"})
  void testIsEmpty_givenDeduplicationData_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DeduplicationData().isEmpty());
  }

  /**
   * Test {@link DeduplicationData#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeduplicationData.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    deduplicationData.add(msg);

    // Act and Assert
    assertFalse(deduplicationData.isEmpty());
  }
}
