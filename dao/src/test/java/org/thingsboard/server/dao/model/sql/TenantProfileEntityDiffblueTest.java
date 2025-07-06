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
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class TenantProfileEntityDiffblueTest {
  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and {@link TenantProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity2);
    int expectedHashCodeResult = tenantProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEntity2.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and {@link TenantProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity);
    int expectedHashCodeResult = tenantProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEntity.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(3L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(false);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("Name");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription(null);
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(false);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("The characteristics of someone or something");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName(null);
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(DoubleNode.valueOf(10.0d));
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(null);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, null);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantProfileEntity, "Different type to TenantProfileEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#TenantProfileEntity()}
   *   <li>{@link TenantProfileEntity#setDefault(boolean)}
   *   <li>{@link TenantProfileEntity#setDescription(String)}
   *   <li>{@link TenantProfileEntity#setIsolatedTbRuleEngine(boolean)}
   *   <li>{@link TenantProfileEntity#setName(String)}
   *   <li>{@link TenantProfileEntity#setProfileData(JsonNode)}
   *   <li>{@link TenantProfileEntity#toString()}
   *   <li>{@link TenantProfileEntity#getDescription()}
   *   <li>{@link TenantProfileEntity#getName()}
   *   <li>{@link TenantProfileEntity#getProfileData()}
   *   <li>{@link TenantProfileEntity#isDefault()}
   *   <li>{@link TenantProfileEntity#isIsolatedTbRuleEngine()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TenantProfileEntity.<init>()",
    "String TenantProfileEntity.getDescription()",
    "String TenantProfileEntity.getName()",
    "JsonNode TenantProfileEntity.getProfileData()",
    "boolean TenantProfileEntity.isDefault()",
    "boolean TenantProfileEntity.isIsolatedTbRuleEngine()",
    "void TenantProfileEntity.setDefault(boolean)",
    "void TenantProfileEntity.setDescription(String)",
    "void TenantProfileEntity.setIsolatedTbRuleEngine(boolean)",
    "void TenantProfileEntity.setName(String)",
    "void TenantProfileEntity.setProfileData(JsonNode)",
    "String TenantProfileEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity();
    actualTenantProfileEntity.setDefault(true);
    actualTenantProfileEntity.setDescription("The characteristics of someone or something");
    actualTenantProfileEntity.setIsolatedTbRuleEngine(true);
    actualTenantProfileEntity.setName("Name");
    JsonNode profileData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTenantProfileEntity.setProfileData(profileData);
    String actualToStringResult = actualTenantProfileEntity.toString();
    String actualDescription = actualTenantProfileEntity.getDescription();
    String actualName = actualTenantProfileEntity.getName();
    JsonNode actualProfileData = actualTenantProfileEntity.getProfileData();
    boolean actualIsDefaultResult = actualTenantProfileEntity.isDefault();
    boolean actualIsIsolatedTbRuleEngineResult = actualTenantProfileEntity.isIsolatedTbRuleEngine();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "TenantProfileEntity(name=Name, description=The characteristics of someone or something, isDefault=true,"
            + " isolatedTbRuleEngine=true, profileData={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualTenantProfileEntity.getId());
    assertNull(actualTenantProfileEntity.getUuid());
    assertEquals(0L, actualTenantProfileEntity.getCreatedTime());
    assertTrue(actualIsDefaultResult);
    assertTrue(actualIsIsolatedTbRuleEngineResult);
    assertSame(profileData, actualProfileData);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TenantProfileEntity actualTenantProfileEntity =
        new TenantProfileEntity(new TenantProfile(new TenantProfileId(id)));

    // Assert
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
    UUID id2 = actualTenantProfileEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualTenantProfileEntity.getUuid());
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenA() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act and Assert
    JsonNode profileData = new TenantProfileEntity(tenantProfile).getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenEmptyArrayOfByte() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {});

    // Act and Assert
    JsonNode profileData = new TenantProfileEntity(tenantProfile).getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setCreatedTime(3L);

    // Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity(tenantProfile);

    // Assert
    assertEquals(3L, actualTenantProfileEntity.getCreatedTime());
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return Default.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenTrue_thenReturnDefault() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDefault(true);

    // Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity(tenantProfile);

    // Assert
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
    assertTrue(actualTenantProfileEntity.isDefault());
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_whenTenantProfile() {
    // Arrange, Act and Assert
    JsonNode profileData = new TenantProfileEntity(new TenantProfile()).getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile(TenantProfile)} with tenantProfile is {@link
   *       TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_whenTenantProfileWithTenantProfileIsTenantProfile() {
    // Arrange, Act and Assert
    JsonNode profileData =
        new TenantProfileEntity(new TenantProfile(new TenantProfile())).getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)} with tenantProfile
   *       is {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile TenantProfileEntity.toData()"})
  public void testToData_givenTenantProfileEntityWithTenantProfileIsTenantProfile() {
    // Arrange, Act and Assert
    assertEquals(
        1905, new TenantProfileEntity(new TenantProfile()).toData().getProfileDataBytes().length);
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileEntity#TenantProfileEntity()}.
   *   <li>Then return ProfileDataBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile TenantProfileEntity.toData()"})
  public void testToData_givenTenantProfileEntity_thenReturnProfileDataBytesIsNull() {
    // Arrange and Act
    TenantProfile actualToDataResult = new TenantProfileEntity().toData();

    // Assert
    assertNull(actualToDataResult.getProfileDataBytes());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(actualToDataResult.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile(TenantProfile)} with tenantProfile is {@link
   *       TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile TenantProfileEntity.toData()"})
  public void testToData_givenTenantProfileWithTenantProfileIsTenantProfile() {
    // Arrange, Act and Assert
    assertEquals(
        1905,
        new TenantProfileEntity(new TenantProfile(new TenantProfile()))
            .toData()
            .getProfileDataBytes()
            .length);
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile TenantProfileEntity.toData()"})
  public void testToData_thenReturnUuidIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    tenantProfileEntity.setUuid(id);
    tenantProfileEntity.setProfileData(MissingNode.getInstance());

    // Act
    TenantProfile actualToDataResult = tenantProfileEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDefault());
    assertTrue(actualToDataResult.isIsolatedTbRuleEngine());
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
  }
}
