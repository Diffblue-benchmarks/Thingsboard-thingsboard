package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgTypeFilterNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbMsgTypeFilterNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsgTypeFilterNodeConfiguration TbMsgTypeFilterNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    List<String> messageTypes =
        new TbMsgTypeFilterNodeConfiguration().defaultConfiguration().getMessageTypes();
    assertEquals(3, messageTypes.size());
    assertEquals("POST_ATTRIBUTES_REQUEST", messageTypes.get(0));
    assertEquals("POST_TELEMETRY_REQUEST", messageTypes.get(1));
    assertEquals("TO_SERVER_RPC_REQUEST", messageTypes.get(2));
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}, and {@link
   * TbMsgTypeFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration =
        new TbMsgTypeFilterNodeConfiguration();
    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration2 =
        new TbMsgTypeFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgTypeFilterNodeConfiguration, tbMsgTypeFilterNodeConfiguration2);
    assertEquals(
        tbMsgTypeFilterNodeConfiguration.hashCode(), tbMsgTypeFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}, and {@link
   * TbMsgTypeFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration =
        new TbMsgTypeFilterNodeConfiguration();
    tbMsgTypeFilterNodeConfiguration.setMessageTypes(new ArrayList<>());

    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration2 =
        new TbMsgTypeFilterNodeConfiguration();
    tbMsgTypeFilterNodeConfiguration2.setMessageTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(tbMsgTypeFilterNodeConfiguration, tbMsgTypeFilterNodeConfiguration2);
    assertEquals(
        tbMsgTypeFilterNodeConfiguration.hashCode(), tbMsgTypeFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}, and {@link
   * TbMsgTypeFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration =
        new TbMsgTypeFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgTypeFilterNodeConfiguration, tbMsgTypeFilterNodeConfiguration);
    int expectedHashCodeResult = tbMsgTypeFilterNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgTypeFilterNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgTypeFilterNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration =
        new TbMsgTypeFilterNodeConfiguration();
    tbMsgTypeFilterNodeConfiguration.setMessageTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbMsgTypeFilterNodeConfiguration, new TbMsgTypeFilterNodeConfiguration());
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration =
        new TbMsgTypeFilterNodeConfiguration();

    TbMsgTypeFilterNodeConfiguration tbMsgTypeFilterNodeConfiguration2 =
        new TbMsgTypeFilterNodeConfiguration();
    tbMsgTypeFilterNodeConfiguration2.setMessageTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbMsgTypeFilterNodeConfiguration, tbMsgTypeFilterNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgTypeFilterNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTypeFilterNodeConfiguration.equals(Object)",
    "int TbMsgTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbMsgTypeFilterNodeConfiguration(),
        "Different type to TbMsgTypeFilterNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgTypeFilterNodeConfiguration}
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#setMessageTypes(List)}
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#toString()}
   *   <li>{@link TbMsgTypeFilterNodeConfiguration#getMessageTypes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMsgTypeFilterNodeConfiguration.<init>()",
    "List TbMsgTypeFilterNodeConfiguration.getMessageTypes()",
    "void TbMsgTypeFilterNodeConfiguration.setMessageTypes(List)",
    "String TbMsgTypeFilterNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgTypeFilterNodeConfiguration actualTbMsgTypeFilterNodeConfiguration =
        new TbMsgTypeFilterNodeConfiguration();
    ArrayList<String> messageTypes = new ArrayList<>();
    actualTbMsgTypeFilterNodeConfiguration.setMessageTypes(messageTypes);
    String actualToStringResult = actualTbMsgTypeFilterNodeConfiguration.toString();
    List<String> actualMessageTypes = actualTbMsgTypeFilterNodeConfiguration.getMessageTypes();

    // Assert
    assertEquals("TbMsgTypeFilterNodeConfiguration(messageTypes=[])", actualToStringResult);
    assertTrue(actualMessageTypes.isEmpty());
    assertSame(messageTypes, actualMessageTypes);
  }
}
