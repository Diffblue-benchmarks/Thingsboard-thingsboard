package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.snmp4j.PDU;
import org.snmp4j.ScopedPDU;
import org.snmp4j.agent.mo.snmp.RowCount;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.Null;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.thingsboard.server.common.adaptor.JsonConverter;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;
import org.thingsboard.server.common.data.transport.snmp.SnmpMethod;
import org.thingsboard.server.common.data.transport.snmp.SnmpProtocolVersion;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

class PduServiceDiffblueTest {
  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        mock(SnmpDeviceTransportConfiguration.class);
    when(snmpDeviceTransportConfiguration.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);
    doNothing().when(snmpDeviceTransportConfiguration).setContextName(Mockito.<String>any());
    doNothing().when(snmpDeviceTransportConfiguration).setEngineId(Mockito.<String>any());
    doNothing()
        .when(snmpDeviceTransportConfiguration)
        .setProtocolVersion(Mockito.<SnmpProtocolVersion>any());
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", "42", DataType.BOOLEAN);

    // Assert
    verify(snmpDeviceTransportConfiguration).getProtocolVersion();
    verify(snmpDeviceTransportConfiguration).setContextName("42");
    verify(snmpDeviceTransportConfiguration).setEngineId("42");
    verify(snmpDeviceTransportConfiguration).setProtocolVersion(SnmpProtocolVersion.V3);
    verify(sessionContext).getDeviceTransportConfiguration();
    List<VariableBinding> all = actualCreateSingleVariablePduResult.getAll();
    assertEquals(1, all.size());
    VariableBinding getResult = all.get(0);
    Variable variable = getResult.getVariable();
    assertTrue(variable instanceof OctetString);
    OID oid = getResult.getOid();
    OID trimResult = oid.trim();
    assertArrayEquals(new byte[] {}, trimResult.toByteArray());
    assertArrayEquals(new byte[] {'*'}, oid.toByteArray());
    OID successorResult = oid.successor();
    assertArrayEquals(new byte[] {'*', 0}, successorResult.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, ((OctetString) variable).getValue());
    assertArrayEquals(new int[] {}, trimResult.getValue());
    assertArrayEquals(new int[] {42}, oid.getValue());
    assertArrayEquals(new int[] {42, 0}, successorResult.getValue());
    assertArrayEquals(new long[] {}, trimResult.toUnsignedLongArray());
    assertArrayEquals(new long[] {42L}, oid.toUnsignedLongArray());
    assertArrayEquals(new long[] {42L, 0L}, successorResult.toUnsignedLongArray());
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); given NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_givenNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            pduService.createSingleVariablePdu(
                sessionContext, SnmpMethod.GET, "Oid", "42", DataType.BOOLEAN));
    verify(sessionContext).getDeviceTransportConfiguration();
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>Then All first Variable return {@link Null}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); then All first Variable return Null")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_thenAllFirstVariableReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        mock(SnmpDeviceTransportConfiguration.class);
    when(snmpDeviceTransportConfiguration.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);
    doNothing().when(snmpDeviceTransportConfiguration).setContextName(Mockito.<String>any());
    doNothing().when(snmpDeviceTransportConfiguration).setEngineId(Mockito.<String>any());
    doNothing()
        .when(snmpDeviceTransportConfiguration)
        .setProtocolVersion(Mockito.<SnmpProtocolVersion>any());
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", null, DataType.BOOLEAN);

    // Assert
    verify(snmpDeviceTransportConfiguration).getProtocolVersion();
    verify(snmpDeviceTransportConfiguration).setContextName("42");
    verify(snmpDeviceTransportConfiguration).setEngineId("42");
    verify(snmpDeviceTransportConfiguration).setProtocolVersion(SnmpProtocolVersion.V3);
    verify(sessionContext).getDeviceTransportConfiguration();
    List<VariableBinding> all = actualCreateSingleVariablePduResult.getAll();
    assertEquals(1, all.size());
    VariableBinding getResult = all.get(0);
    assertTrue(getResult.getVariable() instanceof Null);
    assertEquals("Null", getResult.toValueString());
    VariableBinding[] toArrayResult = actualCreateSingleVariablePduResult.toArray();
    assertEquals(1, toArrayResult.length);
    assertEquals(18, actualCreateSingleVariablePduResult.getBERPayloadLength());
    assertEquals(20, actualCreateSingleVariablePduResult.getBERLength());
    assertEquals(5, getResult.getBERPayloadLength());
    assertEquals(5, getResult.getSyntax());
    assertEquals(7, getResult.getBERLength());
    assertSame(getResult, toArrayResult[0]);
    assertSame(all, actualCreateSingleVariablePduResult.getVariableBindings());
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpDeviceTransportConfiguration#getContextName()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); then calls getContextName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_thenCallsGetContextName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        mock(SnmpDeviceTransportConfiguration.class);
    when(snmpDeviceTransportConfiguration.getContextName()).thenThrow(new NumberFormatException());
    when(snmpDeviceTransportConfiguration.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);
    doNothing().when(snmpDeviceTransportConfiguration).setContextName(Mockito.<String>any());
    doNothing().when(snmpDeviceTransportConfiguration).setEngineId(Mockito.<String>any());
    doNothing()
        .when(snmpDeviceTransportConfiguration)
        .setProtocolVersion(Mockito.<SnmpProtocolVersion>any());
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            pduService.createSingleVariablePdu(
                sessionContext, SnmpMethod.GET, "42", null, DataType.BOOLEAN));
    verify(snmpDeviceTransportConfiguration).getContextName();
    verify(snmpDeviceTransportConfiguration).getProtocolVersion();
    verify(snmpDeviceTransportConfiguration).setContextName("42");
    verify(snmpDeviceTransportConfiguration).setEngineId("42");
    verify(snmpDeviceTransportConfiguration).setProtocolVersion(SnmpProtocolVersion.V3);
    verify(sessionContext).getDeviceTransportConfiguration();
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>Then return All first Oid toIntArray is All first Oid Value.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); then return All first Oid toIntArray is All first Oid Value")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_thenReturnAllFirstOidToIntArrayIsAllFirstOidValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        mock(SnmpDeviceTransportConfiguration.class);
    when(snmpDeviceTransportConfiguration.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);
    doNothing().when(snmpDeviceTransportConfiguration).setContextName(Mockito.<String>any());
    doNothing().when(snmpDeviceTransportConfiguration).setEngineId(Mockito.<String>any());
    doNothing()
        .when(snmpDeviceTransportConfiguration)
        .setProtocolVersion(Mockito.<SnmpProtocolVersion>any());
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(sessionContext, SnmpMethod.GET, "42", "42", null);

    // Assert
    verify(snmpDeviceTransportConfiguration).getProtocolVersion();
    verify(snmpDeviceTransportConfiguration).setContextName("42");
    verify(snmpDeviceTransportConfiguration).setEngineId("42");
    verify(snmpDeviceTransportConfiguration).setProtocolVersion(SnmpProtocolVersion.V3);
    verify(sessionContext).getDeviceTransportConfiguration();
    List<VariableBinding> all = actualCreateSingleVariablePduResult.getAll();
    assertEquals(1, all.size());
    VariableBinding getResult = all.get(0);
    Variable variable = getResult.getVariable();
    assertTrue(variable instanceof OctetString);
    VariableBinding[] toArrayResult = actualCreateSingleVariablePduResult.toArray();
    assertEquals(1, toArrayResult.length);
    assertSame(getResult, toArrayResult[0]);
    assertSame(all, actualCreateSingleVariablePduResult.getVariableBindings());
    OID oid = getResult.getOid();
    int[] value = oid.getValue();
    assertSame(value, oid.toIntArray());
    byte[] value2 = ((OctetString) variable).getValue();
    assertSame(value2, ((OctetString) variable).toByteArray());
    assertArrayEquals(new byte[] {'*'}, oid.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, value2);
    assertArrayEquals(new int[] {42}, value);
    assertArrayEquals(new long[] {42L}, oid.toUnsignedLongArray());
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>Then return {@link ScopedPDU}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); then return ScopedPDU")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_thenReturnScopedPDU() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", "42", DataType.BOOLEAN);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
    assertTrue(actualCreateSingleVariablePduResult instanceof ScopedPDU);
    assertEquals(30, actualCreateSingleVariablePduResult.getBERPayloadLength());
    assertEquals(Integer.SIZE, actualCreateSingleVariablePduResult.getBERLength());
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>When {@code LONG}.
   *   <li>Then All first Variable return {@link Integer32}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); when 'LONG'; then All first Variable return Integer32")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_whenLong_thenAllFirstVariableReturnInteger32() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        mock(SnmpDeviceTransportConfiguration.class);
    when(snmpDeviceTransportConfiguration.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);
    doNothing().when(snmpDeviceTransportConfiguration).setContextName(Mockito.<String>any());
    doNothing().when(snmpDeviceTransportConfiguration).setEngineId(Mockito.<String>any());
    doNothing()
        .when(snmpDeviceTransportConfiguration)
        .setProtocolVersion(Mockito.<SnmpProtocolVersion>any());
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", "42", DataType.LONG);

    // Assert
    verify(snmpDeviceTransportConfiguration).getProtocolVersion();
    verify(snmpDeviceTransportConfiguration).setContextName("42");
    verify(snmpDeviceTransportConfiguration).setEngineId("42");
    verify(snmpDeviceTransportConfiguration).setProtocolVersion(SnmpProtocolVersion.V3);
    verify(sessionContext).getDeviceTransportConfiguration();
    List<VariableBinding> all = actualCreateSingleVariablePduResult.getAll();
    assertEquals(1, all.size());
    VariableBinding getResult = all.get(0);
    assertTrue(getResult.getVariable() instanceof Integer32);
    VariableBinding[] toArrayResult = actualCreateSingleVariablePduResult.toArray();
    assertEquals(1, toArrayResult.length);
    assertEquals(19, actualCreateSingleVariablePduResult.getBERPayloadLength());
    assertEquals(2, getResult.getSyntax());
    assertEquals(21, actualCreateSingleVariablePduResult.getBERLength());
    assertEquals(6, getResult.getBERPayloadLength());
    assertEquals(8, getResult.getBERLength());
    assertSame(getResult, toArrayResult[0]);
    assertSame(all, actualCreateSingleVariablePduResult.getVariableBindings());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()} add {@link VariableBinding#VariableBinding()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU() add VariableBinding()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_givenPduAddVariableBinding() {
    // Arrange
    PduService pduService = new PduService();

    PDU pdu = new PDU();
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU(); when ArrayList() add PDU()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_givenPdu_whenArrayListAddPdu() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU(); when ArrayList() add PDU()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_givenPdu_whenArrayListAddPdu2() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());
    pdus.add(new PDU());

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Given {@link SnmpMapping#SnmpMapping()} Oid is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; given SnmpMapping() Oid is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_givenSnmpMappingOidIs42() {
    // Arrange
    PduService pduService = new PduService();
    ArrayList<PDU> pdus = new ArrayList<>();

    SnmpMapping snmpMapping = new SnmpMapping();
    snmpMapping.setOid("42");

    ArrayList<SnmpMapping> responseMappings = new ArrayList<>();
    responseMappings.add(snmpMapping);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, responseMappings);

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Then calls {@link PDU#add(VariableBinding)}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; then calls add(VariableBinding)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_thenCallsAdd() {
    // Arrange
    PduService pduService = new PduService();

    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(new ArrayList<>());
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Then calls {@link VariableBinding#getOid()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; then calls getOid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_thenCallsGetOid() {
    // Arrange
    PduService pduService = new PduService();

    VariableBinding variableBinding = mock(VariableBinding.class);
    when(variableBinding.toValueString()).thenReturn("42");
    when(variableBinding.getOid()).thenReturn(new OID());
    when(variableBinding.getVariable()).thenReturn(new RowCount());

    ArrayList<VariableBinding> variableBindingList = new ArrayList<>();
    variableBindingList.add(variableBinding);

    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(variableBindingList);
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    verify(variableBinding).getOid();
    verify(variableBinding).getVariable();
    verify(variableBinding).toValueString();
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; when ArrayList(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_whenArrayList_thenReturnSizeIsZero() {
    // Arrange
    PduService pduService = new PduService();
    ArrayList<PDU> pdus = new ArrayList<>();

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; when 'null'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_whenNull_thenReturnSizeIsZero() {
    // Arrange
    PduService pduService = new PduService();

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(new ArrayList<>(), null);

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    JsonObject actualAsJsonObject = actualProcessPdusResult.getAsJsonObject();
    assertSame(actualProcessPdusResult, actualAsJsonObject);
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()} add {@link VariableBinding#VariableBinding()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU() add VariableBinding(); when ArrayList() add PDU()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPduAddVariableBinding_whenArrayListAddPdu() {
    // Arrange
    PduService pduService = new PduService();

    PDU pdu = new PDU();
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU} {@link PDU#getVariableBindings()} return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link PDU#add(VariableBinding)}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU getVariableBindings() return ArrayList(); then calls add(VariableBinding)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPduGetVariableBindingsReturnArrayList_thenCallsAdd() {
    // Arrange
    PduService pduService = new PduService();

    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(new ArrayList<>());
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    Map<OID, String> actualProcessPdusResult = pduService.processPdus(pdus);

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    assertTrue(actualProcessPdusResult.isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU(); when ArrayList() add PDU(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPdu_whenArrayListAddPdu_thenReturnEmpty() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU(); when ArrayList() add PDU(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPdu_whenArrayListAddPdu_thenReturnEmpty2() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());
    pdus.add(new PDU());

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_thenReturnSizeIsOne() {
    // Arrange
    PduService pduService = new PduService();

    VariableBinding variableBinding = mock(VariableBinding.class);
    when(variableBinding.toValueString()).thenReturn("42");
    when(variableBinding.getOid()).thenReturn(new OID());
    when(variableBinding.getVariable()).thenReturn(new RowCount());

    ArrayList<VariableBinding> variableBindingList = new ArrayList<>();
    variableBindingList.add(variableBinding);

    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(variableBindingList);
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    Map<OID, String> actualProcessPdusResult = pduService.processPdus(pdus);

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    verify(variableBinding).getOid();
    verify(variableBinding).getVariable();
    verify(variableBinding).toValueString();
    assertEquals(1, actualProcessPdusResult.size());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_whenArrayList_thenReturnEmpty() {
    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertTrue(pduService.processPdus(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given NumberFormatException(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = mock(JsonObject.class);
    doThrow(new NumberFormatException())
        .when(result)
        .addProperty(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(result).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    result.add(".", new JsonArray());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> pduService.processValue("Key", DataType.STRING, "42", result));
    verify(result).add(eq("."), isA(JsonElement.class));
    verify(result).addProperty("Key", "42");
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then {@link JsonObject} (default constructor) size is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given 'Property'; then JsonObject (default constructor) size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_givenProperty_thenJsonObjectSizeIsThree() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", new JsonArray());
    result.add(".", new JsonArray());

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Then JsonObjectForGateway {@code Device Name} is DefaultInstance size is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); then JsonObjectForGateway 'Device Name' is DefaultInstance size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_thenJsonObjectForGatewayDeviceNameIsDefaultInstanceSizeIsThree() {
    // Arrange
    JsonObject result =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Act
    new PduService().processValue("Key", DataType.STRING, null, result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_thenThrowUnsupportedOperationException() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = mock(JsonObject.class);
    doThrow(new UnsupportedOperationException())
        .when(result)
        .addProperty(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(result).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    result.add(".", new JsonArray());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> pduService.processValue("Key", DataType.STRING, "42", result));
    verify(result).add(eq("."), isA(JsonElement.class));
    verify(result).addProperty("Key", "42");
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenBoolean() {
    // Arrange
    JsonObject result =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Act
    new PduService().processValue("Key", DataType.BOOLEAN, Boolean.TRUE.toString(), result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when 'BOOLEAN'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenBoolean_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PduService()
                .processValue(
                    "Key",
                    DataType.BOOLEAN,
                    null,
                    JsonConverter.getJsonObjectForGateway(
                        "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance())));
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@code JSON}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when 'JSON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenJson() {
    // Arrange
    JsonObject result =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Act
    new PduService().processValue("Key", DataType.JSON, null, result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add {@code .} and {@link
   *       JsonArray#JsonArray()}.
   *   <li>Then {@link JsonObject} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when JsonObject (default constructor) add '.' and JsonArray(); then JsonObject (default constructor) size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenJsonObjectAddDotAndJsonArray_thenJsonObjectSizeIsTwo() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add(".", new JsonArray());

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} {@link JsonObject#addProperty(String, Number)} does nothing.
   *   <li>Then calls {@link JsonObject#addProperty(String, Number)}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when JsonObject addProperty(String, Number) does nothing; then calls addProperty(String, Number)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenJsonObjectAddPropertyDoesNothing_thenCallsAddProperty() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = mock(JsonObject.class);
    doNothing().when(result).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    doNothing().when(result).addProperty(Mockito.<String>any(), Mockito.<Number>any());
    result.add(".", new JsonArray());

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    verify(result).add(eq("."), isA(JsonElement.class));
    verify(result).addProperty(eq("Key"), isA(Number.class));
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} {@link JsonObject#addProperty(String, String)} does nothing.
   *   <li>Then calls {@link JsonObject#addProperty(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when JsonObject addProperty(String, String) does nothing; then calls addProperty(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenJsonObjectAddPropertyDoesNothing_thenCallsAddProperty2() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = mock(JsonObject.class);
    doNothing().when(result).addProperty(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(result).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    result.add(".", new JsonArray());

    // Act
    pduService.processValue("Key", DataType.STRING, "42", result);

    // Assert
    verify(result).add(eq("."), isA(JsonElement.class));
    verify(result).addProperty("Key", "42");
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then {@link JsonObject} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when JsonObject (default constructor); then JsonObject (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenJsonObject_thenJsonObjectSizeIsOne() {
    // Arrange
    PduService pduService = new PduService();
    JsonObject result = new JsonObject();

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(1, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when JsonObject (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenJsonObject_thenThrowIllegalArgumentException() {
    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pduService.processValue("Key", DataType.BOOLEAN, "42", new JsonObject()));
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenTrueToString() {
    // Arrange
    JsonObject result =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Act
    new PduService().processValue("Key", DataType.STRING, Boolean.TRUE.toString(), result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenTrueToString2() {
    // Arrange
    JsonObject result =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Act
    new PduService()
        .processValue(Boolean.TRUE.toString(), DataType.BOOLEAN, Boolean.TRUE.toString(), result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }
}
