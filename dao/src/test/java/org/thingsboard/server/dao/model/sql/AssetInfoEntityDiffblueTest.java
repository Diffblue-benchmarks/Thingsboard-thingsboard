package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.math.BigInteger;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class AssetInfoEntityDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerTitle("Dr");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
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
  public void testGettersAndSetters() {
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
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetInfoEntity.<init>(AssetEntity, String, Object, String)"})
  public void testNewAssetInfoEntity_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
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
    AssetInfoEntity actualAssetInfoEntity =
        new AssetInfoEntity(
            assetEntity,
            "Dr",
            new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)),
            "foo.txt");

    // Assert
    JsonNode additionalInfo = actualAssetInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertSame(additionalInfo, actualAssetInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   *
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetInfoEntity.<init>(AssetEntity, String, Object, String)"})
  public void testNewAssetInfoEntity_whenBigIntegerNodeWithVIsValueOfOne() {
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
    AssetInfoEntity actualAssetInfoEntity =
        new AssetInfoEntity(
            assetEntity, "Dr", new BigIntegerNode(BigInteger.valueOf(1L)), "foo.txt");

    // Assert
    JsonNode additionalInfo = actualAssetInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertSame(additionalInfo, actualAssetInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetInfoEntity.<init>(AssetEntity, String, Object, String)"})
  public void testNewAssetInfoEntity_whenNull() {
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
    JsonNode additionalInfo = actualAssetInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertSame(additionalInfo, actualAssetInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()}.
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_givenAssetInfoEntity_thenReturnExternalIdIsNull() {
    // Arrange and Act
    AssetInfo actualToDataResult = new AssetInfoEntity().toData();

    // Assert
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getAssetProfileId());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnAssetProfileIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
