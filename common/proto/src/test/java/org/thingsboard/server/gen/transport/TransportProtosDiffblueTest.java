package org.thingsboard.server.gen.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos.EntityUpdateMsg;
import org.thingsboard.server.gen.transport.TransportProtos.EntityUpdateMsg.EntityUpdateCase;
import org.thingsboard.server.gen.transport.TransportProtos.GetEntityProfileResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetEntityProfileResponseMsg.DataCase;

class TransportProtosDiffblueTest {
  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code ENTITYUPDATE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase forNumber(int); then return 'ENTITYUPDATE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.forNumber(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseForNumber_thenReturnEntityupdateNotSet() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.ENTITYUPDATE_NOT_SET, EntityUpdateCase.forNumber(0));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code APIUSAGESTATE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase forNumber(int); when five; then return 'APIUSAGESTATE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.forNumber(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseForNumber_whenFive_thenReturnApiusagestate() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.APIUSAGESTATE, EntityUpdateCase.forNumber(5));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.forNumber(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EntityUpdateCase.forNumber(42));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code DEVICEPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase forNumber(int); when four; then return 'DEVICEPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.forNumber(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseForNumber_whenFour_thenReturnDeviceprofile() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.DEVICEPROFILE, EntityUpdateCase.forNumber(4));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase forNumber(int); when one; then return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.forNumber(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseForNumber_whenOne_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.TENANT, EntityUpdateCase.forNumber(1));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase forNumber(int); when three; then return 'DEVICE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.forNumber(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseForNumber_whenThree_thenReturnDevice() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.DEVICE, EntityUpdateCase.forNumber(3));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code TENANTPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase forNumber(int); when two; then return 'TENANTPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.forNumber(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseForNumber_whenTwo_thenReturnTenantprofile() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.TENANTPROFILE, EntityUpdateCase.forNumber(2));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#getNumber()}.
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#getNumber()}
   */
  @Test
  @DisplayName("Test EntityUpdateMsg_EntityUpdateCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityUpdateMsg.EntityUpdateCase.getNumber()"})
  void testEntityUpdateMsg_EntityUpdateCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, EntityUpdateCase.valueOf("TENANT").getNumber());
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   * with {@code value}.
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test EntityUpdateMsg_EntityUpdateCase valueOf(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.valueOf(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.ENTITYUPDATE_NOT_SET, EntityUpdateCase.valueOf(0));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code APIUSAGESTATE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase valueOf(int) with 'value'; then return 'APIUSAGESTATE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.valueOf(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseValueOfWithValue_thenReturnApiusagestate() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.APIUSAGESTATE, EntityUpdateCase.valueOf(5));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code DEVICEPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase valueOf(int) with 'value'; then return 'DEVICEPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.valueOf(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseValueOfWithValue_thenReturnDeviceprofile() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.DEVICEPROFILE, EntityUpdateCase.valueOf(4));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code TENANTPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase valueOf(int) with 'value'; then return 'TENANTPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.valueOf(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseValueOfWithValue_thenReturnTenantprofile() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.TENANTPROFILE, EntityUpdateCase.valueOf(2));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.valueOf(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EntityUpdateCase.valueOf(42));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase valueOf(int) with 'value'; when one; then return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.valueOf(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseValueOfWithValue_whenOne_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.TENANT, EntityUpdateCase.valueOf(1));
  }

  /**
   * Test EntityUpdateMsg_EntityUpdateCase {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityUpdateMsg.EntityUpdateCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test EntityUpdateMsg_EntityUpdateCase valueOf(int) with 'value'; when three; then return 'DEVICE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityUpdateMsg.EntityUpdateCase EntityUpdateMsg.EntityUpdateCase.valueOf(int)"
  })
  void testEntityUpdateMsg_EntityUpdateCaseValueOfWithValue_whenThree_thenReturnDevice() {
    // Arrange, Act and Assert
    assertEquals(EntityUpdateCase.DEVICE, EntityUpdateCase.valueOf(3));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code DEVICEPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase forNumber(int); then return 'DEVICEPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.forNumber(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseForNumber_thenReturnDeviceprofile() {
    // Arrange, Act and Assert
    assertEquals(DataCase.DEVICEPROFILE, DataCase.forNumber(3));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code TENANTPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase forNumber(int); then return 'TENANTPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.forNumber(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseForNumber_thenReturnTenantprofile() {
    // Arrange, Act and Assert
    assertEquals(DataCase.TENANTPROFILE, DataCase.forNumber(2));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.forNumber(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DataCase.forNumber(42));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code DATA_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase forNumber(int); when zero; then return 'DATA_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.forNumber(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseForNumber_whenZero_thenReturnDataNotSet() {
    // Arrange, Act and Assert
    assertEquals(DataCase.DATA_NOT_SET, DataCase.forNumber(0));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#getNumber()}.
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#getNumber()}
   */
  @Test
  @DisplayName("Test GetEntityProfileResponseMsg_DataCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GetEntityProfileResponseMsg.DataCase.getNumber()"})
  void testGetEntityProfileResponseMsg_DataCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, DataCase.valueOf("TENANTPROFILE").getNumber());
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code DATA_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase valueOf(int) with 'value'; then return 'DATA_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.valueOf(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseValueOfWithValue_thenReturnDataNotSet() {
    // Arrange, Act and Assert
    assertEquals(DataCase.DATA_NOT_SET, DataCase.valueOf(0));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code DEVICEPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase valueOf(int) with 'value'; then return 'DEVICEPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.valueOf(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseValueOfWithValue_thenReturnDeviceprofile() {
    // Arrange, Act and Assert
    assertEquals(DataCase.DEVICEPROFILE, DataCase.valueOf(3));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase valueOf(int) with 'value'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.valueOf(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DataCase.valueOf(42));
  }

  /**
   * Test GetEntityProfileResponseMsg_DataCase {@link
   * GetEntityProfileResponseMsg.DataCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code TENANTPROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link GetEntityProfileResponseMsg.DataCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test GetEntityProfileResponseMsg_DataCase valueOf(int) with 'value'; then return 'TENANTPROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetEntityProfileResponseMsg.DataCase GetEntityProfileResponseMsg.DataCase.valueOf(int)"
  })
  void testGetEntityProfileResponseMsg_DataCaseValueOfWithValue_thenReturnTenantprofile() {
    // Arrange, Act and Assert
    assertEquals(DataCase.TENANTPROFILE, DataCase.valueOf(2));
  }
}
