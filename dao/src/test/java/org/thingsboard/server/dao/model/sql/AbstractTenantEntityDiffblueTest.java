/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractTenantEntityDiffblueTest {
  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant AbstractTenantEntity.toTenant()"})
  public void testToTenant() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);

    // Act
    Tenant actualToTenantResult = tenantEntity.toTenant();

    // Assert
    TenantProfileId tenantProfileId = actualToTenantResult.getTenantProfileId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantProfileId.getId().toString());
    assertNull(actualToTenantResult.getId().getId());
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId.getEntityType());
    assertTrue(tenantProfileId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractTenantEntity.equals(Object)",
    "int AbstractTenantEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = mock(TenantEntity.class);
    when(tenantEntity2.getVersion()).thenReturn(1L);
    when(tenantEntity2.getId()).thenReturn(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTenantEntity.setTenantProfileId(UUID)"})
  public void testSetTenantProfileId() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    UUID tenantProfileId = ModelConstants.NULL_UUID;

    // Act
    tenantEntity.setTenantProfileId(tenantProfileId);

    // Assert
    TenantProfileId tenantProfileId2 = tenantEntity.toData().getTenantProfileId();
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId2.getEntityType());
    assertTrue(tenantProfileId2.isNullUid());
    assertSame(tenantProfileId, tenantProfileId2.getId());
    assertSame(tenantProfileId, tenantEntity.getTenantProfileId());
  }

  /**
   * Test {@link AbstractTenantEntity#setTitle(String)}.
   *
   * <p>Method under test: {@link AbstractTenantEntity#setTitle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTenantEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("TenantEntity()", new TenantEntity().toString());
  }
}
