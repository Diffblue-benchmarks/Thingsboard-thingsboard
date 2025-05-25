package org.thingsboard.server.service.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.service.security.model.UserPrincipal.Type;

@ContextConfiguration(classes = {SecurityUser.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class SecurityUserDiffblueTest {
  @Autowired
  private SecurityUser securityUser;

  /**
   * Test {@link SecurityUser#SecurityUser()}.
   * <p>
   * Method under test: {@link SecurityUser#SecurityUser()}
   */
  @Test
  @DisplayName("Test new SecurityUser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityUser.<init>()"})
  void testNewSecurityUser() {
    // Arrange and Act
    SecurityUser actualSecurityUser = new SecurityUser();

    // Assert
    assertNull(actualSecurityUser.getAdditionalInfo());
    assertNull(actualSecurityUser.getVersion());
    assertNull(actualSecurityUser.getEmail());
    assertNull(actualSecurityUser.getFirstName());
    assertNull(actualSecurityUser.getLastName());
    assertNull(actualSecurityUser.getName());
    assertNull(actualSecurityUser.getPhone());
    assertNull(actualSecurityUser.getTitle());
    assertNull(actualSecurityUser.getUuidId());
    assertNull(actualSecurityUser.getCustomerId());
    assertNull(actualSecurityUser.getTenantId());
    assertNull(actualSecurityUser.getId());
    assertNull(actualSecurityUser.getAuthority());
    assertNull(actualSecurityUser.getUserPrincipal());
    assertEquals(0L, actualSecurityUser.getCreatedTime());
    assertFalse(actualSecurityUser.isCustomerUser());
    assertFalse(actualSecurityUser.isTenantAdmin());
    assertFalse(actualSecurityUser.isEnabled());
    assertTrue(actualSecurityUser.isSystemAdmin());
  }

  /**
   * Test {@link SecurityUser#SecurityUser(User, boolean, UserPrincipal)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then AdditionalInfo return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityUser#SecurityUser(User, boolean, UserPrincipal)}
   */
  @Test
  @DisplayName("Test new SecurityUser(User, boolean, UserPrincipal); given Instance; then AdditionalInfo return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityUser.<init>(User, boolean, UserPrincipal)"})
  void testNewSecurityUser_givenInstance_thenAdditionalInfoReturnMissingNode() {
    // Arrange
    User user = mock(User.class);
    MissingNode instance = MissingNode.getInstance();
    when(user.getAdditionalInfo()).thenReturn(instance);
    when(user.getVersion()).thenReturn(1L);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getFirstName()).thenReturn("Jane");
    when(user.getLastName()).thenReturn("Doe");
    when(user.getPhone()).thenReturn("6625550144");
    when(user.getCreatedTime()).thenReturn(1L);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(user.getCustomerId()).thenReturn(customerId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getId()).thenReturn(null);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act
    SecurityUser actualSecurityUser = new SecurityUser(user, true, new UserPrincipal(Type.USER_NAME, "42"));

    // Assert
    verify(user).getAdditionalInfo();
    verify(user).getAuthority();
    verify(user).getCreatedTime();
    verify(user).getCustomerId();
    verify(user).getEmail();
    verify(user).getFirstName();
    verify(user).getId();
    verify(user).getLastName();
    verify(user).getPhone();
    verify(user).getTenantId();
    verify(user).getVersion();
    JsonNode additionalInfo = actualSecurityUser.getAdditionalInfo();
    assertTrue(additionalInfo instanceof MissingNode);
    Collection<GrantedAuthority> authorities = actualSecurityUser.getAuthorities();
    assertEquals(1, authorities.size());
    assertTrue(authorities instanceof List);
    assertEquals("6625550144", actualSecurityUser.getPhone());
    assertEquals("Doe", actualSecurityUser.getLastName());
    assertEquals("Jane Doe", actualSecurityUser.getTitle());
    assertEquals("Jane", actualSecurityUser.getFirstName());
    assertEquals("jane.doe@example.org", actualSecurityUser.getEmail());
    assertEquals("jane.doe@example.org", actualSecurityUser.getName());
    assertEquals(1L, actualSecurityUser.getVersion().longValue());
    assertEquals(1L, actualSecurityUser.getCreatedTime());
    assertEquals(Authority.SYS_ADMIN, actualSecurityUser.getAuthority());
    assertFalse(actualSecurityUser.isSystemAdmin());
    assertTrue(actualSecurityUser.isCustomerUser());
    assertSame(customerId, actualSecurityUser.getCustomerId());
    assertSame(tenantId, actualSecurityUser.getTenantId());
    assertSame(instance, additionalInfo);
  }

  /**
   * Test {@link SecurityUser#SecurityUser(UserId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityUser#SecurityUser(UserId)}
   */
  @Test
  @DisplayName("Test new SecurityUser(UserId); when 'null'; then return AdditionalInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityUser.<init>(UserId)"})
  void testNewSecurityUser_whenNull_thenReturnAdditionalInfoIsNull() {
    // Arrange and Act
    SecurityUser actualSecurityUser = new SecurityUser(null);

    // Assert
    assertNull(actualSecurityUser.getAdditionalInfo());
    assertNull(actualSecurityUser.getVersion());
    assertNull(actualSecurityUser.getEmail());
    assertNull(actualSecurityUser.getFirstName());
    assertNull(actualSecurityUser.getLastName());
    assertNull(actualSecurityUser.getName());
    assertNull(actualSecurityUser.getPhone());
    assertNull(actualSecurityUser.getTitle());
    assertNull(actualSecurityUser.getUuidId());
    assertNull(actualSecurityUser.getCustomerId());
    assertNull(actualSecurityUser.getTenantId());
    assertNull(actualSecurityUser.getId());
    assertNull(actualSecurityUser.getAuthority());
    assertNull(actualSecurityUser.getUserPrincipal());
    assertEquals(0L, actualSecurityUser.getCreatedTime());
    assertFalse(actualSecurityUser.isCustomerUser());
    assertFalse(actualSecurityUser.isTenantAdmin());
    assertFalse(actualSecurityUser.isEnabled());
    assertTrue(actualSecurityUser.isSystemAdmin());
  }

  /**
   * Test {@link SecurityUser#SecurityUser(User, boolean, UserPrincipal)}.
   * <ul>
   *   <li>When {@link User#User(User)} with user is {@link User#User()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityUser#SecurityUser(User, boolean, UserPrincipal)}
   */
  @Test
  @DisplayName("Test new SecurityUser(User, boolean, UserPrincipal); when User(User) with user is User(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityUser.<init>(User, boolean, UserPrincipal)"})
  void testNewSecurityUser_whenUserWithUserIsUser_thenAdditionalInfoReturnNullNode() {
    // Arrange
    User user = new User(new User());

    // Act
    SecurityUser actualSecurityUser = new SecurityUser(user, true, new UserPrincipal(Type.USER_NAME, "42"));

    // Assert
    assertTrue(actualSecurityUser.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSecurityUser.getVersion());
    assertNull(actualSecurityUser.getEmail());
    assertNull(actualSecurityUser.getFirstName());
    assertNull(actualSecurityUser.getLastName());
    assertNull(actualSecurityUser.getName());
    assertNull(actualSecurityUser.getPhone());
    assertNull(actualSecurityUser.getTitle());
    assertNull(actualSecurityUser.getCustomerId());
    assertNull(actualSecurityUser.getTenantId());
    assertNull(actualSecurityUser.getAuthority());
    assertEquals(0L, actualSecurityUser.getCreatedTime());
    assertFalse(actualSecurityUser.isCustomerUser());
    assertTrue(actualSecurityUser.isSystemAdmin());
  }

  /**
   * Test {@link SecurityUser#SecurityUser(User, boolean, UserPrincipal)}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityUser#SecurityUser(User, boolean, UserPrincipal)}
   */
  @Test
  @DisplayName("Test new SecurityUser(User, boolean, UserPrincipal); when User(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecurityUser.<init>(User, boolean, UserPrincipal)"})
  void testNewSecurityUser_whenUser_thenAdditionalInfoReturnNullNode() {
    // Arrange
    User user = new User();

    // Act
    SecurityUser actualSecurityUser = new SecurityUser(user, true, new UserPrincipal(Type.USER_NAME, "42"));

    // Assert
    assertTrue(actualSecurityUser.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSecurityUser.getVersion());
    assertNull(actualSecurityUser.getEmail());
    assertNull(actualSecurityUser.getFirstName());
    assertNull(actualSecurityUser.getLastName());
    assertNull(actualSecurityUser.getName());
    assertNull(actualSecurityUser.getPhone());
    assertNull(actualSecurityUser.getTitle());
    assertNull(actualSecurityUser.getCustomerId());
    assertNull(actualSecurityUser.getTenantId());
    assertNull(actualSecurityUser.getAuthority());
    assertEquals(0L, actualSecurityUser.getCreatedTime());
    assertFalse(actualSecurityUser.isCustomerUser());
    assertTrue(actualSecurityUser.isSystemAdmin());
  }

  /**
   * Test {@link SecurityUser#getAuthorities()}.
   * <ul>
   *   <li>Given {@link SecurityUser#SecurityUser()} Authority is {@code SYS_ADMIN}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecurityUser#getAuthorities()}
   */
  @Test
  @DisplayName("Test getAuthorities(); given SecurityUser() Authority is 'SYS_ADMIN'; then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection SecurityUser.getAuthorities()"})
  void testGetAuthorities_givenSecurityUserAuthorityIsSysAdmin_thenReturnList() {
    // Arrange
    SecurityUser securityUser = new SecurityUser();
    securityUser.setAuthority(Authority.SYS_ADMIN);

    // Act
    Collection<GrantedAuthority> actualAuthorities = securityUser.getAuthorities();

    // Assert
    assertTrue(actualAuthorities instanceof List);
    assertEquals(1, actualAuthorities.size());
    GrantedAuthority getResult = ((List<GrantedAuthority>) actualAuthorities).get(0);
    assertTrue(getResult instanceof SimpleGrantedAuthority);
    assertEquals("SYS_ADMIN", getResult.toString());
    assertEquals("SYS_ADMIN", getResult.getAuthority());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SecurityUser#setEnabled(boolean)}
   *   <li>{@link SecurityUser#setSessionId(String)}
   *   <li>{@link SecurityUser#setUserPrincipal(UserPrincipal)}
   *   <li>{@link SecurityUser#getSessionId()}
   *   <li>{@link SecurityUser#getUserPrincipal()}
   *   <li>{@link SecurityUser#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SecurityUser.getSessionId()", "UserPrincipal SecurityUser.getUserPrincipal()",
      "boolean SecurityUser.isEnabled()", "void SecurityUser.setEnabled(boolean)",
      "void SecurityUser.setSessionId(String)", "void SecurityUser.setUserPrincipal(UserPrincipal)"})
  void testGettersAndSetters() {
    // Arrange
    SecurityUser securityUser = new SecurityUser();

    // Act
    securityUser.setEnabled(true);
    securityUser.setSessionId("42");
    UserPrincipal userPrincipal = new UserPrincipal(Type.USER_NAME, "42");

    securityUser.setUserPrincipal(userPrincipal);
    String actualSessionId = securityUser.getSessionId();
    UserPrincipal actualUserPrincipal = securityUser.getUserPrincipal();

    // Assert
    assertEquals("42", actualSessionId);
    assertTrue(securityUser.isEnabled());
    assertSame(userPrincipal, actualUserPrincipal);
  }
}
