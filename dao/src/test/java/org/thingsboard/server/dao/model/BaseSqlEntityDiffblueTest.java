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
package org.thingsboard.server.dao.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.RawValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.sql.AdminSettingsEntity;

public class BaseSqlEntityDiffblueTest {
  /**
   * Test {@link BaseSqlEntity#getId()}.
   *
   * <p>Method under test: {@link BaseSqlEntity#getId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID BaseSqlEntity.getId()"})
  public void testGetId() {
    // Arrange, Act and Assert
    assertNull(new AdminSettingsEntity().getId());
  }

  /**
   * Test {@link BaseSqlEntity#getUuid()}.
   *
   * <p>Method under test: {@link BaseSqlEntity#getUuid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID BaseSqlEntity.getUuid()"})
  public void testGetUuid() {
    // Arrange, Act and Assert
    assertNull(new AdminSettingsEntity().getUuid());
  }

  /**
   * Test {@link BaseSqlEntity#getUuid(UUIDBased)} with {@code UUIDBased}.
   *
   * <ul>
   *   <li>Then return toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getUuid(UUIDBased)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID BaseSqlEntity.getUuid(UUIDBased)"})
  public void testGetUuidWithUUIDBased_thenReturnToStringIs138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        BaseSqlEntity.getUuid(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link BaseSqlEntity#getUuid(UUIDBased)} with {@code UUIDBased}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getUuid(UUIDBased)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID BaseSqlEntity.getUuid(UUIDBased)"})
  public void testGetUuidWithUUIDBased_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BaseSqlEntity.getUuid(null));
  }

  /**
   * Test {@link BaseSqlEntity#setUuid(UUID)}.
   *
   * <p>Method under test: {@link BaseSqlEntity#setUuid(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseSqlEntity.setUuid(UUID)"})
  public void testSetUuid() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    UUID id = ModelConstants.NULL_UUID;

    // Act
    adminSettingsEntity.setUuid(id);

    // Assert
    assertSame(id, adminSettingsEntity.getId());
    assertSame(id, adminSettingsEntity.getUuid());
  }

  /**
   * Test {@link BaseSqlEntity#getCreatedTime()}.
   *
   * <p>Method under test: {@link BaseSqlEntity#getCreatedTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseSqlEntity.getCreatedTime()"})
  public void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new AdminSettingsEntity().getCreatedTime());
  }

  /**
   * Test {@link BaseSqlEntity#setCreatedTime(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link AdminSettingsEntity#AdminSettingsEntity()} CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#setCreatedTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseSqlEntity.setCreatedTime(long)"})
  public void testSetCreatedTime_whenOne_thenAdminSettingsEntityCreatedTimeIsOne() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    // Act
    adminSettingsEntity.setCreatedTime(1L);

    // Assert
    assertEquals(1L, adminSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link BaseSqlEntity#setCreatedTime(long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link AdminSettingsEntity#AdminSettingsEntity()} CreatedTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#setCreatedTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseSqlEntity.setCreatedTime(long)"})
  public void testSetCreatedTime_whenZero_thenAdminSettingsEntityCreatedTimeIsZero() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    // Act
    adminSettingsEntity.setCreatedTime(0L);

    // Assert that nothing has changed
    assertEquals(0L, adminSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantUuid(TenantId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getTenantUuid(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID BaseSqlEntity.getTenantUuid(TenantId)"})
  public void testGetTenantUuid_whenNull() {
    // Arrange and Act
    UUID actualTenantUuid = BaseSqlEntity.getTenantUuid(null);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantUuid.toString());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantUuid(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getTenantUuid(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID BaseSqlEntity.getTenantUuid(TenantId)"})
  public void testGetTenantUuid_whenSystem_tenant() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        BaseSqlEntity.getTenantUuid(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link BaseSqlEntity#getEntityId(UUID, Function)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>When {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getEntityId(UUID, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.getEntityId(UUID, Function)"})
  public void testGetEntityId_givenApply_whenNull_uuid_thenReturnApply() {
    // Arrange
    Function<UUID, Object> creator = mock(Function.class);
    when(creator.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act
    Object actualEntityId = BaseSqlEntity.getEntityId(ModelConstants.NULL_UUID, creator);

    // Assert
    verify(creator).apply(isA(UUID.class));
    assertEquals("Apply", actualEntityId);
  }

  /**
   * Test {@link BaseSqlEntity#getEntityId(UUID, Function)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getEntityId(UUID, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.getEntityId(UUID, Function)"})
  public void testGetEntityId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BaseSqlEntity.getEntityId(null, mock(Function.class)));
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId BaseSqlEntity.getTenantId(UUID)"})
  public void testGetTenantId_whenNull_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange and Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(null);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.getId().toString());
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertTrue(actualTenantId.isNullUid());
    assertTrue(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId BaseSqlEntity.getTenantId(UUID)"})
  public void testGetTenantId_whenNull_uuid() {
    // Arrange and Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(ModelConstants.NULL_UUID);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.getId().toString());
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertTrue(actualTenantId.isNullUid());
    assertTrue(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then return not NullUid.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId BaseSqlEntity.getTenantId(UUID)"})
  public void testGetTenantId_whenRandomUUID_thenReturnNotNullUid() {
    // Arrange
    UUID uuid = UUID.randomUUID();

    // Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(uuid);

    // Assert
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
    assertSame(uuid, actualTenantId.getId());
  }

  /**
   * Test {@link BaseSqlEntity#toJson(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#toJson(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode BaseSqlEntity.toJson(Object)"})
  public void testToJson_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminSettingsEntity().toJson(null));
  }

  /**
   * Test {@link BaseSqlEntity#toJson(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#toJson(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode BaseSqlEntity.toJson(Object)"})
  public void testToJson_whenOne_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonResult = new AdminSettingsEntity().toJson(1);

    // Assert
    assertTrue(actualToJsonResult instanceof IntNode);
    assertTrue(actualToJsonResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.NUMBER, actualToJsonResult.getNodeType());
    assertFalse(actualToJsonResult.isTextual());
    assertFalse(((IntNode) actualToJsonResult).isNaN());
    assertTrue(actualToJsonResult.isInt());
    assertTrue(actualToJsonResult.isIntegralNumber());
    assertTrue(actualToJsonResult.isNumber());
  }

  /**
   * Test {@link BaseSqlEntity#toJson(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#toJson(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode BaseSqlEntity.toJson(Object)"})
  public void testToJson_whenValue_thenReturnTextNode() {
    // Arrange and Act
    JsonNode actualToJsonResult = new AdminSettingsEntity().toJson("Value");

    // Assert
    assertTrue(actualToJsonResult instanceof TextNode);
    assertTrue(actualToJsonResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.STRING, actualToJsonResult.getNodeType());
    assertFalse(actualToJsonResult.isInt());
    assertFalse(actualToJsonResult.isIntegralNumber());
    assertFalse(actualToJsonResult.isNumber());
    assertTrue(actualToJsonResult.isTextual());
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenAdminSettingsEntityTenantIdIsNull_uuid_thenReturnMap() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult =
        adminSettingsEntity.fromJson(
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) actualFromJsonResult).size());
    assertTrue(((Map<String, Boolean>) actualFromJsonResult).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()}.
   *   <li>When False.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenAdminSettingsEntity_whenFalse_thenReturnFalse() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    BooleanNode json = BooleanNode.getFalse();
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse((Boolean) adminSettingsEntity.fromJson(json, type));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()}.
   *   <li>When Instance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenAdminSettingsEntity_whenInstance_thenReturnNull() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    MissingNode json = MissingNode.getInstance();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(adminSettingsEntity.fromJson(json, type));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenAdminSettingsEntity_whenNull_thenReturnNull() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(adminSettingsEntity.fromJson(null, type));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()}.
   *   <li>When True.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenAdminSettingsEntity_whenTrue_thenReturnTrue() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    BooleanNode json = BooleanNode.getTrue();
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue((Boolean) adminSettingsEntity.fromJson(json, type));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   *   <li>Then return first is {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenPojo_thenReturnFirstIsPojo() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode json = new ArrayNode(nf);
    json.addPOJO("Pojo");
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(1);
    assertTrue(getResult instanceof Map);
    assertEquals("Pojo", ((List<Object>) actualFromJsonResult).get(0));
    assertEquals(1, ((Map<String, Boolean>) getResult).size());
    assertTrue(((Map<String, Boolean>) getResult).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@link RawValue#RawValue(String)} with v is {@code foo}.
   *   <li>Then first return {@link RawValue}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenRawValueWithVIsFoo_thenFirstReturnRawValue() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode json = new ArrayNode(nf);
    RawValue raw = new RawValue("foo");
    json.addRawValue(raw);
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof RawValue);
    assertTrue(actualFromJsonResult instanceof List);
    Object getResult2 = ((List<Object>) actualFromJsonResult).get(1);
    assertTrue(getResult2 instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) getResult2).size());
    assertTrue(((Map<String, Boolean>) getResult2).get("isPublic"));
    assertEquals(raw, getResult);
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return first intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_givenTwo_thenReturnFirstIntValueIsTwo() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode json = new ArrayNode(nf);
    json.addPOJO(2);
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(1);
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) getResult).size());
    assertEquals(2, ((Integer) ((List<Object>) actualFromJsonResult).get(0)).intValue());
    assertTrue(((Map<String, Boolean>) getResult).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Then first return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_thenFirstReturnList() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode json = new ArrayNode(nf);
    json.addArray();
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof List);
    Object getResult2 = ((List<Object>) actualFromJsonResult).get(1);
    assertTrue(getResult2 instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) getResult2).size());
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Boolean>) getResult2).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory, int)} with nf is withExactBigDecimals
   *       {@code true} and capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAndCapacityIsThree() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode json = new ArrayNode(nf, 3);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnEmpty() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode json = new ArrayNode(nf);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.
   *   <li>Then return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BaseSqlEntity.fromJson(JsonNode, Class)"})
  public void testFromJson_whenPublic_customer_additional_info_json_thenReturnMap() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult =
        adminSettingsEntity.fromJson(
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) actualFromJsonResult).size());
    assertTrue(((Map<String, Boolean>) actualFromJsonResult).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseSqlEntity.listToString(List)"})
  public void testListToString_given42_whenArrayListAdd42_thenReturn42() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act and Assert
    assertEquals("42", adminSettingsEntity.listToString(list));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42,42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseSqlEntity.listToString(List)"})
  public void testListToString_given42_whenArrayListAdd42_thenReturn4242() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act and Assert
    assertEquals("42,42", adminSettingsEntity.listToString(list));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseSqlEntity.listToString(List)"})
  public void testListToString_whenArrayList_thenReturnEmptyString() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    // Act and Assert
    assertEquals("", adminSettingsEntity.listToString(new ArrayList<>()));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseSqlEntity.listToString(List)"})
  public void testListToString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new AdminSettingsEntity().listToString(null));
  }

  /**
   * Test {@link BaseSqlEntity#listFromString(String, Function)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>When {@code String}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#listFromString(String, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseSqlEntity.listFromString(String, Function)"})
  public void testListFromString_givenApply_whenString_thenReturnSizeIsOne() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    Function<String, Object> mappingFunction = mock(Function.class);
    when(mappingFunction.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    List<Object> actualListFromStringResult =
        adminSettingsEntity.listFromString("String", mappingFunction);

    // Assert
    verify(mappingFunction).apply("String");
    assertEquals(1, actualListFromStringResult.size());
    assertEquals("Apply", actualListFromStringResult.get(0));
  }

  /**
   * Test {@link BaseSqlEntity#listFromString(String, Function)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#listFromString(String, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseSqlEntity.listFromString(String, Function)"})
  public void testListFromString_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdminSettingsEntity().listFromString("", mock(Function.class)).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#listFromString(String, Function)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseSqlEntity#listFromString(String, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseSqlEntity.listFromString(String, Function)"})
  public void testListFromString_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdminSettingsEntity().listFromString(null, mock(Function.class)).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#setId(UUID)}.
   *
   * <p>Method under test: {@link BaseSqlEntity#setId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseSqlEntity.setId(UUID)"})
  public void testSetId() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    UUID id = ModelConstants.NULL_UUID;

    // Act
    adminSettingsEntity.setId(id);

    // Assert
    assertSame(id, adminSettingsEntity.getId());
    assertSame(id, adminSettingsEntity.getUuid());
  }
}
