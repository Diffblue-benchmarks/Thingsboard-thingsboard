package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbCreateAlarmNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbCreateAlarmNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbCreateAlarmNodeConfiguration TbCreateAlarmNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbCreateAlarmNodeConfiguration actualDefaultConfigurationResult =
        new TbCreateAlarmNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("CRITICAL", actualDefaultConfigurationResult.getSeverity());
    assertEquals("General Alarm", actualDefaultConfigurationResult.getAlarmType());
    assertEquals(
        "var details = {};\n"
            + "if (metadata.prevAlarmDetails != null) {\n"
            + "    details = JSON.parse(metadata.prevAlarmDetails);\n"
            + "    //remove prevAlarmDetails from metadata\n"
            + "    metadata.remove('prevAlarmDetails');\n"
            + "    //now metadata is the same as it comes IN this rule node\n"
            + "}\n"
            + "\n"
            + "\n"
            + "return details;",
        actualDefaultConfigurationResult.getAlarmDetailsBuildTbel());
    assertEquals(
        "var details = {};\n"
            + "if (metadata.prevAlarmDetails) {\n"
            + "    details = JSON.parse(metadata.prevAlarmDetails);\n"
            + "    //remove prevAlarmDetails from metadata\n"
            + "    delete metadata.prevAlarmDetails;\n"
            + "    //now metadata is the same as it comes IN this rule node\n"
            + "}\n"
            + "\n"
            + "\n"
            + "return details;",
        actualDefaultConfigurationResult.getAlarmDetailsBuildJs());
    assertEquals(ScriptLanguage.TBEL, actualDefaultConfigurationResult.getScriptLang());
    assertFalse(actualDefaultConfigurationResult.isDynamicSeverity());
    assertFalse(actualDefaultConfigurationResult.isOverwriteAlarmDetails());
    assertFalse(actualDefaultConfigurationResult.isPropagate());
    assertFalse(actualDefaultConfigurationResult.isPropagateToOwner());
    assertFalse(actualDefaultConfigurationResult.isPropagateToTenant());
    assertFalse(actualDefaultConfigurationResult.isUseMessageAlarmData());
    assertTrue(actualDefaultConfigurationResult.getRelationTypes().isEmpty());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbCreateAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCreateAlarmNodeConfiguration#equals(Object)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration2 =
        new TbCreateAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(tbCreateAlarmNodeConfiguration, tbCreateAlarmNodeConfiguration2);
    assertEquals(
        tbCreateAlarmNodeConfiguration.hashCode(), tbCreateAlarmNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbCreateAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCreateAlarmNodeConfiguration#equals(Object)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setSeverity("S1");

    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration2 =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration2.setSeverity("S1");

    // Act and Assert
    assertEquals(tbCreateAlarmNodeConfiguration, tbCreateAlarmNodeConfiguration2);
    assertEquals(
        tbCreateAlarmNodeConfiguration.hashCode(), tbCreateAlarmNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbCreateAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCreateAlarmNodeConfiguration#equals(Object)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setRelationTypes(new ArrayList<>());

    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration2 =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration2.setRelationTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(tbCreateAlarmNodeConfiguration, tbCreateAlarmNodeConfiguration2);
    assertEquals(
        tbCreateAlarmNodeConfiguration.hashCode(), tbCreateAlarmNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbCreateAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCreateAlarmNodeConfiguration#equals(Object)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(tbCreateAlarmNodeConfiguration, tbCreateAlarmNodeConfiguration);
    int expectedHashCodeResult = tbCreateAlarmNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbCreateAlarmNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCreateAlarmNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setSeverity("S1");

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setPropagate(true);

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setPropagateToOwner(true);

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setPropagateToTenant(true);

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setUseMessageAlarmData(true);

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setDynamicSeverity(true);

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setRelationTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();

    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration2 =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration2.setSeverity("S1");

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, tbCreateAlarmNodeConfiguration2);
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();

    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration2 =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration2.setRelationTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, tbCreateAlarmNodeConfiguration2);
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbCreateAlarmNodeConfiguration tbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    tbCreateAlarmNodeConfiguration.setOverwriteAlarmDetails(false);

    // Act and Assert
    assertNotEquals(tbCreateAlarmNodeConfiguration, new TbCreateAlarmNodeConfiguration());
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCreateAlarmNodeConfiguration(), null);
  }

  /**
   * Test {@link TbCreateAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateAlarmNodeConfiguration.equals(Object)",
    "int TbCreateAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbCreateAlarmNodeConfiguration(), "Different type to TbCreateAlarmNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbCreateAlarmNodeConfiguration}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setDynamicSeverity(boolean)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setOverwriteAlarmDetails(boolean)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setPropagate(boolean)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setPropagateToOwner(boolean)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setPropagateToTenant(boolean)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setRelationTypes(List)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setSeverity(String)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#setUseMessageAlarmData(boolean)}
   *   <li>{@link TbCreateAlarmNodeConfiguration#toString()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#getRelationTypes()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#getSeverity()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#isDynamicSeverity()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#isOverwriteAlarmDetails()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#isPropagate()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#isPropagateToOwner()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#isPropagateToTenant()}
   *   <li>{@link TbCreateAlarmNodeConfiguration#isUseMessageAlarmData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCreateAlarmNodeConfiguration.<init>()",
    "List TbCreateAlarmNodeConfiguration.getRelationTypes()",
    "String TbCreateAlarmNodeConfiguration.getSeverity()",
    "boolean TbCreateAlarmNodeConfiguration.isDynamicSeverity()",
    "boolean TbCreateAlarmNodeConfiguration.isOverwriteAlarmDetails()",
    "boolean TbCreateAlarmNodeConfiguration.isPropagate()",
    "boolean TbCreateAlarmNodeConfiguration.isPropagateToOwner()",
    "boolean TbCreateAlarmNodeConfiguration.isPropagateToTenant()",
    "boolean TbCreateAlarmNodeConfiguration.isUseMessageAlarmData()",
    "void TbCreateAlarmNodeConfiguration.setDynamicSeverity(boolean)",
    "void TbCreateAlarmNodeConfiguration.setOverwriteAlarmDetails(boolean)",
    "void TbCreateAlarmNodeConfiguration.setPropagate(boolean)",
    "void TbCreateAlarmNodeConfiguration.setPropagateToOwner(boolean)",
    "void TbCreateAlarmNodeConfiguration.setPropagateToTenant(boolean)",
    "void TbCreateAlarmNodeConfiguration.setRelationTypes(List)",
    "void TbCreateAlarmNodeConfiguration.setSeverity(String)",
    "void TbCreateAlarmNodeConfiguration.setUseMessageAlarmData(boolean)",
    "String TbCreateAlarmNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCreateAlarmNodeConfiguration actualTbCreateAlarmNodeConfiguration =
        new TbCreateAlarmNodeConfiguration();
    actualTbCreateAlarmNodeConfiguration.setDynamicSeverity(true);
    actualTbCreateAlarmNodeConfiguration.setOverwriteAlarmDetails(true);
    actualTbCreateAlarmNodeConfiguration.setPropagate(true);
    actualTbCreateAlarmNodeConfiguration.setPropagateToOwner(true);
    actualTbCreateAlarmNodeConfiguration.setPropagateToTenant(true);
    ArrayList<String> relationTypes = new ArrayList<>();
    actualTbCreateAlarmNodeConfiguration.setRelationTypes(relationTypes);
    actualTbCreateAlarmNodeConfiguration.setSeverity("S1");
    actualTbCreateAlarmNodeConfiguration.setUseMessageAlarmData(true);
    String actualToStringResult = actualTbCreateAlarmNodeConfiguration.toString();
    List<String> actualRelationTypes = actualTbCreateAlarmNodeConfiguration.getRelationTypes();
    String actualSeverity = actualTbCreateAlarmNodeConfiguration.getSeverity();
    boolean actualIsDynamicSeverityResult =
        actualTbCreateAlarmNodeConfiguration.isDynamicSeverity();
    boolean actualIsOverwriteAlarmDetailsResult =
        actualTbCreateAlarmNodeConfiguration.isOverwriteAlarmDetails();
    boolean actualIsPropagateResult = actualTbCreateAlarmNodeConfiguration.isPropagate();
    boolean actualIsPropagateToOwnerResult =
        actualTbCreateAlarmNodeConfiguration.isPropagateToOwner();
    boolean actualIsPropagateToTenantResult =
        actualTbCreateAlarmNodeConfiguration.isPropagateToTenant();
    boolean actualIsUseMessageAlarmDataResult =
        actualTbCreateAlarmNodeConfiguration.isUseMessageAlarmData();

    // Assert
    assertEquals("S1", actualSeverity);
    assertEquals(
        "TbCreateAlarmNodeConfiguration(severity=S1, propagate=true, propagateToOwner=true, propagateToTenant"
            + "=true, useMessageAlarmData=true, overwriteAlarmDetails=true, dynamicSeverity=true, relationTypes"
            + "=[])",
        actualToStringResult);
    assertNull(actualTbCreateAlarmNodeConfiguration.getAlarmDetailsBuildJs());
    assertNull(actualTbCreateAlarmNodeConfiguration.getAlarmDetailsBuildTbel());
    assertNull(actualTbCreateAlarmNodeConfiguration.getAlarmType());
    assertNull(actualTbCreateAlarmNodeConfiguration.getScriptLang());
    assertTrue(actualRelationTypes.isEmpty());
    assertTrue(actualIsDynamicSeverityResult);
    assertTrue(actualIsOverwriteAlarmDetailsResult);
    assertTrue(actualIsPropagateResult);
    assertTrue(actualIsPropagateToOwnerResult);
    assertTrue(actualIsPropagateToTenantResult);
    assertTrue(actualIsUseMessageAlarmDataResult);
    assertSame(relationTypes, actualRelationTypes);
  }
}
