package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AssetInfoEntityDiffblueTest {
  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    assertEquals(assetInfoEntity.hashCode(), assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerTitle("Dr");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    assertEquals(assetInfoEntity.hashCode(), assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    assertEquals(assetInfoEntity.hashCode(), assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetInfoEntity, assetEntity);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfoEntity, assetInfoEntity2);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfoEntity, assetInfoEntity2);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), null);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), "Different type to AssetInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#AssetInfoEntity()}
   *   <li>{@link AssetInfoEntity#setAssetProfileName(String)}
   *   <li>{@link AssetInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link AssetInfoEntity#setCustomerTitle(String)}
   *   <li>{@link AssetInfoEntity#toString()}
   *   <li>{@link AssetInfoEntity#getAssetProfileName()}
   *   <li>{@link AssetInfoEntity#getCustomerTitle()}
   *   <li>{@link AssetInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetInfoEntity.<init>()",
    "String AssetInfoEntity.getAssetProfileName()",
    "String AssetInfoEntity.getCustomerTitle()",
    "boolean AssetInfoEntity.isCustomerIsPublic()",
    "void AssetInfoEntity.setAssetProfileName(String)",
    "void AssetInfoEntity.setCustomerIsPublic(boolean)",
    "void AssetInfoEntity.setCustomerTitle(String)",
    "String AssetInfoEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AssetInfoEntity actualAssetInfoEntity = new AssetInfoEntity();
    actualAssetInfoEntity.setAssetProfileName("foo.txt");
    actualAssetInfoEntity.setCustomerIsPublic(true);
    actualAssetInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualAssetInfoEntity.toString();
    String actualAssetProfileName = actualAssetInfoEntity.getAssetProfileName();
    String actualCustomerTitle = actualAssetInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualAssetInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals(
        "AssetInfoEntity(customerTitle=Dr, customerIsPublic=true, assetProfileName=foo.txt)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualAssetProfileName);
    assertNull(actualAssetInfoEntity.getAdditionalInfo());
    assertNull(actualAssetInfoEntity.getVersion());
    assertNull(actualAssetInfoEntity.getLabel());
    assertNull(actualAssetInfoEntity.getName());
    assertNull(actualAssetInfoEntity.getType());
    assertNull(actualAssetInfoEntity.getId());
    assertNull(actualAssetInfoEntity.getUuid());
    assertNull(actualAssetInfoEntity.getAssetProfileId());
    assertNull(actualAssetInfoEntity.getCustomerId());
    assertNull(actualAssetInfoEntity.getExternalId());
    assertNull(actualAssetInfoEntity.getTenantId());
    assertEquals(0L, actualAssetInfoEntity.getCreatedTime());
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   *
   * <ul>
   *   <li>Then return toData CustomerIsPublic.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new AssetInfoEntity(AssetEntity, String, Object, String); then return toData CustomerIsPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetInfoEntity.<init>(AssetEntity, String, Object, String)"})
  void testNewAssetInfoEntity_thenReturnToDataCustomerIsPublic() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);
    JsonNode jsonNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    AssetInfoEntity actualAssetInfoEntity =
        new AssetInfoEntity(assetEntity, "Dr", jsonNode, "foo.txt");

    // Assert
    AssetInfo toDataResult = actualAssetInfoEntity.toData();
    assertTrue(toDataResult.isCustomerIsPublic());
    assertTrue(actualAssetInfoEntity.isCustomerIsPublic());
    assertSame(jsonNode, toDataResult.getAdditionalInfo());
    assertSame(jsonNode, actualAssetInfoEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not toData CustomerIsPublic.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new AssetInfoEntity(AssetEntity, String, Object, String); when 'null'; then return not toData CustomerIsPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetInfoEntity.<init>(AssetEntity, String, Object, String)"})
  void testNewAssetInfoEntity_whenNull_thenReturnNotToDataCustomerIsPublic() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);

    // Act
    AssetInfoEntity actualAssetInfoEntity = new AssetInfoEntity(assetEntity, "Dr", null, "foo.txt");

    // Assert
    assertFalse(actualAssetInfoEntity.toData().isCustomerIsPublic());
    assertFalse(actualAssetInfoEntity.isCustomerIsPublic());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given AssetInfoEntity(); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  void testToData_givenAssetInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    AssetInfo actualToDataResult = new AssetInfoEntity().toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getAssetProfileId());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is Instance.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return AdditionalInfo is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  void testToData_thenReturnAdditionalInfoIsInstance() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    MissingNode additionalInfo = MissingNode.getInstance();
    assetInfoEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    assertSame(additionalInfo, assetInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AssetProfileId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return AssetProfileId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  void testToData_thenReturnAssetProfileIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    UUID assetProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetInfoEntity.setAssetProfileId(assetProfileId);

    // Act and Assert
    AssetProfileId assetProfileId2 = assetInfoEntity.toData().getAssetProfileId();
    UUID id = assetProfileId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId2.getEntityType());
    assertFalse(assetProfileId2.isNullUid());
    assertSame(assetProfileId, id);
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetInfoEntity.setCustomerId(customerId);

    // Act and Assert
    CustomerId customerId2 = assetInfoEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetInfoEntity.setExternalId(externalId);

    // Act and Assert
    AssetId externalId2 = assetInfoEntity.toData().getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, id);
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    UUID tenantId = UUID.randomUUID();
    assetInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = assetInfoEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = assetInfoEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
