package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.Authority;

class UserDiffblueTest {
  /**
   * Test {@link User#User(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(User)}
   */
  @Test
  @DisplayName("Test new User(User); when User()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void User.<init>(User)"})
  void testNewUser_whenUser() {
    // Arrange and Act
    User actualUser = new User(new User());

    // Assert
    assertTrue(actualUser.getAdditionalInfo() instanceof NullNode);
    assertNull(actualUser.getVersion());
    assertNull(actualUser.getEmail());
    assertNull(actualUser.getFirstName());
    assertNull(actualUser.getLastName());
    assertNull(actualUser.getName());
    assertNull(actualUser.getPhone());
    assertNull(actualUser.getTitle());
    assertNull(actualUser.getUuidId());
    assertNull(actualUser.getCustomerId());
    assertNull(actualUser.getTenantId());
    assertNull(actualUser.getId());
    assertNull(actualUser.getAuthority());
    assertEquals(0L, actualUser.getCreatedTime());
    assertFalse(actualUser.isCustomerUser());
    assertFalse(actualUser.isTenantAdmin());
    assertTrue(actualUser.isSystemAdmin());
  }

  /**
   * Test {@link User#User(User)}.
   *
   * <ul>
   *   <li>When {@link User#User(User)} with user is {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(User)}
   */
  @Test
  @DisplayName("Test new User(User); when User(User) with user is User()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void User.<init>(User)"})
  void testNewUser_whenUserWithUserIsUser() {
    // Arrange and Act
    User actualUser = new User(new User(new User()));

    // Assert
    assertTrue(actualUser.getAdditionalInfo() instanceof NullNode);
    assertNull(actualUser.getVersion());
    assertNull(actualUser.getEmail());
    assertNull(actualUser.getFirstName());
    assertNull(actualUser.getLastName());
    assertNull(actualUser.getName());
    assertNull(actualUser.getPhone());
    assertNull(actualUser.getTitle());
    assertNull(actualUser.getUuidId());
    assertNull(actualUser.getCustomerId());
    assertNull(actualUser.getTenantId());
    assertNull(actualUser.getId());
    assertNull(actualUser.getAuthority());
    assertEquals(0L, actualUser.getCreatedTime());
    assertFalse(actualUser.isCustomerUser());
    assertFalse(actualUser.isTenantAdmin());
    assertTrue(actualUser.isSystemAdmin());
  }

  /**
   * Test {@link User#User(User)}.
   *
   * <ul>
   *   <li>When {@link User#User(User)} with user is {@link User#User(User)}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(User)}
   */
  @Test
  @DisplayName("Test new User(User); when User(User) with user is User(User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void User.<init>(User)"})
  void testNewUser_whenUserWithUserIsUser2() {
    // Arrange and Act
    User actualUser = new User(new User(new User(new User())));

    // Assert
    assertTrue(actualUser.getAdditionalInfo() instanceof NullNode);
    assertNull(actualUser.getVersion());
    assertNull(actualUser.getEmail());
    assertNull(actualUser.getFirstName());
    assertNull(actualUser.getLastName());
    assertNull(actualUser.getName());
    assertNull(actualUser.getPhone());
    assertNull(actualUser.getTitle());
    assertNull(actualUser.getUuidId());
    assertNull(actualUser.getCustomerId());
    assertNull(actualUser.getTenantId());
    assertNull(actualUser.getId());
    assertNull(actualUser.getAuthority());
    assertEquals(0L, actualUser.getCreatedTime());
    assertFalse(actualUser.isCustomerUser());
    assertFalse(actualUser.isTenantAdmin());
    assertTrue(actualUser.isSystemAdmin());
  }

  /**
   * Test {@link User#getId()}.
   *
   * <p>Method under test: {@link User#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.UserId User.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new User().getId());
  }

  /**
   * Test {@link User#getCreatedTime()}.
   *
   * <p>Method under test: {@link User#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long User.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new User().getCreatedTime());
  }

  /**
   * Test {@link User#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link User#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given User(User) with user is User(); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode User.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenUserWithUserIsUser_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new User(new User()).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link User#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User(User)}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link User#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given User(User) with user is User(User); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode User.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenUserWithUserIsUser_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new User(new User(new User())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link User#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link User#User()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given User(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode User.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenUser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new User().getAdditionalInfo());
  }

  /**
   * Test {@link User#getTitle(String, String, String)} with {@code String}, {@code String}, {@code
   * String}.
   *
   * <ul>
   *   <li>Then return {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTitle(String, String, String) with 'String', 'String', 'String'; then return 'jane.doe@example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle(String, String, String)"})
  void testGetTitleWithStringStringString_thenReturnJaneDoeExampleOrg() {
    // Arrange, Act and Assert
    assertEquals(
        "jane.doe@example.org",
        User.getTitle(
            "jane.doe@example.org",
            DataConstants.DEFAULT_SECRET_KEY,
            DataConstants.DEFAULT_SECRET_KEY));
  }

  /**
   * Test {@link User#getTitle(String, String, String)} with {@code String}, {@code String}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.
   *   <li>Then return {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTitle(String, String, String) with 'String', 'String', 'String'; when DEFAULT_SECRET_KEY; then return 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle(String, String, String)"})
  void testGetTitleWithStringStringString_whenDefault_secret_key_thenReturnNotEmpty() {
    // Arrange, Act and Assert
    assertEquals(
        "not empty",
        User.getTitle("jane.doe@example.org", DataConstants.DEFAULT_SECRET_KEY, "not empty"));
  }

  /**
   * Test {@link User#getTitle(String, String, String)} with {@code String}, {@code String}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@code Jane}.
   *   <li>Then return {@code Jane Doe}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTitle(String, String, String) with 'String', 'String', 'String'; when 'Jane'; then return 'Jane Doe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle(String, String, String)"})
  void testGetTitleWithStringStringString_whenJane_thenReturnJaneDoe() {
    // Arrange, Act and Assert
    assertEquals("Jane Doe", User.getTitle("jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link User#getTitle(String, String, String)} with {@code String}, {@code String}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   *   <li>Then return {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTitle(String, String, String) with 'String', 'String', 'String'; when 'not empty'; then return 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle(String, String, String)"})
  void testGetTitleWithStringStringString_whenNotEmpty_thenReturnNotEmpty() {
    // Arrange, Act and Assert
    assertEquals(
        "not empty",
        User.getTitle("jane.doe@example.org", "not empty", DataConstants.DEFAULT_SECRET_KEY));
  }

  /**
   * Test {@link User#getTitle(String, String, String)} with {@code String}, {@code String}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTitle(String, String, String) with 'String', 'String', 'String'; when 'null'; then return 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle(String, String, String)"})
  void testGetTitleWithStringStringString_whenNull_thenReturnNotEmpty() {
    // Arrange, Act and Assert
    assertEquals("not empty", User.getTitle("jane.doe@example.org", "not empty", null));
  }

  /**
   * Test {@link User#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} FirstName is {@link
   *       DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle()}
   */
  @Test
  @DisplayName(
      "Test getTitle(); given User(User) with user is User() FirstName is DEFAULT_SECRET_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle()"})
  void testGetTitle_givenUserWithUserIsUserFirstNameIsDefault_secret_key() {
    // Arrange
    User user = new User(new User());
    user.setFirstName(DataConstants.DEFAULT_SECRET_KEY);
    user.setLastName("not empty");

    // Act and Assert
    assertEquals("not empty", user.getTitle());
  }

  /**
   * Test {@link User#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} LastName is {@link
   *       DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle()}
   */
  @Test
  @DisplayName(
      "Test getTitle(); given User(User) with user is User() LastName is DEFAULT_SECRET_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle()"})
  void testGetTitle_givenUserWithUserIsUserLastNameIsDefault_secret_key() {
    // Arrange
    User user = new User(new User());
    user.setFirstName("not empty");
    user.setLastName(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    assertEquals("not empty", user.getTitle());
  }

  /**
   * Test {@link User#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link User#User()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given User(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle()"})
  void testGetTitle_givenUser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new User().getTitle());
  }

  /**
   * Test {@link User#getTitle()}.
   *
   * <ul>
   *   <li>Then return {@code not empty not empty}.
   * </ul>
   *
   * <p>Method under test: {@link User#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'not empty not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String User.getTitle()"})
  void testGetTitle_thenReturnNotEmptyNotEmpty() {
    // Arrange
    User user = new User(new User());
    user.setFirstName("not empty");
    user.setLastName("not empty");

    // Act and Assert
    assertEquals("not empty not empty", user.getTitle());
  }

  /**
   * Test {@link User#isSystemAdmin()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} TenantId is {@link
   *       TenantId#SYS_TENANT_ID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link User#isSystemAdmin()}
   */
  @Test
  @DisplayName(
      "Test isSystemAdmin(); given User(User) with user is User() TenantId is SYS_TENANT_ID; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isSystemAdmin()"})
  void testIsSystemAdmin_givenUserWithUserIsUserTenantIdIsSys_tenant_id_thenReturnTrue() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertTrue(user.isSystemAdmin());
  }

  /**
   * Test {@link User#isSystemAdmin()}.
   *
   * <ul>
   *   <li>Given {@link User#User()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link User#isSystemAdmin()}
   */
  @Test
  @DisplayName("Test isSystemAdmin(); given User(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isSystemAdmin()"})
  void testIsSystemAdmin_givenUser_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new User().isSystemAdmin());
  }

  /**
   * Test {@link User#isSystemAdmin()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link User#isSystemAdmin()}
   */
  @Test
  @DisplayName("Test isSystemAdmin(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isSystemAdmin()"})
  void testIsSystemAdmin_thenReturnFalse() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertFalse(user.isSystemAdmin());
  }

  /**
   * Test {@link User#isTenantAdmin()}.
   *
   * <p>Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  @DisplayName("Test isTenantAdmin()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isTenantAdmin()"})
  void testIsTenantAdmin() {
    // Arrange
    User user = new User(new User());
    user.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    user.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertFalse(user.isTenantAdmin());
  }

  /**
   * Test {@link User#isTenantAdmin()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} CustomerId is {@link
   *       CustomerId#CustomerId(UUID)} with id is {@link EntityId#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  @DisplayName(
      "Test isTenantAdmin(); given User(User) with user is User() CustomerId is CustomerId(UUID) with id is NULL_UUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isTenantAdmin()"})
  void testIsTenantAdmin_givenUserWithUserIsUserCustomerIdIsCustomerIdWithIdIsNull_uuid() {
    // Arrange
    User user = new User(new User());
    user.setCustomerId(new CustomerId(EntityId.NULL_UUID));
    user.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertTrue(user.isTenantAdmin());
  }

  /**
   * Test {@link User#isTenantAdmin()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} CustomerId is {@code
   *       null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  @DisplayName(
      "Test isTenantAdmin(); given User(User) with user is User() CustomerId is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isTenantAdmin()"})
  void testIsTenantAdmin_givenUserWithUserIsUserCustomerIdIsNull_thenReturnTrue() {
    // Arrange
    User user = new User(new User());
    user.setCustomerId(null);
    user.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertTrue(user.isTenantAdmin());
  }

  /**
   * Test {@link User#isTenantAdmin()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} TenantId is {@link
   *       TenantId#SYS_TENANT_ID}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  @DisplayName(
      "Test isTenantAdmin(); given User(User) with user is User() TenantId is SYS_TENANT_ID; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isTenantAdmin()"})
  void testIsTenantAdmin_givenUserWithUserIsUserTenantIdIsSys_tenant_id_thenReturnFalse() {
    // Arrange
    User user = new User(new User());
    user.setCustomerId(null);
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertFalse(user.isTenantAdmin());
  }

  /**
   * Test {@link User#isTenantAdmin()}.
   *
   * <ul>
   *   <li>Given {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  @DisplayName("Test isTenantAdmin(); given User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isTenantAdmin()"})
  void testIsTenantAdmin_givenUser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new User().isTenantAdmin());
  }

  /**
   * Test {@link User#isCustomerUser()}.
   *
   * <p>Method under test: {@link User#isCustomerUser()}
   */
  @Test
  @DisplayName("Test isCustomerUser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isCustomerUser()"})
  void testIsCustomerUser() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    user.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertFalse(user.isCustomerUser());
  }

  /**
   * Test {@link User#isCustomerUser()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} CustomerId is {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link User#isCustomerUser()}
   */
  @Test
  @DisplayName(
      "Test isCustomerUser(); given User(User) with user is User() CustomerId is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isCustomerUser()"})
  void testIsCustomerUser_givenUserWithUserIsUserCustomerIdIsNull_thenReturnFalse() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    user.setCustomerId(null);

    // Act and Assert
    assertFalse(user.isCustomerUser());
  }

  /**
   * Test {@link User#isCustomerUser()}.
   *
   * <ul>
   *   <li>Given {@link User#User(User)} with user is {@link User#User()} TenantId is {@link
   *       TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link User#isCustomerUser()}
   */
  @Test
  @DisplayName(
      "Test isCustomerUser(); given User(User) with user is User() TenantId is SYS_TENANT_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isCustomerUser()"})
  void testIsCustomerUser_givenUserWithUserIsUserTenantIdIsSys_tenant_id() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(TenantId.SYS_TENANT_ID);
    user.setCustomerId(null);

    // Act and Assert
    assertFalse(user.isCustomerUser());
  }

  /**
   * Test {@link User#isCustomerUser()}.
   *
   * <ul>
   *   <li>Given {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link User#isCustomerUser()}
   */
  @Test
  @DisplayName("Test isCustomerUser(); given User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isCustomerUser()"})
  void testIsCustomerUser_givenUser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new User().isCustomerUser());
  }

  /**
   * Test {@link User#isCustomerUser()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link User#isCustomerUser()}
   */
  @Test
  @DisplayName("Test isCustomerUser(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.isCustomerUser()"})
  void testIsCustomerUser_thenReturnTrue() {
    // Arrange
    User user = new User(new User());
    user.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    user.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertTrue(user.isCustomerUser());
  }

  /**
   * Test {@link User#equals(Object)}, and {@link User#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    User user = new User();
    User user2 = new User();

    // Act and Assert
    assertEquals(user, user2);
    int expectedHashCodeResult = user.hashCode();
    assertEquals(expectedHashCodeResult, user2.hashCode());
  }

  /**
   * Test {@link User#equals(Object)}, and {@link User#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    User user = new User();

    // Act and Assert
    assertEquals(user, user);
    int expectedHashCodeResult = user.hashCode();
    assertEquals(expectedHashCodeResult, user.hashCode());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    User user = new User(new User());

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    User user = new User();
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    User user = new User();
    user.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    User user = new User();
    user.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    User user = new User();
    user.setAuthority(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    User user = new User();
    user.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    User user = new User();
    user.setLastName("Doe");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    User user = new User();
    user.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    User user = new User();
    user.setVersion(1L);

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setAuthority(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setVersion(1L);

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new User(), null);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.equals(Object)", "int User.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new User(), "Different type to User");
  }
}
