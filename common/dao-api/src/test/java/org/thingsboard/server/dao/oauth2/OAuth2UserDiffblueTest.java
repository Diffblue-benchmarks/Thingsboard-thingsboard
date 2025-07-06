package org.thingsboard.server.dao.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class OAuth2UserDiffblueTest {
  /**
   * Test {@link OAuth2User#equals(Object)}, and {@link OAuth2User#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2User#equals(Object)}
   *   <li>{@link OAuth2User#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertEquals(oAuth2User, oAuth2User2);
    int expectedHashCodeResult = oAuth2User.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2User2.hashCode());
  }

  /**
   * Test {@link OAuth2User#equals(Object)}, and {@link OAuth2User#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2User#equals(Object)}
   *   <li>{@link OAuth2User#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    // Act and Assert
    assertEquals(oAuth2User, oAuth2User);
    int expectedHashCodeResult = oAuth2User.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2User.hashCode());
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(false);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(new CustomerId(UUID.randomUUID()));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(null);
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Tenant Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName(null);
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Tenant Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName(null);
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("john.smith@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail(null);
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("John");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName(null);
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Smith");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName(null);
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.randomUUID()));
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(null);
    oAuth2User.setTenantName("Tenant Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Customer Name");

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName(null);

    OAuth2User oAuth2User2 = new OAuth2User();
    oAuth2User2.setAlwaysFullScreen(true);
    oAuth2User2.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setCustomerName("Customer Name");
    oAuth2User2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User2.setEmail("jane.doe@example.org");
    oAuth2User2.setFirstName("Jane");
    oAuth2User2.setLastName("Doe");
    oAuth2User2.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User2.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, oAuth2User2);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, null);
  }

  /**
   * Test {@link OAuth2User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OAuth2User.equals(Object)", "int OAuth2User.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2User oAuth2User = new OAuth2User();
    oAuth2User.setAlwaysFullScreen(true);
    oAuth2User.setCustomerId(
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setCustomerName("Customer Name");
    oAuth2User.setDefaultDashboardName("Default Dashboard Name");
    oAuth2User.setEmail("jane.doe@example.org");
    oAuth2User.setFirstName("Jane");
    oAuth2User.setLastName("Doe");
    oAuth2User.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    oAuth2User.setTenantName("Tenant Name");

    // Act and Assert
    assertNotEquals(oAuth2User, "Different type to OAuth2User");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OAuth2User}
   *   <li>{@link OAuth2User#setAlwaysFullScreen(boolean)}
   *   <li>{@link OAuth2User#setCustomerId(CustomerId)}
   *   <li>{@link OAuth2User#setCustomerName(String)}
   *   <li>{@link OAuth2User#setDefaultDashboardName(String)}
   *   <li>{@link OAuth2User#setEmail(String)}
   *   <li>{@link OAuth2User#setFirstName(String)}
   *   <li>{@link OAuth2User#setLastName(String)}
   *   <li>{@link OAuth2User#setTenantId(TenantId)}
   *   <li>{@link OAuth2User#setTenantName(String)}
   *   <li>{@link OAuth2User#toString()}
   *   <li>{@link OAuth2User#getCustomerId()}
   *   <li>{@link OAuth2User#getCustomerName()}
   *   <li>{@link OAuth2User#getDefaultDashboardName()}
   *   <li>{@link OAuth2User#getEmail()}
   *   <li>{@link OAuth2User#getFirstName()}
   *   <li>{@link OAuth2User#getLastName()}
   *   <li>{@link OAuth2User#getTenantId()}
   *   <li>{@link OAuth2User#getTenantName()}
   *   <li>{@link OAuth2User#isAlwaysFullScreen()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OAuth2User.<init>()",
    "CustomerId OAuth2User.getCustomerId()",
    "String OAuth2User.getCustomerName()",
    "String OAuth2User.getDefaultDashboardName()",
    "String OAuth2User.getEmail()",
    "String OAuth2User.getFirstName()",
    "String OAuth2User.getLastName()",
    "TenantId OAuth2User.getTenantId()",
    "String OAuth2User.getTenantName()",
    "boolean OAuth2User.isAlwaysFullScreen()",
    "void OAuth2User.setAlwaysFullScreen(boolean)",
    "void OAuth2User.setCustomerId(CustomerId)",
    "void OAuth2User.setCustomerName(String)",
    "void OAuth2User.setDefaultDashboardName(String)",
    "void OAuth2User.setEmail(String)",
    "void OAuth2User.setFirstName(String)",
    "void OAuth2User.setLastName(String)",
    "void OAuth2User.setTenantId(TenantId)",
    "void OAuth2User.setTenantName(String)",
    "String OAuth2User.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2User actualOAuth2User = new OAuth2User();
    actualOAuth2User.setAlwaysFullScreen(true);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualOAuth2User.setCustomerId(customerId);
    actualOAuth2User.setCustomerName("Customer Name");
    actualOAuth2User.setDefaultDashboardName("Default Dashboard Name");
    actualOAuth2User.setEmail("jane.doe@example.org");
    actualOAuth2User.setFirstName("Jane");
    actualOAuth2User.setLastName("Doe");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualOAuth2User.setTenantId(tenantId);
    actualOAuth2User.setTenantName("Tenant Name");
    String actualToStringResult = actualOAuth2User.toString();
    CustomerId actualCustomerId = actualOAuth2User.getCustomerId();
    String actualCustomerName = actualOAuth2User.getCustomerName();
    String actualDefaultDashboardName = actualOAuth2User.getDefaultDashboardName();
    String actualEmail = actualOAuth2User.getEmail();
    String actualFirstName = actualOAuth2User.getFirstName();
    String actualLastName = actualOAuth2User.getLastName();
    TenantId actualTenantId = actualOAuth2User.getTenantId();
    String actualTenantName = actualOAuth2User.getTenantName();

    // Assert
    assertEquals("Customer Name", actualCustomerName);
    assertEquals("Default Dashboard Name", actualDefaultDashboardName);
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals(
        "OAuth2User(tenantName=Tenant Name, tenantId=784f394c-42b6-435a-983c-b7beff2784f9, customerName=Customer"
            + " Name, customerId=784f394c-42b6-435a-983c-b7beff2784f9, email=jane.doe@example.org, firstName=Jane,"
            + " lastName=Doe, alwaysFullScreen=true, defaultDashboardName=Default Dashboard Name)",
        actualToStringResult);
    assertEquals("Tenant Name", actualTenantName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertTrue(actualOAuth2User.isAlwaysFullScreen());
    assertSame(customerId, actualCustomerId);
    assertSame(tenantId, actualTenantId);
  }
}
