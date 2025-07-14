package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

class AssetProfileEntityDiffblueTest {
  /**
   * Test {@link AssetProfileEntity#equals(Object)}, and {@link AssetProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#equals(Object)}
   *   <li>{@link AssetProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(assetProfileEntity, assetProfileEntity2);
    int expectedHashCodeResult = assetProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetProfileEntity2.hashCode());
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}, and {@link AssetProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#equals(Object)}
   *   <li>{@link AssetProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    // Act and Assert
    assertEquals(assetProfileEntity, assetProfileEntity);
    int expectedHashCodeResult = assetProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetProfileEntity.hashCode());
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(3L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(false);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName(null);
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("Name");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription(null);
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(null);
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Name");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage(null);
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Image");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName(null);
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, null);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultEdgeRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, "Different type to AssetProfileEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#AssetProfileEntity()}
   *   <li>{@link AssetProfileEntity#setDefault(boolean)}
   *   <li>{@link AssetProfileEntity#setDefaultDashboardId(UUID)}
   *   <li>{@link AssetProfileEntity#setDefaultEdgeRuleChainId(UUID)}
   *   <li>{@link AssetProfileEntity#setDefaultQueueName(String)}
   *   <li>{@link AssetProfileEntity#setDefaultRuleChainId(UUID)}
   *   <li>{@link AssetProfileEntity#setDescription(String)}
   *   <li>{@link AssetProfileEntity#setExternalId(UUID)}
   *   <li>{@link AssetProfileEntity#setImage(String)}
   *   <li>{@link AssetProfileEntity#setName(String)}
   *   <li>{@link AssetProfileEntity#setTenantId(UUID)}
   *   <li>{@link AssetProfileEntity#toString()}
   *   <li>{@link AssetProfileEntity#getDefaultDashboardId()}
   *   <li>{@link AssetProfileEntity#getDefaultEdgeRuleChainId()}
   *   <li>{@link AssetProfileEntity#getDefaultQueueName()}
   *   <li>{@link AssetProfileEntity#getDefaultRuleChainId()}
   *   <li>{@link AssetProfileEntity#getDescription()}
   *   <li>{@link AssetProfileEntity#getExternalId()}
   *   <li>{@link AssetProfileEntity#getImage()}
   *   <li>{@link AssetProfileEntity#getName()}
   *   <li>{@link AssetProfileEntity#getTenantId()}
   *   <li>{@link AssetProfileEntity#isDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEntity.<init>()",
    "UUID AssetProfileEntity.getDefaultDashboardId()",
    "UUID AssetProfileEntity.getDefaultEdgeRuleChainId()",
    "String AssetProfileEntity.getDefaultQueueName()",
    "UUID AssetProfileEntity.getDefaultRuleChainId()",
    "String AssetProfileEntity.getDescription()",
    "UUID AssetProfileEntity.getExternalId()",
    "String AssetProfileEntity.getImage()",
    "String AssetProfileEntity.getName()",
    "UUID AssetProfileEntity.getTenantId()",
    "boolean AssetProfileEntity.isDefault()",
    "void AssetProfileEntity.setDefault(boolean)",
    "void AssetProfileEntity.setDefaultDashboardId(UUID)",
    "void AssetProfileEntity.setDefaultEdgeRuleChainId(UUID)",
    "void AssetProfileEntity.setDefaultQueueName(String)",
    "void AssetProfileEntity.setDefaultRuleChainId(UUID)",
    "void AssetProfileEntity.setDescription(String)",
    "void AssetProfileEntity.setExternalId(UUID)",
    "void AssetProfileEntity.setImage(String)",
    "void AssetProfileEntity.setName(String)",
    "void AssetProfileEntity.setTenantId(UUID)",
    "String AssetProfileEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity();
    actualAssetProfileEntity.setDefault(true);
    UUID defaultDashboardId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAssetProfileEntity.setDefaultDashboardId(defaultDashboardId);
    UUID defaultEdgeRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAssetProfileEntity.setDefaultEdgeRuleChainId(defaultEdgeRuleChainId);
    actualAssetProfileEntity.setDefaultQueueName("Default Queue Name");
    UUID defaultRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAssetProfileEntity.setDefaultRuleChainId(defaultRuleChainId);
    actualAssetProfileEntity.setDescription("The characteristics of someone or something");
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAssetProfileEntity.setExternalId(externalId);
    actualAssetProfileEntity.setImage("Image");
    actualAssetProfileEntity.setName("Name");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAssetProfileEntity.setTenantId(tenantId);
    String actualToStringResult = actualAssetProfileEntity.toString();
    UUID actualDefaultDashboardId = actualAssetProfileEntity.getDefaultDashboardId();
    UUID actualDefaultEdgeRuleChainId = actualAssetProfileEntity.getDefaultEdgeRuleChainId();
    String actualDefaultQueueName = actualAssetProfileEntity.getDefaultQueueName();
    UUID actualDefaultRuleChainId = actualAssetProfileEntity.getDefaultRuleChainId();
    String actualDescription = actualAssetProfileEntity.getDescription();
    UUID actualExternalId = actualAssetProfileEntity.getExternalId();
    String actualImage = actualAssetProfileEntity.getImage();
    String actualName = actualAssetProfileEntity.getName();
    UUID actualTenantId = actualAssetProfileEntity.getTenantId();
    boolean actualIsDefaultResult = actualAssetProfileEntity.isDefault();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDefaultDashboardId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDefaultEdgeRuleChainId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDefaultRuleChainId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals(
        "AssetProfileEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, image=Image, description=The"
            + " characteristics of someone or something, isDefault=true, defaultRuleChainId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9, defaultDashboardId=784f394c-42b6-435a-983c-b7beff2784f9, defaultQueueName=Default Queue"
            + " Name, defaultEdgeRuleChainId=784f394c-42b6-435a-983c-b7beff2784f9, externalId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Default Queue Name", actualDefaultQueueName);
    assertEquals("Image", actualImage);
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualAssetProfileEntity.getVersion());
    assertNull(actualAssetProfileEntity.getId());
    assertNull(actualAssetProfileEntity.getUuid());
    assertEquals(0L, actualAssetProfileEntity.getCreatedTime());
    assertTrue(actualIsDefaultResult);
    assertSame(defaultDashboardId, actualDefaultDashboardId);
    assertSame(defaultEdgeRuleChainId, actualDefaultEdgeRuleChainId);
    assertSame(defaultRuleChainId, actualDefaultRuleChainId);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @DisplayName("Test new AssetProfileEntity(AssetProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  void testNewAssetProfileEntity() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfile.setDefaultEdgeRuleChainId(new RuleChainId(id));
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    UUID defaultEdgeRuleChainId = actualAssetProfileEntity.getDefaultEdgeRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", defaultEdgeRuleChainId.toString());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getTenantId());
    assertSame(id, defaultEdgeRuleChainId);
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @DisplayName("Test new AssetProfileEntity(AssetProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  void testNewAssetProfileEntity2() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfile.setDefaultRuleChainId(new RuleChainId(id));
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setDefaultEdgeRuleChainId(null);
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    UUID defaultRuleChainId = actualAssetProfileEntity.getDefaultRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", defaultRuleChainId.toString());
    assertNull(actualAssetProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualAssetProfileEntity.getTenantId());
    assertSame(id, defaultRuleChainId);
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @DisplayName("Test new AssetProfileEntity(AssetProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  void testNewAssetProfileEntity3() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setDefaultEdgeRuleChainId(null);
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAssetProfileEntity.getTenantId().toString());
    assertNull(actualAssetProfileEntity.getDefaultDashboardId());
    assertNull(actualAssetProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getExternalId());
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @DisplayName("Test new AssetProfileEntity(AssetProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  void testNewAssetProfileEntity4() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefaultRuleChainId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfile.setDefaultDashboardId(new DashboardId(id));
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfile.setDefaultEdgeRuleChainId(new RuleChainId(id2));
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    UUID defaultDashboardId = actualAssetProfileEntity.getDefaultDashboardId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", defaultDashboardId.toString());
    UUID defaultEdgeRuleChainId = actualAssetProfileEntity.getDefaultEdgeRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", defaultEdgeRuleChainId.toString());
    assertSame(id, defaultDashboardId);
    assertSame(id2, defaultEdgeRuleChainId);
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @DisplayName("Test new AssetProfileEntity(AssetProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  void testNewAssetProfileEntity5() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfile.setDefaultEdgeRuleChainId(new RuleChainId(id));
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfile.setExternalId(new AssetProfileId(id2));

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    UUID defaultEdgeRuleChainId = actualAssetProfileEntity.getDefaultEdgeRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", defaultEdgeRuleChainId.toString());
    UUID externalId = actualAssetProfileEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertSame(id, defaultEdgeRuleChainId);
    assertSame(id2, externalId);
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <ul>
   *   <li>When {@link AssetProfile#AssetProfile()}.
   *   <li>Then return DefaultDashboardId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @DisplayName(
      "Test new AssetProfileEntity(AssetProfile); when AssetProfile(); then return DefaultDashboardId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  void testNewAssetProfileEntity_whenAssetProfile_thenReturnDefaultDashboardIdIsNull() {
    // Arrange and Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(new AssetProfile());

    // Assert
    assertNull(actualAssetProfileEntity.getDefaultDashboardId());
    assertNull(actualAssetProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getExternalId());
    assertNull(actualAssetProfileEntity.getTenantId());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  void testToData() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    UUID defaultEdgeRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfileEntity.setDefaultEdgeRuleChainId(defaultEdgeRuleChainId);
    assetProfileEntity.setExternalId(null);

    // Act and Assert
    RuleChainId defaultEdgeRuleChainId2 = assetProfileEntity.toData().getDefaultEdgeRuleChainId();
    UUID id = defaultEdgeRuleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId2.getEntityType());
    assertFalse(defaultEdgeRuleChainId2.isNullUid());
    assertSame(defaultEdgeRuleChainId, id);
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  void testToData2() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setDefaultRuleChainId(null);
    UUID defaultDashboardId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfileEntity.setDefaultDashboardId(defaultDashboardId);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(null);

    // Act and Assert
    DashboardId defaultDashboardId2 = assetProfileEntity.toData().getDefaultDashboardId();
    UUID id = defaultDashboardId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DASHBOARD, defaultDashboardId2.getEntityType());
    assertFalse(defaultDashboardId2.isNullUid());
    assertSame(defaultDashboardId, id);
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  void testToData3() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    UUID defaultRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfileEntity.setDefaultRuleChainId(defaultRuleChainId);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(null);

    // Act and Assert
    RuleChainId defaultRuleChainId2 = assetProfileEntity.toData().getDefaultRuleChainId();
    UUID id = defaultRuleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, defaultRuleChainId2.getEntityType());
    assertFalse(defaultRuleChainId2.isNullUid());
    assertSame(defaultRuleChainId, id);
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()}.
   *   <li>Then return Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given AssetProfileEntity(); then return Version is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  void testToData_givenAssetProfileEntity_thenReturnVersionIsNull() {
    // Arrange and Act
    AssetProfile actualToDataResult = new AssetProfileEntity().toData();

    // Assert
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getDefaultQueueName());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDefault());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfileEntity.setExternalId(externalId);

    // Act
    AssetProfile actualToDataResult = assetProfileEntity.toData();

    // Assert
    AssetProfileId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetProfileEntity.setExternalId(externalId);

    // Act
    AssetProfile actualToDataResult = assetProfileEntity.toData();

    // Assert
    AssetProfileId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, externalId2.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = assetProfileEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
