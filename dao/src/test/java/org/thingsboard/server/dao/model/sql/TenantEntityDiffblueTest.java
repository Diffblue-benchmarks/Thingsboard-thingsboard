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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantEntityDiffblueTest {
  /**
   * Test {@link TenantEntity#equals(Object)}, and {@link TenantEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntity#equals(Object)}
   *   <li>{@link TenantEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity2.setAddress("42 Main St");
    tenantEntity2.setAddress2("42 Main St");
    tenantEntity2.setCity("Oxford");
    tenantEntity2.setCountry("GB");
    tenantEntity2.setCreatedTime(1L);
    tenantEntity2.setEmail("jane.doe@example.org");
    tenantEntity2.setId(ModelConstants.NULL_UUID);
    tenantEntity2.setPhone("6625550144");
    tenantEntity2.setRegion("us-east-2");
    tenantEntity2.setState("MD");
    tenantEntity2.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity2.setTitle("Dr");
    tenantEntity2.setUuid(ModelConstants.NULL_UUID);
    tenantEntity2.setVersion(1L);
    tenantEntity2.setZip("21654");

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity2);
    assertEquals(tenantEntity.hashCode(), tenantEntity2.hashCode());
  }

  /**
   * Test {@link TenantEntity#equals(Object)}, and {@link TenantEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntity#equals(Object)}
   *   <li>{@link TenantEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity.hashCode());
  }

  /**
   * Test {@link TenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity2.setAddress("42 Main St");
    tenantEntity2.setAddress2("42 Main St");
    tenantEntity2.setCity("Oxford");
    tenantEntity2.setCountry("GB");
    tenantEntity2.setCreatedTime(1L);
    tenantEntity2.setEmail("jane.doe@example.org");
    tenantEntity2.setId(ModelConstants.NULL_UUID);
    tenantEntity2.setPhone("6625550144");
    tenantEntity2.setRegion("us-east-2");
    tenantEntity2.setState("MD");
    tenantEntity2.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity2.setTitle("Dr");
    tenantEntity2.setUuid(ModelConstants.NULL_UUID);
    tenantEntity2.setVersion(1L);
    tenantEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link TenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantEntity, null);
  }

  /**
   * Test {@link TenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantEntity, "Different type to TenantEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntity#TenantEntity()}
   *   <li>{@link TenantEntity#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantEntity.<init>()", "java.lang.String TenantEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantEntity actualTenantEntity = new TenantEntity();

    // Assert
    assertEquals("TenantEntity()", actualTenantEntity.toString());
    assertNull(actualTenantEntity.getAdditionalInfo());
    assertNull(actualTenantEntity.getVersion());
    assertNull(actualTenantEntity.getAddress());
    assertNull(actualTenantEntity.getAddress2());
    assertNull(actualTenantEntity.getCity());
    assertNull(actualTenantEntity.getCountry());
    assertNull(actualTenantEntity.getEmail());
    assertNull(actualTenantEntity.getPhone());
    assertNull(actualTenantEntity.getRegion());
    assertNull(actualTenantEntity.getState());
    assertNull(actualTenantEntity.getTitle());
    assertNull(actualTenantEntity.getZip());
    assertNull(actualTenantEntity.getId());
    assertNull(actualTenantEntity.getUuid());
    assertNull(actualTenantEntity.getTenantProfileId());
    assertEquals(0L, actualTenantEntity.getCreatedTime());
  }

  /**
   * Test {@link TenantEntity#TenantEntity(Tenant)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#TenantEntity(Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantEntity.<init>(Tenant)"})
  public void testNewTenantEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Tenant tenant = new Tenant(ModelConstants.SYSTEM_TENANT);
    TenantProfileId tenantProfileId = new TenantProfileId(ModelConstants.NULL_UUID);
    tenant.setTenantProfileId(tenantProfileId);

    // Act
    TenantEntity actualTenantEntity = new TenantEntity(tenant);

    // Assert
    UUID id = actualTenantEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTenantEntity.getTenantProfileId().toString());
    Tenant toDataResult = actualTenantEntity.toData();
    TenantId id2 = toDataResult.getId();
    assertTrue(id2.isNullUid());
    assertTrue(id2.isSysTenantId());
    assertEquals(tenantProfileId, toDataResult.getTenantProfileId());
    assertSame(id2, toDataResult.getTenantId());
    assertSame(id, toDataResult.getUuidId());
    assertSame(id, id2.getId());
    assertSame(id, actualTenantEntity.getUuid());
  }

  /**
   * Test {@link TenantEntity#TenantEntity(Tenant)}.
   *
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.
   *   <li>Then toData AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#TenantEntity(Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantEntity.<init>(Tenant)"})
  public void testNewTenantEntity_whenTenant_thenToDataAdditionalInfoReturnNullNode() {
    // Arrange and Act
    TenantEntity actualTenantEntity = new TenantEntity(new Tenant());

    // Assert
    Tenant toDataResult = actualTenantEntity.toData();
    JsonNode additionalInfo = toDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertNull(toDataResult.getUuidId());
    TenantId id = toDataResult.getId();
    assertNull(id.getId());
    assertNull(actualTenantEntity.getId());
    assertNull(actualTenantEntity.getUuid());
    assertNull(actualTenantEntity.getTenantProfileId());
    assertNull(toDataResult.getTenantProfileId());
    assertFalse(id.isNullUid());
    assertFalse(id.isSysTenantId());
    assertSame(id, toDataResult.getTenantId());
  }

  /**
   * Test {@link TenantEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is {@link ModelConstants#NULL_UUID}.
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantEntity.toData()"})
  public void testToData_givenTenantEntityUuidIsNull_uuid_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);

    // Act
    Tenant actualToDataResult = tenantEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("us-east-2", actualToDataResult.getRegion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link TenantEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is randomUUID.
   *   <li>Then return UuidId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantEntity.toData()"})
  public void testToData_givenTenantEntityUuidIsRandomUUID_thenReturnUuidIdIsRandomUUID() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTitle("Dr");
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);

    // Act
    Tenant actualToDataResult = tenantEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("us-east-2", actualToDataResult.getRegion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link TenantEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantEntity.toData()"})
  public void testToData_givenTenantEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Tenant actualToDataResult = new TenantEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getAddress());
    assertNull(actualToDataResult.getAddress2());
    assertNull(actualToDataResult.getCity());
    assertNull(actualToDataResult.getCountry());
    assertNull(actualToDataResult.getEmail());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getPhone());
    assertNull(actualToDataResult.getRegion());
    assertNull(actualToDataResult.getState());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getZip());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantProfileId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }
}
