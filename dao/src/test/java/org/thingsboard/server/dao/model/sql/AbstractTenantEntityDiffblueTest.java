package org.thingsboard.server.dao.model.sql;

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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractTenantEntityDiffblueTest {
  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  @DisplayName("Test toTenant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant AbstractTenantEntity.toTenant()"})
  void testToTenant() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    UUID tenantProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    tenantEntity.setTenantProfileId(tenantProfileId);

    // Act and Assert
    TenantProfileId tenantProfileId2 = tenantEntity.toTenant().getTenantProfileId();
    UUID id = tenantProfileId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId2.getEntityType());
    assertFalse(tenantProfileId2.isNullUid());
    assertSame(tenantProfileId, id);
  }

  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is randomUUID.
   *   <li>Then return TenantProfileId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  @DisplayName(
      "Test toTenant(); given TenantEntity() Uuid is randomUUID; then return TenantProfileId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant AbstractTenantEntity.toTenant()"})
  void testToTenant_givenTenantEntityUuidIsRandomUUID_thenReturnTenantProfileIdIsNull() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);

    // Act
    Tenant actualToTenantResult = tenantEntity.toTenant();

    // Assert
    assertNull(actualToTenantResult.getTenantProfileId());
    assertSame(id, actualToTenantResult.getUuidId());
    assertSame(id, actualToTenantResult.getId().getId());
  }

  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  @DisplayName("Test toTenant(); given TenantEntity(); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant AbstractTenantEntity.toTenant()"})
  void testToTenant_givenTenantEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Tenant actualToTenantResult = new TenantEntity().toTenant();

    // Assert
    assertTrue(actualToTenantResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToTenantResult.getVersion());
    assertNull(actualToTenantResult.getAddress());
    assertNull(actualToTenantResult.getAddress2());
    assertNull(actualToTenantResult.getCity());
    assertNull(actualToTenantResult.getCountry());
    assertNull(actualToTenantResult.getEmail());
    assertNull(actualToTenantResult.getName());
    assertNull(actualToTenantResult.getPhone());
    assertNull(actualToTenantResult.getRegion());
    assertNull(actualToTenantResult.getState());
    assertNull(actualToTenantResult.getTitle());
    assertNull(actualToTenantResult.getZip());
    assertNull(actualToTenantResult.getUuidId());
    assertEquals(0L, actualToTenantResult.getCreatedTime());
  }

  /**
   * Test {@link AbstractTenantEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTenantEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TenantEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractTenantEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TenantEntity#TenantEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when TenantEntity(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTenantEntity.canEqual(Object)"})
  void testCanEqual_whenTenantEntity_thenReturnTrue() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act and Assert
    assertTrue(tenantEntity.canEqual(new TenantEntity()));
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}, and {@link AbstractTenantEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    TenantEntity tenantEntity2 = new TenantEntity();

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity2);
    assertEquals(tenantEntity.hashCode(), tenantEntity2.hashCode());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}, and {@link AbstractTenantEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity.hashCode());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

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
    assertNotEquals(tenantEntity, assetEntity);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = mock(TenantEntity.class);
    when(tenantEntity2.getVersion()).thenReturn(1L);
    when(tenantEntity2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tenantEntity2.getCreatedTime()).thenReturn(1L);
    when(tenantEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), null);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), "Different type to AbstractTenantEntity");
  }

  /**
   * Test {@link AbstractTenantEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractTenantEntity.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractTenantEntity#getAddress()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getAddress()}
   */
  @Test
  @DisplayName("Test getAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getAddress()"})
  void testGetAddress() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getAddress());
  }

  /**
   * Test {@link AbstractTenantEntity#getAddress2()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getAddress2()}
   */
  @Test
  @DisplayName("Test getAddress2()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getAddress2()"})
  void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getAddress2());
  }

  /**
   * Test {@link AbstractTenantEntity#getCity()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getCity()}
   */
  @Test
  @DisplayName("Test getCity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getCity()"})
  void testGetCity() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getCity());
  }

  /**
   * Test {@link AbstractTenantEntity#getCountry()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getCountry()}
   */
  @Test
  @DisplayName("Test getCountry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getCountry()"})
  void testGetCountry() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getCountry());
  }

  /**
   * Test {@link AbstractTenantEntity#getEmail()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getEmail()}
   */
  @Test
  @DisplayName("Test getEmail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getEmail()"})
  void testGetEmail() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getEmail());
  }

  /**
   * Test {@link AbstractTenantEntity#getPhone()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getPhone()}
   */
  @Test
  @DisplayName("Test getPhone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getPhone()"})
  void testGetPhone() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getPhone());
  }

  /**
   * Test {@link AbstractTenantEntity#getRegion()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getRegion()}
   */
  @Test
  @DisplayName("Test getRegion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getRegion()"})
  void testGetRegion() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getRegion());
  }

  /**
   * Test {@link AbstractTenantEntity#getState()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getState()"})
  void testGetState() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getState());
  }

  /**
   * Test {@link AbstractTenantEntity#getTenantProfileId()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getTenantProfileId()}
   */
  @Test
  @DisplayName("Test getTenantProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractTenantEntity.getTenantProfileId()"})
  void testGetTenantProfileId() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getTenantProfileId());
  }

  /**
   * Test {@link AbstractTenantEntity#getTitle()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getTitle()"})
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getTitle());
  }

  /**
   * Test {@link AbstractTenantEntity#getZip()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getZip()}
   */
  @Test
  @DisplayName("Test getZip()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.getZip()"})
  void testGetZip() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getZip());
  }

  /**
   * Test {@link AbstractTenantEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    tenantEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, tenantEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, tenantEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractTenantEntity#setAddress(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setAddress(String)}
   */
  @Test
  @DisplayName("Test setAddress(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setAddress(String)"})
  void testSetAddress() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setAddress("42 Main St");

    // Assert
    assertEquals("42 Main St", tenantEntity.toData().getAddress());
    assertEquals("42 Main St", tenantEntity.getAddress());
  }

  /**
   * Test {@link AbstractTenantEntity#setAddress2(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setAddress2(String)}
   */
  @Test
  @DisplayName("Test setAddress2(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setAddress2(String)"})
  void testSetAddress2() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setAddress2("42 Main St");

    // Assert
    assertEquals("42 Main St", tenantEntity.toData().getAddress2());
    assertEquals("42 Main St", tenantEntity.getAddress2());
  }

  /**
   * Test {@link AbstractTenantEntity#setCity(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setCity(String)}
   */
  @Test
  @DisplayName("Test setCity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setCity(String)"})
  void testSetCity() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setCity("Oxford");

    // Assert
    assertEquals("Oxford", tenantEntity.toData().getCity());
    assertEquals("Oxford", tenantEntity.getCity());
  }

  /**
   * Test {@link AbstractTenantEntity#setCountry(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setCountry(String)}
   */
  @Test
  @DisplayName("Test setCountry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setCountry(String)"})
  void testSetCountry() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setCountry("GB");

    // Assert
    assertEquals("GB", tenantEntity.toData().getCountry());
    assertEquals("GB", tenantEntity.getCountry());
  }

  /**
   * Test {@link AbstractTenantEntity#setEmail(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setEmail(String)}
   */
  @Test
  @DisplayName("Test setEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setEmail(String)"})
  void testSetEmail() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setEmail("jane.doe@example.org");

    // Assert
    assertEquals("jane.doe@example.org", tenantEntity.toData().getEmail());
    assertEquals("jane.doe@example.org", tenantEntity.getEmail());
  }

  /**
   * Test {@link AbstractTenantEntity#setPhone(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setPhone(String)}
   */
  @Test
  @DisplayName("Test setPhone(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setPhone(String)"})
  void testSetPhone() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setPhone("6625550144");

    // Assert
    assertEquals("6625550144", tenantEntity.toData().getPhone());
    assertEquals("6625550144", tenantEntity.getPhone());
  }

  /**
   * Test {@link AbstractTenantEntity#setRegion(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setRegion(String)}
   */
  @Test
  @DisplayName("Test setRegion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setRegion(String)"})
  void testSetRegion() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setRegion("us-east-2");

    // Assert
    assertEquals("us-east-2", tenantEntity.toData().getRegion());
    assertEquals("us-east-2", tenantEntity.getRegion());
  }

  /**
   * Test {@link AbstractTenantEntity#setState(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setState(String)"})
  void testSetState() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setState("MD");

    // Assert
    assertEquals("MD", tenantEntity.toData().getState());
    assertEquals("MD", tenantEntity.getState());
  }

  /**
   * Test {@link AbstractTenantEntity#setTenantProfileId(UUID)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setTenantProfileId(UUID)}
   */
  @Test
  @DisplayName("Test setTenantProfileId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setTenantProfileId(UUID)"})
  void testSetTenantProfileId() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    UUID tenantProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    tenantEntity.setTenantProfileId(tenantProfileId);

    // Assert
    TenantProfileId tenantProfileId2 = tenantEntity.toData().getTenantProfileId();
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId2.getEntityType());
    assertFalse(tenantProfileId2.isNullUid());
    assertSame(tenantProfileId, tenantProfileId2.getId());
    assertSame(tenantProfileId, tenantEntity.getTenantProfileId());
  }

  /**
   * Test {@link AbstractTenantEntity#setTitle(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setTitle(String)"})
  void testSetTitle() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setTitle("Dr");

    // Assert
    Tenant toDataResult = tenantEntity.toData();
    assertEquals("Dr", toDataResult.getName());
    assertEquals("Dr", toDataResult.getTitle());
    assertEquals("Dr", tenantEntity.getTitle());
  }

  /**
   * Test {@link AbstractTenantEntity#setZip(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setZip(String)}
   */
  @Test
  @DisplayName("Test setZip(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setZip(String)"})
  void testSetZip() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setZip("21654");

    // Assert
    assertEquals("21654", tenantEntity.toData().getZip());
    assertEquals("21654", tenantEntity.getZip());
  }

  /**
   * Test {@link AbstractTenantEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TenantEntity()", new TenantEntity().toString());
  }
}
