package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.MsgType;

class PartitionChangeMsgDiffblueTest {
  /**
   * Test {@link PartitionChangeMsg#equals(Object)}, and {@link PartitionChangeMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartitionChangeMsg#equals(Object)}
   *   <li>{@link PartitionChangeMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PartitionChangeMsg.equals(Object)",
    "int PartitionChangeMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_CORE);
    PartitionChangeMsg partitionChangeMsg2 = new PartitionChangeMsg(ServiceType.TB_CORE);

    // Act and Assert
    assertEquals(partitionChangeMsg, partitionChangeMsg2);
    assertEquals(partitionChangeMsg.hashCode(), partitionChangeMsg2.hashCode());
  }

  /**
   * Test {@link PartitionChangeMsg#equals(Object)}, and {@link PartitionChangeMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartitionChangeMsg#equals(Object)}
   *   <li>{@link PartitionChangeMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PartitionChangeMsg.equals(Object)",
    "int PartitionChangeMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(null);
    PartitionChangeMsg partitionChangeMsg2 = new PartitionChangeMsg(null);

    // Act and Assert
    assertEquals(partitionChangeMsg, partitionChangeMsg2);
    assertEquals(partitionChangeMsg.hashCode(), partitionChangeMsg2.hashCode());
  }

  /**
   * Test {@link PartitionChangeMsg#equals(Object)}, and {@link PartitionChangeMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartitionChangeMsg#equals(Object)}
   *   <li>{@link PartitionChangeMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PartitionChangeMsg.equals(Object)",
    "int PartitionChangeMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_CORE);

    // Act and Assert
    assertEquals(partitionChangeMsg, partitionChangeMsg);
    int expectedHashCodeResult = partitionChangeMsg.hashCode();
    assertEquals(expectedHashCodeResult, partitionChangeMsg.hashCode());
  }

  /**
   * Test {@link PartitionChangeMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PartitionChangeMsg.equals(Object)",
    "int PartitionChangeMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(null);

    // Act and Assert
    assertNotEquals(partitionChangeMsg, new PartitionChangeMsg(ServiceType.TB_CORE));
  }

  /**
   * Test {@link PartitionChangeMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PartitionChangeMsg.equals(Object)",
    "int PartitionChangeMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_RULE_ENGINE);

    // Act and Assert
    assertNotEquals(partitionChangeMsg, new PartitionChangeMsg(ServiceType.TB_CORE));
  }

  /**
   * Test {@link PartitionChangeMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PartitionChangeMsg.equals(Object)",
    "int PartitionChangeMsg.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PartitionChangeMsg(ServiceType.TB_CORE), null);
  }

  /**
   * Test {@link PartitionChangeMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PartitionChangeMsg.equals(Object)",
    "int PartitionChangeMsg.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PartitionChangeMsg(ServiceType.TB_CORE), "Different type to PartitionChangeMsg");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartitionChangeMsg#PartitionChangeMsg(ServiceType)}
   *   <li>{@link PartitionChangeMsg#toString()}
   *   <li>{@link PartitionChangeMsg#getMsgType()}
   *   <li>{@link PartitionChangeMsg#getServiceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PartitionChangeMsg.<init>(ServiceType)",
    "MsgType PartitionChangeMsg.getMsgType()",
    "ServiceType PartitionChangeMsg.getServiceType()",
    "String PartitionChangeMsg.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PartitionChangeMsg actualPartitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_CORE);
    String actualToStringResult = actualPartitionChangeMsg.toString();
    MsgType actualMsgType = actualPartitionChangeMsg.getMsgType();

    // Assert
    assertEquals("PartitionChangeMsg(serviceType=TB_CORE)", actualToStringResult);
    assertEquals(MsgType.PARTITION_CHANGE_MSG, actualMsgType);
    assertEquals(ServiceType.TB_CORE, actualPartitionChangeMsg.getServiceType());
  }
}
