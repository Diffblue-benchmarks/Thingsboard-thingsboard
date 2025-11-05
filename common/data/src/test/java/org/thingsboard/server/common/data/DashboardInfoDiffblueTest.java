package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DashboardInfoDiffblueTest {
  /**
   * Test {@link DashboardInfo#DashboardInfo(DashboardInfo)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link DashboardInfo#DashboardInfo()} MobileHide is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#DashboardInfo(DashboardInfo)}
   */
  @Test
  @DisplayName(
      "Test new DashboardInfo(DashboardInfo); given 'true'; when DashboardInfo() MobileHide is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardInfo.<init>(DashboardInfo)"})
  void testNewDashboardInfo_givenTrue_whenDashboardInfoMobileHideIsTrue() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setMobileHide(true);

    // Act
    DashboardInfo actualDashboardInfo = new DashboardInfo(dashboardInfo);

    // Assert
    assertEquals(dashboardInfo, actualDashboardInfo);
  }

  /**
   * Test {@link DashboardInfo#DashboardInfo(DashboardInfo)}.
   *
   * <ul>
   *   <li>When {@link DashboardInfo#DashboardInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#DashboardInfo(DashboardInfo)}
   */
  @Test
  @DisplayName("Test new DashboardInfo(DashboardInfo); when DashboardInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardInfo.<init>(DashboardInfo)"})
  void testNewDashboardInfo_whenDashboardInfo() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    DashboardInfo actualDashboardInfo = new DashboardInfo(dashboardInfo);

    // Assert
    assertEquals(dashboardInfo, actualDashboardInfo);
  }

  /**
   * Test {@link DashboardInfo#getId()}.
   *
   * <p>Method under test: {@link DashboardInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.DashboardId DashboardInfo.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new DashboardInfo().getId());
  }

  /**
   * Test {@link DashboardInfo#getCreatedTime()}.
   *
   * <p>Method under test: {@link DashboardInfo#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DashboardInfo.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new DashboardInfo().getCreatedTime());
  }

  /**
   * Test {@link DashboardInfo#isAssignedToCustomer(CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfo#DashboardInfo()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#isAssignedToCustomer(CustomerId)}
   */
  @Test
  @DisplayName("Test isAssignedToCustomer(CustomerId); given DashboardInfo(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.isAssignedToCustomer(CustomerId)"})
  void testIsAssignedToCustomer_givenDashboardInfo_thenReturnFalse() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    boolean actualIsAssignedToCustomerResult =
        dashboardInfo.isAssignedToCustomer(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertFalse(actualIsAssignedToCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#isAssignedToCustomer(CustomerId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#isAssignedToCustomer(CustomerId)}
   */
  @Test
  @DisplayName("Test isAssignedToCustomer(CustomerId); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.isAssignedToCustomer(CustomerId)"})
  void testIsAssignedToCustomer_thenReturnFalse() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act
    boolean actualIsAssignedToCustomerResult =
        dashboardInfo.isAssignedToCustomer(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertFalse(actualIsAssignedToCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#isAssignedToCustomer(CustomerId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#isAssignedToCustomer(CustomerId)}
   */
  @Test
  @DisplayName("Test isAssignedToCustomer(CustomerId); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.isAssignedToCustomer(CustomerId)"})
  void testIsAssignedToCustomer_thenReturnTrue() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    // Act
    boolean actualIsAssignedToCustomerResult =
        dashboardInfo.isAssignedToCustomer(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertTrue(actualIsAssignedToCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}.
   *
   * <p>Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  @DisplayName("Test getAssignedCustomerInfo(CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ShortCustomerInfo DashboardInfo.getAssignedCustomerInfo(CustomerId)"})
  void testGetAssignedCustomerInfo() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    // Act
    ShortCustomerInfo actualAssignedCustomerInfo =
        dashboardInfo.getAssignedCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertSame(shortCustomerInfo, actualAssignedCustomerInfo);
  }

  /**
   * Test {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is {@link EntityId#NULL_UUID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  @DisplayName(
      "Test getAssignedCustomerInfo(CustomerId); given CustomerId(UUID) with id is NULL_UUID; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ShortCustomerInfo DashboardInfo.getAssignedCustomerInfo(CustomerId)"})
  void testGetAssignedCustomerInfo_givenCustomerIdWithIdIsNull_uuid_thenReturnNull() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);

    // Act
    ShortCustomerInfo actualAssignedCustomerInfo =
        dashboardInfo.getAssignedCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertNull(actualAssignedCustomerInfo);
  }

  /**
   * Test {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfo#DashboardInfo()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  @DisplayName(
      "Test getAssignedCustomerInfo(CustomerId); given DashboardInfo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ShortCustomerInfo DashboardInfo.getAssignedCustomerInfo(CustomerId)"})
  void testGetAssignedCustomerInfo_givenDashboardInfo_thenReturnNull() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    ShortCustomerInfo actualAssignedCustomerInfo =
        dashboardInfo.getAssignedCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertNull(actualAssignedCustomerInfo);
  }

  /**
   * Test {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#getAssignedCustomerInfo(CustomerId)}
   */
  @Test
  @DisplayName("Test getAssignedCustomerInfo(CustomerId); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ShortCustomerInfo DashboardInfo.getAssignedCustomerInfo(CustomerId)"})
  void testGetAssignedCustomerInfo_thenReturnNull() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act
    ShortCustomerInfo actualAssignedCustomerInfo =
        dashboardInfo.getAssignedCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertNull(actualAssignedCustomerInfo);
  }

  /**
   * Test {@link DashboardInfo#addAssignedCustomer(Customer)}.
   *
   * <p>Method under test: {@link DashboardInfo#addAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName("Test addAssignedCustomer(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.addAssignedCustomer(Customer)"})
  void testAddAssignedCustomer() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    Customer customer = new Customer(new Customer());
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    boolean actualAddAssignedCustomerResult = dashboardInfo.addAssignedCustomer(customer);

    // Assert
    assertEquals(1, dashboardInfo.getAssignedCustomers().size());
    assertTrue(actualAddAssignedCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#addAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then {@link DashboardInfo#DashboardInfo()} AssignedCustomers is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#addAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test addAssignedCustomer(Customer); then DashboardInfo() AssignedCustomers is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.addAssignedCustomer(Customer)"})
  void testAddAssignedCustomer_thenDashboardInfoAssignedCustomersIsHashSet() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    dashboardInfo.setAssignedCustomers(assignedCustomers);
    CustomerId id = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualAddAssignedCustomerResult = dashboardInfo.addAssignedCustomer(new Customer(id));

    // Assert
    Set<ShortCustomerInfo> assignedCustomers2 = dashboardInfo.getAssignedCustomers();
    assertEquals(1, assignedCustomers2.size());
    assertTrue(actualAddAssignedCustomerResult);
    assertSame(assignedCustomers, assignedCustomers2);
  }

  /**
   * Test {@link DashboardInfo#addAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#addAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName("Test addAssignedCustomer(Customer); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.addAssignedCustomer(Customer)"})
  void testAddAssignedCustomer_thenReturnFalse() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);
    CustomerId id = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualAddAssignedCustomerResult = dashboardInfo.addAssignedCustomer(new Customer(id));

    // Assert
    Set<ShortCustomerInfo> assignedCustomers2 = dashboardInfo.getAssignedCustomers();
    assertEquals(1, assignedCustomers2.size());
    assertFalse(actualAddAssignedCustomerResult);
    assertSame(assignedCustomers, assignedCustomers2);
  }

  /**
   * Test {@link DashboardInfo#addAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#addAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName("Test addAssignedCustomer(Customer); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.addAssignedCustomer(Customer)"})
  void testAddAssignedCustomer_thenReturnTrue() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    CustomerId id = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualAddAssignedCustomerResult = dashboardInfo.addAssignedCustomer(new Customer(id));

    // Assert
    assertEquals(1, dashboardInfo.getAssignedCustomers().size());
    assertTrue(actualAddAssignedCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#updateAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfo#DashboardInfo()}.
   *   <li>When {@link Customer#Customer()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test updateAssignedCustomer(Customer); given DashboardInfo(); when Customer(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.updateAssignedCustomer(Customer)"})
  void testUpdateAssignedCustomer_givenDashboardInfo_whenCustomer_thenReturnFalse() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertFalse(dashboardInfo.updateAssignedCustomer(new Customer()));
  }

  /**
   * Test {@link DashboardInfo#updateAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName("Test updateAssignedCustomer(Customer); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.updateAssignedCustomer(Customer)"})
  void testUpdateAssignedCustomer_thenReturnFalse() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act and Assert
    assertFalse(dashboardInfo.updateAssignedCustomer(new Customer()));
  }

  /**
   * Test {@link DashboardInfo#updateAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName("Test updateAssignedCustomer(Customer); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.updateAssignedCustomer(Customer)"})
  void testUpdateAssignedCustomer_thenReturnTrue() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);
    CustomerId id = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualUpdateAssignedCustomerResult =
        dashboardInfo.updateAssignedCustomer(new Customer(id));

    // Assert
    assertTrue(actualUpdateAssignedCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#updateAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#updateAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test updateAssignedCustomer(Customer); when Customer(Customer) with customer is Customer(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.updateAssignedCustomer(Customer)"})
  void testUpdateAssignedCustomer_whenCustomerWithCustomerIsCustomer_thenReturnFalse() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    boolean actualUpdateAssignedCustomerResult =
        dashboardInfo.updateAssignedCustomer(new Customer(new Customer()));

    // Assert
    assertFalse(actualUpdateAssignedCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#removeAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then {@link DashboardInfo#DashboardInfo()} AssignedCustomers Empty.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test removeAssignedCustomer(Customer); then DashboardInfo() AssignedCustomers Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.removeAssignedCustomer(Customer)"})
  void testRemoveAssignedCustomer_thenDashboardInfoAssignedCustomersEmpty() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act and Assert
    assertFalse(dashboardInfo.removeAssignedCustomer(new Customer()));
    assertTrue(dashboardInfo.getAssignedCustomers().isEmpty());
  }

  /**
   * Test {@link DashboardInfo#removeAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then {@link DashboardInfo#DashboardInfo()} AssignedCustomers is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test removeAssignedCustomer(Customer); then DashboardInfo() AssignedCustomers is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.removeAssignedCustomer(Customer)"})
  void testRemoveAssignedCustomer_thenDashboardInfoAssignedCustomersIsNull() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    boolean actualRemoveAssignedCustomerResult =
        dashboardInfo.removeAssignedCustomer(new Customer());

    // Assert
    assertNull(dashboardInfo.getAssignedCustomers());
    assertFalse(actualRemoveAssignedCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#removeAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName("Test removeAssignedCustomer(Customer); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.removeAssignedCustomer(Customer)"})
  void testRemoveAssignedCustomer_thenReturnTrue() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(assignedCustomers);
    CustomerId id = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualRemoveAssignedCustomerResult =
        dashboardInfo.removeAssignedCustomer(new Customer(id));

    // Assert
    assertTrue(dashboardInfo.getAssignedCustomers().isEmpty());
    assertTrue(actualRemoveAssignedCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#removeAssignedCustomer(Customer)}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#removeAssignedCustomer(Customer)}
   */
  @Test
  @DisplayName(
      "Test removeAssignedCustomer(Customer); when Customer(Customer) with customer is Customer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.removeAssignedCustomer(Customer)"})
  void testRemoveAssignedCustomer_whenCustomerWithCustomerIsCustomer() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act
    boolean actualRemoveAssignedCustomerResult =
        dashboardInfo.removeAssignedCustomer(new Customer(new Customer()));

    // Assert
    assertNull(dashboardInfo.getAssignedCustomers());
    assertFalse(actualRemoveAssignedCustomerResult);
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}, and {@link DashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardInfo#equals(Object)}
   *   <li>{@link DashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    DashboardInfo dashboardInfo2 = new DashboardInfo();

    // Act and Assert
    assertEquals(dashboardInfo, dashboardInfo2);
    assertEquals(dashboardInfo.hashCode(), dashboardInfo2.hashCode());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}, and {@link DashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardInfo#equals(Object)}
   *   <li>{@link DashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();

    // Act and Assert
    assertEquals(dashboardInfo, dashboardInfo);
    int expectedHashCodeResult = dashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, dashboardInfo.hashCode());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertNotEquals(dashboard, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setImage("Image");

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setAssignedCustomers(new HashSet<>());

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setMobileHide(true);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setMobileOrder(1);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(dashboardInfo, new DashboardInfo());
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DashboardInfo(), null);
  }

  /**
   * Test {@link DashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardInfo.equals(Object)", "int DashboardInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DashboardInfo(), "Different type to DashboardInfo");
  }
}
