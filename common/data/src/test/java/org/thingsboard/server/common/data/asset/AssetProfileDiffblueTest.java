package org.thingsboard.server.common.data.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class AssetProfileDiffblueTest {
  /**
   * Test {@link AssetProfile#getExternalId()}.
   *
   * <p>Method under test: {@link AssetProfile#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.AssetProfileId AssetProfile.getExternalId()"
  })
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new AssetProfile().getExternalId());
  }

  /**
   * Test {@link AssetProfile#AssetProfile(AssetProfile)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link AssetProfile#AssetProfile()} Default is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#AssetProfile(AssetProfile)}
   */
  @Test
  @DisplayName(
      "Test new AssetProfile(AssetProfile); given 'true'; when AssetProfile() Default is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfile.<init>(AssetProfile)"})
  void testNewAssetProfile_givenTrue_whenAssetProfileDefaultIsTrue() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefault(true);

    // Act and Assert
    assertEquals(assetProfile, new AssetProfile(assetProfile));
  }

  /**
   * Test {@link AssetProfile#AssetProfile(AssetProfile)}.
   *
   * <ul>
   *   <li>When {@link AssetProfile#AssetProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#AssetProfile(AssetProfile)}
   */
  @Test
  @DisplayName("Test new AssetProfile(AssetProfile); when AssetProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfile.<init>(AssetProfile)"})
  void testNewAssetProfile_whenAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, new AssetProfile(assetProfile));
  }

  /**
   * Test {@link AssetProfile#getId()}.
   *
   * <p>Method under test: {@link AssetProfile#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.AssetProfileId AssetProfile.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new AssetProfile().getId());
  }

  /**
   * Test {@link AssetProfile#getCreatedTime()}.
   *
   * <p>Method under test: {@link AssetProfile#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AssetProfile.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new AssetProfile().getCreatedTime());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}, and {@link AssetProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfile#equals(Object)}
   *   <li>{@link AssetProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    AssetProfile assetProfile2 = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, assetProfile2);
    int expectedHashCodeResult = assetProfile.hashCode();
    assertEquals(expectedHashCodeResult, assetProfile2.hashCode());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}, and {@link AssetProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfile#equals(Object)}
   *   <li>{@link AssetProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, assetProfile);
    int expectedHashCodeResult = assetProfile.hashCode();
    assertEquals(expectedHashCodeResult, assetProfile.hashCode());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfile(), 1);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setName("Name");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setImage("Image");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefault(true);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultEdgeRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(assetProfile, new AssetProfile());
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setName("Name");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setImage("Image");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDefaultRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDefaultQueueName("Default Queue Name");

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setDefaultEdgeRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfile, assetProfile2);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfile(), null);
  }

  /**
   * Test {@link AssetProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetProfile.equals(Object)", "int AssetProfile.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetProfile(), "Different type to AssetProfile");
  }
}
