package org.thingsboard.server.service.edge.rpc.constructor.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.gen.edge.v1.TenantUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class TenantMsgConstructorV1DiffblueTest {
  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Given {@code 21654}.
   *   <li>Then return SerializedSize is seventy-one.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); given '21654'; then return SerializedSize is seventy-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_given21654_thenReturnSerializedSizeIsSeventyOne() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setZip("21654");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals(71, actualConstructTenantUpdateMsgResult.getSerializedSize());
    assertEquals("21654", actualConstructTenantUpdateMsgResult.getZip());
    ByteString zipBytes = actualConstructTenantUpdateMsgResult.getZipBytes();
    assertFalse(zipBytes.isEmpty());
    ByteIterator iteratorResult = zipBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals("21654", zipBytes.toStringUtf8());
    assertTrue(actualConstructTenantUpdateMsgResult.hasZip());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144}.
   *   <li>Then return Phone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); given '6625550144'; then return Phone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_given6625550144_thenReturnPhoneIs6625550144() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setPhone("6625550144");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals("6625550144", actualConstructTenantUpdateMsgResult.getPhone());
    ByteString phoneBytes = actualConstructTenantUpdateMsgResult.getPhoneBytes();
    assertFalse(phoneBytes.isEmpty());
    ByteIterator iteratorResult = phoneBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals("6625550144", phoneBytes.toStringUtf8());
    assertTrue(actualConstructTenantUpdateMsgResult.hasPhone());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Given {@code GB}.
   *   <li>When {@link Tenant#Tenant()} Country is {@code GB}.
   *   <li>Then return Country is {@code GB}.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); given 'GB'; when Tenant() Country is 'GB'; then return Country is 'GB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_givenGb_whenTenantCountryIsGb_thenReturnCountryIsGb() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setCountry("GB");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals("GB", actualConstructTenantUpdateMsgResult.getCountry());
    ByteString countryBytes = actualConstructTenantUpdateMsgResult.getCountryBytes();
    assertFalse(countryBytes.isEmpty());
    ByteIterator iteratorResult = countryBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('G', nextResult.byteValue());
    assertEquals('B', nextResult2.byteValue());
    assertEquals("GB", countryBytes.toStringUtf8());
    assertTrue(actualConstructTenantUpdateMsgResult.hasCountry());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Given {@code MD}.
   *   <li>When {@link Tenant#Tenant()} State is {@code MD}.
   *   <li>Then return State is {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); given 'MD'; when Tenant() State is 'MD'; then return State is 'MD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_givenMd_whenTenantStateIsMd_thenReturnStateIsMd() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setState("MD");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals("MD", actualConstructTenantUpdateMsgResult.getState());
    ByteString stateBytes = actualConstructTenantUpdateMsgResult.getStateBytes();
    assertFalse(stateBytes.isEmpty());
    ByteIterator iteratorResult = stateBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('M', nextResult.byteValue());
    assertEquals('D', nextResult2.byteValue());
    assertEquals("MD", stateBytes.toStringUtf8());
    assertTrue(actualConstructTenantUpdateMsgResult.hasState());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Given {@code Oxford}.
   *   <li>Then return City is {@code Oxford}.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); given 'Oxford'; then return City is 'Oxford'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_givenOxford_thenReturnCityIsOxford() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setCity("Oxford");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals("Oxford", actualConstructTenantUpdateMsgResult.getCity());
    ByteString cityBytes = actualConstructTenantUpdateMsgResult.getCityBytes();
    assertFalse(cityBytes.isEmpty());
    ByteIterator iteratorResult = cityBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('O', iteratorResult.next().byteValue());
    assertEquals('x', iteratorResult.next().byteValue());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals("Oxford", cityBytes.toStringUtf8());
    assertEquals(72, actualConstructTenantUpdateMsgResult.getSerializedSize());
    assertTrue(actualConstructTenantUpdateMsgResult.hasCity());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return AdditionalInfo is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_thenReturnAdditionalInfoIsEmptyString() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setRegion("us-east-2");
    tenant.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant.setTitle("Dr");
    tenant.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    assertEquals("", actualConstructTenantUpdateMsgResult.getAdditionalInfo());
    assertEquals(57, actualConstructTenantUpdateMsgResult.getSerializedSize());
    assertEquals(6, actualConstructTenantUpdateMsgResult.getAllFields().size());
    assertFalse(actualConstructTenantUpdateMsgResult.hasAdditionalInfo());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Then return Address2 is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return Address2 is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_thenReturnAddress2Is42MainSt() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setAddress2("42 Main St");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals("42 Main St", actualConstructTenantUpdateMsgResult.getAddress2());
    assertTrue(actualConstructTenantUpdateMsgResult.hasAddress2());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Then return Address is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return Address is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_thenReturnAddressIs42MainSt() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setAddress("42 Main St");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals("42 Main St", actualConstructTenantUpdateMsgResult.getAddress());
    ByteString addressBytes = actualConstructTenantUpdateMsgResult.getAddressBytes();
    assertFalse(addressBytes.isEmpty());
    ByteIterator iteratorResult = addressBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('4', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals(' ', iteratorResult.next().byteValue());
    assertEquals("42 Main St", addressBytes.toStringUtf8());
    assertTrue(actualConstructTenantUpdateMsgResult.hasAddress());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Then return AllFields size is seven.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return AllFields size is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_thenReturnAllFieldsSizeIsSeven() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant(new Tenant());
    tenant.setRegion("us-east-2");
    tenant.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant.setTitle("Dr");
    tenant.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    assertEquals(7, actualConstructTenantUpdateMsgResult.getAllFields().size());
    assertEquals(Double.SIZE, actualConstructTenantUpdateMsgResult.getSerializedSize());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Then return Email is {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return Email is 'jane.doe@example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_thenReturnEmailIsJaneDoeExampleOrg() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    Tenant tenant = new Tenant();
    tenant.setEmail("jane.doe@example.org");

    Tenant tenant2 = new Tenant(tenant);
    tenant2.setRegion("us-east-2");
    tenant2.setTenantProfileId(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant2.setTitle("Dr");
    tenant2.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV1.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant2);

    // Assert
    assertEquals("jane.doe@example.org", actualConstructTenantUpdateMsgResult.getEmail());
    ByteString emailBytes = actualConstructTenantUpdateMsgResult.getEmailBytes();
    assertFalse(emailBytes.isEmpty());
    ByteIterator iteratorResult = emailBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('j', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals("jane.doe@example.org", emailBytes.toStringUtf8());
    assertEquals(86, actualConstructTenantUpdateMsgResult.getSerializedSize());
    assertTrue(actualConstructTenantUpdateMsgResult.hasEmail());
  }
}
