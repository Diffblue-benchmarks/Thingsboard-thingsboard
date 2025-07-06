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
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class AbstractTenantEntityDiffblueTest {
  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Tenant AbstractTenantEntity.toTenant()"})
  public void testToTenant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Tenant AbstractTenantEntity.toTenant()"})
  public void testToTenant_givenTenantEntityUuidIsRandomUUID_thenReturnTenantProfileIdIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Tenant AbstractTenantEntity.toTenant()"})
  public void testToTenant_givenTenantEntity_thenAdditionalInfoReturnNullNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTenantEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTenantEntity.canEqual(Object)"})
  public void testCanEqual_whenTenantEntity_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    TenantEntity tenantEntity2 = new TenantEntity();

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity2);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setTitle("Dr");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setCountry("GB");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setState("MD");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setCity("Oxford");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAddress2("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setCountry("GB");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setState("MD");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setCity("Oxford");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAddress2("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), "Different type to AbstractTenantEntity");
  }

  /**
   * Test {@link AbstractTenantEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getAdditionalInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JsonNode AbstractTenantEntity.getAdditionalInfo()"})
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractTenantEntity#getAddress()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getAddress()"})
  public void testGetAddress() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getAddress());
  }

  /**
   * Test {@link AbstractTenantEntity#getAddress2()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getAddress2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getAddress2()"})
  public void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getAddress2());
  }

  /**
   * Test {@link AbstractTenantEntity#getCity()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getCity()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getCity()"})
  public void testGetCity() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getCity());
  }

  /**
   * Test {@link AbstractTenantEntity#getCountry()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getCountry()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getCountry()"})
  public void testGetCountry() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getCountry());
  }

  /**
   * Test {@link AbstractTenantEntity#getEmail()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getEmail()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getEmail()"})
  public void testGetEmail() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getEmail());
  }

  /**
   * Test {@link AbstractTenantEntity#getPhone()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getPhone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getPhone()"})
  public void testGetPhone() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getPhone());
  }

  /**
   * Test {@link AbstractTenantEntity#getRegion()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getRegion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getRegion()"})
  public void testGetRegion() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getRegion());
  }

  /**
   * Test {@link AbstractTenantEntity#getState()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getState()"})
  public void testGetState() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getState());
  }

  /**
   * Test {@link AbstractTenantEntity#getTenantProfileId()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getTenantProfileId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractTenantEntity.getTenantProfileId()"})
  public void testGetTenantProfileId() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getTenantProfileId());
  }

  /**
   * Test {@link AbstractTenantEntity#getTitle()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getTitle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getTitle()"})
  public void testGetTitle() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getTitle());
  }

  /**
   * Test {@link AbstractTenantEntity#getZip()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#getZip()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.getZip()"})
  public void testGetZip() {
    // Arrange, Act and Assert
    assertNull(new TenantEntity().getZip());
  }

  /**
   * Test {@link AbstractTenantEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setAdditionalInfo(JsonNode)"})
  public void testSetAdditionalInfo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setAddress(String)"})
  public void testSetAddress() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setAddress2(String)"})
  public void testSetAddress2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setCity(String)"})
  public void testSetCity() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setCountry(String)"})
  public void testSetCountry() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setEmail(String)"})
  public void testSetEmail() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setPhone(String)"})
  public void testSetPhone() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setRegion(String)"})
  public void testSetRegion() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setState(String)"})
  public void testSetState() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setTenantProfileId(UUID)"})
  public void testSetTenantProfileId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setTitle(String)"})
  public void testSetTitle() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTenantEntity.setZip(String)"})
  public void testSetZip() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTenantEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("TenantEntity()", new TenantEntity().toString());
  }
}
