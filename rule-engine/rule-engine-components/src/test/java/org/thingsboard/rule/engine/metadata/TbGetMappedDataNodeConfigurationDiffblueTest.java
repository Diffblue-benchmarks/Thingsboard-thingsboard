package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.msg.TbMsg;

class TbGetMappedDataNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetMappedDataNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbGetMappedDataNodeConfiguration.canEqual(Object)"})
  void testCanEqual_thenReturnFalse() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertFalse(tbGetEntityDataNodeConfiguration.canEqual(telemetryMsgResult));
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TbGetEntityDataNodeConfiguration} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when TbGetEntityDataNodeConfiguration (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbGetMappedDataNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenTbGetEntityDataNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();

    // Act and Assert
    assertTrue(tbGetEntityDataNodeConfiguration.canEqual(new TbGetEntityDataNodeConfiguration()));
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}, and {@link
   * TbGetMappedDataNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration2 =
        new TbGetEntityDataNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration2);
    assertEquals(
        tbGetEntityDataNodeConfiguration.hashCode(), tbGetEntityDataNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}, and {@link
   * TbGetMappedDataNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration);
    int expectedHashCodeResult = tbGetEntityDataNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetEntityDataNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbGetRelatedDataNodeConfiguration, new TbGetEntityDataNodeConfiguration());
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration2 =
        mock(TbGetEntityDataNodeConfiguration.class);
    when(tbGetEntityDataNodeConfiguration2.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetEntityDataNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetEntityDataNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration2);
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration2 =
        mock(TbGetEntityDataNodeConfiguration.class);
    when(tbGetEntityDataNodeConfiguration2.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetEntityDataNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetEntityDataNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration2);
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataMapping(new HashMap<>());
    tbGetEntityDataNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration2 =
        mock(TbGetEntityDataNodeConfiguration.class);
    when(tbGetEntityDataNodeConfiguration2.getDataToFetch()).thenReturn(DataToFetch.ATTRIBUTES);
    when(tbGetEntityDataNodeConfiguration2.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetEntityDataNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetEntityDataNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration2);
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("Key", "42");

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);
    tbGetEntityDataNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration2 =
        mock(TbGetEntityDataNodeConfiguration.class);
    when(tbGetEntityDataNodeConfiguration2.getDataToFetch()).thenReturn(DataToFetch.ATTRIBUTES);
    when(tbGetEntityDataNodeConfiguration2.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetEntityDataNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetEntityDataNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration2);
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetEntityDataNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetMappedDataNodeConfiguration.equals(Object)",
    "int TbGetMappedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGetEntityDataNodeConfiguration(),
        "Different type to TbGetMappedDataNodeConfiguration");
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#getDataMapping()}.
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#getDataMapping()}
   */
  @Test
  @DisplayName("Test getDataMapping()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TbGetMappedDataNodeConfiguration.getDataMapping()"})
  void testGetDataMapping() {
    // Arrange, Act and Assert
    assertNull(new TbGetEntityDataNodeConfiguration().getDataMapping());
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#setDataMapping(Map)}.
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#setDataMapping(Map)}
   */
  @Test
  @DisplayName("Test setDataMapping(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetMappedDataNodeConfiguration.setDataMapping(Map)"})
  void testSetDataMapping() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    HashMap<String, String> dataMapping = new HashMap<>();

    // Act
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);

    // Assert
    assertSame(dataMapping, tbGetEntityDataNodeConfiguration.getDataMapping());
  }

  /**
   * Test {@link TbGetMappedDataNodeConfiguration#toString()}.
   *
   * <p>Method under test: {@link TbGetMappedDataNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbGetMappedDataNodeConfiguration.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "TbGetEntityDataNodeConfiguration(dataToFetch=null)",
        new TbGetEntityDataNodeConfiguration().toString());
  }
}
