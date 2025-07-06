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
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserEntityDiffblueTest {
  /**
   * Test {@link UserEntity#equals(Object)}, and {@link UserEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEntity#equals(Object)}
   *   <li>{@link UserEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(userEntity, userEntity2);
    int expectedHashCodeResult = userEntity.hashCode();
    assertEquals(expectedHashCodeResult, userEntity2.hashCode());
  }

  /**
   * Test {@link UserEntity#equals(Object)}, and {@link UserEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEntity#equals(Object)}
   *   <li>{@link UserEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    // Act and Assert
    assertEquals(userEntity, userEntity);
    int expectedHashCodeResult = userEntity.hashCode();
    assertEquals(expectedHashCodeResult, userEntity.hashCode());
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(null);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(null);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.TENANT_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(3L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(null);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("john.smith@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail(null);
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("John");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName(null);
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Smith");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName(null);
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("8605550118");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone(null);
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(null);
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    UserEntity userEntity2 = new UserEntity();
    userEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity2.setAuthority(Authority.SYS_ADMIN);
    userEntity2.setCreatedTime(1L);
    userEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setEmail("jane.doe@example.org");
    userEntity2.setFirstName("Jane");
    userEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setLastName("Doe");
    userEntity2.setPhone("6625550144");
    userEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, userEntity2);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, null);
  }

  /**
   * Test {@link UserEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UserEntity.equals(Object)", "int UserEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(userEntity, "Different type to UserEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEntity#UserEntity()}
   *   <li>{@link UserEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link UserEntity#setAuthority(Authority)}
   *   <li>{@link UserEntity#setCustomerId(UUID)}
   *   <li>{@link UserEntity#setEmail(String)}
   *   <li>{@link UserEntity#setFirstName(String)}
   *   <li>{@link UserEntity#setLastName(String)}
   *   <li>{@link UserEntity#setPhone(String)}
   *   <li>{@link UserEntity#setTenantId(UUID)}
   *   <li>{@link UserEntity#toString()}
   *   <li>{@link UserEntity#getAdditionalInfo()}
   *   <li>{@link UserEntity#getAuthority()}
   *   <li>{@link UserEntity#getCustomerId()}
   *   <li>{@link UserEntity#getEmail()}
   *   <li>{@link UserEntity#getFirstName()}
   *   <li>{@link UserEntity#getLastName()}
   *   <li>{@link UserEntity#getPhone()}
   *   <li>{@link UserEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UserEntity.<init>()",
    "JsonNode UserEntity.getAdditionalInfo()",
    "Authority UserEntity.getAuthority()",
    "UUID UserEntity.getCustomerId()",
    "String UserEntity.getEmail()",
    "String UserEntity.getFirstName()",
    "String UserEntity.getLastName()",
    "String UserEntity.getPhone()",
    "UUID UserEntity.getTenantId()",
    "void UserEntity.setAdditionalInfo(JsonNode)",
    "void UserEntity.setAuthority(Authority)",
    "void UserEntity.setCustomerId(UUID)",
    "void UserEntity.setEmail(String)",
    "void UserEntity.setFirstName(String)",
    "void UserEntity.setLastName(String)",
    "void UserEntity.setPhone(String)",
    "void UserEntity.setTenantId(UUID)",
    "String UserEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UserEntity actualUserEntity = new UserEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserEntity.setAdditionalInfo(additionalInfo);
    actualUserEntity.setAuthority(Authority.SYS_ADMIN);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserEntity.setCustomerId(customerId);
    actualUserEntity.setEmail("jane.doe@example.org");
    actualUserEntity.setFirstName("Jane");
    actualUserEntity.setLastName("Doe");
    actualUserEntity.setPhone("6625550144");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserEntity.setTenantId(tenantId);
    String actualToStringResult = actualUserEntity.toString();
    JsonNode actualAdditionalInfo = actualUserEntity.getAdditionalInfo();
    Authority actualAuthority = actualUserEntity.getAuthority();
    UUID actualCustomerId = actualUserEntity.getCustomerId();
    String actualEmail = actualUserEntity.getEmail();
    String actualFirstName = actualUserEntity.getFirstName();
    String actualLastName = actualUserEntity.getLastName();
    String actualPhone = actualUserEntity.getPhone();
    UUID actualTenantId = actualUserEntity.getTenantId();

    // Assert
    assertEquals("6625550144", actualPhone);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualCustomerId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals(
        "UserEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, customerId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " authority=SYS_ADMIN, email=jane.doe@example.org, firstName=Jane, lastName=Doe, phone=6625550144,"
            + " additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("jane.doe@example.org", actualEmail);
    assertNull(actualUserEntity.getVersion());
    assertNull(actualUserEntity.getId());
    assertNull(actualUserEntity.getUuid());
    assertEquals(0L, actualUserEntity.getCreatedTime());
    assertEquals(Authority.SYS_ADMIN, actualAuthority);
    assertSame(customerId, actualCustomerId);
    assertSame(tenantId, actualTenantId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }

  /**
   * Test {@link UserEntity#UserEntity(User)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#UserEntity(User)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserEntity.<init>(User)"})
  public void testNewUserEntity_givenNull_customer_id_thenReturnTenantIdIsNull() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(null);
    user.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    UserEntity actualUserEntity = new UserEntity(user);

    // Assert
    assertTrue(actualUserEntity.getAdditionalInfo() instanceof NullNode);
    assertNull(actualUserEntity.getTenantId());
  }

  /**
   * Test {@link UserEntity#UserEntity(User)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#UserEntity(User)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserEntity.<init>(User)"})
  public void testNewUserEntity_givenSystem_tenant_thenReturnCustomerIdIsNull() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(ModelConstants.SYSTEM_TENANT);
    user.setCustomerId(null);

    // Act
    UserEntity actualUserEntity = new UserEntity(user);

    // Assert
    assertTrue(actualUserEntity.getAdditionalInfo() instanceof NullNode);
    assertNull(actualUserEntity.getCustomerId());
  }

  /**
   * Test {@link UserEntity#UserEntity(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#UserEntity(User)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserEntity.<init>(User)"})
  public void testNewUserEntity_whenUser_thenReturnAdditionalInfoIsNull() {
    // Arrange and Act
    UserEntity actualUserEntity = new UserEntity(new User());

    // Assert
    assertNull(actualUserEntity.getAdditionalInfo());
    assertNull(actualUserEntity.getVersion());
    assertNull(actualUserEntity.getEmail());
    assertNull(actualUserEntity.getFirstName());
    assertNull(actualUserEntity.getLastName());
    assertNull(actualUserEntity.getPhone());
    assertNull(actualUserEntity.getId());
    assertNull(actualUserEntity.getUuid());
    assertNull(actualUserEntity.getAuthority());
    assertEquals(0L, actualUserEntity.getCreatedTime());
  }

  /**
   * Test {@link UserEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserEntity#UserEntity()} TenantId is {@code null}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"User UserEntity.toData()"})
  public void testToData_givenUserEntityTenantIdIsNull_thenReturnTenantIdIsNull() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);
    userEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userEntity.setCustomerId(customerId);

    // Act
    User actualToDataResult = userEntity.toData();

    // Assert
    CustomerId customerId2 = actualToDataResult.getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertTrue(actualToDataResult.isSystemAdmin());
    assertSame(customerId, id);
  }

  /**
   * Test {@link UserEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserEntity#UserEntity()} TenantId is randomUUID.
   *   <li>Then return CustomerUser.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"User UserEntity.toData()"})
  public void testToData_givenUserEntityTenantIdIsRandomUUID_thenReturnCustomerUser() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userEntity.setCustomerId(customerId);

    // Act
    User actualToDataResult = userEntity.toData();

    // Assert
    CustomerId customerId2 = actualToDataResult.getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(actualToDataResult.isSystemAdmin());
    assertFalse(customerId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualToDataResult.isCustomerUser());
    assertSame(customerId, id);
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link UserEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserEntity#UserEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"User UserEntity.toData()"})
  public void testToData_givenUserEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    User actualToDataResult = new UserEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getEmail());
    assertNull(actualToDataResult.getFirstName());
    assertNull(actualToDataResult.getLastName());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getPhone());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getAuthority());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link UserEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link UserEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"User UserEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setVersion(1L);
    userEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userEntity.setCustomerId(null);

    // Act
    User actualToDataResult = userEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertNull(actualToDataResult.getCustomerId());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(actualToDataResult.isSystemAdmin());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertTrue(actualToDataResult.isTenantAdmin());
  }
}
